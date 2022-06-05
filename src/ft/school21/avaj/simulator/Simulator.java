package ft.school21.avaj.simulator;

import ft.school21.avaj.aircraft.AircraftFactory;
import ft.school21.avaj.aircraft.BufferAircraft;
import java.io.*;

public class Simulator {
    static int timesSim;
    static WeatherTower weatherTower;

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
            throw new ArgumentException("Invalid argument!!!");
            }
            InitAirCraft(ParsArgs(args[0]));
            for (int i = timesSim; i > 0; i--)
            {
                weatherTower.changeWeather();
            }
        }
        catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        finally {
            BufferAircraft.closeBuf();
        }
    }

    static void CheckParameters(String[] parameters) throws ParsingException {
        for (String s : parameters) {
            if (s.equals(""))
                throw new ParsingException("Invalid parsing");
        }
    }

    static void InitAirCraft(String[] arrInfo) throws ParsingException {
        if (arrInfo == null) {
            throw new ParsingException("Invalid parsing");
        }
        try {
            if (arrInfo[0].length() != 0)
                timesSim = Integer.parseInt(arrInfo[0]);
            else
                throw new ParsingException("Invalid parsing");
        }
        catch (RuntimeException e) {
            throw new ParsingException("Invalid parsing");
        }
        weatherTower = new WeatherTower();
        for (int i = 1; i < arrInfo.length; i++) {
            String[] parameters = arrInfo[i].split(" ");
            if (arrInfo[i].length() != 0 && parameters.length == 5) {
                CheckParameters(parameters);
                AircraftFactory.newAircraft(parameters[0], parameters[1], Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]), Integer.parseInt(parameters[4])).registerTower(weatherTower);
            }
            else
                throw new ParsingException("Invalid parsing");
        }
    }

    static String[] ParsArgs(String strFile) throws ParsingException {
        File file = new File(strFile);
        if (!file.exists())
        {
            throw new ParsingException("Invalid parsing");
        }
        String str = "";

        try {
            FileInputStream inputStream = new FileInputStream(file);
            int i = 0;
            while ((i = inputStream.read()) != -1)
            {
                str += (char)i;
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.split("\n");
    }
}
