package com.sprint3.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {



    /*
     * creating a private constructor so we are closing access to the
     * object to the class from outside the class
     * */
    private Driver(){}

    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver(){

        if (driverPool.get() == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "3.89.244.209";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set( new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driverPool.get();
    }


    public static void closeDriver(){

        if (driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }


    }




}
