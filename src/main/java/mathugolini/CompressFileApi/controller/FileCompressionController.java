package mathugolini.CompressFileApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import mathugolini.CompressFileApi.service.FileCompressionService;

@Controller
public class FileCompressionController implements FileCompressionControllerInterface{

    @Autowired
    private FileCompressionService fileCompressionService;

    @Autowired
    public FileCompressionController(FileCompressionService fileCompressionService) {
        this.fileCompressionService = fileCompressionService;
    }

    @Override
    public ResponseEntity<String> compressFile(@RequestParam("file") MultipartFile file) {
        String compressedFileName = fileCompressionService.compressFile(file);
        return ResponseEntity.ok("Arquivo comprimido com sucesso: " + compressedFileName);
    }
}
