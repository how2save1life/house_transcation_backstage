package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DealPK implements Serializable {
    private String dealHouse;
    //private String dealId;
    private String dealBuyer;
    private String dealAgency;

    @Column(name = "deal_house", nullable = false, length = 32)
    @Id
    public String getDealHouse() {
        return dealHouse;
    }

    public void setDealHouse(String dealHouse) {
        this.dealHouse = dealHouse;
    }

/*    @Column(name = "deal_id", nullable = false, length = 32)
    @Id
    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }*/

    @Column(name = "deal_buyer", nullable = false, length = 20)
    @Id
    public String getDealBuyer() {
        return dealBuyer;
    }

    public void setDealBuyer(String dealBuyer) {
        this.dealBuyer = dealBuyer;
    }

    @Column(name = "deal_agency", nullable = false, length = 20)
    @Id
    public String getDealAgency() {
        return dealAgency;
    }

    public void setDealAgency(String dealAgency) {
        this.dealAgency = dealAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DealPK dealPK = (DealPK) o;
        return Objects.equals(dealHouse, dealPK.dealHouse) &&
                //Objects.equals(dealId, dealPK.dealId) &&
                Objects.equals(dealBuyer, dealPK.dealBuyer) &&
                Objects.equals(dealAgency, dealPK.dealAgency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealHouse, dealBuyer, dealAgency);
    }//, dealId
}
