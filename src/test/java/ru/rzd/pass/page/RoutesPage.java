package ru.rzd.pass.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rzd.pass.util.Configuration;

import java.util.List;

public class RoutesPage {

    private WebDriver driver;
    private By routesLocator = new By.ByClassName("route-items-cont");
    private By routeLocator = new By.ByClassName("route-item");

    public RoutesPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getRoutes() {
        new WebDriverWait(driver, Configuration.WAITER_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(routesLocator));

        return driver.findElements(routeLocator);
    }

    public void chooseTrain(String trainId, String type, String wagonId) {
        By trainLocator = new By.ByXPath("//span[text()='" + trainId + "']/../../../../..");

        WebElement train = new WebDriverWait(driver, Configuration.WAITER_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(trainLocator));
        train.findElement(new By.ByPartialLinkText(type)).click();

        new WebDriverWait(driver, Configuration.WAITER_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(new By.ByPartialLinkText(wagonId))).click();

        System.out.println("");
    }
}
