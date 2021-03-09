package com.bookit.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {} //this is the private constructor

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if(driverPool.get() == null) {

            synchronized (Driver.class) {

                String browser = com.bookit.utilities.ConfigurationReader.getProperty("browser");

                switch (browser) {
                    case "remote-chrome":
                        try {
                            URL url = new URL("http://54.158.165.251:4444/wd/hub");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");
                            //desiredCapabilities.setBrowserName(BrowserType.CHROME);
                            driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
//                default:
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
                }

            }

        }

//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //This same driver will be returned every time we call Driver.getDriver() method
        return driverPool.get();
    }

    public static void closeDriver() {
        if(driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }



}
