package manager;

import listener_provider.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    String browser;

    //    WebDriver wd;
    EventFiringWebDriver driver;
    HelperUser user;
    HelperCar car;
    HelperSearch search;
    Properties properties;

//    public manager.ApplicationManager() {
//        properties = new Properties();
//    }

    public ApplicationManager(String browser) {
        properties = new Properties();
        this.browser = browser;
    }
    public void init() throws IOException {
//        wd = new ChromeDriver();
        String target = System.getProperty("target","config");
//        properties.load(new FileReader(new File("src/test/resources/config.properties")));
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if(browser.equals(BrowserType.CHROME)) {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests on Chrome started");
        } else if(browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests on FireFox started");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new MyListener());
        driver.manage().window().maximize();
//        wd.navigate().to("https://ilcarro.web.app/");
        driver.navigate().to(properties.getProperty("web.baseURL"));
        user = new HelperUser(driver);
        car = new HelperCar(driver);
        search = new HelperSearch(driver);
    }

    public HelperSearch getSearch() {
        return search;
    }

    public HelperCar getCar() {
        return car;
    }

    public HelperUser getUser() {
        return user;
    }

    public String getEmail() {
        return properties.getProperty("web.email");
    }
    public String getPassword() {
        return properties.getProperty("web.password");
    }
}
