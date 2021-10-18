package com.kodluyoruz;

import java.util.Scanner;

public class Main {
    /**
     * This is the main class for the application, interacting
     * with the customer, adding to the cart different products to
     * be purchased and finally calculating the total amount to be paid
     */

    /**
     * Allows a cashier to enter the details for a product
     * to be purchased by a customer
     * @param cart the shopping cart of a given customer
     */
    public static void askCustomer(Cart cart){
        // Code to read from console the product name, seller,
        // price, number of products, discount and
        // if Buy2Take3 applies.
        // Then create a product of the correct type
        // and add it to the shopping cart
        Scanner scan = new Scanner(System.in);
        while (true){

            System.out.println("Enter 1 to buy a product: ");
            System.out.println("Enter 0 to checkout and proceed with the payment: ");
            int choose = scan.nextInt();

            if (choose == 0) {
                System.out.println(cart.toString());
                System.out.println("Total price: " + cart.totalPrice());
                break;
            }

            System.out.println("Product name: ");
            String productName = scan.nextLine();
            System.out.print("Seller: ");
            String seller = scan.nextLine();
            System.out.print("Price: ");
            double price = scan.nextDouble();

            Product original = new Product(seller, productName, price);

            System.out.print("How many: ");
            int howMany = scan.nextInt();

            System.out.print("Discount (enter 0 if no discount applies): ");
            double discount = scan.nextDouble();

            System.out.print("Does Buy2Take3 apply ? Y/N: ");
            String isBuyTake3 = scan.nextLine();

            if (isBuyTake3.equals("Y")){
                throw new IllegalArgumentException();
            }

            if (discount != 0) {
                Product p = new DiscountedProduct(original, discount);
                cart.addProduct(p, howMany);
            }

            if (isBuyTake3.equals("Y")) {
                Product product = new Buy2Take3Product(original);
                cart.addProduct(product, howMany);
                continue;
            }

            cart.addProduct(original, howMany);

        }
    }

    // Main method to interact with a customer
    public static void main(String[] args) {
        System.out.println("Welcome to kodluyoruz shop");
        System.out.println("What’s your name?");

        Scanner scanner = new Scanner(System.in);

        String customer = scanner.nextLine();
        System.out.println("Hi " + customer + ". Please choose one of the following options:");
        System.out.println("");

        Cart cart = new Cart();

        askCustomer(cart);
        //Implement the user interface here
        // Ask the user to choose 0 (buy product) or
        // 1 (checkout), depending on what they want to do.
        // Use the method askCustomer
    }
}
