package com.example.demo.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ResultAll {
    private String dealId;
    private String dealHouse;
    private String houseAddr;
    private BigDecimal houseArea;
    private String houseLayout;
    private String houseName;
    private BigDecimal housePrice;
    private String houseStatus;
    private String houseType;
    private String dealBuyer;
    private String dealOwner;
    private String dealAgency;
    private String houseDescribe;
    private String housePic;
    private String agencyName;
    private String agencyPhone;
    private String ownerName;
    private String ownerPhone;
    private String buyerName;
    private String buyerPhone;
    private BigDecimal dealPrice;
    private String dealStatus;
    private String dealTime;


    public ResultAll() {//构造函数
    }


    //构造函数
    public ResultAll(
            String dealId,
            String dealHouse,
            String houseAddr,
            BigDecimal houseArea,
            String houseLayout,
            String houseName,
            BigDecimal housePrice,
            String houseStatus,
            String houseType,
            String dealBuyer,
            String dealOwner,
            String dealAgency,
            String houseDescribe,
            String housePic,
            String agencyName,
            String agencyPhone,
            String ownerName,
            String ownerPhone,
            String buyerName,
            String buyerPhone,
            BigDecimal dealPrice,
            String dealStatus,
            String dealTime

    ) {
        this.dealId = dealId;
        this.dealHouse = dealHouse;
        this.houseAddr = houseAddr;
        this.houseArea = houseArea;
        this.houseLayout = houseLayout;
        this.houseName = houseName;
        this.housePrice = housePrice;
        this.houseStatus = houseStatus;
        this.houseType = houseType;
        this.dealBuyer = dealBuyer;
        this.dealOwner = dealOwner;
        this.dealAgency = dealAgency;
        this.houseDescribe = houseDescribe;
        this.housePic = housePic;
        this.agencyName = agencyName;
        this.agencyPhone = agencyPhone;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.dealPrice = dealPrice;
        this.dealStatus = dealStatus;
        this.dealTime = dealTime;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealHouse() {
        return dealHouse;
    }

    public void setDealHouse(String dealHouse) {
        this.dealHouse = dealHouse;
    }

    public String getDealOwner() {
        return dealOwner;
    }

    public void setDealOwner(String dealOwner) {
        this.dealOwner = dealOwner;
    }

    public String getDealAgency() {
        return dealAgency;
    }

    public void setDealAgency(String dealAgency) {
        this.dealAgency = dealAgency;
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr;
    }

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseLayout() {
        return houseLayout;
    }

    public void setHouseLayout(String houseLayout) {
        this.houseLayout = houseLayout;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(BigDecimal housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseAgency() {
        return dealAgency;
    }

    public void setHouseAgency(String dealAgency) {
        this.dealAgency = dealAgency;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getHouseDescribe() {
        return houseDescribe;
    }

    public void setHouseDescribe(String houseDescribe) {
        this.houseDescribe = houseDescribe;
    }

    public String getHousePic() {
        return housePic;
    }

    public void setHousePic(String housePic) {
        this.housePic = housePic;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealBuyer() {
        return dealBuyer;
    }

    public void setDealBuyer(String dealBuyer) {
        this.dealBuyer = dealBuyer;
    }
}
