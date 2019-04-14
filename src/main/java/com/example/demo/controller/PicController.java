package com.example.demo.controller;

import com.example.demo.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/Pic", produces = {"application/json;charset=UTF-8"})
public class PicController {
    @Autowired
    PicService picService;

    @PostMapping(value = "/Agency/myHead/{id}")
    public String uploadAgencyHead(@RequestParam("file") MultipartFile file, @PathVariable("id") String ownerId) throws Exception {
        return picService.saveHead(file, "Agency", ownerId);
    }

    @PostMapping(value = "/Buyer/myHead/{id}")
    public String uploadBuyerHead(@RequestParam("file") MultipartFile file, @PathVariable("id") String ownerId) throws Exception {
        return picService.saveHead(file, "Buyer", ownerId);
    }

    @PostMapping(value = "/Owner/myHead/{id}")
    public String uploadOwnerHead(@RequestParam("file") MultipartFile file, @PathVariable("id") String ownerId) throws Exception {
        return picService.saveHead(file, "Owner", ownerId);
        /*移动到 PicService
        String path = null;
        String type = null;
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件原名称:" + fileName);
        type = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
        if (type != null) {//文件类型是否为空
            //是否是jpg、png
            if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                fileName = ownerId + type;//文件名 id+后缀名
                path = "D:/Java/demo/src/main/resources/pics/head/Owner/" + fileName;//路径
                file.transferTo(new File(path));//存图
            }
            else {
                System.out.println("type error");
                return "type_error";
            }
        }else{
            System.out.println("type null");
            return "type_null";
        }
        return "success";*/

       /*用文件流导致 图片受损
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
        inputStreamReader.close();*/
    }

    @PostMapping(value = "/House/{houseId}")
    public String uploadHousePic(@RequestParam("file") MultipartFile file,@PathVariable("houseId") String houseId){
        return picService.saveHousePic(file,houseId);
    }
}
