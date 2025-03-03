package io.matsior.mockservice.masterdata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class MasterdataClient {
  
  private final RestClient restClient;
  
  public MasterdataClient(RestClient.Builder restClientBuilder, @Value("${masterdata-url}") String masterdataUrl) {
    this.restClient = restClientBuilder
            .baseUrl(masterdataUrl)
            .build();
  }
  
  public List<Country> fetchAllCountries() {
    return restClient.get()
            .uri("/countries")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });
  }
  
  public List<City> fetchAllCities() {
    return restClient.get()
            .uri("/cities")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });
  }
  
}
