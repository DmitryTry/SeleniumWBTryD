package testsForCart;


import org.junit.jupiter.api.*;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    public static final String EXPECTED_CART_NAME = "Cart1";
    private static Cart cart;
    private static RealItem car;
    private static VirtualItem disk;
    private static VirtualItem disk2;

    @BeforeAll
    public static void setUp() {
        cart = new Cart(EXPECTED_CART_NAME);
        car = new RealItem();
        car.setName("Lada");
        car.setPrice(12500);
        car.setWeight(1200);

        disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(70);
        disk.setSizeOnDisk(23000);

        cart.addVirtualItem(disk);
        cart.addRealItem(car);

        disk2 = new VirtualItem();
        disk2.setName("Linux");
        disk2.setPrice(20);
        disk2.setSizeOnDisk(8000);
    }

    @DisplayName("Check cart name and total price") // failed test with error message
    @Test
    public void cartNameAndTotalPriceTest() {
        double expectedTotalPrice = (car.getPrice() + disk2.getPrice());
        assertAll("Cart name and price after cart creation",
                () -> assertEquals(EXPECTED_CART_NAME, cart.getCartName(), "Cart name is wrong!"),
                () -> assertEquals(expectedTotalPrice, cart.getTotalPrice(), "Total price isn't expected")
        );
    }

    @DisplayName("Check add new item to cart")
    @Test
    public void addNewItemToCartTest() {
        double priceBefore = cart.getTotalPrice();
        cart.addVirtualItem(disk);
        assertTrue(priceBefore < cart.getTotalPrice(), "New item has not been added");
    }
}