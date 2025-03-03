package io.matsior.masterdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MasterdataApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(MasterdataApplication.class, args);
  }
  
}
