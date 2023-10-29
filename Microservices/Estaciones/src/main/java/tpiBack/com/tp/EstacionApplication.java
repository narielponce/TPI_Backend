package tpiBack.com.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "tpiBack.com.tp")
public class EstacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionApplication.class, args);
	}

}
