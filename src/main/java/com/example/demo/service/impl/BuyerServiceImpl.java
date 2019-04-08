package com.example.demo.service.impl;

import com.example.demo.entity.Buyer;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public String saveOne(Buyer buyer) {
        boolean flag = false;
        if(buyer.getBuyerId()==null||buyer.getBuyerId()==""){
            return "info_needed";
        }
        if (buyerRepository.findOneByBuyerSelfid(buyer.getBuyerSelfid())!=null){
            return "selfid_used";
        }
        if (buyerRepository.findOneByBuyerId(buyer.getBuyerId()) == null){
            try{
                buyerRepository.save(buyer);
                flag=true;
            }catch (Exception e){
                System.out.println("save buyer failed"+e.getMessage());
            }
        }
        else {
            System.out.println("buyerid registered");
            return "registered";
        }
        return flag==true?"success":"failed";
    }

    @Override
    public String deleteOne(String buyerId) {
        return null;
    }

    @Override
    public String updateBuyer(Buyer buyer) {
        boolean flag = false;
        String buyerId = buyer.getBuyerId();
        String buyerName = buyer.getBuyerName();
        String buyerSelfid = buyer.getBuyerSelfid();
        String buyerPhone = buyer.getBuyerPhone();
        String buyerSex = buyer.getBuyerSex();
        String buyerAge = buyer.getBuyerAge();
        String buyerAddr = buyer.getBuyerAddr();

        try {
            buyerRepository.updateBuyer(buyerId,buyerName, buyerSex, buyerAge, buyerSelfid,
                    buyerPhone, buyerAddr);

            flag = true;
        } catch (Exception e) {
            System.out.println("updateBuyer failed" + e.getMessage());
        }
        return flag==true?"success":"failed";
    }

    @Override
    public Buyer findOne(String buyerId) {
        return null;
    }

    @Override
    public List<Buyer> findAll() {
        List<Buyer> list = buyerRepository.findAll();;
        return list;
    }

    @Override
    public String login(Buyer buyer) {
        System.out.println(buyer.getBuyerId());
        System.out.println(buyer.getBuyerPasswd());
        Buyer b = buyerRepository.findOneByBuyerIdAndBuyerPasswd(buyer.getBuyerId(),buyer.getBuyerPasswd());
        return b==null?"failed":"success";
    }
}
