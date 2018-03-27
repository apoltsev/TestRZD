package ru.rzd.pass.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverCreator {

    public static WebDriver get() {
        String browserName = Configuration.WEB_DRIVER;
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException(String.format("There is no browser with name: %s", browserName));
        }
    }
}
