package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("fileupload")
public class ShopGoodsController {
    @Value("${server.port}")
    private int port;

    @Value("${savepath}")
    private String path;

    @Value("${eureka.instance.hostname}")
    private String hostname;
    /**
     * 上传商品主图
     * @return
     */
    @PostMapping("/uploadShopGoodsImage")
    public  Object uploadShopGoodsImage(MultipartFile file){
        if(file == null){
            return ServerResponse.createByErrorMessage("文件上传失败!");
        }
        try{
            String fileName = UUID.randomUUID().toString()+file.getOriginalFilename();
            file.transferTo(new File(path+ fileName));
            return ServerResponse.createBySuccess("文件上传成功!",fileName);
        }catch (IOException e){
            return  ServerResponse.createByErrorMessage("文件上传失败!");
        }
    }
}
