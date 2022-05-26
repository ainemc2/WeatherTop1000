package controllers;

import models.Station;
import models.Member;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
    public static void index()
    {
        Logger.info("Rendering Admin");
        Member member = Accounts.getLoggedInMember();

        List<Station> station = Station.findAll();
        render ("dashboard.html", station);
    }

    public static void deleteStation (Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Removing" + station.code);
        station.delete();
        redirect ("/dashboard");
    }

    public static void addStation (String title, String latitude, String longitude)
    {
        Station station = new Station (title,  0);
        Logger.info ("Adding a new station called " + title);
        station.save();
        redirect ("/dashboard");
    }
}
