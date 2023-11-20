package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Customer who places orders.
 */
public class Customer {

    private static final int ZERO = 0;
    private static final int INCREMENT_VALUE = 1;

    private List<OrderLine> orderLines;
    private int count;

    /**
     * Constructs a new Customer with the given name, savings, and order lines.
     *
     * @param name The name of the customer.
     * @param savings The savings of the customer.
     * @param orderLines The list of order lines the customer has.
     */
    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = new ArrayList<>(orderLines);
        this.count = orderLines.size();
    }

    /**
     * Retrieves the order lines for this customer.
     *
     * @return A new list containing the order lines for this customer.
     */
    public List<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);
    }

    /**
     * Adds a product to the customer's order line. If the product already exists, it increments the quantity.
     *
     * @param newOrderLine The order line to add.
     */
    public void addProduct(OrderLine newOrderLine) {
        if (newOrderLine == null) return;

        for (OrderLine orderLine : orderLines) {
            if (isSameProduct(orderLine, newOrderLine)) {
                orderLine.setQuantity(orderLine.getQuantity() + INCREMENT_VALUE);
                return;
            }
        }

        orderLines.add(newOrderLine);
        count = orderLines.size();
    }

    /**
     * Checks if two order lines are for the same product.
     *
     * @param orderLine The first order line.
     * @param newOrderLine The second order line.
     * @return true if they are for the same product, false otherwise.
     */
    private boolean isSameProduct(OrderLine orderLine, OrderLine newOrderLine) {
        return orderLine.getName().equals(newOrderLine.getName())
                && orderLine.getCode().equals(newOrderLine.getCode());
    }

    /**
     * Calculates the sum of the prices for all products, excluding the product with the given name.
     *
     * @param avoidProductName The name of the product to exclude.
     * @return The sum of the prices for all other products.
     */
    public int calculateSum(String avoidProductName){
        int sum = ZERO;

        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(avoidProductName)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }

        return sum;
    }
}

/**
 * Represents an order line in a customer's order.
 */
class OrderLine {

    private String name;
    private String code;
    private int quantity;
    private int price;

    /**
     * @return The name of the product in this order line.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product in this order line.
     *
     * @param name The new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The quantity of the product in this order line.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in this order line.
     *
     * @param quantity The new quantity of the product.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return The price of the product in this order line.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product in this order line.
     *
     * @param price The new price of the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return The code of the product in this order line.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the product in this order line.
     *
     * @param code The new code of the product.
     */
    public void setCode(String code) {
        this.code = code;
    }
}