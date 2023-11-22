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

    @Before
    public void setUp(){
        List<OrderLine> orderLines = new ArrayList<>();
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

        orderLines.add(orderLine1);
        orderLines.add(orderLine2);

        customer = new Customer("test", 100, orderLines);
    }

    @Test
    public void testAddProduct_NewProduct(){
        OrderLine orderLine3 = new OrderLine();
        orderLine3.setName("product3");
        orderLine3.setCode("code3");
        orderLine3.setQuantity(1);
        orderLine3.setPrice(30);
        customer.addProduct(orderLine3);
        assertEquals(3, customer.getOrderLines().size());
    }

    @Test
    public void testAddProduct_ExistingProductSameCode(){
        OrderLine orderLineDuplicate = new OrderLine();
        orderLineDuplicate.setName("product1");
        orderLineDuplicate.setCode("code1");
        customer.addProduct(orderLineDuplicate);
        assertEquals(3, customer.getOrderLines().get(0).getQuantity());
    }

    @Test
    public void testAddProduct_ExistingProductDifferentCode(){
        OrderLine orderLineDuplicate = new OrderLine();
        orderLineDuplicate.setName("product1");
        orderLineDuplicate.setCode("code3");
        customer.addProduct(orderLineDuplicate);
        assertEquals(3, customer.getOrderLines().size());
    }

//    @Test
//    public void testAddProduct_NullProduct(){
//        customer.addProduct(null);
//        assertEquals(2, customer.getOrderLines().size());
//    }

    @Test
    public void testAddProduct_EmptyProduct(){
        OrderLine emptyOrderLine = new OrderLine();
        customer.addProduct(emptyOrderLine);
        assertEquals(3, customer.getOrderLines().size());
    }

    @Test
    public void testCalculateSum_AllProducts(){
        int sum = customer.calculateSum("");
        assertEquals(80, sum);
    }

    @Test
    public void testCalculateSum_ExcludeOneProduct(){
        int sum = customer.calculateSum("product1");
        assertEquals(60, sum);
    }

//    @Test
//    public void testCalculateSum_ExcludeAllProducts(){
//        int sum = customer.calculateSum("product1");
//        sum += customer.calculateSum("product2");
//        assertEquals(0, sum);
//    }

    @Test
    public void testCalculateSum_ExcludeNonExistentProduct(){
        int sum = customer.calculateSum("product3");
        assertEquals(80, sum);
    }

    @Test
    public void testCalculateSum_ExcludeNull(){
        int sum = customer.calculateSum(null);
        assertEquals(80, sum);
    }
}