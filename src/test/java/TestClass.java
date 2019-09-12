import Core.BaseTest;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {

    @Test
    public void test(){
        driver.get("https://football.ua");
        actions.print();
    }
}
