package com.example.demo.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

public interface PicService {
    String saveHead(MultipartFile file, String userType,String userId);

    String saveHousePic(MultipartFile file, String houseId);

}
