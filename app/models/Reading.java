package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.HashMap;

@Entity

public class Reading extends Model
{
    public String code;
    public String temp;
    public String windspeed;


    public String pressure;

    public int weather;


    public Reading(String code, String temp, String windspeed,   String pressure, int weather)
    {
        this.code = code;
        this.temp = temp;
        this.windspeed = windspeed;
        this.pressure = pressure;
        this.weather = weather;

    }


}