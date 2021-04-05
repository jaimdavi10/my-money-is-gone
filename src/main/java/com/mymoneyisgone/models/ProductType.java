package com.mymoneyisgone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    public ProductType (){};

    public ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "Product Type: "+ this.name;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof ProductType))
            return false;

        ProductType pt = (ProductType) o;
        return this.name.equals(pt.name);
    }
}
