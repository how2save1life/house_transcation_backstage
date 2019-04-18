package com.example.demo.service.impl;

import com.example.demo.entity.Deal;
import com.example.demo.entity.ResultAll;
import com.example.demo.repository.*;
import com.example.demo.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

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
    @Autowired
    OwnerRepository ownerRepository;

    /**
     * @param deal
     * @return info_needed
     * deal_existed
     * success
     * failed
     */
    @Override
    public String saveOne(Deal deal) {
        boolean flag = false;
        String dealOwner = deal.getDealOwner();
        String dealAgency = deal.getDealAgency();
        String dealBuyer = deal.getDealBuyer();
        String dealHouse = deal.getDealHouse();
        Deal getDeal = dealRepository.findByDealAgencyAndDealHouseAndDealBuyerAndDealOwner(dealAgency, dealHouse, dealBuyer, dealOwner);
        if (agencyRepository.findOneByAgencyId(dealAgency) == null
                || buyerRepository.findOneByBuyerId(dealBuyer) == null
                || houseRepository.findByHouseId(dealHouse) == null
                || ownerRepository.findOneByOwnerId(dealOwner) == null) {
            // agencyId || buyerId || houseId ||ownerId不存在
            return "info_needed";

        } else if (!houseRepository.findByHouseId(dealHouse).getHouseStatus().equals("onsale")) {
            return "not_saleable";//房屋不在销售中
        } else if (getDeal != null && (!getDeal.getDealStatus().equals("ing"))) {
            //如果保存过交易 且交易完成了/取消了
            return "deal_existed";
        } else if (getDeal != null && getDeal.getDealStatus().equals("ing")) {
            return "deal_ing";//看房中
        } else {
            //信息真实存在 且未保存过
            try {
                dealRepository.save(deal);
                //md5 产生随机32位 作为dealId
                String target = dealHouse + dealOwner + dealBuyer + dealAgency;
                String dealId = DigestUtils.md5DigestAsHex(target.getBytes());
                dealRepository.setDealId(dealId, dealHouse, dealOwner, dealBuyer, dealAgency);
                flag = true;
            } catch (Exception e) {
                System.out.println("save deal failed" + e.getMessage());
            }
        }
        return flag ? "success" : "failed";
    }

    @Override
    public String updateOne(Deal deal) {
        boolean flag = false;
        String dealOwner = deal.getDealOwner();
        String dealAgency = deal.getDealAgency();
        String dealBuyer = deal.getDealBuyer();
        String dealHouse = deal.getDealHouse();
        String dealStatus = deal.getDealStatus();
        BigDecimal dealPrice = deal.getDealPrice();
        String dealTime = deal.getDealTime();
        Deal getDeal = dealRepository.findByDealAgencyAndDealHouseAndDealBuyerAndDealOwner(dealAgency, dealHouse, dealBuyer, dealOwner);
        if (agencyRepository.findOneByAgencyId(dealAgency) == null
                || buyerRepository.findOneByBuyerId(dealBuyer) == null
                || houseRepository.findByHouseId(dealHouse) == null
                || ownerRepository.findOneByOwnerId(dealOwner) == null) {
            // agencyId || buyerId || houseId ||ownerId不存在
            System.out.println("info_needed");
            return "info_needed";
        } else {
            try {
                dealRepository.updateDeal(dealStatus, dealPrice, dealTime, dealOwner, dealAgency, dealBuyer, dealHouse);
                if (dealStatus.equals("done")) {
                    String houseStatus = "sold";//交易完成，同步修改houseStatus
                    houseRepository.updateHouseStatus(dealHouse, houseStatus);

                    List<Deal> deals = dealRepository.findAllByDealHouse(dealHouse);
                    for (int i = 0; i < deals.size(); i++) {
                        Deal tempDeal = deals.get(i);
                        if (!tempDeal.getDealBuyer().equals(dealBuyer)) {
                            System.out.println(tempDeal.getDealBuyer());
                            dealRepository.updateDealStatus("failed", dealOwner, dealAgency, tempDeal.getDealBuyer(), dealHouse);
                        }
                    }
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("update deal failed" + e.getMessage());
            }
        }
        return flag ? "success" : "failed";
    }

    @Override
    public List<ResultAll> findAllByUser(String User, String userId) {
        List<ResultAll> result = null;
        switch (User) {
            case "Owner":
                result = dealRepository.findAllByOwner(userId);
                break;
            case "Buyer":
                result = dealRepository.findAllByBuyer(userId);
                break;
            case "Agency":
                result = dealRepository.findAllByAgency(userId);
                break;
            default:
                System.out.println("user error");
                break;
        }
        System.out.println(result);
        return result;
    }

    @Override
    public List<Deal> findAll() {
        List<Deal> deals = dealRepository.findAll();
        return deals;
    }

    @Override
    public List<Deal> findAllByDealAgency(String dealAgency) {
        List<Deal> deals = dealRepository.findAllByDealAgency(dealAgency);
        return deals;
    }

    @Override
    public List<Deal> findAllByDealBuyer(String dealBuyer) {
        List<Deal> deals = dealRepository.findAllByDealBuyer(dealBuyer);
        return deals;
    }

    @Override
    public List<Deal> findAllByDealHouse(String dealHouse) {
        List<Deal> deals = dealRepository.findAllByDealHouse(dealHouse);
        return deals;
    }

    @Override
    public List<Deal> findAllByHouseOwner(String houseOwner) {
        List<Deal> deals = dealRepository.findAllByHouseOwner(houseOwner);
        return deals;
    }

    @Override
    public String getDealData() {
        String result;
        int Max = dealRepository.getMaxPrice();
/*
        int Min = dealRepository.getMinPrice();
        int Avg = dealRepository.getAvgPrice();
*/

        result = String.valueOf(Max)/* + ',' + String.valueOf(Min) + ',' + String.valueOf(Avg)*/;
        return result;
    }

}
