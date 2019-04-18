package com.example.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Agency {
    private String agencyId;
    private String agencyAddr;
    private String agencyAge;
    //private BigDecimal agencyFee;
    private String agencyName;
    private String agencyPasswd;
    private String agencyPhone;
    private String agencySelfid;
    private String agencySex;
    private String agencyHead;

    @Id
    @Column(name = "agency_id", nullable = false, length = 20)
    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    @Basic
    @Column(name = "agency_addr", nullable = true, length = 255)
    public String getAgencyAddr() {
        return agencyAddr;
    }

    public void setAgencyAddr(String agencyAddr) {
        this.agencyAddr = agencyAddr;
    }

    @Basic
    @Column(name = "agency_age", nullable = true, length = 3)
    public String getAgencyAge() {
        return agencyAge;
    }

    public void setAgencyAge(String agencyAge) {
        this.agencyAge = agencyAge;
    }

    /*@Basic
    @Column(name = "agency_fee", nullable = false,length=10, precision = 2)
    public BigDecimal getAgencyFee() {
        return agencyFee;
    }

    public void setAgencyFee(BigDecimal agencyFee) {
        this.agencyFee = agencyFee;
    }
*/
    @Basic
    @Column(name = "agency_name", nullable = true, length = 20)
    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @Basic
    @Column(name = "agency_passwd", nullable = false, length = 20)
    public String getAgencyPasswd() {
        return agencyPasswd;
    }

    public void setAgencyPasswd(String agencyPasswd) {
        this.agencyPasswd = agencyPasswd;
    }

    @Basic
    @Column(name = "agency_phone", nullable = true, length = 11)
    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    @Basic
    @Column(name = "agency_selfid", nullable = true, length = 20)
    public String getAgencySelfid() {
        return agencySelfid;
    }

    public void setAgencySelfid(String agencySelfid) {
        this.agencySelfid = agencySelfid;
    }

    @Basic
    @Column(name = "agency_sex", nullable = true, length = 1)
    public String getAgencySex() {
        return agencySex;
    }
    public void setAgencySex(String agencySex) {
        this.agencySex = agencySex;
    }

    @Basic
    @Column(name = "agency_head", nullable = true, length = 255)
    public String getAgencyHead() {
        return agencyHead;
    }
    public void setAgencyHead(String agencyHead) {
        this.agencyHead = agencyHead;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return Objects.equals(agencyId, agency.agencyId) &&
                Objects.equals(agencyAddr, agency.agencyAddr) &&
                Objects.equals(agencyAge, agency.agencyAge) &&
                //Objects.equals(agencyFee, agency.agencyFee) &&
                Objects.equals(agencyName, agency.agencyName) &&
                Objects.equals(agencyPasswd, agency.agencyPasswd) &&
                Objects.equals(agencyPhone, agency.agencyPhone) &&
                Objects.equals(agencySelfid, agency.agencySelfid) &&
                Objects.equals(agencySex, agency.agencySex)&&
                Objects.equals(agencyHead, agency.agencyHead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencyId, agencyAddr, agencyAge/*, agencyFee*/, agencyName, agencyPasswd, agencyPhone, agencySelfid, agencySex,agencyHead);
    }
}
