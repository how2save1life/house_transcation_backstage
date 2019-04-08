package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class House {
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



    @Id
    @Column(name = "house_id", nullable = false, length = 32)
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
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
    @Column(name = "house_area", nullable = true, length = 20)
    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
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
    @Column(name = "house_name", nullable = true, length = 20)
    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
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
    @Column(name = "house_status", nullable = true, length = 255)
    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    @Basic
    @Column(name = "house_type", nullable = true, length = 20)
    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(houseId, house.houseId) &&
                Objects.equals(houseAddr, house.houseAddr) &&
                Objects.equals(houseArea, house.houseArea) &&
                Objects.equals(houseLayout, house.houseLayout) &&
                Objects.equals(houseName, house.houseName) &&
                Objects.equals(housePrice, house.housePrice) &&
                Objects.equals(houseStatus, house.houseStatus) &&
                Objects.equals(houseType, house.houseType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, houseAddr, houseArea, houseLayout, houseName, housePrice, houseStatus, houseType);
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
}
