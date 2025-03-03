package io.matsior.mockservice.destination;

import io.matsior.mockservice.masterdata.City;
import io.matsior.mockservice.masterdata.Country;
import io.matsior.mockservice.masterdata.MasterdataClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/destinations")
class DestinationController {
  
  private final MasterdataClient masterdataClient;
  
  DestinationController(MasterdataClient masterdataClient) {
    this.masterdataClient = masterdataClient;
  }
  
  @GetMapping
  List<DestinationResponse> getAll() {
    
    Stream<String> countries = masterdataClient.fetchAllCountries().stream().map(Country::name);
    Stream<String> cities = masterdataClient.fetchAllCities().stream().map(City::name);
    
    return Stream.concat(countries, cities)
            .map(DestinationResponse::new)
            .toList();
  }
  
  record DestinationResponse(String name) {
  }
  
}
