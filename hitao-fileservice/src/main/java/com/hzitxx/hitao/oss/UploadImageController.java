package com.hzitxx.hitao.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadImageController {
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
     * 上传文件
     * @return
     */
    @PostMapping("/uploadMyImages")
    public ServerResponse<String> uploadImage(@RequestParam("myImages") MultipartFile myImages){
       // myImages.getInputStream();//获取到输入流
        if(myImages== null){
            return ServerResponse.createByErrorMessage("文件上传失败!");
        }
        String fileName = null;
        try {
            OSSClient client = new OSSClient("http://"+endPoint,
                    accessKeyId,
                    accessKeySecret);
            // 上传文件
            fileName = UUID.randomUUID().toString()+ myImages.getOriginalFilename();
            PutObjectResult result = client.putObject("hitao-images",fileName,myImages.getInputStream());
            System.out.println(result.getETag());
            System.out.println(result.getResponse()); // 获取响应结果
            //  "https://你的BucketName.你的Endpoint/自定义路径/" + fileName;
            String url = "https://bucketName.endPoint/fileName";
            url =url.replace("bucketName","hitao-images");
            url =url.replace("endPoint",endPoint);
            url = url.replace("fileName",fileName);
            return ServerResponse.createBySuccess("图片上传成功!",url);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("文件上传失败！");
        }
    }
}
