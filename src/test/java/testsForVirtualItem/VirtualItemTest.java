package testsForVirtualItem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualItemTest {

    private static VirtualItem disk;

    @BeforeAll
    public static void setUp() {
        disk = new VirtualItem();
        disk.setSizeOnDisk(1024);
    }

    @DisplayName("Check message about disk size")
    @Test
    public void checkMessageSizeDiskTest() {
        String expectedString = String.valueOf(disk.getSizeOnDisk());
        assertTrue(disk.toString().contains(expectedString), "Size on disk is wrong!");
    }
}