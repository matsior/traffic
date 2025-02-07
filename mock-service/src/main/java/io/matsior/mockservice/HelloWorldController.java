package io.matsior.mockservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
class HelloWorldController {
  
  @GetMapping("/hello")
  String helloWorld() {
    return "Hello World! " + OffsetDateTime.now();
  }

}
