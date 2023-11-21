package service;

import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class represents a customer who places orders.
 * It contains a list of OrderLine objects, each representing a product in the order.
 */
public class Customer {

    /**
     * Constants used in the class.
     */
    private static final int MULTIPLIER = 1250;
    private static final int ADDITION = 142;
    private static final int ZERO_NUMBER = 0;
    private static final int INCREMENT = 1;

    /**
     * Represents the count of unique products in the order.
     */
    public int count;

    /**
     * List of OrderLine objects representing the products in the order.
     */
    public List<OrderLine> orderLines = new ArrayList<>();

    /**
     * Constructor for the Customer class.
     *
     * @param name The name of the customer.
     * @param savings The amount of savings the customer has.
     * @param orderLines The list of products in the order.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * Getter for the list of products in the order.
     *
     * @return The list of products in the order.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Adds a product to the order. If the product already exists in the order,
     * it increments the quantity of that product. Otherwise, it adds the product to the order.
     *
     * @param a1 The product to add.
     */
    public void addProduct(OrderLine a1) {
        if (isProductExist(a1)) {
            incrementProductQuantity(a1);
        } else {
            orderLines.add(a1);
            count = orderLines.size();
        }
    }

    /**
     * Checks if a product already exists in the order.
     *
     * @param a1 The product to check.
     * @return True if the product exists, false otherwise.
     */
    private boolean isProductExist(OrderLine a1) {
        return orderLines.stream().anyMatch(orderLine -> orderLine.getName().equals(a1.getName()) &&
                orderLine.getCode().equals(a1.getCode()));
    }

    /**
     * Increments the quantity of a product in the order.
     *
     * @param a1 The product whose quantity to increment.
     */
    private void incrementProductQuantity(OrderLine a1) {
        for (OrderLine orderLine : orderLines) {
            if (orderLine.getName().equals(a1.getName()) && orderLine.getCode().equals(a1.getCode())) {
                orderLine.setQuantity(orderLine.getQuantity() + INCREMENT);
            }
        }
    }

    /**
     * Calculates the total cost of the order, excluding a particular product.
     *
     * @param ss The name of the product to exclude.
     * @return The total cost of the order, excluding the product.
     */
    public int calculateSum(String ss) {
        int sum = ZERO_NUMBER;
        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(ss)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }
        return sum;
    }
}

/**
 * The OrderLine class represents a line item in an order.
 * It contains properties such as name, code, quantity, and price.
 */
class OrderLine {

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The code of the product.
     */
    private String code;

    /**
     * The quantity of the product in the order.
     */
    private int quantity;

    /**
     * The price of the product.
     */
    private int price;

    /**
     * Getter for the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the quantity of the product in the order.
     *
     * @return The quantity of the product in the order.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for the quantity of the product in the order.
     *
     * @param quantity The quantity of the product in the order.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for the code of the product.
     *
     * @return The code of the product.
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for the code of the product.
     *
     * @param code The code of the product.
     */
    public void setCode(String code) {
        this.code = code;
    }
}