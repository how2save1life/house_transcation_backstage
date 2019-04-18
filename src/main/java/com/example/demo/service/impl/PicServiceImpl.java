package com.example.demo.service.impl;

import com.example.demo.entity.Owner;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class PicServiceImpl implements PicService {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    HouseRepository houseRepository;

    @Override
    public String saveHead(MultipartFile file, String userType, String userId) {
        String path;//实际路径
        String savePath;//存入数据库的 部分路径
        String type;//文件类型
        String fileName;//文件名
        //判断用户登录类型是否正确
        if (userType == "Owner" || userType == "Agency" || userType == "Buyer") {
            fileName = file.getOriginalFilename();
            System.out.println("上传的文件原名称:" + fileName);
            type = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;//.后缀
            System.out.println(type);
            //文件类型是否为空
            if (type != null) {
                //是否是jpg、png
                if (".PNG".equals(type.toUpperCase()) || ".JPG".equals(type.toUpperCase())) {
                    fileName = userId + type;//文件名 id+后缀名
                    path = "D:/vue/housing_transaction_management/static/pics/head/" + userType + "/" + fileName;//路径
                    savePath = "/pics/head/" + userType + "/" + fileName;//存入数据库的 部分路径
                    try {
                        File temp = new File(path);
                        //
                        isPath(temp);//若路径不存在则创建
                        //
                        file.transferTo(temp);//存图
                        switch (userType) {//三种情况
                            case "Owner":
                                ownerRepository.updateOwnerHead(userId, savePath);//保存路径到数据库
                                break;
                            case "Agency":
                                agencyRepository.updateAgencyHead(userId, savePath);
                                break;
                            case "Buyer":
                                buyerRepository.updateBuyerHead(userId, savePath);
                                break;
                            default:
                                return "userType_error";//用户类型有误
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "error";//异常
                    }
                } else {
                    System.out.println("type error");
                    return "type_error";//文件类型有误
                }
            } else {
                System.out.println("type null");
                return "type_null";//没有文件类型
            }
        } else {
            System.out.println("user error");
            return "user_error";//用户有误
        }
        return "success";//成功
    }

    @Override
    public String saveHousePic(MultipartFile file, String houseId) {
        String housepic[] = houseId.split(",");
        System.out.println(housepic[0]);
        System.out.println(housepic[1]);
        String path;//实际路径
        String savePath;//存入数据库的 部分路径
        String type;//文件类型
        String fileName;//文件名
        //判断用户登录类型是否正确
        if (houseRepository.findByHouseId(housepic[1]) != null) {
            fileName = file.getOriginalFilename();
            System.out.println("上传的文件原名称:" + fileName);
            type = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;//.后缀
            //文件类型是否为空
            if (type != null) {
                //是否是jpg、png
                if (".PNG".equals(type.toUpperCase()) || ".JPG".equals(type.toUpperCase())) {
                    fileName = housepic[0] + type;//文件名 id+后缀名
                    path = "D:/vue/housing_transaction_management/static/pics/house/" + housepic[1] + "/" + fileName;//路径
                    savePath = "/pics/house/" + housepic[1] + "/";//+ fileName;//存入数据库的 部分路径
                    try {
                        File temp = new File(path);
                        //
                        isPath(temp);//若路径不存在则创建
                        //
                        file.transferTo(temp);//存图
                        houseRepository.updateHousePic(housepic[1], savePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "error";//异常
                    }
                } else {
                    System.out.println("type error");
                    return "type_error";//文件类型有误
                }
            } else {
                System.out.println("type null");
                return "type_null";//没有文件类型
            }
        } else {
            System.out.println("house null");
            return "house_null";//用户有误
        }
        return "success";//成功
    }


    private void isPath(File temp) {
        if (!temp.getParentFile().exists()) { //判断父目录路径是否存在，即.jpg前的
            try {
                temp.getParentFile().mkdirs();//不存在则创建父目录
                temp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


