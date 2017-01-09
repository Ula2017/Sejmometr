package com.company;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class OfficeTerm {

    @SerializedName("Dataobject")
    private List<Deputy> deputies=null;


    public void addToList(List<Deputy> tmpList){
        deputies.addAll(tmpList);
    }

    public List<Deputy> getDeputies(){
        return deputies;
    }
    public void setDeputies(List<Deputy> deputies){
        this.deputies=deputies;
    }


}
