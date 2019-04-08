package com.example.demo.service;
import com.example.demo.entity.Owner;

import java.util.List;

public interface OwnerService {
    String saveOne(Owner owner);
    String deleteOne(String ownerId);
    String updateOwner(Owner owner);
    Owner findOne(String ownerId);
    List<Owner> findAll();

    String login(Owner owner);
}
