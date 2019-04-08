package com.example.demo.service;

import com.example.demo.entity.Agency;

import java.util.List;

public interface AgencyService {
    String saveOne(Agency agency);
    String deleteOne(String agencyId);
    String updateAgency(Agency agency);
    Agency findOne(String agencyId);
    List<Agency> findAll();

    String login(Agency agency);

    Agency findRandomAgency();
}
