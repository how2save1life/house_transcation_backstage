package com.example.demo.entity;

import java.math.BigDecimal;

public class ResultHouse {
    private String houseId;
    private String houseAddr;
    private BigDecimal houseArea;
    private String houseLayout;
    private String houseName;
    private BigDecimal housePrice;
    private String houseStatus;
    private String houseType;
    private String houseOwner;
    private String houseAgency;
    private String agencyName;
    private String agencyPhone;

    public ResultHouse() {//构造函数
    }
    //构造函数
    public ResultHouse(String houseId,
                       String houseAddr,
                       BigDecimal houseArea,
                       String houseLayout,
                       String houseName,
                       BigDecimal housePrice,
                       String houseStatus,
                       String houseType,
                       String houseOwner,
                       String houseAgency,
                       String agencyName,
                       String agencyPhone) {
        this.houseId = houseId;
        this.houseAddr = houseAddr;
        this.houseArea = houseArea;
        this.houseLayout = houseLayout;
        this.houseName = houseName;
        this.housePrice = housePrice;
        this.houseStatus = houseStatus;
        this.houseType = houseType;
        this.houseOwner = houseOwner;
        this.houseAgency = houseAgency;
        this.agencyName = agencyName;
        this.agencyPhone = agencyPhone;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
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

    public String getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(String houseOwner) {
        this.houseOwner = houseOwner;
    }

    public String getHouseAgency() {
        return houseAgency;
    }

    public void setHouseAgency(String houseAgency) {
        this.houseAgency = houseAgency;
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




}
