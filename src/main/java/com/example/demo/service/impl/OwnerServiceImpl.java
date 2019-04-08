package com.example.demo.service.impl;

import com.example.demo.entity.Owner;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public String saveOne(Owner owner) {
        boolean flag = false;
        if(owner.getOwnerId()==null||owner.getOwnerId()==""){//传空值
            return "info_needed";
        }
        if (ownerRepository.findOneByOwnerSelfid(owner.getOwnerSelfid())!=null){
            return "selfid_used";
        }
        if (ownerRepository.findOneByOwnerId(owner.getOwnerId())==null){
            try{
                ownerRepository.save(owner);
                flag = true;
            }catch(Exception e){
                System.out.println("save owner failed"+e.getMessage());
            }
        }
        else {
            System.out.println("already registered");
            return "registered";
        }
        return flag ?"success":"failed";
    }

    @Override
    public String deleteOne(String ownerId) {
        return null;
    }

    @Override
    public String updateOwner(Owner owner) {
        boolean flag = false;
        String ownerId = owner.getOwnerId();
        String ownerName = owner.getOwnerName();
        String ownerSelfid = owner.getOwnerSelfid();
        String ownerPhone = owner.getOwnerPhone();
        String ownerSex = owner.getOwnerSex();
        String ownerAge = owner.getOwnerAge();
        String ownerAddr = owner.getOwnerAddr();
        String ownerType = owner.getOwnerType();
        try {
            ownerRepository.updateOwner(ownerId,ownerName, ownerSex, ownerAge, ownerSelfid,
                    ownerPhone, ownerAddr,ownerType);
            flag = true;
        } catch (Exception e) {
            System.out.println("updateAgency failed" + e.getMessage());
        }
        //owner.setOwnerName(ownerName);
        return flag ?"success":"failed";
    }

    @Override
    public Owner findOne(String ownerId) {

        return null;
    }

    @Override
    public List<Owner> findAll() {
        List<Owner> list = ownerRepository.findAll();
        return list;
    }

    @Override
    public String login(Owner owner) {
        Owner o=ownerRepository.findOneByOwnerIdAndOwnerPasswd(owner.getOwnerId(),owner.getOwnerPasswd());
        return o==null?"failed":"success";
    }
}
