package ft.school21.avaj.aircraft;

import ft.school21.avaj.simulator.WeatherTower;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
