package ft.school21.avaj.simulator;

import ft.school21.avaj.aircraft.Coordinates;

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
