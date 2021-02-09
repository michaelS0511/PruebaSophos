package Traductor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TraductorPage {
    WebDriver driver;
    By fieldTranslate = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div" +
                                    "[2]/div[2]/c-wiz[1]/span/span/div/textarea");

    By result = By.xpath("/html/body/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[2]/div[5]" +
                            "/div/div[1]/span[1]/span/span");

    public TraductorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void writeWord(String word) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldTranslate));
        driver.findElement(fieldTranslate).sendKeys(word);
    }

    public String translatedWord() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        return driver.findElement(result).getText();
    }
}
