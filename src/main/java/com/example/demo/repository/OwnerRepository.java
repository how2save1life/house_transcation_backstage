package com.example.demo.repository;

import com.example.demo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Owner findOneByOwnerId(String ownerId);

    @Transactional
    @Modifying
    @Query(value = "update Owner o set " +
            "o.ownerName=:ownerName," +
            "o.ownerSex=:ownerSex," +
            "o.ownerAge=:ownerAge," +
            "o.ownerSelfid=:ownerSelfid," +
            "o.ownerPhone=:ownerPhone," +
            "o.ownerAddr=:ownerAddr " +

            "where o.ownerId=:ownerId")
    int updateOwner(@Param("ownerId") String ownerId,
                    @Param("ownerName") String ownerName,
                    @Param("ownerSex") String ownerSex,
                    @Param("ownerAge") String ownerAge,
                    @Param("ownerSelfid") String ownerSelfid,
                    @Param("ownerPhone") String ownerPhone,
                    @Param("ownerAddr") String ownerAddr);

    @Transactional
    @Modifying
    @Query(value = "update Owner o set o.ownerHead=:ownerHead where o.ownerId=:ownerId")
    int updateOwnerHead(@Param("ownerId") String ownerId,@Param("ownerHead") String ownerHead);

    Owner findOneByOwnerIdAndOwnerPasswd(String ownerId, String ownerPasswd);

    Owner findOneByOwnerSelfid(String ownerSelfid);
}
