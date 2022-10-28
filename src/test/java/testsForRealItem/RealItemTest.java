package testsForRealItem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RealItemTest {

    private static RealItem car;

    @BeforeAll
    public static void setUp() {
        car = new RealItem();
        car.setName("Lada");
        car.setPrice(39999);
        car.setWeight(1250);
    }

    @DisplayName("Check the message display format")
    @Test
    public void checkDisplayFormatTest() {
        assertEquals(car.toString(), String.format("Class: %s; Name: %s; Price: %s; Weight: %s",
                car.getClass(), car.getName(), car.getPrice(), car.getWeight()));
    }
}