package com.kodluyoruz;

/**
 * Subclass representing a discounted product to be
 * purchased. It extends the Product class with two instance variables
 */
public class DiscountedProduct extends Product {
    // Original product
    private final Product original;

    // Discount in percent (%)
    private final double discount;

    /**
     * Construct a discounted product
     * @param original
     * @param discount
     */
    public DiscountedProduct(Product original, double discount) {
        // if the price can not be reduced you should print a message and
        // terminate the program. Use IllegalArgumentException to terminate.
        // code here
        super(original);
        if (original instanceof Buy2Take3Product){
            throw new IllegalArgumentException();
        }

        this.original = original;
        this.discount = discount;
    }

    /**
     * Return the price of this discounted product
     * @param cart shopping cart
     * @return discounted price
     */

    public double getPrice(Cart cart) {
        // code here
        return this.original.getPrice(cart) - this.original.getPrice(cart) * (this.discount / 100.0);
    }

    /**
     * Return the string representation of the product
     * Example: CD [discounted 20 %]
     */
    public String toString() {
        // code here
        return this.original.getName() + "[discounted " + this.discount + " %]";
    }
}
