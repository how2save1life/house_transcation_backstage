package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(DealPK.class)
public class Deal {
    private String dealHouse;
    private String dealId;
    private String dealBuyer;
    private String dealAgency;
    private BigInteger dealPrice;
    private String dealStatus;
    private Timestamp dealTime;

    @Id
    @Column(name = "deal_house", nullable = false, length = 32)
    public String getDealHouse() {
        return dealHouse;
    }

    public void setDealHouse(String dealHouse) {
        this.dealHouse = dealHouse;
    }

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "deal_id", nullable = false, length = 20)
    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    @Id
    @Column(name = "deal_buyer", nullable = false, length = 20)
    public String getDealBuyer() {
        return dealBuyer;
    }

    public void setDealBuyer(String dealBuyer) {
        this.dealBuyer = dealBuyer;
    }

    @Id
    @Column(name = "deal_agency", nullable = false, length = 20)
    public String getDealAgency() {
        return dealAgency;
    }

    public void setDealAgency(String dealAgency) {
        this.dealAgency = dealAgency;
    }

    @Basic
    @Column(name = "deal_price", nullable = true,length = 10,precision = 2)
    public BigInteger getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigInteger dealPrice) {
        this.dealPrice = dealPrice;
    }

    @Basic
    @Column(name = "deal_status", nullable = true, length = 255)
    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    @Basic
    @Column(name = "deal_time", nullable = true)
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return Objects.equals(dealHouse, deal.dealHouse) &&
                Objects.equals(dealId, deal.dealId) &&
                Objects.equals(dealBuyer, deal.dealBuyer) &&
                Objects.equals(dealAgency, deal.dealAgency) &&
                Objects.equals(dealPrice, deal.dealPrice) &&
                Objects.equals(dealStatus, deal.dealStatus) &&
                Objects.equals(dealTime, deal.dealTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealHouse, dealId, dealBuyer, dealAgency, dealPrice, dealStatus, dealTime);
    }
}
