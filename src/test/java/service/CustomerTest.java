package service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    private Customer customer;
    private OrderLine order1;
    private OrderLine order2;

    @Before
    public void setUp() {
        order1 = new OrderLine();
        order1.setName("Product1");
        order1.setCode("111");
        order1.setQuantity(1);
        order1.setPrice(100);

        order2 = new OrderLine();
        order2.setName("Product2");
        order2.setCode("222");
        order2.setQuantity(2);
        order2.setPrice(200);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(order1);
        customer = new Customer("John Doe", 1000, orderLines);
    }

    // Unit tests for addProduct method
    @Test
    public void testAddProduct_NewProduct() {
        customer.addProduct(order2);
        assertEquals(2, customer.getOrderLines().size());
        assertEquals(2, customer.count);
    }

    @Test
    public void testAddProduct_ExistingProduct() {
        customer.addProduct(order1);
        assertEquals(1, customer.getOrderLines().size());
        assertEquals(2, order1.getQuantity());
    }

    @Test
    public void testAddProduct_NullProduct() {
        customer.addProduct(null);
        assertEquals(1, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_SameProductDifferentCode() {
        OrderLine order = new OrderLine();
        order.setName(order1.getName());
        order.setCode("333");
        order.setQuantity(1);
        order.setPrice(100);
        customer.addProduct(order);
        assertEquals(2, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_EmptyOrderLines() {
        customer = new Customer("John Doe", 1000, new ArrayList<>());
        customer.addProduct(order1);
        assertEquals(1, customer.getOrderLines().size());
    }

    // Unit tests for calculateSum method
    @Test
    public void testCalculateSum_WithValidName() {
        customer.addProduct(order2);
        int sum = customer.calculateSum("Product1");
        assertEquals(400, sum);
    }

    @Test
    public void testCalculateSum_WithInvalidName() {
        customer.addProduct(order2);
        int sum = customer.calculateSum("Product3");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSum_WithEmptyName() {
        customer.addProduct(order2);
        int sum = customer.calculateSum("");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSum_WithNullName() {
        customer.addProduct(order2);
        int sum = customer.calculateSum(null);
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSum_EmptyOrderLines() {
        customer = new Customer("John Doe", 1000, new ArrayList<>());
        int sum = customer.calculateSum("Product1");
        assertEquals(0, sum);
    }
}