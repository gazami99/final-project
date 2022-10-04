package kr.pe.cshop.model.util;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.pe.cshop.model.dao.MemoryCardRepository;
import kr.pe.cshop.model.domain.MemoryCard;

@Aspect
@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(MemoryCardRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new MemoryCard("sn", "brand", "mcName", "price512GB", "price256GB", "price126GB", "price64GB")));
		};
	}
}
