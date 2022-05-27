package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.simulator.WeatherTower;
import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;


    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        HashMap<String, String> state = new HashMap<>();
        state.put("SUN", "Let's enjoy the good weather and take some pics");
        state.put("RAIN", "Damn you rain! You messed up my baloon");
        state.put("FOG", "Visibility is zero");
        state.put("SNOW", "It's snowing. We're gonna crash");
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather)
        {
            case "SUN": //SUN
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 4);
//                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + state.get("SUN"));
                BufferInFile.RegisterBuffer().print("Baloon#" + this.name + "(" + this.id + "): " + state.get("SUN"));
                break;
            case "RAIN": //RAIN
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 5);
//                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + state.get("RAIN"));
                BufferInFile.RegisterBuffer().print("Baloon#" + this.name + "(" + this.id + "): " + state.get("RAIN"));
                break;
            case "FOG": //FOG
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 3);
//                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + state.get("FOG"));
                BufferInFile.RegisterBuffer().print("Baloon#" + this.name + "(" + this.id + "): " + state.get("FOG"));
                break;
            case "SNOW": //SNOW
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 15);
//                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + state.get("SNOW"));
                BufferInFile.RegisterBuffer().print("Baloon#" + this.name + "(" + this.id + "): " + state.get("SNOW"));
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
//            System.out.println("Baloon#" + this.name + "(" + this.id + ") landing.");
//            System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            BufferInFile.RegisterBuffer().print("Baloon#" + this.name + "(" + this.id + ") landing.");
            BufferInFile.RegisterBuffer().print("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        this.weatherTower.register(this);
//        System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        BufferInFile.RegisterBuffer().print("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
