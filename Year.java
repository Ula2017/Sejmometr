package com.company;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Year {
    @SerializedName("pola")
    private List<Double> field; //wartosci wydatkow wg punktow

    @SerializedName("rok")
    private String year;


    public List<Double> getField() { return field;  }

    public void setField(List<Double> field) {
        this.field = field;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getYearsum(){
        double sum=0;
        for(Double element : this.field){
            sum+=element.doubleValue();
        }
        return sum;
    }

}

