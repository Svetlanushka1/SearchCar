import listener_provider.DataProviderCity;
import model.City;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCityTests extends TestBase{
    @Test(dataProvider = "cityCSV", dataProviderClass = DataProviderCity.class)
    public void selectCity(City city){
        //app.getSearch().fillCity("Tel Aviv");
       // app.getSearch().fillCity("Jerusalem");//"Haifa"
        app.getSearch().fillCity(city.getCityName());
        Assert.assertTrue(app.getSearch().isElementPresent(By.id("city")));
        app.getSearch().clearFieldCity(By.id("city"));
// //h2 == Type your data and hit Yalla!  className subtitle

    }
}
