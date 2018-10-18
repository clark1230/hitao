package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class MemberInfoController {
    @Value("${savepath}")
    private String path;
    /**
     * 上传会员头像
     * @param avatar
     * @return
     */
    @PostMapping(value = "/uploadAvatar")
    public ServerResponse<String>  uploadAvatar(@RequestParam("avatar") MultipartFile avatar){
        if(avatar == null){
            return ServerResponse.createByErrorMessage("文件上传失败!");
        }
        try{
            String fileName = UUID.randomUUID().toString()+avatar.getOriginalFilename();
            avatar.transferTo(new File(path+fileName));
            return ServerResponse.createBySuccess("文件上传成功!",fileName);
        }catch (IOException e){
            e.printStackTrace();
            return  ServerResponse.createByErrorMessage("文件上传失败!");
        }
    }
}
