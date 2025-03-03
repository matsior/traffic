package io.matsior.masterdata.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
class UserService {
  
  private final RestClient restClient;
  
  UserService(RestClient.Builder restClientBuilder) {
    this.restClient = restClientBuilder
            .baseUrl("http://jsonplaceholder.typicode.com")
            .build();
  }
  
  List<User> getAllUsers() {
    return restClient.get()
            .uri("/users")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });
  }
  
}
