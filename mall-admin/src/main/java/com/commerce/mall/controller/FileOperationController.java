package com.commerce.mall.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.common.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.07
 */
@Api(tags = "FileOperationController", description = "文件上传")
@RestController
@RequestMapping("/file")
@Slf4j
public class FileOperationController {

    @ApiOperation("单文件上传")
    @PostMapping("/single")
    public CommonResult<Object> singleFileUpload(MultipartFile file) {
        try {
            String url = FileUtil.upload(file, "test");
            return CommonResult.success(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

    @ApiOperation("多文件上传")
    @PostMapping("/multi")
    public CommonResult<Object> multiFileUpload(MultipartFile[] files) {
        List<String> urls = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                String url = FileUtil.upload(file, "test");
                urls.add(url);
            }
            return CommonResult.success(urls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

    @ApiOperation("文件删除")
    @PostMapping("/remove")
    public CommonResult<Object> removeFile(String relativePath) {
        return CommonResult.success(FileUtil.delete(relativePath));
    }
}
