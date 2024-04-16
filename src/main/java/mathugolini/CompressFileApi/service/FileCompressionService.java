package mathugolini.CompressFileApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileCompressionService {

    public String compressFile(MultipartFile file) {
        try {
            String outputFileName = file.getOriginalFilename() + ".zip";
            // Criar um arquivo zip
            FileOutputStream fos = new FileOutputStream(outputFileName);
            ZipOutputStream zop = new ZipOutputStream(fos);

            // Adicionar o arquivo enviado ao arquivo zip
            ZipEntry zipEntry = new ZipEntry(file.getOriginalFilename());
            zop.putNextEntry(zipEntry);
            zop.write(file.getBytes());

            // Fechar o arquivo zip
            zop.closeEntry();
            zop.close();
            fos.close();
            return outputFileName;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao comprimir o arquivo " + e.getMessage());
        }
    }
}
