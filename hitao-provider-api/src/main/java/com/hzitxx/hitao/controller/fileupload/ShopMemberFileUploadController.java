package com.hzitxx.hitao.controller.fileupload;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.fileupload.ShopMemberFileUploadSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ShopMemberFileUploadController {
    @Autowired
    private ShopMemberFileUploadSevice shopMemberFileUploadSevice;

    /**
     * 处理会员头像上传
     * @param avatar
     * @return
     */
    @PostMapping(value = "/uploadAvatar")
    public ServerResponse uploadAvatar(@RequestParam("avatar")MultipartFile avatar){
        return this.shopMemberFileUploadSevice.uploadAvatar(avatar);
    }
}
