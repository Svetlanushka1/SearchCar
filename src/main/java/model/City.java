package model;

public class City {
    String cityName;

    public City() {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public City withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
}
