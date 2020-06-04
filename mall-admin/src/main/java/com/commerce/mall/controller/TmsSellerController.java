package com.commerce.mall.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.model.TmsSeller;
import com.commerce.mall.service.impl.TmsSellerServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = {"TmsSellerController"},description = "商家管理")
@RequestMapping("/seller")
public class TmsSellerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TmsSellerController.class);

    @Autowired
    private TmsSellerServiceImpl tmsSellerService;

    @ApiOperation(value = "根据商家id查询商家信息")
    @GetMapping("/{sellerId}")
    @ResponseBody
    public CommonResult<Object> getSellers(@PathVariable("sellerId") Integer sellerId){
        TmsSeller tmsSellerById = tmsSellerService.getTmsSellerById(sellerId);
        return CommonResult.success(tmsSellerById);
    }


    @ApiOperation(value = "添加商家")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<Object> addSeller(TmsSeller tmsSeller){
        int rows = tmsSellerService.addTmsSeller(tmsSeller);
        if(rows>0){
            return CommonResult.success(null);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据商家id删除商家")
    @PostMapping("/delete/{sellerId}")
    @ResponseBody
    public CommonResult<Object> deleteSeller(@PathVariable("sellerId") Integer sellerId){
        int rows = tmsSellerService.deleteTmsSellerById(sellerId);
        if(rows>0){
            return CommonResult.success(null);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据商家Id修改商家信息")
    @PostMapping("/update/{sellerId}")
    @ResponseBody
    public CommonResult<Object> updateSeller(@PathVariable("sellerId")Integer sellerId, TmsSeller tmsSeller){
        tmsSeller.setSellerId(sellerId);
        int rows = tmsSellerService.updateTmsSeller(tmsSeller);
        if(rows>0){
            return CommonResult.success(null);
        }
            return CommonResult.failed();
    }


    @ApiOperation(value = "分页查询商家列表")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<Object> pagedList(@RequestParam(required = false ,defaultValue = "1" )int pageNum,
                                          @RequestParam(required = false ,defaultValue = "5" )int pageSize,
                                          @RequestParam(required = false )String keyWord){
        PageInfo<TmsSeller> tmsSellerPageInfo = tmsSellerService.pagedList(pageNum, pageSize, keyWord);
        return CommonResult.success(tmsSellerPageInfo);
    }

    @ApiOperation(value = "修改商家isDelete")
    @PostMapping("/update/isDelete")
    @ResponseBody
    public CommonResult<Object> updateAttrIsDelete(Integer sellerId , String isDelete){
        int rows = tmsSellerService.updateAttrIsDelete(sellerId, isDelete);
        if(rows>0){
            return CommonResult.success(null);
        }
            return CommonResult.failed();
    }

    @ApiOperation(value = "修改商家closed")
    @PostMapping("/update/closed")
    @ResponseBody
    public CommonResult<Object> updateAttrClosed(@Validated @PathVariable("sellerId") Integer sellerId ,@Validated @PathVariable("closed") String closed){
        int rows = tmsSellerService.updateAttrClosed(sellerId, closed);
        if(rows>0){
            return CommonResult.success(null);
        }
            return CommonResult.failed();
    }

}
