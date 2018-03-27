package ru.rzd.pass;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Assertions {

    public static void webElementsExist(List<WebElement> webElementList, String message) {
        Assert.assertEquals(webElementList.size() > 0, true, message);
    }
}
