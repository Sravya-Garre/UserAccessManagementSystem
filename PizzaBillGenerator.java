package com.nt.bill;
import java.util.Scanner;

class Pizza {
    protected String type;
    protected int price;
    protected boolean extraCheese;
    protected boolean extraToppings;
    
    public Pizza(String type, int price) {
        this.type = type;
        this.price = price;
        this.extraCheese = false;
        this.extraToppings = false;
    }
    
    public void addExtraCheese() {
        this.extraCheese = true;
        this.price += 100;
    }
    
    public void addExtraToppings() {
        this.extraToppings = true;
        this.price += 150;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void displayBill() {
        System.out.println("Pizza Type: " + type);
        System.out.println("Base Price: " + price);
        if (extraCheese) {
            System.out.println("Extra Cheese Added: 100");
        }
        if (extraToppings) {
            System.out.println("Extra Toppings Added: 150");
        }
        System.out.println("Total Price: " + price);
    }
}

class DeluxePizza extends Pizza {
    public DeluxePizza(String type, int price) {
        super(type, price);
        this.extraCheese = true;
        this.extraToppings = true;
    }
    
    @Override
    public void displayBill() {
        System.out.println("Pizza Type: " + type);
        System.out.println("Base Price (Includes Extra Cheese & Toppings): " + price);
        System.out.println("Total Price: " + price);
    }
}

public class PizzaBillGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pizzamania!");
        System.out.println("Select your Pizza Type:");
        System.out.println("1. Veg Pizza (300)");
        System.out.println("2. Non-Veg Pizza (400)");
        System.out.println("3. Deluxe Veg Pizza (550)");
        System.out.println("4. Deluxe Non-Veg Pizza (650)");
        
        int choice = scanner.nextInt();
        Pizza pizza = null;
        
        switch (choice) {
            case 1:
                pizza = new Pizza("Veg Pizza", 300);
                break;
            case 2:
                pizza = new Pizza("Non-Veg Pizza", 400);
                break;
            case 3:
                pizza = new DeluxePizza("Deluxe Veg Pizza", 550);
                break;
            case 4:
                pizza = new DeluxePizza("Deluxe Non-Veg Pizza", 650);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        if (!(pizza instanceof DeluxePizza)) {
            System.out.println("Do you want Extra Cheese? (yes/no)");
            String cheese = scanner.next();
            if (cheese.equalsIgnoreCase("yes")) {
                pizza.addExtraCheese();
            }
            
            System.out.println("Do you want Extra Toppings? (yes/no)");
            String toppings = scanner.next();
            if (toppings.equalsIgnoreCase("yes")) {
                pizza.addExtraToppings();
            }
        }
        
        System.out.println("Do you want Take Away? (yes/no)");
        String takeAway = scanner.next();
        if (takeAway.equalsIgnoreCase("yes")) {
            pizza.price += 20;
        }
        
        pizza.displayBill();
        scanner.close();
    }
}
