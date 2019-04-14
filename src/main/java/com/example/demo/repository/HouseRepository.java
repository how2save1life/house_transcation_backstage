package com.example.demo.repository;

import com.example.demo.entity.House;
import com.example.demo.entity.ResultHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public interface HouseRepository extends JpaRepository<House, Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update House h set " +
            "h.houseAddr=:houseAddr," +
            "h.houseArea=:houseArea," +
            "h.houseLayout=:houseLayout," +
            "h.houseName=:houseName," +
            "h.housePrice=:housePrice," +
            "h.houseType=:houseType," +
            "h.houseAgency=:houseAgency," +
            "h.houseStatus=:houseStatus," +
            "h.houseDescribe=:houseDescribe "+
            "where h.houseId=:houseId")
    int updateHouse(@Param("houseId") String houseId,
                    @Param("houseAddr") String houseAddr,
                    @Param("houseArea") BigDecimal houseArea,
                    @Param("houseLayout") String houseLayout,
                    @Param("houseName") String houseName,
                    @Param("housePrice") BigDecimal housePrice,
                    @Param("houseType") String houseType,
                    @Param("houseAgency") String houseAgency,
                    @Param("houseStatus") String houseStatus,
                    @Param("houseDescribe") String houseDescribe);

    House findByHouseNameAndHouseAddr(String houseName, String houseAddr);

    void deleteByHouseId(String houseId);

    House findByHouseId(String houseId);



    House findOneByHouseNameAndHouseAddr(String houseName, String houseAddr);

    House findOneByHouseNameAndHouseAddrAndHouseOwner(String houseName, String houseAddr, String houseOwner);

    @Transactional
    @Modifying
//    @Query(value = "select * from house inner join agency on house.house_agency = agency.agency_id",nativeQuery = true)
/*    @Query(value = "select new com.example.demo.entity.ResultHouse(H.houseId,H.houseAddr,H.houseArea,H.houseLayout,H.houseName,H.housePrice,H.houseStatus,H.houseType,H.houseOwner,H.houseAgency,A.agencyName,A.agencyPhone) " +
            "from House H inner join Agency A on H.houseAgency = A.agencyId",nativeQuery = false)*/
    @Query(value = "select new com.example.demo.entity.ResultHouse(H.houseId,H.houseAddr,H.houseArea,H.houseLayout,H.houseName,H.housePrice,H.houseStatus,H.houseType,H.houseOwner,H.houseAgency,H.houseDescribe,H.housePic,A.agencyName,A.agencyPhone) " +
            "from House H,Agency A where H.houseAgency = A.agencyId", nativeQuery = false)
    List<ResultHouse> findAllHouseInfo();

    @Transactional
    @Modifying
    @Query(value = "select new com.example.demo.entity.ResultHouse(H.houseId,H.houseAddr,H.houseArea,H.houseLayout,H.houseName,H.housePrice,H.houseStatus,H.houseType,H.houseOwner,H.houseAgency,H.houseDescribe,H.housePic,A.agencyName,A.agencyPhone) " +
            "from House H,Agency A where H.houseAgency = A.agencyId and H.houseOwner=?1", nativeQuery = false)
    List<ResultHouse> findHouseByOwner(String houseOwner);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update House h set " +
            "h.housePic=:housePic " +
            "where h.houseId=:houseId")
    int updateHousePic(@Param("houseId") String houseId,
                    @Param("housePic") String housePic);

}
