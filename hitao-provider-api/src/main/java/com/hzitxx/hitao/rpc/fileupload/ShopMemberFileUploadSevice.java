package com.hzitxx.hitao.rpc.fileupload;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.fileupload.fallback.ShopMemberFileUploadServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "fileupload-service",fallback = ShopMemberFileUploadServiceImpl.class)
public interface ShopMemberFileUploadSevice {
    /**
     * 处理用户头像上传
     * @param avatar
     * @return
     */
    @RequestMapping(value = "/uploadAvatar",method = RequestMethod.POST)
    public ServerResponse uploadAvatar(@RequestParam("avatar")MultipartFile avatar);
}
