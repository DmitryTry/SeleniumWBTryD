package testNG.cart;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTest {

    public static final String EXPECTED_CART_NAME = "Cart1";
    private Cart cart;
    private RealItem car;
    private VirtualItem disk;
    private VirtualItem disk2;

    @BeforeClass(alwaysRun = true, groups = {"smoke", "cart"})
    public void setUp() {
        cart = new Cart(EXPECTED_CART_NAME);
        car = new RealItem();
        car.setName("Lada");
        car.setPrice(6666);
        car.setWeight(2300);

        disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(77);
        disk.setSizeOnDisk(2048);

        cart.addRealItem(car);
        cart.addVirtualItem(disk);

        disk2 = new VirtualItem();
        disk2.setName("Linux");
        disk2.setPrice(88);
        disk2.setSizeOnDisk(1024);
    }

    @Test(testName = "Check cart name and total price", groups = {"smoke", "cart"}) // failed test with error message
    public void cartNameAndTotalPriceTest() {
        SoftAssert softAssert = new SoftAssert();
        double expectedTotalPrice = (car.getPrice() + disk.getPrice());

        softAssert.assertEquals(cart.getCartName(), EXPECTED_CART_NAME, "Cart name is wrong!");
        softAssert.assertEquals(cart.getTotalPrice(), expectedTotalPrice, "Total price is wrong!");
        softAssert.assertAll();
    }

    @Test(testName = "Check add new item to cart", groups = {"smoke", "cart"})
    public void addNewItemToCartTest() {
        double priceBefore = cart.getTotalPrice();
        cart.addVirtualItem(disk2);

        Assert.assertTrue(priceBefore < cart.getTotalPrice(), "New item has not been added");
    }
}
