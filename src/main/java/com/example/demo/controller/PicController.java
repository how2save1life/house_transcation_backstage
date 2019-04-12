package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

@RestController
@RequestMapping(value = "/Pic", produces = {"application/json;charset=UTF-8"})
public class PicController {
    @RequestMapping(value = "/Owner/myHead/{id}")
    public String upload(@RequestParam("file") MultipartFile file, @PathVariable("id") String ownerId) throws IOException {
        // 获取文件名
        //
        String tail = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = ownerId + tail;
        // 在file文件夹中创建名为fileName的文件
        OutputStreamWriter op = new OutputStreamWriter(new FileOutputStream("D:/Java/demo/src/main/resources/pics/head/Owner/" + fileName), "UTF-8");
        // 获取文件输入流
        InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
        char[] bytes = new char[12];
        // 如果这里的bytes不是数组，则每次只会读取一个字节，例如test会变成 t   e     s    t
        while (inputStreamReader.read(bytes) != -1) {
            op.write(bytes);
        }
        // 关闭输出流
        op.close();
        // 关闭输入流
        inputStreamReader.close();
        return "上传成功";
    }
}
