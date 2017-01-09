package com.company;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.JsonElement;

import java.util.*;

public class Layers {

    @SerializedName("wydatki")
    private Spending spending;

    public Spending getSpending() {
        return spending;
    }

    public void setSpending(Spending wydatki) {
        this.spending = wydatki;
    }


    @SerializedName("wyjazdy")
    private JsonElement isTrips;

    public List<Map<String, String>> getTrips() {
        return trips;
    }

    public void setTrips(List<Map<String, String>> trips) {
        this.trips = trips;
    }

    private List<Map<String,String>> trips;


    public JsonElement getIsTrips() {
        return isTrips;
    }

    public void setIsTrips(JsonElement isTrips) {
        this.isTrips = isTrips;
    }
    @SuppressWarnings("unchecked")
    public void loadtrips() {

        if (this.isTrips.isJsonObject())
            this.trips = new ArrayList<Map<String, String>>();
        else {
            this.trips = new Gson().fromJson(this.isTrips, List.class);

        }
    }

    //@SuppressWarnings("unchecked")
    //gdy pusta lista to jsonobject, a takto jsonarray
   /* public void loadtrips() {
        if (this.isTrips.isJsonObject())
            this.trips= new ArrayList<Map<String,String>>();
        else {
            this.trips = new Gson().fromJson(this.isTrips, List.class);
        }
    } */

}
