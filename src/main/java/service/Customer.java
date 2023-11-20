package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class represents a customer in the system.
 * It holds a list of order lines and provides methods to manage them.
 */
public class Customer {

    public static final int INITIAL_COUNT = 0;
    public static final int QUANTITY_INCREMENT = 1;

     int count;
    private List<OrderLine> orderLines;

    /**
     * Constructs a new Customer with the given name, savings and order lines.
     *
     * @param name The name of the customer.
     * @param savings The savings of the customer.
     * @param orderLines The order lines of the customer.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * Returns the order lines of the customer.
     *
     * @return The order lines of the customer.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Adds a product represented by the given order line to the customer's order lines.
     * If the product already exists, it increments its quantity.
     *
     * @param newOrderLine The order line representing the product to be added.
     */
    public void addProduct(OrderLine newOrderLine) {
        if (newOrderLine == null) {
            return;
        }

        for (OrderLine existingOrderLine : orderLines) {
            if (existingOrderLine.getName().equals(newOrderLine.getName())
                    && existingOrderLine.getCode().equals(newOrderLine.getCode())) {
                existingOrderLine.setQuantity(existingOrderLine.getQuantity() + QUANTITY_INCREMENT);
                return;
            }
        }

        orderLines.add(newOrderLine);
        count = orderLines.size();
    }

    /**
     * Calculates the total sum of the prices of the order lines excluding the product with the given name.
     *
     * @param excludedProductName The name of the product to be excluded.
     * @return The total sum of the prices of the order lines excluding the product with the given name.
     */
    public int calculateSum(String excludedProductName) {
        int sum = INITIAL_COUNT;
        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(excludedProductName)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }
        return sum;
    }
}

/**
 * OrderLine class represents a line in an order.
 * It holds information about a product such as its name, code, quantity, and price.
 */
class OrderLine {

    private String name;
    private String code;
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