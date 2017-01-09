package com.company;

import com.google.gson.annotations.SerializedName;

public class DataDeputy {
    @SerializedName("poslowie.imie_pierwsze")
    private String firstName;

    @SerializedName("poslowie.nazwisko")
    private String lastName;
/////////////////////////
    @SerializedName("poslowie.liczba_wyjazdow")
    private Integer poslowieLiczbaWyjazdow;

    public Integer getPoslowieLiczbaWyjazdow() {
        return poslowieLiczbaWyjazdow;
    }

    public void setPoslowieLiczbaWyjazdow(Integer poslowieLiczbaWyjazdow) {
        this.poslowieLiczbaWyjazdow = poslowieLiczbaWyjazdow;
    }
    //////////////

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

}
