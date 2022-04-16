package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public Driver() {
        //no driver for you:)
    }

    private static InheritableThreadLocal <WebDriver> driver = new InheritableThreadLocal<>();
    private static String browser = ConfReader.getValue("browser");

    public static WebDriver getDriver() {

        if (driver.get() == null) {

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;

                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
            }

            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver.get();
    }

    public static void quitDriver(){
        if ( driver.get() != null){

            driver.get().quit();
            driver.set(null);
        }
    }


}
