package service;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;
    private OrderLine product1;
    private OrderLine product2;
    private OrderLine product3;

    @Before
    public void setUp() {
        product1 = new OrderLine();
        product1.setName("product1");
        product1.setCode("001");
        product1.setPrice(100);
        product1.setQuantity(1);

        product2 = new OrderLine();
        product2.setName("product2");
        product2.setCode("002");
        product2.setPrice(200);
        product2.setQuantity(2);

        product3 = new OrderLine();
        product3.setName("product3");
        product3.setCode("003");
        product3.setPrice(300);
        product3.setQuantity(3);

        customer = new Customer("John Doe", 5000, new ArrayList<>(Arrays.asList(product1, product2)));
    }

    @Test
    public void testAddProduct_NewProduct() {
        customer.addProduct(product3);
        assertEquals(3, customer.count);
    }

    @Test
    public void testAddProduct_ExistingProduct() {
        customer.addProduct(product1);
        assertEquals(2, customer.getOrderLines().get(0).getQuantity());
    }

//    @Test
//    public void testAddProduct_NullProduct() {
//        customer.addProduct(null);
//        assertEquals(2, customer.count);
//    }

//    @Test
//    public void testAddProduct_EmptyProduct() {
//        OrderLine emptyProduct = new OrderLine();
//        customer.addProduct(emptyProduct);
//        assertEquals(3, customer.count);
//    }

    @Test
    public void testAddProduct_ProductWithSameNameDifferentCode() {
        OrderLine productSameName = new OrderLine();
        productSameName.setName(product1.getName());
        productSameName.setCode("004");
        customer.addProduct(productSameName);
        assertEquals(3, customer.count);
    }

    @Test
    public void testCalculateSum_WithAvoidedProduct() {
        int sum = customer.calculateSum("product1");
        assertEquals(400, sum);
    }

    @Test
    public void testCalculateSum_WithoutAvoidedProduct() {
        int sum = customer.calculateSum("product4");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSum_NullAvoidedProduct() {
        int sum = customer.calculateSum(null);
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSum_EmptyStringAvoidedProduct() {
        int sum = customer.calculateSum("");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSum_NoOrderLines() {
        Customer customerWithoutOrders = new Customer("Jane Doe", 5000, new ArrayList<>());
        int sum = customerWithoutOrders.calculateSum("product1");
        assertEquals(0, sum);
    }
}