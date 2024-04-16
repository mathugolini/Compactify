package mathugolini.CompressFileApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

public interface FileCompressionControllerInterface {
    @PostMapping(value = "/compress")
    ResponseEntity<String> compressFile(MultipartFile file);
}
