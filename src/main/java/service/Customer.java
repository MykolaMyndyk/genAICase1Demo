package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer who has a list of orders.
 * Provides methods to manipulate and retrieve information about the orders.
 */
public class Customer {

    public static final String EMPTY_STRING = "";
    public static final int INITIAL_QUANTITY = 1;

    private List<OrderLine> orderLines;
    public int count;

    /**
     * Constructs a new Customer with the given name, savings and list of orders.
     * @param name the customer's name.
     * @param savings the customer's savings.
     * @param orderLines the list of orders.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * Retrieves the list of orders.
     * @return the list of orders.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Adds a product to the list of orders.
     * If the product already exists in the list, increments its quantity.
     * If the product is new, adds it to the list.
     * @param newOrderLine the product to be added.
     */
    public void addProduct(OrderLine newOrderLine) {
        if (newOrderLine == null) {
            return;
        }

        for (OrderLine existingOrderLine : orderLines) {
            if (isSameProduct(existingOrderLine, newOrderLine)) {
                incrementQuantity(existingOrderLine);
                return;
            }
        }

        addNewProduct(newOrderLine);
    }

    /**
     * Calculates the total cost of all orders excluding a specific product.
     * @param productNameToExclude the name of the product to be excluded.
     * @return the total cost.
     */
    public int calculateSum(String productNameToExclude) {
        int sum = 0;

        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(productNameToExclude)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }

        return sum;
    }

    private boolean isSameProduct(OrderLine existingOrderLine, OrderLine newOrderLine) {
        return existingOrderLine.getName().equals(newOrderLine.getName()) &&
                existingOrderLine.getCode().equals(newOrderLine.getCode());
    }

    private void incrementQuantity(OrderLine existingOrderLine) {
        existingOrderLine.setQuantity(existingOrderLine.getQuantity() + 1);
    }

    private void addNewProduct(OrderLine newOrderLine) {
        orderLines.add(newOrderLine);
        count = orderLines.size();
    }
}

/**
 * Represents an order line with properties such as name, code, quantity and price.
 */
class OrderLine {

    private String name;
    private String code;
    private int quantity;
    private int price;

    /**
     * Retrieves the name of the product.
     * @return the product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * @param name the product's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the quantity of the product.
     * @return the product's quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     * @param quantity the product's quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieves the price of the product.
     * @return the product's price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price the product's price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the code of the product.
     * @return the product's code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the product.
     * @param code the product's code.
     */
    public void setCode(String code) {
        this.code = code;
    }
}