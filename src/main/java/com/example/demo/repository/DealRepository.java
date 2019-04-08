package com.example.demo.repository;

import com.example.demo.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Integer> {
    Deal findByDealAgencyAndDealHouseAndDealBuyer(String dealAgency, String dealHouse, String dealBuyer);

    @Transactional
    @Modifying
    @Query(value = "update Deal d set  d.dealStatus=?1,d.dealPrice=?2,d.dealTime=?3")
    int updateDeal(String dealStatus, BigInteger dealPrice, Timestamp dealTime);

    List<Deal> findAllByDealAgency(String dealAgency);

    List<Deal> findAllByDealBuyer(String dealBuyer);

    List<Deal> findAllByDealHouse(String dealHouse);

    @Transactional
    @Modifying
    @Query(value = "select * from deal inner join house on deal.deal_house = house.house_id inner join owner on house.house_owner = owner.owner_id where house_owner=?1",nativeQuery = true)
    List<Deal> findAllByHouseOwner(String houseOwner);
}
