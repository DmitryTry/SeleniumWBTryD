package testsForRealItem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RealItemTest {

    private RealItem car;

    @BeforeAll
    void setUp() {
        car = new RealItem();
        car.setName("Lada");
        car.setPrice(39999);
        car.setWeight(1250);
    }

    @Test
    void checkDisplayFormat() {
        assertEquals(car.toString(), String.format("Class: %s; Name: %s; Price: %s; Weight: %s",
                car.getClass(), car.getName(), car.getPrice(), car.getWeight()));
    }
}