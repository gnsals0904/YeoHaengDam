package com.ssafy.yeohaengdam.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${app.upload.dir}")
    private String uploadDir;

    public String saveFile(MultipartFile file) throws IOException {
        // 현재 작업 디렉토리를 기준으로 절대 경로 생성
        String projectDir = System.getProperty("user.dir");
        Path uploadPath = Paths.get(projectDir, uploadDir);

        System.out.println("Current directory: " + projectDir);
        System.out.println("Upload directory: " + uploadPath.toString());

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        String fileName = file.getOriginalFilename();
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        file.transferTo(filePath.toFile());
        return filePath.toString();
    }
}
