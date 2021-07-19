package com.good.news.services.files;

import lombok.extern.slf4j.Slf4j;
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

    private static String PATH_UPLOAD_FILE = new File("src/main/resources/static/uploads/images").getAbsolutePath() + "/";

    public String upload(MultipartFile file) {
        String imageName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String result = "/uploads/images/" + imageName;
        String fileName = PATH_UPLOAD_FILE + imageName;
        try {
            log.info("Файл загружается: " + imageName);
            file.transferTo(new File(fileName));
            log.info("Файл загружен: " + imageName);
        } catch (IOException e) {
            log.error("Ошибка при загрузки файла: " + imageName);
            e.printStackTrace();
        }
        return result;
    }

    public void delete(String fileName) {
        try {
            log.info("Файл удаляется: " + fileName);
            Files.delete(Paths.get(fileName));
            log.info("Файл удален: " + fileName);
        } catch (IOException e) {
            log.error("Ошибка при удалении файла: " + fileName);
            e.printStackTrace();
        }
    }
}

