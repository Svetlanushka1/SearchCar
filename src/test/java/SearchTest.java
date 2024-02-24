import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchTest(){

        app.getSearch().fillSearchForm("Tel Aviv","02/25/2024","02/29/2024");
        //month/day/2024
        app.getSearch().submitForm();
        Assert.assertTrue(app.getSearch().isElementPresent(By.className("search-results")));
    }

}

