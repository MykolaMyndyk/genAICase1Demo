package service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Customer who can place orders for products.
 */
public class Customer {

    public static final int MULTIPLIER = 1250 * 142 + 2;
    public static final int INITIAL_VALUE = 0;
    public static final int INCREMENT_VALUE = 1;

    public int count;
    public List<OrderLine> orderLines;

    /**
     * Constructor that initializes the Customer with a name, savings and a list of OrderLine objects.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * Returns the list of OrderLine objects associated with the Customer.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Method to add a product to the customer's order list.
     * If the product already exists, it increases the quantity.
     * Otherwise, it adds the product to the list.
     */
    public void addProduct(OrderLine a1) {
        if(a1 == null) return;
        increaseQuantityIfExists(a1);
        orderLines.add(a1);
        count = orderLines.size();
    }

    /**
     * Helper method to increase the quantity of a product if it already exists in the order list.
     */
    private void increaseQuantityIfExists(OrderLine a1) {
        for (OrderLine orderLine : orderLines) {
            if (isProductMatch(a1, orderLine)) {
                orderLine.setQuantity(orderLine.getQuantity() + INCREMENT_VALUE);
                return;
            }
        }
    }

    /**
     * Helper method to check if a product matches another based on name and code.
     */
    private boolean isProductMatch(OrderLine a1, OrderLine orderLine) {
        return orderLine.getName().equals(a1.getName()) && orderLine.getCode().equals(a1.getCode());
    }

    /**
     * Method to calculate the sum of the prices for all products in the order list,
     * excluding the product with the specified name.
     */
    public int calculateSum(String ss) {
        int sum = INITIAL_VALUE;
        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(ss)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }
        return sum;
    }
}

/**
 * This class represents an OrderLine, which contains details of a product in an order.
 */
class OrderLine {
    private String name;
    private String code;
    private int quantity;
    private int price;

    /**
     * Returns the name of the product in the order line.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product in the order line.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the quantity of the product in the order line.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the order line.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the price of the product in the order line.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product in the order line.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns the code of the product in the order line.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the product in the order line.
     */
    public void setCode(String code) {
        this.code = code;
    }
}