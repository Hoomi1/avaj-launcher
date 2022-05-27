package ro.academyplus.avaj.aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = (longitude > 0) ? longitude : 1;
        this.latitude = (latitude > 0) ? latitude : 1;
        this.height = (height > 100) ? 100 : (height < 0) ? 0 : height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
