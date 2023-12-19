package org.jmresler.fbi.nibrs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class NibrsWebTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(NibrsWebTesterApplication.class, args);
    }
}
