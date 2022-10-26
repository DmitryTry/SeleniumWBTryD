package testsForParser;

import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JsonParserTest {

    private Gson gson;
    private JsonParser jsonParser;
    private Cart cart;
    private Path pathToFile;
    private String fileExtension;

    @BeforeAll
    void setUp() {
        gson = new Gson();
        jsonParser = new JsonParser();
        cart = new Cart("Cart1");
        pathToFile = Paths.get("src", "main", "resources", cart.getCartName());
        fileExtension = ".json";

        RealItem car = new RealItem();
        car.setName("Lada");
        car.setPrice(39999);
        car.setWeight(1560);

        cart.addRealItem(car);
    }

    @AfterAll
    void cleanData() throws IOException {
        Files.deleteIfExists(Paths.get(pathToFile + fileExtension));
    }

    @Test
    void writeToFile() throws IOException {
        jsonParser.writeToFile(cart);
        Reader reader = new FileReader(pathToFile + fileExtension);
        Cart actualCart = gson.fromJson(reader, Cart.class);
        reader.close();

        assertAll(
                () -> assertEquals(cart.getCartName(), actualCart.getCartName()),
                () -> assertEquals(cart.getTotalPrice(), actualCart.getTotalPrice())
        );
    }

    @Disabled
    @Test
    void readFromFile() throws IOException {
        FileWriter writer = new FileWriter(pathToFile + fileExtension);
        writer.write(gson.toJson(cart));
        writer.close();
        Cart expectedCart = jsonParser.readFromFile(new File(pathToFile + fileExtension));

        assertAll(
                () -> assertEquals(expectedCart.getTotalPrice(), cart.getTotalPrice()),
                () -> assertEquals(expectedCart.getCartName(), cart.getCartName())
        );
    }
}