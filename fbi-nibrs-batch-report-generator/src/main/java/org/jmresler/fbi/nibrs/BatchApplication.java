package org.jmresler.fbi.nibrs;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.services.RefStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {
		"org.jmresler.fbi.nibrs.mappers",
		"org.jmresler.fbi.nibrs"
})
public class BatchApplication implements CommandLineRunner {

	@Autowired
	protected RefStateService service;

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.findAllRefStates().forEach(each -> {
			log.debug(each.toString());
		});
	}
}
