package testNG.parser;

import com.google.gson.Gson;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonParserTest {

    private SoftAssert softAssert;
    private Gson gson;
    private JsonParser jsonParser;
    private Cart cart;
    private Path pathToFile;
    private String fileExtension;

    @BeforeClass(alwaysRun = true, groups = {"parser", "smoke"})
    public void setUp() {
        gson = new Gson();
        jsonParser = new JsonParser();
        cart = new Cart("Cart1");
        pathToFile = Paths.get("src", "main", "resources", cart.getCartName());
        fileExtension = ".json";

        RealItem car = new RealItem();
        car.setName("Lada");
        car.setPrice(6666);
        car.setWeight(2200);

        cart.addRealItem(car);
    }

    @AfterMethod(alwaysRun = true, groups = {"parser", "smoke"})
    public void cleanData() throws IOException {
        Files.deleteIfExists(Paths.get(pathToFile + fileExtension));
    }

    @Test(testName = "Check write to file", groups = {"parser", "smoke"})
    public void writeToFileTest() throws IOException {
        softAssert = new SoftAssert();
        jsonParser.writeToFile(cart);
        Reader reader = new FileReader(pathToFile + fileExtension);
        Cart actualCart = gson.fromJson(reader, Cart.class);
        reader.close();

        softAssert.assertFalse(Files.exists(Paths.get(pathToFile + fileExtension, "File not found!")));
        softAssert.assertEquals(actualCart.getCartName(), cart.getCartName(), "Cart name is wrong");
        softAssert.assertEquals(actualCart.getTotalPrice(), cart.getTotalPrice(), "Total price is wrong");
        softAssert.assertAll();
    }

    @Test(testName = "Check read from file", groups = {"parser", "smoke"})
    public void readFromFileTest() throws IOException {
        softAssert = new SoftAssert();
        FileWriter writer = new FileWriter(pathToFile + fileExtension);
        writer.write(gson.toJson(cart));
        writer.close();
        Cart expectedCart = jsonParser.readFromFile(new File(pathToFile + fileExtension));

        softAssert.assertEquals(cart.getTotalPrice(), expectedCart.getTotalPrice(), "Cart name is wrong");
        softAssert.assertEquals(cart.getCartName(), expectedCart.getCartName(), "Total price is wrong");
        softAssert.assertAll();
    }
}
