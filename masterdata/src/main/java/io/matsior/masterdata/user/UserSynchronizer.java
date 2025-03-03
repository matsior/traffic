package io.matsior.masterdata.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
class UserSynchronizer {
  
  private static final Logger log = LoggerFactory.getLogger(UserSynchronizer.class);
  
  private final UserService userService;
  
  public UserSynchronizer(UserService userService) {
    this.userService = userService;
  }
  
  @Scheduled(fixedRate = 10000)
  public void synchronize() {
    log.info("Synchronizing users...");
    long start = System.currentTimeMillis();
    int allUsers = userService.getAllUsers().size();
    long end = System.currentTimeMillis();
    log.info("All users: {}. Time taken: {}ms", allUsers, end - start);
  }
  
}
