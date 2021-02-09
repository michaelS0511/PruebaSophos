package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ConfigurationDriver {
    private static WebDriver driver;

    public WebDriver chromeConfiguration(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
         driver = new ChromeDriver(options);
        return driver;
    }

}
