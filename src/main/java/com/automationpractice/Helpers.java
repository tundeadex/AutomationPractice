package com.automationpractice;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Helpers {

    public static void setChromeDriverSystemProperty() {
        String pathToChromeDriverPrefix = "src/main/resources/chromedrivers/";
        String fullPathToChromeDriver = "";
        if (SystemUtils.IS_OS_MAC_OSX) {
            fullPathToChromeDriver = pathToChromeDriverPrefix.concat("chromedriver_mac64");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            fullPathToChromeDriver = pathToChromeDriverPrefix.concat("chromedriver.exe");
        } else if (SystemUtils.IS_OS_LINUX) {
            fullPathToChromeDriver = SystemUtils.OS_ARCH.equals("x86_64") ? pathToChromeDriverPrefix.concat("chromedriver_linux64") : pathToChromeDriverPrefix.concat("src/main/resources/chromedrivers/chromedriver_linux32");
        }
        System.setProperty("webdriver.chrome.driver", fullPathToChromeDriver);
    }

    public static WebDriver getChromeDriverInstance() {
        setChromeDriverSystemProperty();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1300, 806));
        return driver;
    }
}

