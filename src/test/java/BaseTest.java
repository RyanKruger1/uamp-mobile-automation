import io.qameta.allure.Description;
import org.core.BaseMobileClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Test
public class BaseTest extends BaseMobileClient {

    @Description("This is a test to test it all")
    public void runBasic() {
        System.out.println("this is a test");
    }

    @AfterMethod
    public void burnDown() {
        System.out.println("This is an after test");
    }
}