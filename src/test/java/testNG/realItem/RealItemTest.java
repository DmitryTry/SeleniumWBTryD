package testNG.realItem;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.RealItem;

public class RealItemTest {

    private RealItem car;

    @Parameters({"weight"})
    @BeforeClass(alwaysRun = true, groups = {"smoke", "item"})
    public void setUp(@Optional("2500") double weight) {
        car = new RealItem();
        car.setName("Lada");
        car.setPrice(7777);
        car.setWeight(weight);
    }

    @Test(testName = "Check weight field", groups = {"smoke", "item"})
    public void checkWeightFieldTest() {
        String weight = String.valueOf(car.getWeight());
        Assert.assertTrue(car.toString().contains(weight), "Weight field isn't displayed");
    }

    @Test(testName = "Check format of print", groups = {"smoke", "item"}) // exclude in testng1.xml
    public void checkFormatOfPrint() {

        Assert.assertEquals(car.toString(), String.format("Class: %s; Name: %s; Price: %s; Weight: %s",
                car.getClass(), car.getName(), car.getPrice(), car.getWeight(), "Wrong format of print"));
    }
}
