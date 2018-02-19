package lilm.p.easy.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lilm on 17-11-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RedisDemoTest {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	/**
	 * push redis 队列脚本
	 * 1. 检查队列长度是否超出配置长度
	 * 2. 若超出, 弹出队列最后一个元素, 并将当前元素插入第一位
	 * 3. 没超出则将当前元素插入第一位
	 */
	private static DefaultRedisScript<Long> queueScript = null;
	
	// 创建一个锁对象
	private Lock lock = new ReentrantLock();
	
	private Long l = 0L;
	
	// 最大缓存消息数
	private final static Long MAX_CACHED_NUM = 300L;
	
	private final static String QUEUE_KEY = "demo-queue";
	
	private void push() {
		try {
			lock.lock();
			Long num = redisTemplate.execute(
					getQueueScript(), Collections.singletonList(QUEUE_KEY),
					MAX_CACHED_NUM.toString(), String.valueOf(l)
			);
			logger.info("push data:{} to queue return:{}", l, num);
		} catch (Exception e) {
			logger.error("redis error:", e);
		} finally {
			l++;
			lock.unlock();
		}
	}
	
	private static RedisScript<Long> getQueueScript() {
		if (queueScript == null) {
			queueScript = new DefaultRedisScript<Long>();
			queueScript.setResultType(Long.class);
			// ClassPathResource指定路径不需要前缀 classpath:
			queueScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/queue_script.lua")));
		}
		return queueScript;
	}
	
	/**
	 * 线程池持有三十个线程，每个线程持续写入100次，推入数据为0~2999
	 * 由于push方法是线程安全的，最终redis中demo-queue的结果应该是：
	 * 1. list中总共300条数据
	 * 2. 第一条为 2999 第300条为 2700，中间数据依次加1
	 */
	@Test
	public void testQueue() {
		ExecutorService service = Executors.newFixedThreadPool(50);
		try {
			for (int i = 0; i < 30; i ++) {
				Thread t = new Thread(() -> {
					int x = 0;
					while (true) {
						if (x == 100) {
							break;
						}
						push();
						x++;
					}
				});
				try {
					service.execute(t);
				} finally {
					logger.info("子线程{}已开启", i + 1);
				}
			}
			
			logger.info("已启动所有的子线程");
			service.shutdown();
			while (true) {
				if (service.isTerminated()) {
					logger.info("所有的子线程都结束了！");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
