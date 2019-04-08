package com.example.demo.repository;

import com.example.demo.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CollectRepository extends JpaRepository<Collect,Integer> {
    Collect findByCollectHouseAndCollectBuyer(String collectHouse, String collectBuyer);

    /*List<Collect> findAllByCollectBuyer(String collectBuyer);*/


    void deleteByCollectHouseAndCollectBuyer(String collectHouse, String collectBuyer);
}
