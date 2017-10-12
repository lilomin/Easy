package lilm.p.easy.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lilm on 17-9-6.
 */
@SpringBootApplication
@MapperScan("lilm.p.easy.web.dao")
public class EasyWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EasyWebApplication.class, args);
	}
	
}
