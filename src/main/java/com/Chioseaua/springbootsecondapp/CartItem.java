package com.Chioseaua.springbootsecondapp;

public class CartItem {
    private String Id;
    private int quantity;
    private double price;

    public CartItem(String id, double price, int quantity) {
        Id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getId() {
        return Id;
    }

    public double getPrice() {
        return price;
    }
}
