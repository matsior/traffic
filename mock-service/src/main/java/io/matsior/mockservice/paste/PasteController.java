package io.matsior.mockservice.paste;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paste")
class PasteController {
  
  private final PasteService pasteService;
  
  PasteController(PasteService pasteService) {
    this.pasteService = pasteService;
  }
  
  @GetMapping
  List<String> getAll() {
    return pasteService.getAll();
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void add(@RequestBody String content) {
    pasteService.add(content);
  }

}
