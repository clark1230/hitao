package com.hzitxx.hitao.oss;

import com.aliyun.oss.OSSClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 上传文件
 */
public class UploadFile {
    public static void main(String[] args) throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAIa2gt5ypc31f6";
        String accessKeySecret = "md6fT59gxuFg5EZ9l7KVv3Xa347Ora";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        // ossClient.putObject(
        // "<yourBucketName>", // 自己配置的存储空间 hitao-images
        // "<yourObjectName>", // 自定义存储空间和文件名字
        // hitao-images/images/a.jpg
        //hitao-images/images2/2.jpg
        // new File("<yourLocalFile>") // 本地文件的路径
        // );
        InputStream inputStream =
                new FileInputStream("T:/"+ "array.png");
        ossClient.putObject("hitao-images",
                UUID.randomUUID().toString()+"array.png",
                inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
