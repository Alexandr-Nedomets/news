package com.good.news.services.files;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
public class FilesService {

    @Value("${path.upload.file}")
    private String PATH_UPLOAD_FILE;

    public String upload(MultipartFile file) {
        String imageName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String fileName = PATH_UPLOAD_FILE + imageName;
        try {
            log.info("Файл загружается: " + imageName);
            file.transferTo(new File(fileName));
            log.info("Файл загружен: " + imageName);
        } catch (IOException e) {
            log.error("Ошибка при загрузки файла: " + imageName);
            e.printStackTrace();
        }
        return imageName;
    }

    public void delete(String fileName) {
        try {
            log.info("Файл удаляется: " + fileName);
            Files.delete(Paths.get(PATH_UPLOAD_FILE + fileName));
            log.info("Файл удален: " + fileName);
        } catch (IOException e) {
            log.error("Ошибка при удалении файла: " + fileName);
            e.printStackTrace();
        }
    }
}

