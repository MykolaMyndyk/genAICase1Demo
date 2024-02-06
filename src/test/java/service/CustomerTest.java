package service;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private ArrayList<OrderLine> orderLines;

    @Before
    public void setUp() {
        orderLines = new ArrayList<>();
        customer = new Customer("John", 1000, orderLines);
    }

    @Test
    public void testAddProduct_NewProduct() {
        OrderLine orderLine = new OrderLine();
        orderLine.setName("Product1");
        orderLine.setCode("Code1");
        orderLine.setQuantity(1);
        orderLine.setPrice(10);

        customer.addProduct(orderLine);
        assertEquals(1, customer.count);
    }

//    @Test
//    public void testAddProduct_ExistingProduct() {
//        OrderLine orderLine1 = new OrderLine();
//        orderLine1.setName("Product1");
//        orderLine1.setCode("Code1");
//        orderLine1.setQuantity(1);
//        orderLine1.setPrice(10);
//        orderLines.add(orderLine1);
//
//        OrderLine orderLine2 = new OrderLine();
//        orderLine2.setName("Product1");
//        orderLine2.setCode("Code1");
//        orderLine2.setQuantity(1);
//        orderLine2.setPrice(10);
//
//        customer.addProduct(orderLine2);
//        assertEquals(1, customer.count);
//        assertEquals(2, orderLine1.getQuantity());
//    }

//    @Test
//    public void testAddProduct_DifferentProducts() {
//        OrderLine orderLine1 = new OrderLine();
//        orderLine1.setName("Product1");
//        orderLine1.setCode("Code1");
//        orderLine1.setQuantity(1);
//        orderLine1.setPrice(10);
//        orderLines.add(orderLine1);
//
//        OrderLine orderLine2 = new OrderLine();
//        orderLine2.setName("Product2");
//        orderLine2.setCode("Code2");
//        orderLine2.setQuantity(1);
//        orderLine2.setPrice(20);
//
//        customer.addProduct(orderLine2);
//        assertEquals(2, customer.count);
//    }

    @Test
    public void testCalculateSum_SingleValue() {
        OrderLine orderLine = new OrderLine();
        orderLine.setName("Product1");
        orderLine.setCode("Code1");
        orderLine.setQuantity(2);
        orderLine.setPrice(20);
        orderLines.add(orderLine);

        int sum = customer.calculateSum("");
        assertEquals(40, sum);
    }

    @Test
    public void testCalculateSum_MultipleValues() {
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setName("Product1");
        orderLine1.setCode("Code1");
        orderLine1.setQuantity(2);
        orderLine1.setPrice(20);
        orderLines.add(orderLine1);

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setName("Product2");
        orderLine2.setCode("Code2");
        orderLine2.setQuantity(3);
        orderLine2.setPrice(10);
        orderLines.add(orderLine2);

        int sum = customer.calculateSum("");
        assertEquals(70, sum);
    }

    @Test
    public void testCalculateSum_ExcludeProduct() {
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setName("Product1");
        orderLine1.setCode("Code1");
        orderLine1.setQuantity(2);
        orderLine1.setPrice(20);
        orderLines.add(orderLine1);

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setName("Product2");
        orderLine2.setCode("Code2");
        orderLine2.setQuantity(3);
        orderLine2.setPrice(10);
        orderLines.add(orderLine2);

        int sum = customer.calculateSum("Product1");
        assertEquals(30, sum);
    }
}