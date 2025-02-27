package io.matsior.masterdata.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
class CityController {
  
  @GetMapping
  List<City> getAll() {
    return List.of(
            new City("Gdynia"),
            new City("Olsztyn"),
            new City("Berlin")
    );
  }
  
  record City(String name) {
  }
  
}
