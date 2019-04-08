package com.example.demo.service.impl;

import com.example.demo.entity.Agency;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;

    /**
     * success
     * failed
     * registered
     */
    @Override
    public String saveOne(Agency agency) {
        boolean flag = false;
//        System.out.println(agency.getAgencyId() + "+" + agency.getAgencyPasswd());
//        System.out.println(agencyRepository.findOneByAgencyIdAndAgencyPasswd(agency.getAgencyId(), agency.getAgencyPasswd()));
        if(agency.getAgencyId()==null||agency.getAgencyId()==""){//传空值
            return "info_needed";
        }
        if (agencyRepository.findOneByAgencySelfid(agency.getAgencySelfid())!=null){
            return "selfid_used";
        }
        if (agencyRepository.findOneByAgencyId(agency.getAgencyId()) == null) {//id未重複
            try {
                agencyRepository.save(agency);//
                flag = true;
            } catch (Exception e) {
                System.out.println("failed" + e.getMessage());
            }
        } else {
            System.out.println("already registered");
            return "registered";
        }
        return flag == true ? "success" : "failed";

    }

    @Override
    public String deleteOne(String agencyId) {
        return null;
    }

    @Override
    public String updateAgency(Agency agency) {
        boolean flag = false;
        String agencyId = agency.getAgencyId();
        String agencyName = agency.getAgencyName();
        String agencySelfid = agency.getAgencySelfid();
        String agencyPhone = agency.getAgencyPhone();
        String agencySex = agency.getAgencySex();
        String agencyAge = agency.getAgencyAge();
        String agencyAddr = agency.getAgencyAddr();
        BigDecimal agencyFee = agency.getAgencyFee();
        try {
            agencyRepository.updateAgency(agencyId,agencyName, agencySex, agencyAge, agencySelfid,
                    agencyPhone, agencyAddr, agencyFee);

            flag = true;
        } catch (Exception e) {
            System.out.println("updateAgency failed" + e.getMessage());
        }
        return flag ?"success":"failed";
    }

    @Override
    public Agency findOne(String agencyId) {
        Agency agency = agencyRepository.findOneByAgencyId(agencyId);
        return agency;
    }

    @Override
    public List<Agency> findAll() {
        List<Agency> list = agencyRepository.findAll();
        return list;
    }

    @Override
    public String login(Agency agency) {
        /*boolean flag=false;
        Agency agency = agencyRepository.findOneByAgencyId(agencyId);
        System.out.println(agencyId);
        System.out.println("\n");
        System.out.println(agencyPasswd+"\n");
        System.out.println(findOne(agencyId));
        *//*if (agencyRepository.findOneByAgencyId(agencyId)!=null
                && agencyRepository.findOneByAgencyId(agencyId).getAgencyPasswd() == agencyPasswd)
            flag=true;*//*
        if (agency!=null)
            flag=true;
        return flag==true ?"success":"failed";*/
        boolean flag = false;
        Agency a = agencyRepository.findOneByAgencyIdAndAgencyPasswd(agency.getAgencyId(), agency.getAgencyPasswd());
        if (a != null)
            flag = true;

        return flag ? "success" : "failed";
    }

    @Override
    public Agency findRandomAgency() {
        List<Agency> agencyList = findAll();
        Random random = new Random();
        Agency agency=agencyList.get(random.nextInt(agencyList.size()));
        return agency;
    }


}
