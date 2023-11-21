package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class CustomerTest {
    private Customer customer;
    private OrderLine orderLine1;
    private OrderLine orderLine2;

    @Before
    public void setup() {
        customer = new Customer("John Doe", 500, new ArrayList<>());
        orderLine1 = new OrderLine();
        orderLine1.setName("Product1");
        orderLine1.setCode("P1");
        orderLine1.setQuantity(1);
        orderLine1.setPrice(100);

        orderLine2 = new OrderLine();
        orderLine2.setName("Product2");
        orderLine2.setCode("P2");
        orderLine2.setQuantity(2);
        orderLine2.setPrice(200);
    }

    @Test
    public void testAddProductNew() {
        customer.addProduct(orderLine1);
        Assert.assertEquals(1, customer.count);
        Assert.assertEquals(orderLine1, customer.orderLines.get(0));
    }

    @Test
    public void testAddProductExisting() {
        customer.addProduct(orderLine1);
        customer.addProduct(orderLine1);
        Assert.assertEquals(1, customer.count);
        Assert.assertEquals(2, customer.orderLines.get(0).getQuantity());
    }

    @Test
    public void testAddProductMultiple() {
        customer.addProduct(orderLine1);
        customer.addProduct(orderLine2);
        Assert.assertEquals(2, customer.count);
    }

    @Test
    public void testCalculateSumAllProducts() {
        customer.addProduct(orderLine1);
        customer.addProduct(orderLine2);
        Assert.assertEquals(500, customer.calculateSum(""));
    }

    @Test
    public void testCalculateSumExcludeOneProduct() {
        customer.addProduct(orderLine1);
        customer.addProduct(orderLine2);
        Assert.assertEquals(400, customer.calculateSum("Product1"));
    }

//    @Test
//    public void testCalculateSumExcludeAllProducts() {
//        customer.addProduct(orderLine1);
//        customer.addProduct(orderLine2);
//        Assert.assertEquals(0, customer.calculateSum("Product1"));
//        Assert.assertEquals(0, customer.calculateSum("Product2"));
//    }

    @Test
    public void testCalculateSumNoProducts() {
        Assert.assertEquals(0, customer.calculateSum(""));
    }

    @Test
    public void testCalculateSumSingleProduct() {
        customer.addProduct(orderLine1);
        Assert.assertEquals(100, customer.calculateSum(""));
    }

    @Test
    public void testCalculateSumSingleProductExclude() {
        customer.addProduct(orderLine1);
        Assert.assertEquals(0, customer.calculateSum("Product1"));
    }
}