package listener_provider;

import model.City;
import model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCity {
    @DataProvider
    public Iterator<Object[]> cityModelDto(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new City().withCityName("Haifa")
        });
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> cityCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/datacity")));
        String line = reader.readLine();
        while(line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new City()
                    .withCityName(split[0])
                    });
            line = reader.readLine();
        }
        return list.iterator();
    }
}
