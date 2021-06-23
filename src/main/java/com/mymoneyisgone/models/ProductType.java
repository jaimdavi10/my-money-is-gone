package com.mymoneyisgone.models;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    //@OneToOne(mappedBy = "productType")
    //private PurchaseEntry purchaseEntry;

    public ProductType (){};

    public ProductType(String name) {
        this.name = name;
    }


//    public PurchaseEntry getPurchaseEntry () {
//        return this.purchaseEntry;
//    }
//
//    public void setPurchaseEntry (PurchaseEntry pe) {
//
//        this.purchaseEntry = pe;
//
//    }

    public long getId() {return this.id;}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return this.name;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof ProductType))
            return false;

        ProductType pt = (ProductType) o;
        return this.name.equals(pt.name);
    }

    @Override
    public int hashCode () {
        return this.name.hashCode();
    }

}
