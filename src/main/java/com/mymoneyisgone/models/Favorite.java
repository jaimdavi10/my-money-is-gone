package com.mymoneyisgone.models;

public class Favorite {

    private double price;
    private String name;
    private String purchaseLocation;

    public Favorite (){};

    public Favorite (double price, String name, String purchaseLocation){

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

    public void setPrice (double price){
        this.price = price;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setPurchaseLocation (String purchaseLocation){
        this.purchaseLocation = purchaseLocation;
    }


}
