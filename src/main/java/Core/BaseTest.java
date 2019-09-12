package Core;

import Utilities.Actions;
import Utilities.Asserts;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static TestsInfo.Urls.homePageUrl;


public class BaseTest {
    protected WebDriver driver;

    public Asserts asserts;
    public Actions actions;

    @BeforeMethod
    @Step("Preconditions")
    public void setUp() {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\AscendRegressionTests\\src\\main\\resources\\drivers\\chromedriver.exe");
        //System.setProperty("phantomjs.binary.path", "C:\\Users\\user\\IdeaProjects\\AscendRegressionTests\\src\\main\\resources\\drivers\\phantomjs.exe");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);

//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        //goToWebPage("Go to home page" + homePageUrl, homePageUrl);
        driver.manage().window().maximize();
        System.out.println("open page");

        asserts = new Asserts(driver);
        actions = new Actions(driver);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void afterTest(WebDriver driver, ITestResult result) {
        String className = String.valueOf(result.getTestClass()).replaceAll("TestClass name=class ", "");
        String testName = result.getName();
        String screenName = className + testName;

        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshotPNG(driver);
        }
        driver.quit();
    }

    @Step("{step}")
    public void goToWebPage(String step, String url) {
        driver.get(url);
        //driver.manage().deleteAllCookies();
    }


    @AfterMethod
    public void after(ITestResult result) {
        afterTest(driver, result  );
    }
}
