package com.example.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Buyer {
    private String buyerId;
    private String buyerAddr;
    private String buyerAge;
    private String buyerName;
    private String buyerPasswd;
    private String buyerPhone;
    private String buyerSelfid;
    private String buyerSex;
    private String buyerHead;

    @Id
    @Column(name = "buyer_id", nullable = false, length = 20)
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column(name = "buyer_addr", nullable = true, length = 255)
    public String getBuyerAddr() {
        return buyerAddr;
    }

    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
    }

    @Basic
    @Column(name = "buyer_age", nullable = true, length = 3)
    public String getBuyerAge() {
        return buyerAge;
    }

    public void setBuyerAge(String buyerAge) {
        this.buyerAge = buyerAge;
    }

    @Basic
    @Column(name = "buyer_name", nullable = true, length = 20)
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Basic
    @Column(name = "buyer_passwd", nullable = false, length = 20)
    public String getBuyerPasswd() {
        return buyerPasswd;
    }

    public void setBuyerPasswd(String buyerPasswd) {
        this.buyerPasswd = buyerPasswd;
    }

    @Basic
    @Column(name = "buyer_phone", nullable = true, length = 11)
    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    @Basic
    @Column(name = "buyer_selfid", nullable = true, length = 20)
    public String getBuyerSelfid() {
        return buyerSelfid;
    }

    public void setBuyerSelfid(String buyerSelfid) {
        this.buyerSelfid = buyerSelfid;
    }

    @Basic
    @Column(name = "buyer_sex", nullable = true, length = 1)
    public String getBuyerSex() {
        return buyerSex;
    }

    public void setBuyerSex(String buyerSex) {
        this.buyerSex = buyerSex;
    }

    @Basic
    @Column(name = "buyer_head", nullable = true, length = 255)
    public String getBuyerHead() {
        return buyerHead;
    }

    public void setBuyerHead(String buyerHead) {
        this.buyerHead = buyerHead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(buyerId, buyer.buyerId) &&
                Objects.equals(buyerAddr, buyer.buyerAddr) &&
                Objects.equals(buyerAge, buyer.buyerAge) &&
                Objects.equals(buyerName, buyer.buyerName) &&
                Objects.equals(buyerPasswd, buyer.buyerPasswd) &&
                Objects.equals(buyerPhone, buyer.buyerPhone) &&
                Objects.equals(buyerSelfid, buyer.buyerSelfid) &&
                Objects.equals(buyerSex, buyer.buyerSex)&&
        Objects.equals(buyerHead, buyer.buyerHead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerId, buyerAddr, buyerAge, buyerName, buyerPasswd, buyerPhone, buyerSelfid, buyerSex,buyerHead);
    }
}
