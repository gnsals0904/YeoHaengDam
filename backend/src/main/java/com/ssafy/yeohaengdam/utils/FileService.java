package com.ssafy.yeohaengdam.utils;

import com.ssafy.yeohaengdam.article.entity.Image;
import com.ssafy.yeohaengdam.article.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta
        .annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {
    private final ArticleMapper articleMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostConstruct
    public void init() {
        try {
            // src/main/resources/static/uploads 디렉터리 생성
//            ClassPathResource resource = new ClassPathResource("static/uploads/");
//            File staticDir = resource.getFile();
            Files.createDirectories(Paths.get("src/main/resources/static/images"));
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!", e);
        }
    }

    // 확장자 추출 메소드
    public String extractExtension(String originalFileName) {
        int fileExtensionIndex = originalFileName.lastIndexOf('.');

        String fileExtension = originalFileName.substring(fileExtensionIndex + 1);

        if (validateExtension(fileExtension)) return fileExtension;
        throw new RuntimeException("지원하지 않는 확장자");
    }

    // 저장할 파일 이름 구성 메소드
    public String organizeStoredFileName(String originalFileName) {
        String uuidValue = UUID.randomUUID().toString();
        String fileExtension = extractExtension(originalFileName);
        return uuidValue + "." + fileExtension;
    }

    // 저장 경로 반환 메소드
    public String getImageDirectory(String storedFileName, String imageType) throws IOException {
        return Paths.get(Paths.get("src/main/resources/static/images").toString(), imageType, storedFileName).toString();
    }

    // 디렉터리 존재 여부 확인 및 생성 메소드
    private void createDirectoryIfNotExists(String dirPath) throws IOException {
        Path dir = Paths.get(dirPath);
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
    }

    // 이미지 저장 로직
    public Image saveImage(MultipartFile multipartFile, int articleId) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storedFileName = organizeStoredFileName(originalFilename);
        String imageType = extractExtension(originalFilename);

        // 이미지 저장 디렉터리 생성
        String imageDir = getImageDirectory(storedFileName, imageType);
        createDirectoryIfNotExists(Paths.get(imageDir).getParent().toString());
        String basePath = Paths.get("src/main/resources/static/images").toAbsolutePath().toString();
        File file = new File(basePath + "/" + storedFileName);
        multipartFile.transferTo(file);

        Image savedImage = Image.builder()
                .originalName(originalFilename)
                .storedName(storedFileName)
                .articleId(articleId)
                .build();

        articleMapper.createImage(savedImage);
        return savedImage;
    }

    // 전체 이미지 저장
    public List<Image> saveImages(List<MultipartFile> multipartFiles, int articleId) throws IOException {
        List<Image> imageList = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                imageList.add(saveImage(multipartFile, articleId));
            }
        }

        return imageList;
    }

    // 파일 확장자 확인
    public boolean validateExtension(String fileExtension) {
        String[] extension = {"jpg", "jpeg", "bmp", "gif", "png"};
        return Arrays.stream(extension).anyMatch(value -> value.equals(fileExtension));
    }
}