package com.company;


import com.google.gson.Gson;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public OfficeTerm officeTerm=null;
    public OfficeTerm temp;
    String currentURL; //URL z ktorego teraz bedziemy korzystac
    String json; //json

public OfficeTerm deputyParse(int number) throws Exception {

    int tmp =11;
    if(number==8) tmp--;
    Gson gson=new Gson();
    currentURL="https://api-v3.mojepanstwo.pl/dane/poslowie.json?conditions[poslowie.kadencja]="+number;
    this.officeTerm= gson.fromJson(URLReader.read(currentURL), OfficeTerm.class);
    for(int i=2; i<=tmp; i++) {

        currentURL=currentURL+"&_type=objects&page=" +i;
        json = URLReader.read(currentURL);

        temp=gson.fromJson(json,OfficeTerm.class );

        this.officeTerm.addToList(temp.getDeputies());

    }

    this.dataParser();
    return officeTerm;
}

public void dataParser() throws Exception{
    Deputy deputytmp;

    for(Deputy element : this.officeTerm.getDeputies()){

        String newURL="https://api-v3.mojepanstwo.pl/dane/poslowie/"+element.getId()+".json?layers[]=wydatki&layers[]=wyjazdy";
        json=URLReader.read(newURL);
        Gson gson = new Gson();
        deputytmp=gson.fromJson(json, Deputy.class);
       element.setLayers(deputytmp.getLayers());
       element.getLayers().loadtrips();
    }

}


}
