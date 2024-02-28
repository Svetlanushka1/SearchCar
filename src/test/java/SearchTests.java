import listener_provider.DataProviderLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchTest(){

        app.getSearch().fillSearchForm("Tel Aviv","04/25/2024","06/29/2024");
        //month/day/2024
        app.getSearch().submitForm();
        Assert.assertTrue(app.getSearch().isElementPresent(By.className("search-results")));
    }

    @Test
    public void selectCity(){
        app.getSearch().fillCity("Tel Aviv");
        Assert.assertTrue(app.getSearch().isElementPresent(By.id("city")));


    }
    @Test
    public void searchNegativeTest(){

        app.getSearch().fillSearchForm("Tel Aviv","02/25/2023","02/29/2024");
        //month/day/2024
        app.getSearch().submitForm();
        Assert.assertFalse(app.getSearch().isElementPresent(By.className("search-results")));
    }
  // Firefox browser terminal; ./gradlew tests -Pbrowser=firefox
  @Test(groups = {"smoke"}, dataProvider = "loginCSV", dataProviderClass = DataProviderLogin.class)
    public void searchTestFireFox(){

        app.getSearch().fillSearchForm("Tel Aviv","02/25/2024","02/29/2024");
        //month/day/2024
        app.getSearch().submitForm();
        Assert.assertTrue(app.getSearch().isElementPresent(By.className("search-results")));
    }

}

