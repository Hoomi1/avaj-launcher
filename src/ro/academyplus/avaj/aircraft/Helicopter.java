package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.simulator.WeatherTower;

import java.util.HashMap;;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions()
    {
        HashMap<String, String> state = new HashMap<>();
        state.put("SUN", "It's hot.");
        state.put("RAIN", "Rain like a bucket");
        state.put("FOG", "Fog makes landing difficult.");
        state.put("SNOW", "My rotor will freeze!");
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather)
        {
            case "SUN": //SUN
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 2);
//                System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + state.get("SUN"));
                BufferInFile.RegisterBuffer().print("Helicopter#" + this.name + "(" + this.id + "): " + state.get("SUN"));
                break;
            case "RAIN": //RAIN
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight());
//                System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + state.get("RAIN"));
                BufferInFile.RegisterBuffer().print("Helicopter#" + this.name + "(" + this.id + "): " + state.get("RAIN"));
                break;
            case "FOG": //FOG
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight());
//                System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + state.get("FOG"));
                BufferInFile.RegisterBuffer().print("Helicopter#" + this.name + "(" + this.id + "): " + state.get("FOG"));
                break;
            case "SNOW": //SNOW
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 12);
//                System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + state.get("SNOW"));
                BufferInFile.RegisterBuffer().print("Helicopter#" + this.name + "(" + this.id + "): " + state.get("SNOW"));
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
//            System.out.println("Helicopter#" + this.name + "(" + this.id + ") landing.");
//            System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            BufferInFile.RegisterBuffer().print("Helicopter#" + this.name + "(" + this.id + ") landing.");
            BufferInFile.RegisterBuffer().print("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        this.weatherTower.register(this);
//        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        BufferInFile.RegisterBuffer().print("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }


}
