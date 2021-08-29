package com.Chioseaua.springbootsecondapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    //private int OrderId;
    private final LocalDateTime dateOrderCreated;
    private LocalDateTime dateOrderShipped;
    private final String customerName;
    private final String customerId;
    private String status;
    private List<ProductDetails> productDetailsList =  new ArrayList<>();
    private ShippingInfo shippingInfo;

    public Order(String customerName, String customerId) {
        this.dateOrderCreated = LocalDateTime.now();
        this.customerName = customerName;
        this.customerId = customerId;
        this.status = "pending";
    }

    Scanner scanner = new Scanner(System.in);

    public void addProductToOrder(ProductDetails productDetails) {
        productDetailsList.add(productDetails);
    }


    public String printOrderDetails() {
        return "Order{" +
                "dateOrderCreated=" + dateOrderCreated +
                ", dateOrderShipped=" + dateOrderShipped +
                ", customerName='" + customerName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void printOrderTable() {
        final Object[][] table = new String[productDetailsList.size()][];
        int i=0;
        for(ProductDetails item : productDetailsList) {
            table[i++] = new String[] {item.getProductName(), item.getProductId()
                      ,item.getUnitCost() + "", item.getQuantity() + "", item.getSubtotal() + ""};
        }
        System.out.println("Items in your order:");
        System.out.format("%15s%15s%15s%15s%15s\n", "Product:", "ProductID", "Price/Unit", "Quantity", "Total Price");
        for(Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%15s\n", row);
        }
    }
}
