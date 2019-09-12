package Utilities;

import Core.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actionwords extends BaseClass {
    public Actionwords(WebDriver driver) {
        super(driver);
    }

    public void iOpenHttpGoogleCom(String httpGoogleCom) {
        driver.get(httpGoogleCom);
    }

    public void iSearchForHiptest(String hiptest) {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(hiptest);
        element.submit();
    }

    public void aLinkToHiptestAgileTestManagementToolBehaviorDrivenDevelopment(String hiptestAgileTestManagementToolBehaviorDrivenDevelopment) {
        final String matcher = hiptestAgileTestManagementToolBehaviorDrivenDevelopment;

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElements(By.xpath("//a[contains(@href, '"+ matcher +"')]")).size() != 0;
            }
        });
    }

    public void iOpenPage(String freeText) {

    }

    public void clickLoginButton() {

    }

    public void iInputValidEmail(String freeText) {

    }

    public void inputValidPassword(String freeText) {

    }

    public void theUrlContains(String freeText) {

    }

    public void clickOnLoginButton() {

    }

    public void goToPage() {

    }

    public void goToEngland() {

    }

    public void assertEnglandUrl() {

    }

    public void goToPage2() {

    }

    public void goToEngland2() {

    }
}