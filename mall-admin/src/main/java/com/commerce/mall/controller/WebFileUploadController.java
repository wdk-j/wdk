package com.commerce.mall.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.common.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.list.CursorableLinkedList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Controller
@Api(tags = "WebFileUploadController",description = "文件上传")
@RequestMapping("/file")
@Slf4j
public class WebFileUploadController {


    @ApiOperation("单个文件上传")
    @PostMapping("/single")
    @ResponseBody
    public CommonResult<Object> fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
        try {
            String url = FileUtil.upload(file, "test");
            return CommonResult.success(url);
        } catch (IOException e) {
            return CommonResult.failed(e.getMessage());
        }

    }

    @ApiOperation("单个文件上传")
    @PostMapping("/multi")
    @ResponseBody
    public CommonResult<Object> filesUpload(@RequestParam("files") MultipartFile[] files, HttpServletRequest req) {
        List<String> urls = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            try {
                String url = FileUtil.upload(file, "test");
                urls.add(url);
            } catch (IOException e) {
                return CommonResult.failed(e.getMessage());
            }
        }
        return CommonResult.success(urls);
    }
}
