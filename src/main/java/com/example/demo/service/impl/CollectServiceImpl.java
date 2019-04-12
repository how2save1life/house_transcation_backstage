package com.example.demo.service.impl;

import com.example.demo.entity.Collect;
import com.example.demo.entity.ResultHouse;
import com.example.demo.repository.CollectRepository;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.HouseRepository;
import com.example.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectRepository collectRepository;

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    BuyerRepository buyerRepository;

    /**
     * @param collect
     * @return "info_needed";//传入的houseId或buyerId不存在
     * "collect_existed";//收藏已存在
     * flag == true ? "success" : "failed";
     */
    @Override
    public String saveOne(Collect collect) {
        boolean flag = false;
        String collectHouse = collect.getCollectHouse();
        String collectBuyer = collect.getCollectBuyer();
        if (houseRepository.findByHouseId(collectHouse) == null || buyerRepository.findOneByBuyerId(collectBuyer) == null) {
            //传入的houseId或buyerId不存在
            return "info_needed";
        } else if (collectRepository.findByCollectHouseAndCollectBuyer(collectHouse, collectBuyer) != null) {
            //收藏已存在
            return "collect_existed";
        } else {
            //保存
            try {
                collectRepository.save(collect);
                flag = true;
            } catch (Exception e) {
                System.out.println("save collect failed" + e.getMessage());
            }
        }
        return flag == true ? "success" : "failed";
    }

    @Override
    public String deleteOne(Collect collect) {
        boolean flag = false;
        String collectHouse = collect.getCollectHouse();
        String collectBuyer = collect.getCollectBuyer();
        if (collectRepository.findByCollectHouseAndCollectBuyer(collectHouse, collectBuyer) == null) {
            //要删除的信息不存在
            return "not_existed";
        } else {
            try {
                collectRepository.delete(collect);
                flag = true;
            } catch (Exception e) {
                System.out.println("delete collect failed" + e.getMessage());
            }
        }
        return true == true ? "success" : "failed";
    }

    @Override
    public String updateOne(Collect collect) {
        return null;
    }

    @Override
    public List<Collect> findAll(String collectBuyer) {
        return null;
    }

    /*    @Override
        public List<Collect> findAllByBuyer(String collectBuyer) {
            List<Collect> collect = collectRepository.findAllByCollectBuyer(collectBuyer);
            return collect;
        }*/
    @Override
    public List<ResultHouse> findAllByBuyer(String collectBuyer) {
        List<ResultHouse> collect = collectRepository.findAllByCollectBuyer(collectBuyer);
        return collect;
    }
}
