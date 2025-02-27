package io.matsior.masterdata.coutry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
class CountryController {
  
  @GetMapping
  List<Country> getAll() {
    return List.of(
            new Country("Poland", "PL"),
            new Country("Germany", "DE")
    );
  }
  
  record Country(String name, String code) {
  }
  
}
