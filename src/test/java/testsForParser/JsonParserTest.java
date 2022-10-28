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

import static org.junit.jupiter.api.Assertions.*;


class JsonParserTest {

    private static Gson gson;
    private static JsonParser jsonParser;
    private static Cart cart;
    private static Path pathToFile;
    private static String fileExtension;

    @BeforeAll
    public static void setUp() {
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
    public static void cleanData() throws IOException {
        Files.deleteIfExists(Paths.get(pathToFile + fileExtension));
    }

    @DisplayName("Check write to file")
    @Test
    public void writeToFileTest() throws IOException {
        jsonParser.writeToFile(cart);
        Reader reader = new FileReader(pathToFile + fileExtension);
        Cart actualCart = gson.fromJson(reader, Cart.class);
        reader.close();

        assertAll(
                () -> assertFalse(Files.exists(Paths.get(pathToFile + fileExtension, "File doesn't exist"))),
                () -> assertEquals(cart.getCartName(), actualCart.getCartName()),
                () -> assertEquals(cart.getTotalPrice(), actualCart.getTotalPrice())
        );
    }

    @Disabled
    @DisplayName("Check read from file")
    @Test
    public void readFromFileTest() throws IOException {
        FileWriter writer = new FileWriter(pathToFile + fileExtension);
        writer.write(gson.toJson(cart));
        writer.close();
        Cart expectedCart = jsonParser.readFromFile(new File(pathToFile + fileExtension));

        assertAll(
                () -> assertFalse(Files.exists(Paths.get(pathToFile + fileExtension, "File doesn't exist"))),
                () -> assertEquals(expectedCart.getTotalPrice(), cart.getTotalPrice()),
                () -> assertEquals(expectedCart.getCartName(), cart.getCartName())
        );
    }
}