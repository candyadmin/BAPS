package tk.baseaccept.pass.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class ServiceApplication {
	private Logger log = LoggerFactory.getLogger(ServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
