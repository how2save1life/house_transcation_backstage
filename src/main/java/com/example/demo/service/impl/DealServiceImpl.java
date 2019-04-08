package com.example.demo.service.impl;

import com.example.demo.entity.Deal;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.DealRepository;
import com.example.demo.repository.HouseRepository;
import com.example.demo.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {
    @Autowired
    DealRepository dealRepository;
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    AgencyRepository agencyRepository;

    /**
     * @param deal
     * @return
     * info_needed
     * deal_existed
     * success
     * failed
     *
     */
    @Override
    public String saveOne(Deal deal) {
        boolean flag = false;
        String dealId = deal.getDealId();
        String dealAgency = deal.getDealAgency();
        String dealBuyer = deal.getDealBuyer();
        String dealHouse = deal.getDealHouse();
        Deal getDeal = dealRepository.findByDealAgencyAndDealHouseAndDealBuyer(dealAgency, dealHouse, dealBuyer);
        if (agencyRepository.findOneByAgencyId(dealAgency) == null
                || buyerRepository.findOneByBuyerId(dealBuyer) == null
                || houseRepository.findByHouseId(dealHouse) == null) {
            // agencyId || buyerId || houseId 不存在
            return "info_needed";

        } else if (getDeal != null && getDeal.getDealStatus()!=null) {
            //如果保存过交易
            return "deal_existed";

        } else {
            //信息真实存在 且未保存过
            try {
                dealRepository.save(deal);
                flag = true;
            } catch (Exception e) {
                System.out.println("save deal failed" + e.getMessage());
            }
        }


        return flag == true ? "success" : "failed";
    }

    @Override
    public String updateOne(Deal deal) {
        boolean flag = false;
        String dealStatus = deal.getDealStatus();
        BigInteger dealPrice = deal.getDealPrice();
        Timestamp dealTime = deal.getDealTime();
        try{
            dealRepository.updateDeal(dealStatus,dealPrice,dealTime);
            flag = true;
        }catch (Exception e){
            System.out.println("update deal failed"+e.getMessage());
        }


        return flag==true?"success":"failed";
    }

    @Override
    public List<Deal> findAll() {
        List<Deal> deals= dealRepository.findAll();
        return deals;
    }

    @Override
    public List<Deal> findAllByDealAgency(String dealAgency) {
        List<Deal> deals= dealRepository.findAllByDealAgency(dealAgency);
        return deals;
    }
    @Override
    public List<Deal> findAllByDealBuyer(String dealBuyer) {
        List<Deal> deals= dealRepository.findAllByDealBuyer(dealBuyer);
        return deals;
    }
    @Override
    public List<Deal> findAllByDealHouse(String dealHouse) {
        List<Deal> deals= dealRepository.findAllByDealHouse(dealHouse);
        return deals;
    }
    @Override
    public List<Deal> findAllByHouseOwner(String houseOwner) {
        List<Deal> deals= dealRepository.findAllByHouseOwner(houseOwner);
        return deals;
    }

}
