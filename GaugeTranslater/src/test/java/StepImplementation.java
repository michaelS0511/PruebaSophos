import Common.ConfigurationDriver;
import Traductor.TraductorPage;
import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepImplementation {


    private static ConfigurationDriver ConfigDriver = new ConfigurationDriver();
    private static WebDriver driver = ConfigDriver.chromeConfiguration();

    @BeforeSpec
    public void setup() {
        ConfigurationDriver configurationDriver = new ConfigurationDriver();
        driver = configurationDriver.chromeConfiguration();
    }

    @AfterSpec
    public void closed(){
        driver.close();
    }



    @Test
    public void testManin(){

        implementation1("https://translate.google.com/?hl=es");
        implementation2("Hello");
        implementation4("Hola");
    }


    @Step("Navigate to <url>")
    public void implementation1(String url){
        driver.get(url);
        Gauge.captureScreenshot();
    }


    @Step("Enter hello <hello> in the field to translate")
    public void implementation2(String word){
        TraductorPage traductorPage = new TraductorPage(driver);
        traductorPage.writeWord(word);
        Gauge.captureScreenshot();
    }

    @Step("See hola <wortExpected> as the translated word")
    public void implementation4(String wortExpected) {
        TraductorPage traductorPage = new TraductorPage(driver);
        String result = traductorPage.translatedWord();
        Gauge.captureScreenshot();
        assertEquals("Hola", result);
    }
    
}
