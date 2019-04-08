package com.example.demo.repository;

import com.example.demo.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {


    Agency findOneByAgencyId(String agencyId);

    Agency findOneByAgencyIdAndAgencyPasswd(String agencyId, String agencyPasswd);

    @Transactional
    @Modifying
    @Query(value = "update Agency a set " +
            "a.agencyName=:agencyName," +
            "a.agencySex=:agencySex," +
            "a.agencySex=:agencySex," +
            "a.agencyAge=:agencyAge," +
            "a.agencySelfid=:agencySelfid," +
            "a.agencyPhone=:agencyPhone," +
            "a.agencyAddr=:agencyAddr," +
            "a.agencyFee=:agencyFee " +
            "where a.agencyId=:agencyId")
    int updateAgency(@Param("agencyId") String agencyId,
                        @Param("agencyName") String agencyName,
                        @Param("agencySex") String agencySex,
                        @Param("agencyAge") String agencyAge,
                        @Param("agencySelfid") String agencySelfid,
                        @Param("agencyPhone") String agencyPhone,
                        @Param("agencyAddr") String agencyAddr,
                        @Param("agencyFee") BigDecimal agencyFee);

    Agency findOneByAgencySelfid(String agencySelfid);
}
