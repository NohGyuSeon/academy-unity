package com.daonplace.springbootweb.service.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.Image;
import com.daonplace.springbootweb.dto.user.ImageUploadDto;
import com.daonplace.springbootweb.repository.user.ImageRepository;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    // 6. 이미지가 저장되는 경로 호출하기
    @Value("${file.path}")
    private String uploadFolder;

    @Transactional
    public void upload(ImageUploadDto imageUploadDto,
        PrincipalDetails principalDetails) {
        // 2. UUID 객체를 생성한다.
        UUID uuid = UUID.randomUUID();
        // 1. 업로드 되는 원본 파일명을 imageFileName 이라고 지정한다.
        // 3. UUID를 더한 값으로 지정한다.
        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();
        // 4. UUID가 적용된 파일명 확인하기
        System.out.println(imageFileName);
        // 5. image 저장 경로 확인하기
        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        // 7. 파일을 업로드하기
        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser());
        Image imageEntity = imageRepository.save(image);

        System.out.println("imageEntity : " + imageEntity);
    }

}
