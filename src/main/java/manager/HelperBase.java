package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void clearField(By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
    }

    public void pause(int time){
//        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
//        time = time * 1000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void takeScreenShot(String link){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(link);

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

