package com.Chioseaua.springbootsecondapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Customer extends User{
    private String customerName;
    private String address;
    private String email;
    private double accountBalance = 0;
    private ShoppingCart shoppingCart = new ShoppingCart();
    private List<Order> orderList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public String getCustomerName() {
        return customerName;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void refreshShoppingCart() {
        this.shoppingCart = new ShoppingCart();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void register() {

        System.out.println("Nume: ");
        this.customerName = scanner.nextLine();
        System.out.println("Adresa: ");
        this.address = scanner.nextLine();
        System.out.println("Email: ");
        this.email = scanner.nextLine();
        User();
        System.out.println("Suma cu care doriti sa incarcati cardul: ");
        double sum = scanner.nextDouble();
        if(sum > 0) {
            this.accountBalance = sum;
        } else {
            System.out.println("You have introduced a negative sum.");
        }
    }

    public boolean VerifyLogin() {
        System.out.println("Enter password: ");
        scanner.nextLine();
        String pas = scanner.nextLine();
        return verifyLogin(pas);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", accountBalance='" + accountBalance + "\', " +
                super.toString()+
                '}';
    }

    public void placeOrder() {
        if(isLoginStatus()) {
            Order order = new Order(this.customerName, getUserID());
            Double totalOrderPrice = 0.00;
            for(Map.Entry<String, CartItem> pair : shoppingCart.getItems().entrySet()) {
                totalOrderPrice += pair.getValue().getPrice() * pair.getValue().getQuantity();
                if(totalOrderPrice <= this.accountBalance) {
                    order.addProductToOrder(new ProductDetails(pair.getKey(), pair.getValue().getId(),
                            pair.getValue().getPrice(), pair.getValue().getQuantity()));
                    this.accountBalance -= totalOrderPrice;
                } else {
                    System.out.println("The balance of your card(" + this.accountBalance
                            + ") is not enough for completing this order(" + totalOrderPrice + ")" );
                    break;
                }
                System.out.println("The order was sent successfully");
            }
            orderList.add(order);
        }

    }
}
