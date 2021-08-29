package com.Chioseaua.springbootsecondapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        boolean condition = false;
        Administrator administrator = new Administrator();


        while(!condition) {
            System.out.println("\n");
            int option = printMenu(1);
            switch(option) {
                case 1:
                    customer = new Customer();
                    System.out.println("Please enter your registration:");
                    customer.register();
                    customerList.add(customer);
                    break;
                case 2:
                    System.out.println("Enter CustomerName: ");
                    String customerName = scanner.nextLine();
                    for (Customer customer1 : customerList) {
                        if (customer1.getCustomerName().compareTo(customerName) == 0) {
                            if (customer1.VerifyLogin()) {

                                boolean condition1 = false;
                                while (!condition1) {

                                    option = printMenu(2);
                                    switch (option) {
                                        case 1:
                                            addToCartFunction(customer1);
                                            break;
                                        case 2:
                                            removeFromCartFunction(customer1);
                                        case 3:
                                            System.out.println();
                                            if (customer1.getShoppingCart().isEmpty()) {
                                                System.out.println("There are no products in your shopping basket.");
                                            } else {
                                                customer1.getShoppingCart().viewCartDetails();
                                            }
                                            break;
                                        case 4:
                                            if (customer1.getShoppingCart().isEmpty()) {
                                                System.out.println("There are no products in your shopping basket. No order was created");
                                            } else {
                                                customer1.placeOrder();
                                                for (Order order : customer1.getOrderList()) {
                                                    System.out.println(order.printOrderDetails());
                                                    order.printOrderTable();
                                                }
                                                customer1.refreshShoppingCart();
                                            }
                                            break;
                                        case 6:
                                            customer1.setLoginStatus(false);
                                            condition1 = true;
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (Customer customer1 : customerList) {
                        System.out.println(customer1.toString());
                    }
                    break;
                case 4:

                    boolean cond = true;
                    while(cond) {
                        System.out.println("Choose if you want to \'remove\' or \'modify\' a product. Enter \'exit\' to end session.");
                        String opt = scanner.nextLine();
                        switch (opt.toLowerCase()) {
                            case "remove":
                                System.out.println("Enter the item which you try to remove: ");
                                String item = scanner.nextLine();
                                administrator.fileReplace(item);
                                break;
                            case "modify":
                                System.out.println("Enter the item to which you want to modify fields: ");
                                item = scanner.nextLine();
                                cond = false;
                                while (!cond) {
                                    System.out.println("\n");
                                    if ((option = printMenu(3)) == 5) {
                                        cond = true;
                                    } else {
                                        System.out.println("Enter with what you want to modify that particular field");
                                        String item1 = scanner.nextLine();
                                        administrator.fileReplace((option - 1), item, item1);
                                    }
                                }
                                break;
                            case "exit":
                                cond = false;
                        }
                    }
                    break;
                case 5:
                    condition = true;
                    break;
            }
        }
    }


    public static void addToCartFunction(Customer customer) {
        if (customer.isLoginStatus()) {
            System.out.println("Enter the the product you want to buy: ");
            String product = scanner.nextLine();
            System.out.println("Enter how many products you want to buy: ");
            int quantity = scanner.nextInt();
            customer.getShoppingCart().addCartItem(product, quantity);
        }
    }

    public static void removeFromCartFunction(Customer customer) {
        if (customer.isLoginStatus()) {
            System.out.println("Enter the the product you want to remove: ");
            String product = scanner.nextLine();
            customer.getShoppingCart().removeItem(product);
        }
    }

    public static int printMenu(int a) {
        if(a == 1) {
            System.out.println("1.Registration\n2.Login\n3.Print customers\n4.Enter as administrator\n5.End session");
        } else if(a == 2){
            System.out.println("\n1.Add item to shopping basket\n2.Remove item from shopping basket\n3.Show details of the shopping basket\n" +
                    "4.Add items from your shopping basket to your order\n6.Log out");
        } else {
            System.out.println("Press the number of the field you want to modify:");
            System.out.println("1.Product Name\n2.Product ID\n3.Product Price\n4.Product quantity\n5.End Modifying Session");
        }
        System.out.println("Wanted option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}
