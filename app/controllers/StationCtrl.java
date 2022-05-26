package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;
import java.util.HashMap;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        Reading currentReading = StationAnalytics.getCurrentReading(station.readings);

        double tempC = Double.parseDouble(currentReading.temp);
        double tempF = StationAnalytics.convertToF(tempC);



        HashMap <String , String> weatherCodeMap = new HashMap <String, String>();
        weatherCodeMap.put("100","Clear");
        weatherCodeMap.put("200","Partial clouds");
        weatherCodeMap.put("300","Cloudy");
        weatherCodeMap.put("400","Light Showers");
        weatherCodeMap.put("500","Heavy Showers");
        weatherCodeMap.put("600","Rain");
        weatherCodeMap.put("700","Snow");
        weatherCodeMap.put("800","Thunder");


        render("station.html", station, currentReading, tempF, weatherCodeMap);
    }



    public static void deletereading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing " + reading.code);

        render("reading.html", reading);
    }

    public static void addReading(Long id, String code, String temp, String windspeed , String pressure, int weather)
        {
        Reading reading = new Reading(code, temp, windspeed,  pressure,  weather);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/station/" + id);
    }




}