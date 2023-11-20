package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class CustomerTest {
    private Customer customer;
    private OrderLine orderLine1;
    private OrderLine orderLine2;

    @Before
    public void setUp() {
        orderLine1 = new OrderLine();
        orderLine1.setName("Product1");
        orderLine1.setCode("Code1");
        orderLine1.setQuantity(1);
        orderLine1.setPrice(100);

        orderLine2 = new OrderLine();
        orderLine2.setName("Product2");
        orderLine2.setCode("Code2");
        orderLine2.setQuantity(2);
        orderLine2.setPrice(200);

        ArrayList<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);

        customer = new Customer("John", 1000, orderLines);
    }

    @Test
    public void testAddProductNew() {
        OrderLine newOrderLine = new OrderLine();
        newOrderLine.setName("Product3");
        newOrderLine.setCode("Code3");
        newOrderLine.setQuantity(1);
        newOrderLine.setPrice(300);

        customer.addProduct(newOrderLine);
        assertEquals(3, customer.count);
    }

    @Test
    public void testAddProductExisting() {
        OrderLine existingOrderLine = new OrderLine();
        existingOrderLine.setName("Product1");
        existingOrderLine.setCode("Code1");

        customer.addProduct(existingOrderLine);
        assertEquals(2, orderLine1.getQuantity());
    }

    @Test
    public void testAddProductNewWithSameName() {
        OrderLine newOrderLine = new OrderLine();
        newOrderLine.setName("Product1");
        newOrderLine.setCode("Code3");

        customer.addProduct(newOrderLine);
        assertEquals(3, customer.count);
    }

    @Test
    public void testAddProductNewWithSameCode() {
        OrderLine newOrderLine = new OrderLine();
        newOrderLine.setName("Product3");
        newOrderLine.setCode("Code1");

        customer.addProduct(newOrderLine);
        assertEquals(3, customer.count);
    }

    @Test
    public void testAddProductNull() {
        customer.addProduct(null);
        assertEquals(2, customer.count);
    }

    @Test
    public void testCalculateSumExcludeOne() {
        int sum = customer.calculateSum("Product1");
        assertEquals(400, sum);
    }

    @Test
    public void testCalculateSumExcludeNone() {
        int sum = customer.calculateSum("");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSumExcludeAll() {
        int sum = customer.calculateSum("Product1");
        customer.calculateSum("Product2");
        assertEquals(0, sum);
    }

    @Test
    public void testCalculateSumExcludeNonExistent() {
        int sum = customer.calculateSum("Product3");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSumEmptyOrderLines() {
        customer = new Customer("John", 1000, new ArrayList<>());
        int sum = customer.calculateSum("");
        assertEquals(0, sum);
    }
}