package lilm.p.easy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EasyEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyEurekaApplication.class, args);
	}
}
