package com.mymoneyisgone.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class PurchaseEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long entryId;

    @NotNull(message = "Price of product is required")
    @Positive(message = "Price of product must be higher than zero")
    private double price;

    @NotBlank(message = "Name of product is required")
    @Size(min=2, message = "Name of product must be 2 or more characters")
    private String name;

    @NotBlank(message = "Product purchasing location is required")
    @Size(min=2, message = "Name of product purchase location must be 2 or more characters")
    private String purchaseLocation;

    private LocalDateTime created;
    private LocalDateTime modified;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id" , referencedColumnName = "id")
    private ProductType productType;

    //private Set<ProductType> productTypes;

    public PurchaseEntry (){}

    public PurchaseEntry (double price, String name, String purchaseLocation){

        this.price = price;
        this.name = name;
        this.purchaseLocation = purchaseLocation;

    }

    public ProductType getProductType (){

        return this.productType;
    }

    public void setProductType (ProductType pt){

        this.productType = pt;

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
