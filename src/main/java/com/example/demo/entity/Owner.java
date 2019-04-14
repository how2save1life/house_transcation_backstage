package com.example.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Owner {
    private String ownerId;
    private String ownerAddr;
    private String ownerAge;
    private String ownerName;
    private String ownerPasswd;
    private String ownerPhone;
    private String ownerSelfid;
    private String ownerSex;
    private String ownerHead;

    @Id
    @Column(name = "owner_id", nullable = false, length = 20)
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "owner_addr", nullable = true, length = 255)
    public String getOwnerAddr() {
        return ownerAddr;
    }

    public void setOwnerAddr(String ownerAddr) {
        this.ownerAddr = ownerAddr;
    }

    @Basic
    @Column(name = "owner_age", nullable = true, length = 3)
    public String getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(String ownerAge) {
        this.ownerAge = ownerAge;
    }

    @Basic
    @Column(name = "owner_name", nullable = true, length = 20)
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Basic
    @Column(name = "owner_passwd", nullable = false, length = 20)
    public String getOwnerPasswd() {
        return ownerPasswd;
    }

    public void setOwnerPasswd(String ownerPasswd) {
        this.ownerPasswd = ownerPasswd;
    }

    @Basic
    @Column(name = "owner_phone", nullable = true, length = 11)
    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    @Basic
    @Column(name = "owner_selfid", nullable = true, length = 20)
    public String getOwnerSelfid() {
        return ownerSelfid;
    }

    public void setOwnerSelfid(String ownerSelfid) {
        this.ownerSelfid = ownerSelfid;
    }

    @Basic
    @Column(name = "owner_sex", nullable = true, length = 1)
    public String getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(String ownerSex) {
        this.ownerSex = ownerSex;
    }

    @Basic
    @Column(name = "owner_head", nullable = false, length = 255)
    public String getOwnerHead() {
        return ownerHead;
    }

    public void setOwnerHead(String ownerHead) {
        this.ownerHead = ownerHead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(ownerId, owner.ownerId) &&
                Objects.equals(ownerAddr, owner.ownerAddr) &&
                Objects.equals(ownerAge, owner.ownerAge) &&
                Objects.equals(ownerName, owner.ownerName) &&
                Objects.equals(ownerPasswd, owner.ownerPasswd) &&
                Objects.equals(ownerPhone, owner.ownerPhone) &&
                Objects.equals(ownerSelfid, owner.ownerSelfid) &&
                Objects.equals(ownerSex, owner.ownerSex) &&
                Objects.equals(ownerHead, owner.ownerHead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, ownerAddr, ownerAge, ownerName, ownerPasswd, ownerPhone, ownerSelfid, ownerSex, ownerHead);
    }
}
