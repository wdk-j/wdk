package com.macro.mall.service.impl;

import com.macro.mall.service.UploadService;
import com.macro.mall.util.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadServiceImpl.class);
    @Override
    public String uploadPicture(MultipartFile file, String path) {
        try {
            String newPicPath = UploadUtil.saveFile(file,path);
            if(newPicPath == null){
                throw new IOException("创建文件失败");
            }
            return newPicPath;
        }catch (IOException e){
            LOGGER.warn("文件创建异常:{}", e.getMessage());
        }
        return "";
    }
}
