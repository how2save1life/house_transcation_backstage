package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class House {
    private String houseId;
    private String houseName;
    private String houseType;
    private String houseLayout;
    private String houseAddr;
    private BigDecimal houseArea;
    private BigDecimal housePrice;
    private String houseOwner;
    private String houseAgency;
    private String houseStatus;
    private String houseDescribe;
    private String housePic;

    @Id
    @Column(name = "house_id", nullable = false, length = 32)
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "house_name", nullable = true, length = 20)
    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    @Basic
    @Column(name = "house_type", nullable = true, length = 20)
    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Basic
    @Column(name = "house_layout", nullable = true, length = 20)
    public String getHouseLayout() {
        return houseLayout;
    }

    public void setHouseLayout(String houseLayout) {
        this.houseLayout = houseLayout;
    }

    @Basic
    @Column(name = "house_addr", nullable = true, length = 255)
    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr;
    }

    @Basic
    @Column(name = "house_area", nullable = true, precision = 2)
    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    @Basic
    @Column(name = "house_price", nullable = true, precision = 2)
    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(BigDecimal housePrice) {
        this.housePrice = housePrice;
    }

    @Basic
    @Column(name = "house_owner", nullable = true, length = 20)
    public String getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(String houseOwner) {
        this.houseOwner = houseOwner;
    }

    @Basic
    @Column(name = "house_agency", nullable = true, length = 20)
    public String getHouseAgency() {
        return houseAgency;
    }

    public void setHouseAgency(String houseAgency) {
        this.houseAgency = houseAgency;
    }

    @Basic
    @Column(name = "house_status", nullable = true, length = 10)
    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    @Basic
    @Column(name = "house_describe", nullable = true, length = 600)
    public String getHouseDescribe() {
        return houseDescribe;
    }

    public void setHouseDescribe(String houseDescribe) {
        this.houseDescribe = houseDescribe;
    }

    @Basic
    @Column(name = "house_pic", nullable = true, length = 255)
    public String getHousePic() {
        return houseDescribe;
    }

    public void setHousePic(String housePic) {
        this.housePic = housePic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(houseId, house.houseId) &&
                Objects.equals(houseName, house.houseName) &&
                Objects.equals(houseType, house.houseType) &&
                Objects.equals(houseLayout, house.houseLayout) &&
                Objects.equals(houseAddr, house.houseAddr) &&
                Objects.equals(houseArea, house.houseArea) &&
                Objects.equals(housePrice, house.housePrice) &&
                Objects.equals(houseOwner, house.houseOwner) &&
                Objects.equals(houseAgency, house.houseAgency) &&
                Objects.equals(houseStatus, house.houseStatus) &&
                Objects.equals(houseDescribe, house.houseDescribe)&&
                Objects.equals(housePic, house.housePic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, houseName, houseType, houseLayout, houseAddr, houseArea, housePrice, houseOwner, houseAgency, houseStatus, houseDescribe,housePic);
    }
}
