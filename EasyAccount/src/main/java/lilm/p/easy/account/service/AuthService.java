package lilm.p.easy.account.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by lilm on 17-10-17.
 */
@Service
public class AuthService {
	
	private static final int TOKEN_LENGTH = 24;
	private static final String TOKEN_KEY_HEADER = "eToken-";
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public String generateToken(String userId) {
		if (StringUtils.isBlank(userId)) {
			return null;
		}
		String key = getTokenKeyHeader(userId);
		
		String token = redisTemplate.opsForValue().get(key);
		if (StringUtils.isNotBlank(token)) {
			return token;
		}
		token = RandomStringUtils.random(TOKEN_LENGTH, userId);
		redisTemplate.opsForValue().set(key, token, 300, TimeUnit.SECONDS);
		return token;
	}
	
	private String getTokenKeyHeader(String userId) {
		return TOKEN_KEY_HEADER + userId;
	}
	
	
	
}
