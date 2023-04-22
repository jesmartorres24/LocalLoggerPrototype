import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExampleTest {
    
    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();
        
        softAssert.fail();
        
        // Hard assertion
        Assert.assertEquals(2 + 2, 4);
        
        // Soft assertion
        softAssert.assertEquals(2 + 2, 5);
        
        // Hard assertion
        Assert.assertTrue(false, "This should fail");
        System.out.println("qweqwe");
        
        // Soft assertion
        softAssert.assertTrue(false, "This should fail too");
        
        // Hard assertion
        Assert.assertNotNull(null, "This should fail as well");
        
        // Soft assertion
        softAssert.assertNotNull(null, "This should fail too");
        
        // Assert all soft assertions at once
        softAssert.assertAll();
    }
}
