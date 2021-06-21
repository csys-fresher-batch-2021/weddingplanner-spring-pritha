package in.pritha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import in.pritha.repository.UserRepository;

@SpringBootApplication
public class WeddingAppPaymentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeddingAppPaymentApiApplication.class, args);
	}

}
