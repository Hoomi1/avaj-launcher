package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.aircraft.Coordinates;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather()
    {
        this.conditionsChanged();
    }
}
