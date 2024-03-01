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
        orderLine1.setQuantity(2);
        orderLine1.setPrice(10);

        orderLine2 = new OrderLine();
        orderLine2.setName("product2");
        orderLine2.setCode("code2");
        orderLine2.setQuantity(3);
        orderLine2.setPrice(20);

        orderLine3 = new OrderLine();
        orderLine3.setName("product3");
        orderLine3.setCode("code3");
        orderLine3.setQuantity(4);
        orderLine3.setPrice(30);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        customer = new Customer("John Doe", 5000, orderLines);
    }

    @Test
    public void testAddProduct_ExistingProduct() {
        customer.addProduct(orderLine1);
        assertEquals(3, orderLine1.getQuantity());
    }

    @Test
    public void testAddProduct_NewProduct() {
        customer.addProduct(orderLine3);
        assertEquals(3, customer.getOrderLines().size());
        assertEquals(1, orderLine3.getQuantity());
    }

    @Test
    public void testAddProduct_NullProduct() {
        customer.addProduct(null);
        assertEquals(2, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_ExistingProductDifferentCode() {
        OrderLine orderLine = new OrderLine();
        orderLine.setName("product1");
        orderLine.setCode("code4");
        customer.addProduct(orderLine);
        assertEquals(3, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_SameProductCodeDifferentName() {
        OrderLine orderLine = new OrderLine();
        orderLine.setName("product4");
        orderLine.setCode("code1");
        customer.addProduct(orderLine);
        assertEquals(3, customer.getOrderLines().size());
    }

    @Test
    public void testCalculateSum_AllProducts() {
        int sum = customer.calculateSum("");
        assertEquals(80, sum);
    }

    @Test
    public void testCalculateSum_ExcludingOneProduct() {
        int sum = customer.calculateSum("product1");
        assertEquals(60, sum);
    }

    @Test
    public void testCalculateSum_ExcludingNonExistentProduct() {
        int sum = customer.calculateSum("product5");
        assertEquals(80, sum);
    }

    @Test
    public void testCalculateSum_EmptyOrderLines() {
        customer = new Customer("John Doe", 5000, new ArrayList<>());
        int sum = customer.calculateSum("");
        assertEquals(0, sum);
    }

    @Test
    public void testCalculateSum_ExcludingAllProducts() {
        int sum1 = customer.calculateSum("product1");
        int sum2 = customer.calculateSum("product2");
        assertEquals(0, sum1 + sum2);
    }
}