package com.mymoneyisgone.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PurchaseEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long entryId;
    private double price;
    private String name;
    private String purchaseLocation;
    private LocalDateTime created;
    private LocalDateTime modified;

    public PurchaseEntry (){};

    public PurchaseEntry (double price, String name, String purchaseLocation){

        this.price = price;
        this.name = name;
        this.purchaseLocation = purchaseLocation;

    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public String getPurchaseLocation (){
        return this.purchaseLocation;
    }

    public long getEntryId () { return this.entryId;}

    public LocalDateTime getCreated () {return this.created; }

    public LocalDateTime getModified () {return this.modified;}

    public void setPrice (double price){
        this.price = price;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setPurchaseLocation (String purchaseLocation){
        this.purchaseLocation = purchaseLocation;
    }

    public void setCreated (LocalDateTime ldt) {
        this.created = ldt;
    }

    public void setModified (LocalDateTime ldt) {
        this.modified = ldt;
    }


    public String toString () {

        return this.getName()+"  $"+ this.getPrice()+" ,  from: "+ this.getPurchaseLocation();
    }

    @PrePersist
    public void onCreate(){
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate(){
        this.setModified(LocalDateTime.now());
    }

}
