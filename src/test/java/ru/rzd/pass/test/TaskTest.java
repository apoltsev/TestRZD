package ru.rzd.pass.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import ru.rzd.pass.Assertions;
import ru.rzd.pass.page.RoutesPage;
import ru.rzd.pass.util.DriverCreator;
import ru.rzd.pass.page.BasePage;

public class TaskTest {

    private WebDriver driver;
    private BasePage basePage;

    @BeforeTest
    public void beforeClass() {
        driver = DriverCreator.get();
        basePage =  new BasePage(driver);
    }

    @Test
    public void basicLevelTest() {
        basePage.goToBasePage();
        basePage.fillInDepartureStation("МОСКВА");
        basePage.fillInArrivalStation("ТУЛА");
        basePage.chooseDepartureDate("Март", "29");
        RoutesPage routesPage = basePage.clickTableButton();

        Assertions.webElementsExist(routesPage.getRoutes(), "No routes");
    }

    @Test
    public void GoodLevelTest() {
        basePage.goToBasePage();
        basePage.fillInDepartureStation("МОСКВА");
        basePage.fillInArrivalStation("ТУЛА");
        basePage.chooseDepartureDate("Март", "29");
        RoutesPage routesPage = basePage.clickTableButton();
        routesPage.chooseTrain("141Ч", "Купе", "4");
        //Assertions.webElementsExist(routesPage.getRoutes(), "No routes");
    }

    @AfterTest
    public void afterClass() {
        driver.quit();
    }
}
