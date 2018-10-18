package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/shopGoodsCategory")
public class ShopGoodsCategoryController {

    @Value("${savepath}")
    private String path;
    /**
     * 上传商品类目图片
     * @param iconImage
     * @return
     */
    @PostMapping(value = "/uploadCategory")
    public ServerResponse<String> uploadAvatar(@RequestParam("iconImage") MultipartFile iconImage){
        if(iconImage == null){
            return ServerResponse.createByErrorMessage("文件上传失败!");
        }
        try{
            String fileName = UUID.randomUUID().toString()+iconImage.getOriginalFilename();
            iconImage.transferTo(new File(path+fileName));
            return ServerResponse.createBySuccess("文件上传成功!",fileName);
        }catch (IOException e){
            e.printStackTrace();
            return  ServerResponse.createByErrorMessage("文件上传失败!");
        }
    }
}
