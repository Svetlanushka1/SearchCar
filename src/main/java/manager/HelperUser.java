package manager;

import model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver driver) {
        super(driver);
    }



    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOkButton(){
        click(By.xpath("//button[@type='button']"));

    }

    public void submitRegistration(){
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isRegistered(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='dialog-container']"))));
        return driver.findElement(By.xpath("//div[@class='dialog-container']")).getText().contains("success");
    }

    public boolean isLoggedSuccess(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
//        WebElement element = wd.findElement(
//                By.cssSelector(".dialog-container"));
//        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.cssSelector(".dialog-container"))));
//        System.out.println(element.getText());
        return driver.findElement(
                By.cssSelector(".dialog-container")).getText().contains("success");
    }
    public void logout(){
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void fillLoginForm(User data){
        type(By.xpath("//input[@id='email']"), data.getEmail());
        type(By.xpath("//input[@id='password']"), data.getPassword());
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
//        clickOkButton();
//        pause(5000);
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
//        type(By.id("name"),user.getName());
        type(By.id("name"),null);
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
////        click(By.cssSelector("label[for='terms-of-use']"));
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click();");
        checkPolicy();
    }

    public void checkPolicy(){
        // variant 1:
        //        click(By.cssSelector("label[for='terms-of-use']"));
        // variant 2:
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click();");
        // variant 3:
        Rectangle rect = driver.findElement(By.cssSelector(".checkbox-container")).getRect();
        int x = rect.getX() + 5;
        int y = rect.getY() + 1/4 * rect.getHeight();
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();
    }
}
