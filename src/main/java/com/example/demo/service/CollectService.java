package com.example.demo.service;

import com.example.demo.entity.Collect;
import com.example.demo.entity.ResultHouse;

import java.util.List;

public interface CollectService {
    String saveOne(Collect collect);
    String deleteOne(Collect collect);
    String updateOne(Collect collect);
    List<Collect> findAll(String collectBuyer);

    List<ResultHouse> findAllByBuyer(String collectBuyer);
}
