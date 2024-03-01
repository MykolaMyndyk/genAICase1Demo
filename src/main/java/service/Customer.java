package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer with a list of order lines.
 */
public class Customer {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private int count;
    private List<OrderLine> orderLines = new ArrayList<>();

    /**
     * Constructs a new customer.
     *
     * @param name The name of the customer.
     * @param savings The savings of the customer.
     * @param orderLines The list of order lines for the customer.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * Returns the list of order lines for the customer.
     *
     * @return The list of order lines.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Adds a product to the customer's order lines.
     *
     * @param newProduct The product to add.
     */
    public void addProduct(OrderLine newProduct) {
        for (OrderLine existingProduct : orderLines) {
            if (isSameProduct(newProduct, existingProduct)) {
                existingProduct.setQuantity(existingProduct.getQuantity() + ONE);
                return;
            }
        }
        orderLines.add(newProduct);
        count = orderLines.size();
    }

    /**
     * Calculates the sum of the prices of all order lines excluding the specified product.
     *
     * @param productNameToExclude The name of the product to exclude.
     * @return The sum of the prices.
     */
    public int calculateSum(String productNameToExclude){
        int sum = ZERO;
        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(productNameToExclude)) {
                sum += calculateLineTotal(orderLine);
            }
        }
        return sum;
    }

    private boolean isSameProduct(OrderLine newProduct, OrderLine existingProduct) {
        return existingProduct.getName().equals(newProduct.getName()) &&
                existingProduct.getCode().equals(newProduct.getCode());
    }

    private int calculateLineTotal(OrderLine orderLine) {
        return orderLine.getPrice() * orderLine.getQuantity();
    }
}

/**
 * Represents an order line with a product name, code, quantity, and price.
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