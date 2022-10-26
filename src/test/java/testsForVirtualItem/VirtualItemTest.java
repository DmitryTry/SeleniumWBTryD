package testsForVirtualItem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VirtualItemTest {

    private VirtualItem disk;
    @BeforeAll
    public void setUp() {
        disk = new VirtualItem();
        disk.setSizeOnDisk(1024);
    }

    @Test
    public void checkMessageSizeDisk() {
        String expectedString = String.valueOf(disk.getSizeOnDisk());
        assertTrue(disk.toString().contains(expectedString));
    }
}