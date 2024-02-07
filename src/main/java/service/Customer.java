package service;

import java.util.List;

/**
 * Customer class represents a customer who places orders.
 */
public class Customer {

    public static final int INITIAL_QUANTITY = 1;
    public static final int INITIAL_SUM = 0;
    private List<OrderLine> orderLines;
    public int count;

    /**
     * Constructor to initialize Customer with name, savings and order lines.
     * @param name Name of the customer.
     * @param savings Amount of savings the customer has.
     * @param orderLines List of orders the customer has made.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * Getter for order lines.
     * @return a List of order lines.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Adds a product to the customer's order. If the product already exists, the quantity is incremented.
     * @param a1 The product to add.
     */
    public void addProduct(OrderLine a1) {
        if (a1 == null) {
            return;
        }

        for (OrderLine orderLine : orderLines) {
            if (isSameProduct(orderLine, a1)) {
                incrementQuantity(orderLine);
                updateCount();
                return;
            }
        }

        orderLines.add(a1);
        updateCount();
    }

    /**
     * Calculates the total cost of all products ordered by a customer, excluding a specific product.
     * @param productToExclude The product to exclude from the calculation.
     * @return The total cost.
     */
    public int calculateSum(String productToExclude){
        int sum = INITIAL_SUM;

        for (OrderLine orderLine : orderLines) {
            if (!isExcludedProduct(orderLine, productToExclude)) {
                sum += calculateProductTotal(orderLine);
            }
        }

        return sum;
    }

    /**
     * Checks if two products are the same based on their name and code.
     * @param orderLine The existing product in the order.
     * @param a1 The product to compare with.
     * @return True if they are the same product, false otherwise.
     */
    private boolean isSameProduct(OrderLine orderLine, OrderLine a1) {
        return orderLine.getName().equals(a1.getName()) &&
                orderLine.getCode().equals(a1.getCode());
    }

    /**
     * Increments the quantity of a product in the order.
     * @param orderLine The product whose quantity is to be incremented.
     */
    private void incrementQuantity(OrderLine orderLine) {
        orderLine.setQuantity(orderLine.getQuantity()+INITIAL_QUANTITY);
    }

    /**
     * Updates the count of total products in the order.
     */
    private void updateCount() {
        count = orderLines.size();
    }

    /**
     * Checks if a product is the one to be excluded from the calculation.
     * @param orderLine The product to check.
     * @param productToExclude The product to be excluded.
     * @return True if they are the same product, false otherwise.
     */
    private boolean isExcludedProduct(OrderLine orderLine, String productToExclude) {
        return orderLine.getName().equals(productToExclude);
    }

    /**
     * Calculates the total cost of a product.
     * @param orderLine The product whose cost is to be calculated.
     * @return The total cost of the product.
     */
    private int calculateProductTotal(OrderLine orderLine) {
        return orderLine.getPrice()*orderLine.getQuantity();
    }
}

/**
 * OrderLine class represents a product ordered by a customer.
 */
class OrderLine {

    private String name ;
    private String code ;
    private int quantity;
    private int price;

    /**
     * Getter for product name.
     * @return The product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for product name.
     * @param name The product name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for product quantity.
     * @return The product quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for product quantity.
     * @param quantity The product quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for product price.
     * @return The product price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for product price.
     * @param price The product price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for product code.
     * @return The product code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for product code.
     * @param code The product code.
     */
    public void setCode(String code) {
        this.code = code;
    }
}