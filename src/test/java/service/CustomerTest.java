package service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;
    private OrderLine orderLine1;
    private OrderLine orderLine2;
    private OrderLine orderLine3;

    @Before
    public void setUp() {
        orderLine1 = new OrderLine();
        orderLine1.setName("Product1");
        orderLine1.setCode("P1");
        orderLine1.setQuantity(2);
        orderLine1.setPrice(100);

        orderLine2 = new OrderLine();
        orderLine2.setName("Product2");
        orderLine2.setCode("P2");
        orderLine2.setQuantity(3);
        orderLine2.setPrice(200);

        orderLine3 = new OrderLine();
        orderLine3.setName("Product3");
        orderLine3.setCode("P3");
        orderLine3.setQuantity(1);
        orderLine3.setPrice(300);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        customer = new Customer("John Doe", 5000, orderLines);
    }

    @Test
    public void testAddProduct_newProduct() {
        customer.addProduct(orderLine3);
        assertEquals(3, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_existingProduct_differentCode() {
        OrderLine orderLine = new OrderLine();
        orderLine.setName("Product1");
        orderLine.setCode("P4");
        orderLine.setQuantity(1);
        orderLine.setPrice(100);
        customer.addProduct(orderLine);
        assertEquals(3, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_existingProduct_sameCode() {
        OrderLine orderLine = new OrderLine();
        orderLine.setName("Product1");
        orderLine.setCode("P1");
        orderLine.setQuantity(1);
        orderLine.setPrice(100);
        customer.addProduct(orderLine);
        assertEquals(2, customer.getOrderLines().size());
        assertEquals(3, orderLine1.getQuantity());
    }

    @Test
    public void testAddProduct_nullProduct() {
        customer.addProduct(null);
        assertEquals(2, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_emptyOrderLines() {
        customer = new Customer("John Doe", 5000, new ArrayList<>());
        customer.addProduct(orderLine1);
        assertEquals(1, customer.getOrderLines().size());
    }

    @Test
    public void testCalculateSum_noExclusion() {
        int sum = customer.calculateSum("");
        assertEquals(1000, sum);
    }

    @Test
    public void testCalculateSum_excludeOneProduct() {
        int sum = customer.calculateSum("Product1");
        assertEquals(600, sum);
    }

    @Test
    public void testCalculateSum_excludeNonExistingProduct() {
        int sum = customer.calculateSum("Product4");
        assertEquals(1000, sum);
    }

    @Test
    public void testCalculateSum_noProducts() {
        customer = new Customer("John Doe", 5000, new ArrayList<>());
        int sum = customer.calculateSum("Product1");
        assertEquals(0, sum);
    }

    @Test
    public void testCalculateSum_excludeAllProducts() {
        int sum = customer.calculateSum("Product1");
        sum += customer.calculateSum("Product2");
        assertEquals(0, sum);
    }
}