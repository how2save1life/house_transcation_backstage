package com.example.demo.repository;

import com.example.demo.entity.Collect;
import com.example.demo.entity.ResultHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CollectRepository extends JpaRepository<Collect,Integer> {
    Collect findByCollectHouseAndCollectBuyer(String collectHouse, String collectBuyer);

    /*List<Collect> findAllByCollectBuyer(String collectBuyer);*/
    /**
     * 查询collectBuyer 下收藏夹内所有的房屋信息
     *
     * @param collectBuyer
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "select new com.example.demo.entity.ResultHouse(C.collectHouse,H.houseAddr,H.houseArea,H.houseLayout,H.houseName,H.housePrice,H.houseStatus,H.houseType,H.houseOwner,H.houseAgency,H.houseDescribe,A.agencyName,A.agencyPhone) " +
            "from Collect C,House H,Agency A where H.houseAgency = A.agencyId and C.collectHouse=H.houseId and C.collectBuyer=?1", nativeQuery = false)
    List<ResultHouse> findAllByCollectBuyer(String collectBuyer);

    void deleteByCollectHouseAndCollectBuyer(String collectHouse, String collectBuyer);
}
