package com.Chioseaua.springbootsecondapp;

public class ShippingInfo {
    private String shippingType;
    private double shippingCost;
    private int shippingRegionId;

    public ShippingInfo(String shippingType, double shippingCost, int shippingRegionId) {
        this.shippingType = shippingType;
        this.shippingCost = shippingCost;
        this.shippingRegionId = shippingRegionId;
    }
}
