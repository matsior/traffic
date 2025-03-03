package io.matsior.masterdata.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {
  
  private final UserService userService;
  
  UserController(UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping
  List<User> getAll() {
    return userService.getAllUsers();
  }
  
}
