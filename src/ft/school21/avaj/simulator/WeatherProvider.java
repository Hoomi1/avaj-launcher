package ft.school21.avaj.simulator;

import ft.school21.avaj.aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider()
    {

    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
       int sum = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
       sum += new Random().nextInt(100);
       return weather[sum % 4];
    }
}
