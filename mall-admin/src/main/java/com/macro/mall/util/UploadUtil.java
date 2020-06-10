package com.macro.mall.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class UploadUtil {
    /**
     * @// TODO: 2020/6/6
     * 注意 path 为 /upload/product  是在根目录下创建目录
     * 注意 path 为 upload/product  是在项目目录目录下创建目录
     * @return 文件保存全路径， null保存失败
     *
     * */
    public static String saveFile(MultipartFile file,String path){
        //按日期创建文件夹
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        File file1 = new File(path+"/"+date);
        if (!file1.exists()){
            boolean mkdirs = file1.mkdirs();
            if (!mkdirs) return null;
        }
        //创建文件
        File file2 = new File(file1, getFileName(file.getOriginalFilename()));
        if (!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        //写入文件
        try {
            FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(file2));
        } catch (IOException e) {
            file2.delete();
            return null;
        }
        return file2.getAbsoluteFile().toString();
    }

    public static String getFileName(String oldName){
        //获取文件后缀
        String suff = oldName.substring(oldName.lastIndexOf("."));
        String filename = getNowTime() + "_" + (int)((Math.random() * 9 + 1) * 100000) + suff;
        return filename;
    }

    public static String getNowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(new Date());
        return format;
    }

}
