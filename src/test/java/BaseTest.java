
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class BaseTest {

    @BeforeMethod
    public void setup() {
        System.out.println("This is a before test");
    }

    @Description("This is a test to test it all")
    public void runBasic() {
        System.out.println("this is a test");
    }

    @AfterMethod
    public void burnDown(){
        System.out.println("This is an after test");
    }
}