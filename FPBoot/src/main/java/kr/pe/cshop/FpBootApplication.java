package kr.pe.cshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"kr.pe.cshop.model.service.MemoryCardService"})
public class FpBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FpBootApplication.class, args);
	}

}
