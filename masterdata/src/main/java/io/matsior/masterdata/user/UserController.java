package io.matsior.masterdata.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {
  
  private final RestClient restClient;
  
  UserController(RestClient.Builder restClientBuilder) {
    this.restClient = restClientBuilder
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();
  }
  
  @GetMapping
  List<User> getAll() {
    return restClient.get()
            .uri("/users")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });
  }
  
  record User(@JsonProperty("name") String name,
              @JsonProperty("email") String email) {
  }
  
}
