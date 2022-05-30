package ft.school21.avaj.aircraft;

import ft.school21.avaj.simulator.WeatherTower;

import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable{

        private WeatherTower weatherTower;

        public JetPlane(String name, Coordinates coordinates) {
                super(name, coordinates);
        }

        @Override
        public void updateConditions() {
                HashMap<String, String> state = new HashMap<>();
                state.put("SUN", "The sun heats up the interior.");
                state.put("RAIN", "It's raining. Better take care of the lighting.");
                state.put("FOG", "Fog is coming.");
                state.put("SNOW", "Oh my God! Winter is coming!");
                String weather = this.weatherTower.getWeather(this.coordinates);
                switch (weather)
                {
                        case "SUN": //SUN
                                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                                        this.coordinates.getLatitude() + 10,
                                        this.coordinates.getHeight() + 2);
//                                System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + state.get("SUN"));
                                BufferAircraft.RegisterBuffer().print("JetPlane#" + this.name + "(" + this.id + "): " + state.get("SUN"));
                                break;
                        case "RAIN": //RAIN
                                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                                        this.coordinates.getLatitude() + 5,
                                        this.coordinates.getHeight());
//                                System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + state.get("RAIN"));
                                BufferAircraft.RegisterBuffer().print("JetPlane#" + this.name + "(" + this.id + "): " + state.get("RAIN"));
                                break;
                        case "FOG": //FOG
                                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                                        this.coordinates.getLatitude() + 1,
                                        this.coordinates.getHeight());
//                                System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + state.get("FOG"));
                                BufferAircraft.RegisterBuffer().print("JetPlane#" + this.name + "(" + this.id + "): " + state.get("FOG"));
                                break;
                        case "SNOW": //SNOW
                                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                                        this.coordinates.getLatitude(),
                                        this.coordinates.getHeight() - 7);
//                                System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + state.get("SNOW"));
                                BufferAircraft.RegisterBuffer().print("JetPlane#" + this.name + "(" + this.id + "): " + state.get("SNOW"));
                                break;
                }
                if (this.coordinates.getHeight() <= 0)
                {
//                        System.out.println("JetPlane#" + this.name + "(" + this.id + ") landing.");
//                        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
                        BufferAircraft.RegisterBuffer().print("JetPlane#" + this.name + "(" + this.id + ") landing.");
                        BufferAircraft.RegisterBuffer().print("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
                        this.weatherTower.unregister(this);
                }
        }

        @Override
        public void registerTower(WeatherTower WeatherTower) {
                this.weatherTower = WeatherTower;
                this.weatherTower.register(this);
//                System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
                BufferAircraft.RegisterBuffer().print("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");

        }
}
