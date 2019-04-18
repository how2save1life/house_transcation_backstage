package com.example.demo.repository;

import com.example.demo.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Buyer findOneByBuyerId(String buyerId);

    Buyer findOneByBuyerIdAndBuyerPasswd(String buyerId, String buyerPasswd);

    @Transactional
    @Modifying
    @Query(value = "update Buyer b set " +
            "b.buyerName=:buyerName," +
            "b.buyerSex=:buyerSex," +
            "b.buyerAge=:buyerAge," +
            "b.buyerSelfid=:buyerSelfid," +
            "b.buyerPhone=:buyerPhone," +
            "b.buyerAddr=:buyerAddr " +
            "where b.buyerId=:buyerId")
    int updateBuyer(@Param("buyerId") String buyerId,
                    @Param("buyerName") String buyerName,
                    @Param("buyerSex") String buyerSex,
                    @Param("buyerAge") String buyerAge,
                    @Param("buyerSelfid") String buyerSelfid,
                    @Param("buyerPhone") String buyerPhone,
                    @Param("buyerAddr") String buyerAddr);


    Buyer findOneByBuyerSelfid(String buyerSelfid);

    @Transactional
    @Modifying
    @Query(value = "update Buyer b set b.buyerHead=:buyerHead where b.buyerId=:buyerId")
    int updateBuyerHead(@Param("buyerId") String buyerId,@Param("buyerHead") String buyerHead);

}
