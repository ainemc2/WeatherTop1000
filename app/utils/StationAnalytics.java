package utils;

import models.Reading;

import java.util.List;
import java.util.HashMap;

public class StationAnalytics {

    public static Reading getCurrentReading(List<Reading> readings) {
        Reading currentReading = null;
        if (readings.size() > 0) {
            currentReading = readings.get(0);
            for (Reading reading : readings ) {
                if (reading.weather < currentReading.weather) {
                    currentReading = reading;
                }
            }
        }
        return currentReading;
    }

    public static double convertToF(double tempC) {
      double tempF;
      tempF = (tempC * 9/5) + 32;
      return tempF;
    }





    }



