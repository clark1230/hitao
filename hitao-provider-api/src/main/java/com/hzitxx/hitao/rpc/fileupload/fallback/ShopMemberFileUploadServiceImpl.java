package com.hzitxx.hitao.rpc.fileupload.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.fileupload.ShopMemberFileUploadSevice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ShopMemberFileUploadServiceImpl implements ShopMemberFileUploadSevice {
    @Override
    public ServerResponse uploadAvatar(MultipartFile avatar) {
        return ServerResponse.createByErrorMessage("文件上传微服务调用失败!");
    }
}
