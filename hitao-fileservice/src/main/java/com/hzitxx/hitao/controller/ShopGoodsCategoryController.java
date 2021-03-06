package com.hzitxx.hitao.controller;

import com.aliyun.oss.OSSClient;
import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/shopGoodsCategory")
public class ShopGoodsCategoryController {


    /**
     * 文件上传数据中心
     */
    @Value("${oss.endpoint}")
    private String endPoint;
    /**
     * oss账号
     */
    @Value("${oss.accessKeyId}")
    private String accessKeyId;
    /**
     * oss密码
     */
    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;
    /**
     * 上传商品类目图片
     * @param iconImage
     * @return
     */
    @PostMapping(value = "/uploadCategory")
    public ServerResponse<String> uploadAvatar(@RequestParam("iconImage") MultipartFile iconImage){
        if(iconImage== null){
            return ServerResponse.createByErrorMessage("会员头像上传失败!");
        }
        String fileName = null;
        try {
            OSSClient client = new OSSClient("http://"+endPoint,
                    accessKeyId,
                    accessKeySecret);
            // 上传文件
            fileName = UUID.randomUUID().toString()+ iconImage.getOriginalFilename();
            client.putObject("hitao-images",fileName,iconImage.getInputStream());
            String url = "https://bucketName.endPoint/fileName";
            url =url.replace("bucketName","hitao-images");
            url =url.replace("endPoint",endPoint);
            url = url.replace("fileName",fileName);
            return ServerResponse.createBySuccess("商品类目图片上传成功!",url);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("商品类目图片上传失败！");
        }
    }
}
