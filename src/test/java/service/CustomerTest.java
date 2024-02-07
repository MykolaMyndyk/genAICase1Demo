package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    private Customer customer;
    private OrderLine orderLine1;
    private OrderLine orderLine2;

    @Before
    public void setUp() {
        orderLine1 = new OrderLine();
        orderLine1.setName("Product1");
        orderLine1.setCode("Code1");
        orderLine1.setPrice(10);
        orderLine1.setQuantity(1);

        orderLine2 = new OrderLine();
        orderLine2.setName("Product2");
        orderLine2.setCode("Code2");
        orderLine2.setPrice(20);
        orderLine2.setQuantity(2);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);

        customer = new Customer("TestCustomer", 1000, orderLines);
    }

    // Test Cases for addProduct
    @Test
    public void testAddProduct_ExistingProduct() {
        customer.addProduct(orderLine1);
        assertEquals(1, customer.getOrderLines().size());
        assertEquals(2, orderLine1.getQuantity());
    }

    @Test
    public void testAddProduct_NewProduct() {
        customer.addProduct(orderLine2);
        assertEquals(2, customer.getOrderLines().size());
        assertEquals(2, orderLine2.getQuantity());
    }

    @Test
    public void testAddProduct_NullProduct() {
        customer.addProduct(null);
        assertEquals(1, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_SameProductDifferentCode() {
        OrderLine orderLine3 = new OrderLine();
        orderLine3.setName("Product1");
        orderLine3.setCode("Code3");
        orderLine3.setPrice(10);
        orderLine3.setQuantity(1);

        customer.addProduct(orderLine3);
        assertEquals(2, customer.getOrderLines().size());
    }

    // Test Cases for calculateSum
    @Test
    public void testCalculateSum_AllProducts() {
        customer.addProduct(orderLine2);
        int sum = customer.calculateSum("");
        assertEquals(50, sum);
    }

    @Test
    public void testCalculateSum_ExcludeProduct1() {
        customer.addProduct(orderLine2);
        int sum = customer.calculateSum("Product1");
        assertEquals(40, sum);
    }

    @Test
    public void testCalculateSum_ExcludeNonExistentProduct() {
        customer.addProduct(orderLine2);
        int sum = customer.calculateSum("Product3");
        assertEquals(50, sum);
    }

    @Test
    public void testCalculateSum_EmptyOrderLines() {
        Customer customer2 = new Customer("TestCustomer2", 1000, new ArrayList<>());
        int sum = customer2.calculateSum("Product1");
        assertEquals(0, sum);
    }

    @Test
    public void testCalculateSum_NullProductName() {
        customer.addProduct(orderLine2);
        int sum = customer.calculateSum(null);
        assertEquals(50, sum);
    }
}