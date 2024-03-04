package service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a customer. It contains the customer's orders and
 * provides methods to add products and calculate the sum of the orders.
 */
public class Customer {

    private static final String EMPTY_STRING = "";
    private static final int INITIAL_COUNT = 0;

    private List<OrderLine> orderLines;
    int count;

    /**
     * Constructs a new Customer object with the specified parameters.
     *
     * @param name The name of the customer.
     * @param savings The savings of the customer.
     * @param orderLines The orders made by the customer.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines != null ? orderLines : new ArrayList<>();
        this.count = this.orderLines.size();
    }

    /**
     * Returns a list of order lines.
     *
     * @return The list of order lines.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Adds a product to the customer's order line.
     *
     * @param product The product to be added.
     */
    public void addProduct(OrderLine product) {
        if (product == null || product.getName() == null || product.getCode() == null) {
            return;
        }

        for (OrderLine orderLine : orderLines) {
            if (isSameProduct(orderLine, product)) {
                incrementQuantity(orderLine);
                return;
            }
        }

        addNewProduct(product);
    }

    /**
     * Checks if two products are the same based on their name and code.
     *
     * @param orderLine The existing product.
     * @param product The product to be compared.
     * @return true if the products are the same, false otherwise.
     */
    private boolean isSameProduct(OrderLine orderLine, OrderLine product) {
        return orderLine.getName().equals(product.getName()) && orderLine.getCode().equals(product.getCode());
    }

    /**
     * Increments the quantity of the specified product.
     *
     * @param orderLine The product whose quantity is to be incremented.
     */
    private void incrementQuantity(OrderLine orderLine) {
        orderLine.setQuantity(orderLine.getQuantity() + 1);
    }

    /**
     * Adds a new product to the order line and updates the count.
     *
     * @param product The product to be added.
     */
    private void addNewProduct(OrderLine product) {
        orderLines.add(product);
        count = orderLines.size();
    }

    /**
     * Calculates the sum of the prices of all products in the order line
     * excluding the product with the specified name.
     *
     * @param productNameToAvoid The name of the product to be excluded.
     * @return The sum of the prices of all products excluding the product
     * with the specified name.
     */
    public int calculateSum(String productNameToAvoid) {
        int sum = INITIAL_COUNT;
        String avoid = productNameToAvoid != null ? productNameToAvoid : EMPTY_STRING;

        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(avoid)) {
                sum += calculateProductTotalPrice(orderLine);
            }
        }

        return sum;
    }

    /**
     * Calculates the total price of the specified product.
     *
     * @param orderLine The product whose total price is to be calculated.
     * @return The total price of the product.
     */
    private int calculateProductTotalPrice(OrderLine orderLine) {
        return orderLine.getPrice() * orderLine.getQuantity();
    }
}

/**
 * This class represents a line in an order. It contains the details of a product
 * such as its name, code, quantity, and price.
 */
class OrderLine {

    private String name ;
    private String code ;
    private int quantity;
    private int price;

    /**
     * Returns the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity The quantity of the product.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns the code of the product.
     *
     * @return The code of the product.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the product.
     *
     * @param code The code of the product.
     */
    public void setCode(String code) {
        this.code = code;
    }
}