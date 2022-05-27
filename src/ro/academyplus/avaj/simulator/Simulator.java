package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.aircraft.AircraftFactory;
import ro.academyplus.avaj.aircraft.BufferInFile;
import java.io.*;
import java.nio.Buffer;

public class Simulator {
    static int timesSim;
    static WeatherTower weatherTower;

    public static void main(String[] args) throws MyException {
        if (args.length != 1)
        {
            throw new MyException("Invalid argument!!!");
        }
        try {
            InitAirCraft(ParsArgs(args[0]));
            for (int i = timesSim; i > 0; i--)
            {
                weatherTower.changeWeather();
            }
        }
        catch (MyException e) {
            e.printMyException("Invalid parsing");
        }
        finally {
            BufferInFile.closeBuf();
        }
    }

    static void CheckParameters(String[] parameters) throws MyException {
        for (String s : parameters) {
            if (s.equals(""))
                throw new MyException("Invalid parsing");
        }
    }

    static void InitAirCraft(String[] arrInfo) throws MyException {
        if (arrInfo == null) {
            throw new MyException("Invalid parsing");
        }
        try {
            if (arrInfo[0].length() != 0)
                timesSim = Integer.parseInt(arrInfo[0]);
            else
                throw new MyException("Invalid parsing");
        }
        catch (RuntimeException e) {
            throw new MyException("Invalid parsing");
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
                throw new MyException("Invalid parsing");
        }
    }

    static String[] ParsArgs(String strFile) throws MyException {
        File file = new File(strFile);
        if (!file.exists())
        {
            throw new MyException("Invalid parsing");
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
