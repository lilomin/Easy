package lilm.p.easy.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@MapperScan("lilm.p.easy.account.dao")
public class EasyAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyAccountApplication.class, args);
	}
}
