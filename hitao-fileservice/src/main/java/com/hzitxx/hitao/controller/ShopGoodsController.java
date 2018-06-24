package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("fileupload")
public class ShopGoodsController {
    @Value("${server.port}")
    private int port;

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
            file.transferTo(new File("D:/hitao_images2/"+file.getOriginalFilename()));
        }catch (IOException e){
            return  ServerResponse.createByErrorMessage("文件上传失败!");
        }
        return ServerResponse.createBySuccess("http://localhost:8096/static/"+file.getOriginalFilename());
    }
}
