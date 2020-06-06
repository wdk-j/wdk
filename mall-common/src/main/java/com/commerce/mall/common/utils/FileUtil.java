package com.commerce.mall.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Slf4j
public class FileUtil {

    /**
     * 这里上传指定的文件到此module所属的project目录
     */
    private static final String BASE_DIR = System.getProperty("user.dir") + File.separator;

    /**
     * 一级目录
     */
    private static final String FIRST_DIR = "uploads";

    /**
     * 默认二级目录
     */
    private static final String SECOND_DIR_DEFAULT = "default";

    public static String fullFilename(String originalFilename) {
        long currentMillions = DateUtil.current(false);
        String prefix = DateUtil.format(new Date(currentMillions), "yyyyMMddHHmmss");
        String suffix = RandomUtil.randomNumbers(5);
        String newFileName = prefix + "_" + suffix;
        String extensionName = FilenameUtils.getExtension(originalFilename);
        return newFileName + "." + extensionName;
    }

    /**
     *
     * 一级目录: upload
     * 二级目录: 请提供
     *
     * @param file file
     * @param path path，不带分隔符
     * @return 相对url
     * @throws IOException IOException
     */
    public static String upload(MultipartFile file, String path) throws IOException {
//        命名格式
//        20200603142533_84678.jpg
        String filename = fullFilename(file.getOriginalFilename());
        String compressedFilename = fullFilename(file.getOriginalFilename());

        // 保存压缩文件的路径
        String savePath = BASE_DIR + "upload" + File.separator + path;

        String tempFileSavePath = savePath + File.separator + filename;
        log.info(tempFileSavePath);
        File tempFile = new File(tempFileSavePath);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        file.transferTo(tempFile);

        String compressedFileSavePath = savePath + File.separator + compressedFilename;

        String s = zipFile(file, tempFile, compressedFileSavePath, tempFileSavePath);
        log.info(s.replace(BASE_DIR, ""));
        return s.replace(BASE_DIR, "");
    }

    /**
     * 文件删除
     *
     * @param url  url
     * @param path path
     * @return code
     */
    public static boolean delete(String url, String path) {
        //TODO 文件删除
        return false;
    }

    public static String zipFile(MultipartFile file, File tempFile, String zipFileSavePath, String tempFileSavePath) {
        try {
            long size = file.getSize() / 1024;
            // 判断文件大小对图片质量进行压缩,尺寸不变，
            // 范围0.01~1.0,值越低压缩效率越高。图片低于600K不进行压缩
            if (size >= 7380) {
                Thumbnails.of(tempFileSavePath).scale(1f).outputQuality(0.01f).toFile(zipFileSavePath);
                tempFile.delete();
                return zipFileSavePath;
            } else if (size >= 4096) {
                Thumbnails.of(tempFileSavePath).scale(1f).outputQuality(0.2f).toFile(zipFileSavePath);
                tempFile.delete();
                return zipFileSavePath;
            } else if (size >= 1024) {
                Thumbnails.of(tempFileSavePath).scale(1f).outputQuality(0.3f).toFile(zipFileSavePath);
                tempFile.delete();
                return zipFileSavePath;
            } else if (size >= 600) {
                Thumbnails.of(tempFileSavePath).scale(1f).outputQuality(1f).toFile(zipFileSavePath);
                tempFile.delete();
                return zipFileSavePath;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        // 低于600K不进行压缩
        return tempFileSavePath;
    }
}
