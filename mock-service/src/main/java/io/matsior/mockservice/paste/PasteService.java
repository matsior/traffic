package io.matsior.mockservice.paste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
class PasteService {
  
  private static final Logger log = LoggerFactory.getLogger(PasteService.class);
  
  private final Path uploadPath;
  
  PasteService(@Value("${mock.upload-path}") Path uploadPath) throws IOException {
    this.uploadPath = uploadPath;
    log.info("Uploading files to: {}", uploadPath);
  }
  
  
  public List<String> getAll() {
    try {
      List<String> paste = Files.readAllLines(uploadPath);
      log.info("Returning {} paste", paste.size());
      return paste;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void add(String content) {
    try {
      Files.write(uploadPath, List.of(content), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
}
