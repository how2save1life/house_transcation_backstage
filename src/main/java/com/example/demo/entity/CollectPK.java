package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CollectPK implements Serializable {
    private String collectHouse;
    private String collectBuyer;

    @Column(name = "collect_house", nullable = false, length = 32)
    @Id
    public String getCollectHouse() {
        return collectHouse;
    }

    public void setCollectHouse(String collectHouse) {
        this.collectHouse = collectHouse;
    }

    @Column(name = "collect_buyer", nullable = false, length = 20)
    @Id
    public String getCollectBuyer() {
        return collectBuyer;
    }

    public void setCollectBuyer(String collectBuyer) {
        this.collectBuyer = collectBuyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectPK that = (CollectPK) o;
        return Objects.equals(collectHouse, that.collectHouse) &&
                Objects.equals(collectBuyer, that.collectBuyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectHouse, collectBuyer);
    }
}
