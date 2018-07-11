package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/shopBrand")
public class ShopBrandController {
    /**
     * 上传会员头像
     * @param pic
     * @return
     */
    @PostMapping(value = "/uploadPic")
    public ServerResponse<String> uploadAvatar(@RequestParam("pic") MultipartFile pic){
        if(pic == null){
            return ServerResponse.createByErrorMessage("文件上传失败!");
        }
        try{
            String fileName = UUID.randomUUID().toString()+pic.getOriginalFilename();
            pic.transferTo(new File("D:/hitao_images2/"+fileName));
            return ServerResponse.createBySuccess("/static/"+fileName);
        }catch (IOException e){
            e.printStackTrace();
            return  ServerResponse.createByErrorMessage("文件上传失败!");
        }
    }
}
