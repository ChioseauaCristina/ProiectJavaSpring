package com.Chioseaua.springbootsecondapp;

public class ProductDetails {
    private final String productId;
    private final String productName;
    private final int quantity;
    private final double unitCost;
    private final double subtotal;

    public ProductDetails( String productName,String productId,  double unitCost, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.subtotal = unitCost * quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }
}
