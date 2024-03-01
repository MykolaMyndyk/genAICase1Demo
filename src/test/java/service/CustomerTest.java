package service;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;
    private OrderLine orderLine1;
    private OrderLine orderLine2;
    private OrderLine orderLine3;

    @Before
    public void setup() {
        orderLine1 = new OrderLine();
        orderLine1.setName("product1");
        orderLine1.setCode("code1");
        orderLine1.setQuantity(1);
        orderLine1.setPrice(100);

        orderLine2 = new OrderLine();
        orderLine2.setName("product2");
        orderLine2.setCode("code2");
        orderLine2.setQuantity(2);
        orderLine2.setPrice(200);

        orderLine3 = new OrderLine();
        orderLine3.setName("product3");
        orderLine3.setCode("code3");
        orderLine3.setQuantity(3);
        orderLine3.setPrice(300);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        customer = new Customer("Test", 0, orderLines);
    }

    @Test
    public void testAddProductExistingProduct() {
        customer.addProduct(orderLine1);
        assertEquals(2, customer.getOrderLines().get(0).getQuantity());
        assertEquals(2, customer.count);
    }

//    @Test
//    public void testAddProductNewProduct() {
//        customer.addProduct(orderLine3);
//        assertEquals(1, customer.getOrderLines().get(2).getQuantity());
//        assertEquals(3, customer.count);
//    }

    @Test
    public void testAddProductNullProduct() {
        customer.addProduct(null);
        assertEquals(2, customer.count);
    }

    @Test
    public void testAddProductEmptyProduct() {
        OrderLine emptyOrderLine = new OrderLine();
        customer.addProduct(emptyOrderLine);
        assertEquals(3, customer.count);
    }

    @Test
    public void testAddProductIdenticalProducts() {
        customer.addProduct(orderLine1);
        customer.addProduct(orderLine1);
        assertEquals(3, customer.getOrderLines().get(0).getQuantity());
        assertEquals(2, customer.count);
    }

    @Test
    public void testCalculateSumAllProducts() {
        int sum = customer.calculateSum("");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSumExcludingProduct1() {
        int sum = customer.calculateSum("product1");
        assertEquals(400, sum);
    }

    @Test
    public void testCalculateSumExcludingProduct2() {
        int sum = customer.calculateSum("product2");
        assertEquals(100, sum);
    }

    @Test
    public void testCalculateSumExcludingNonExistentProduct() {
        int sum = customer.calculateSum("product4");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSumExcludingNull() {
        int sum = customer.calculateSum(null);
        assertEquals(500, sum);
    }
}