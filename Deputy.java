package com.company;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Deputy {

    @SerializedName("id")
    private String id;

    @SerializedName("data")
    private DataDeputy data;

    @SerializedName("layers")
    private Layers layers;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataDeputy getData(){
        return data;
    }

    public void setData(DataDeputy data){
        this.data=data;
    }

    public Layers getLayers(){
        return layers;
    }

    public void setLayers(Layers layers){
        this.layers=layers;
    }

    public String getFirstName(){
        return this.getData().getFirstName();
    }

    public String getLastName(){
        return this.getData().getLastName();
    }

    public double getDeputySum(){
        double sum=this.getLayers().getSpending().getSum();
        return sum;
    }
    public List<Year> getSpendingsYear(){
        return this.getLayers().getSpending().getYears();
    }

    public String getElementNamed ( int k, Object key){
        return this.getLayers().getTrips().get(k).get(key);
    }

    public int getSizeTravel(){
        return this.getLayers().getTrips().size();

    }




}
