package testsForCart;


import org.junit.jupiter.api.*;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private static Cart cart;
    private static RealItem car;
    private static VirtualItem disk;
    private static VirtualItem disk2;

    @BeforeAll
    static void setUp() {
        cart = new Cart("Cart1");
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

    @DisplayName("Check cart name and total price")
    @Test
    void CartNameAndTotalPriceTest() {
        String expectedCartName = cart.getCartName();
        double expectedTotalPrice = (car.getPrice() + disk.getPrice()) * 1.2;

        assertAll("Cart name and price after cart creation",
                () -> assertEquals(expectedCartName, cart.getCartName()),
                () -> assertEquals(expectedTotalPrice, cart.getTotalPrice())
        );
    }

    @DisplayName("Check add new item to cart")
    @Test
    void AddNewItemToCartTest() {
        double priceBefore = cart.getTotalPrice();
        cart.addVirtualItem(disk2);

        assertAll("Comparing priceBefore to actual price of cart",
                () -> assertTrue(priceBefore < cart.getTotalPrice()),
                () -> assertNotEquals(priceBefore, cart.getTotalPrice())
        );
    }
}