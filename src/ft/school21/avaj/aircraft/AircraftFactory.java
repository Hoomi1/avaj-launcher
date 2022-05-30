package ft.school21.avaj.aircraft;

import ft.school21.avaj.simulator.MyException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws MyException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equals("Baloon") || type.equals(getMD5("Baloon")))
        {
            return new Baloon(name, coordinates);
        }
        else if (type.equals("JetPlane") || type.equals(getMD5("JetPlane")))
        {
            return new JetPlane(name, coordinates);
        }
        else if (type.equals("Helicopter") || type.equals(getMD5("Helicopter")))
        {
            return new Helicopter(name, coordinates);
        }
        else
        {
            throw new MyException("Invalid arguments");
        }
    }

    private static String getMD5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
