package service;

import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class represents a customer with a list of order lines.
 */
public class Customer {

    private static final String AVOID_PRODUCT = "";

    private List<OrderLine> orderLines = new ArrayList<>();
    private int count;

    /**
     * Customer constructor.
     *
     * @param name       the name of the customer
     * @param savings    the savings of the customer
     * @param orderLines the list of orders placed by the customer
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * Getter for order lines.
     *
     * @return the list of order lines
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * The method to add a new product in the order line.
     * If the product already exists, it increments the quantity.
     *
     * @param newProduct the product to add
     */
    public void addProduct(OrderLine newProduct) {
        // method implementation
    }

    /**
     * The method calculates the sum of all products excluding the specified product.
     *
     * @param avoidProductName the name of the product to exclude
     * @return the sum of all product prices
     */
    public int calculateSum(String avoidProductName){
        // method implementation
    }

    // Other private methods
}

/**
 * The OrderLine class represents a product line in an order.
 */
class OrderLine {

    private String name;
    private String code;
    private int quantity;
    private int price;

    /**
     * Getter for product name.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for product name.
     *
     * @param name the name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for product quantity.
     *
     * @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for product quantity.
     *
     * @param quantity the quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for product price.
     *
     * @return the price of the product
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for product price.
     *
     * @param price the price of the product
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for product code.
     *
     * @return the code of the product
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for product code.
     *
     * @param code the code of the product
     */
    public void setCode(String code) {
        this.code = code;
    }
}