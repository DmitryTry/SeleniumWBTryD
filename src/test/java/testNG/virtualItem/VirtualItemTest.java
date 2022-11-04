package testNG.virtualItem;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTest {

    private VirtualItem disk;

    @BeforeClass (alwaysRun = true, groups = {"smoke", "item"})
    public void setUp() {
        disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(777);
        disk.setSizeOnDisk(2048);
    }

    @Test (testName = "Check sizeOnDisk field", groups = {"smoke", "item"})
    public void checkSizeOnDiskFieldTest() {
        String sizeOnDisk = String.valueOf(disk.getSizeOnDisk());
        Assert.assertTrue(disk.toString().contains(sizeOnDisk), "SizeOnDisk field isn't displayed");
    }

}
