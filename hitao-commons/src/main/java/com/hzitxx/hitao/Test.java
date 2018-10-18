package com.hzitxx.hitao;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file2 =new File("F:\\ip2.txt"); // 重命名前的文件
        File renameFile = new File("‪F:/io4/ip3.txt"); // 重命名后的文件
        // 把a.txt 重命名为 b.txt
        boolean result = file2.renameTo(renameFile);
        System.out.println(result);
    }
}
