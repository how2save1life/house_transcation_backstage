package com.example.demo.service.impl;

import com.example.demo.entity.Agency;
import com.example.demo.entity.House;
import com.example.demo.entity.ResultHouse;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public String saveOne(House house) {
        boolean flag = false;
        String agency = house.getHouseAgency();
        String owner = house.getHouseOwner();
        if (agencyRepository.findOneByAgencyId(agency) != null &&
                ownerRepository.findOneByOwnerId(owner) != null) {
            House isHouse = houseRepository.findOneByHouseNameAndHouseAddrAndHouseOwner(house.getHouseName(), house.getHouseAddr(), house.getHouseOwner());
            if (isHouse == null || (isHouse != null && !isHouse.getHouseStatus().equals("onsale"))) {
                //该业主在该小区的该房房源未发布过   || 房源曾经发布过 但不是onsale状态            =>保存
                try {
                    houseRepository.save(house);
                    flag = true;
                } catch (Exception e) {
                    System.out.println("save house failed" + e.getMessage());
                }
            } else {
                return "existed";//该房已添加过
            }
        } else {
            return "info_needed";//信息有误
        }
        return flag ? "success" : "failed";
    }

    @Override
    public String deleteOne(String houseId) {
        boolean flag = false;
        House house = findOne(houseId);
        if (house != null) {//存在
            try {
                houseRepository.delete(house);
                flag = true;
            } catch (Exception e) {
                System.out.println("delete house failed" + e.getMessage());
            }
        } else {
            return "not_existed";
        }

        return flag == true ? "success" : "failed";
    }

    @Override
    public String updateHouse(House house) {
        boolean flag = false;
        String houseId = house.getHouseId();
        String houseAddr = house.getHouseAddr();
        BigDecimal houseArea = house.getHouseArea();
        String houseLayout = house.getHouseLayout();
        String houseName = house.getHouseName();
        BigDecimal housePrice = house.getHousePrice();
        String houseStatus = house.getHouseStatus();
        String houseType = house.getHouseType();
        String houseAgency = house.getHouseAgency();
        String houseDescribe = house.getHouseDescribe();
        if (house.getHouseId() != null) {
            try {
                System.out.println(houseId);
                houseRepository.updateHouse(houseId, houseAddr, houseArea, houseLayout, houseName, housePrice, houseType, houseAgency, houseStatus, houseDescribe);
                flag = true;
            } catch (Exception e) {
                System.out.println("update house failed" + e.getMessage());
            }
        } else {
            return "id_required";
        }

        return flag == true ? "success" : "failed";
    }

    @Override
    public House findOne(String houseId) {
        House house = houseRepository.findByHouseId(houseId);
        return house;
    }

    @Override
    public List<House> findAll() {
        List<House> houses = houseRepository.findAll();
        return houses;
    }

    @Override
    public List<ResultHouse> findAllHouseInfo() {
        List<ResultHouse> houses = houseRepository.findAllHouseInfo();
        return houses;
    }

    @Override
    public List<ResultHouse> findHouseByOwner(String houseOwner) {
        List<ResultHouse> houses = houseRepository.findHouseByOwner(houseOwner);
        return houses;
    }

    @Override
    public String getHouseData() {
        String result;
        long Sum = houseRepository.count();
        long Sold = houseRepository.countByHouseStatus("sold");
        long OnSale = houseRepository.countByHouseStatus("onsale");
        long left = Sum - Sold - OnSale;
        /*long Unsold = */
        result = String.valueOf(Sum) + ',' + Sold + ',' + OnSale + ',' + left;
        return result;
    }

    @Override
    public String getHouseLayoutData() {
        String result;

        long one = houseRepository.countByHouseLayout("one");
        long two = houseRepository.countByHouseLayout("two");
        long three = houseRepository.countByHouseLayout("three");
        long four = houseRepository.countByHouseLayout("four");
        long five = houseRepository.countByHouseLayout("five");
        long more = houseRepository.countByHouseLayout("more");

        result = String.valueOf(one) + ',' + two + ',' + three + ',' + four + ',' + five + ',' + more;
        return result;
    }
}
