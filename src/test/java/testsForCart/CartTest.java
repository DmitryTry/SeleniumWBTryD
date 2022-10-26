package testsForCart;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import shop.Cart;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CartTest {

    private Cart cart;
    private VirtualItem disk;

    @BeforeAll
    void setUp() {
        cart = new Cart("Cart1");
        disk = new VirtualItem();
        disk.setPrice(77);
    }

    @Test
    void checkAddItemToCart() {
        double priceBefore = cart.getTotalPrice();
        cart.addVirtualItem(disk);

        assertAll("Comparing price before add to cart and after add to cart",
                () -> assertTrue(priceBefore < cart.getTotalPrice()),
                () -> assertNotEquals(priceBefore, cart.getTotalPrice())
        );
    }

    @Test
    void checkCartName() {
        String expectedCartName = cart.getCartName();
        assertEquals(expectedCartName, cart.getCartName());
    }
}