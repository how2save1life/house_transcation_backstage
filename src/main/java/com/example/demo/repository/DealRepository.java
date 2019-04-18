package com.example.demo.repository;

import com.example.demo.entity.Deal;
import com.example.demo.entity.ResultAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Integer> {
    Deal findByDealAgencyAndDealHouseAndDealBuyer(String dealAgency, String dealHouse, String dealBuyer);

    Deal findByDealAgencyAndDealHouseAndDealBuyerAndDealOwner(String dealAgency, String dealHouse, String dealBuyer, String dealOwner);

    @Transactional
    @Modifying
    @Query(value = "update Deal d set  d.dealStatus=?1,d.dealPrice=?2,d.dealTime=?3 where d.dealOwner=?4 and d.dealAgency=?5 and d.dealBuyer=?6 and d.dealHouse=?7")
    int updateDeal(String dealStatus, BigDecimal dealPrice, String dealTime, String dealOwner, String dealAgency, String dealBuyer, String dealHouse);

    List<Deal> findAllByDealAgency(String dealAgency);

    List<Deal> findAllByDealBuyer(String dealBuyer);

    List<Deal> findAllByDealHouse(String dealHouse);

    @Transactional
    @Modifying
    @Query(value = "select * from deal inner join house on deal.deal_house = house.house_id inner join owner on house.house_owner = owner.owner_id where house_owner=?1", nativeQuery = true)
    List<Deal> findAllByHouseOwner(String houseOwner);

    @Transactional
    @Modifying
    @Query(value = "select new com.example.demo.entity.ResultAll(D.dealId,D.dealHouse,H.houseAddr,H.houseArea,H.houseLayout,H.houseName,H.housePrice,H.houseStatus,H.houseType,D.dealBuyer,D.dealOwner,D.dealAgency,H.houseDescribe,H.housePic,A.agencyName,A.agencyPhone,O.ownerName,O.ownerPhone,B.buyerName,B.buyerPhone,D.dealPrice,D.dealStatus,D.dealTime) " +
            "from Deal D,House H,Agency A,Owner O,Buyer B where D.dealHouse=H.houseId and D.dealBuyer=B.buyerId and D.dealAgency=A.agencyId and D.dealOwner=O.ownerId and D.dealOwner=?1", nativeQuery = false)
    List<ResultAll> findAllByOwner(String userId);

    @Transactional
    @Modifying
    @Query(value = "select new com.example.demo.entity.ResultAll(D.dealId,D.dealHouse,H.houseAddr,H.houseArea,H.houseLayout,H.houseName,H.housePrice,H.houseStatus,H.houseType,D.dealBuyer,D.dealOwner,D.dealAgency,H.houseDescribe,H.housePic,A.agencyName,A.agencyPhone,O.ownerName,O.ownerPhone,B.buyerName,B.buyerPhone,D.dealPrice,D.dealStatus,D.dealTime) " +
            "from Deal D,House H,Agency A,Owner O,Buyer B where D.dealHouse=H.houseId and D.dealBuyer=B.buyerId and D.dealAgency=A.agencyId and D.dealOwner=O.ownerId and D.dealBuyer=?1", nativeQuery = false)
    List<ResultAll> findAllByBuyer(String userId);

    @Transactional
    @Modifying
    @Query(value = "select new com.example.demo.entity.ResultAll(D.dealId,D.dealHouse,H.houseAddr,H.houseArea,H.houseLayout,H.houseName,H.housePrice,H.houseStatus,H.houseType,D.dealBuyer,D.dealOwner,D.dealAgency,H.houseDescribe,H.housePic,A.agencyName,A.agencyPhone,O.ownerName,O.ownerPhone,B.buyerName,B.buyerPhone,D.dealPrice,D.dealStatus,D.dealTime) " +
            "from Deal D,House H,Agency A,Owner O,Buyer B where D.dealHouse=H.houseId and D.dealBuyer=B.buyerId and D.dealAgency=A.agencyId and D.dealOwner=O.ownerId and D.dealAgency=?1", nativeQuery = false)
    List<ResultAll> findAllByAgency(String userId);

    @Transactional
    @Modifying
    @Query(value = "update Deal D set D.dealId=?1 where D.dealHouse = ?2 and D.dealOwner=?3 and D.dealBuyer=?4 and D.dealAgency=?5")
    int setDealId(String dealId, String dealHouse, String dealOwner, String dealBuyer, String dealAgency);

    @Transactional
    @Modifying
    @Query(value = "update Deal D set D.dealStatus=?1 where D.dealOwner=?2 and D.dealAgency=?3 and D.dealBuyer=?4 and D.dealHouse=?5")
    int updateDealStatus(String dealStatus, String dealOwner, String dealAgency, String dealBuyer, String dealHouse);

    @Transactional
    @Modifying
    @Query(value = "select max(d.dealPrice) from Deal d ")
    int getMaxPrice();
/*
    @Transactional
    @Modifying
    @Query(value = "select min(deal_price) from deal ", nativeQuery = true)
    int getMinPrice();

    @Transactional
    @Modifying
    @Query(value = "select avg(deal_price) from deal ", nativeQuery = true)
    int getAvgPrice();*/
}
