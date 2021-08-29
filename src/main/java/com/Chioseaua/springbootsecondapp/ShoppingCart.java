package com.Chioseaua.springbootsecondapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {

   // private String cartId;
    private Map<String, CartItem> items = new HashMap<>();
    private LocalDateTime dateAdded = LocalDateTime.now();
    private static long idCounter = 0;


    public void ShoppingCart() {
        this.dateAdded = LocalDateTime.now();
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public Map<String, CartItem> getItems() {
        return items;//new HashMap<String, CartItem>(item);
    }

    Scanner scanner = null;

    public void addCartItem(String item, int quantity) {
        try {
            FileReader fr = new FileReader("src/Products.txt");
            BufferedReader br = new BufferedReader(fr);
            scanner = new Scanner(br);
            boolean check = false;
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                if(data[0].compareTo(item) == 0) {
                    check = true;
                    if(quantity < Integer.parseInt(data[3])) {
                        this.items.put(data[0], new CartItem(data[1], Double.parseDouble(data[2]), quantity));
                    } else {
                        System.out.println("There are not enough " + data[0] + " in stock");
                    }
                }
            }
            if(check == false) {
                System.out.println("The product you have tried to add is not in the stock list.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }

    public void removeItem(String item) {
        if(items.containsKey(item)) {
            items.remove(item);
        } else {
            System.out.println("The product you tried to remove is not in the shopping basket.");
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void viewCartDetails() {
        System.out.println("Date added: " + getDateAdded());
        System.out.println("Products and quantities int the cart:");
        for(Map.Entry<String, CartItem> entry : this.items.entrySet()) {
            System.out.println("Product: " + entry.getKey() + " of quantity: " + entry.getValue().getQuantity());
        }
    }

    /*String s;
                        String totalStr = "";
                        try {
                            BufferedReader br2 = new BufferedReader(fr);
                            while ((s = br2.readLine()) != null) {
                                totalStr += s;
                            }
                            totalStr = totalStr.replace(data[2], Character.toString(Integer.parseInt(data[2]) - quantity));
                            FileWriter fw = new FileWriter("src/Products.txt");
                            fw.write(totalStr);
                            fw.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        */
}
