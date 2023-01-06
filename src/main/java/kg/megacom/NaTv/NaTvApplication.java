package kg.megacom.NaTv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("kg.megacom.NaTv.microServices")
public class NaTvApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaTvApplication.class, args);
	}

}
