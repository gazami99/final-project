package io.playdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"encore.io.playdata.sub"})
public class Step20TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step20TestApplication.class, args);
	}

}
