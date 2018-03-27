package ru.rzd.pass.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rzd.pass.util.Configuration;

public class BasePage {

    private WebDriver driver;
    private By departureStationLocator = new By.ById("name0");
    private By arrivalStationLocator = new By.ById("name1");
    private By buttonSubmitLocator = new By.ById("Submit");
    private By departureCalendarLocator = new By.ByClassName("sh_calendar");
    private By monthsWindowsLocator = new By.ById("new_ticket_formTwo");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToBasePage() {
        driver.get(Configuration.MAIN_PAGE_URL);
    }

    public void fillInDepartureStation(String value) {
        driver.findElement(departureStationLocator).sendKeys(value);
    }

    public void fillInArrivalStation(String value) {
        driver.findElement(arrivalStationLocator).sendKeys(value);
    }

    public void chooseDepartureDate(String month, String day) {
        WebElement calendarImage = driver.findElements(departureCalendarLocator).get(0);
        calendarImage.click();

        new WebDriverWait(driver, Configuration.WAITER_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(monthsWindowsLocator));

        By dateLocator = new By.ByXPath("//div[@class='month_title']/span[text()='" + month
                + "']/../..//span[text()='" + day + "']");
        new WebDriverWait(driver, Configuration.WAITER_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(dateLocator)).click();
    }

    public RoutesPage clickTableButton() {
        new WebDriverWait(driver, Configuration.WAITER_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(buttonSubmitLocator)).click();

        return new RoutesPage(driver);
    }
}
