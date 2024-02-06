package service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Customer who can place orders.
 */
public class Customer {

    int count;
    private List<OrderLine> orderLines;

    /**
     * This constructor initializes the Customer with a name, savings, and a list of OrderLines.
     *
     * @param name The name of the Customer.
     * @param savings The savings of the Customer.
     * @param orderLines The list of OrderLines.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * This method returns a list of OrderLines.
     *
     * @return The list of OrderLines.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * This method adds a product to the Customer's list of OrderLines.
     * If the product already exists in the list, it increments the quantity of the product.
     *
     * @param product The product to add.
     */
    public void addProduct(OrderLine product) {
        boolean productExists = false;

        for (OrderLine orderLine : orderLines) {
            if (isSameProduct(orderLine, product)) {
                incrementProductQuantity(orderLine);
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            orderLines.add(product);
            count++;
        }
    }

    /**
     * This method checks if two OrderLines are the same based on their name and code.
     *
     * @param orderLine The first OrderLine to compare.
     * @param product The second OrderLine to compare.
     * @return A boolean indicating if the two OrderLines are the same.
     */
    private boolean isSameProduct(OrderLine orderLine, OrderLine product) {
        return orderLine.getName().equals(product.getName()) &&
                orderLine.getCode().equals(product.getCode());
    }

    /**
     * This method increments the quantity of an OrderLine.
     *
     * @param orderLine The OrderLine to increment.
     */
    private void incrementProductQuantity(OrderLine orderLine) {
        orderLine.setQuantity(orderLine.getQuantity() + 1);
    }

    /**
     * This method calculates the total sum of all OrderLines, excluding any OrderLine with the specified name.
     *
     * @param excludeProductName The name of the OrderLine to exclude.
     * @return The total sum.
     */
    public int calculateSum(String excludeProductName) {
        int sum = 0;

        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(excludeProductName)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }

        return sum;
    }
}

/**
 * This class represents an OrderLine, which contains information about a product.
 */
class OrderLine {
    private String name;
    private String code;
    private int quantity;
    private int price;

    /**
     * This method returns the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method sets the quantity of the product.
     *
     * @param quantity The quantity of the product.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This method returns the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method returns the code of the product.
     *
     * @return The code of the product.
     */
    public String getCode() {
        return code;
    }

    /**
     * This method sets the code of the product.
     *
     * @param code The code of the product.
     */
    public void setCode(String code) {
        this.code = code;
    }
}