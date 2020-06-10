package com.macro.mall.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public String uploadPicture(MultipartFile file, String path);
}
