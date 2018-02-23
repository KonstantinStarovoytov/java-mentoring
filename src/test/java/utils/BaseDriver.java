package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    private static WebDriver instance;

    private BaseDriver() {
    }

    public static WebDriver getWebDriverInstance() {
        if (instance == null) {
            initDriver();
        }
        return instance;
    }

    private static void initDriver() {
        
         instance = new ChromeDriver();
//        WebDriver driver = null;
//        try {
//            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
//        } catch (MalformedURLException e) {
//            Logger.error("Error with creating URL");
//            e.printStackTrace();
//        }
        instance.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instance.manage().window().maximize();

    }

    public static void exit() {
        if (instance != null) {
            try {
                instance.quit();
            } catch (Exception e) {
               // Logger.error("Cannot kill browser");
            } finally {
                instance = null;
            }
        }
    }
}
