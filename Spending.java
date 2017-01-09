package com.company;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Spending {

    @SerializedName("punkty")
    private List<Map<String,String>> fields;


    @SerializedName("roczniki")
    private List<Year> years;

    public List<Map<String, String>> getFields() {
        return fields;
    }

    public void setFields(List<Map<String, String>> punkty) {
        this.fields = punkty;
    }

    public List<Year> getYears() {
        return years;
    }

    public void setYears(List<Year> roczniki) {
        this.years = roczniki;
    }

    public double getSum(){
        double sum=0;
        for(Year element : this.years){
            sum+=element.getYearsum();
        }
        return sum;
    }


    }


