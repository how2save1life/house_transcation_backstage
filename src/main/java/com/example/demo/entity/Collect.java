package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "collect", schema = "test1", catalog = "")
@IdClass(CollectPK.class)
public class Collect {
    private String collectHouse;
    private String collectBuyer;

    @Id
    @Column(name = "collect_house", nullable = false, length = 32)
    public String getCollectHouse() {
        return collectHouse;
    }

    public void setCollectHouse(String collectHouse) {
        this.collectHouse = collectHouse;
    }

    @Id
    @Column(name = "collect_buyer", nullable = false, length = 20)
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
        Collect that = (Collect) o;
        return Objects.equals(collectHouse, that.collectHouse) &&
                Objects.equals(collectBuyer, that.collectBuyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectHouse, collectBuyer);
    }
}
