package com.company;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    //obliczamy sume wszystkich wydatkow danego posla, w switch : P
    public String addAllSpendings(String firstName, String lastName, OfficeTerm officeTerm){

        Deputy deputy=findDeputy(firstName, lastName,officeTerm );
        double sum= deputy.getDeputySum();
        return "Wszystkie wydatki "+firstName+" "+lastName+" wynosza "+sum;


    }

    //obliczanie wydatkow na 'drobne naprawy i remonty biura poselskiego' switch S
    public String smallExpenses(String firstName, String lastName, OfficeTerm officeTerm){
        Deputy deputy=findDeputy(firstName, lastName, officeTerm);
        double sum=0;
       for(Year element: deputy.getSpendingsYear()){
          sum+=element.getField().get(12);
        }
        return "Wydatki na drobne naprawy i remonty biura poselskiego posła "+firstName+" "+lastName +" wynosza "+sum;

    }
    //obliczamy srednia wszystkich poslow danej kadencji w switch : A
    //niezgodnosc miedzy liczba wyjazdów a layerem wyjazdy np ID 134 liczba wyjazdow -72 a wyjazdy 67
    public String avgSum(OfficeTerm officeTerm){
        double sum=0;
        int counter=0;
        for(Deputy element : officeTerm.getDeputies()){
            sum+=element.getDeputySum();
            counter++;
        }
        sum=sum/counter;
        return "Srednia suma wydatkow wszystkich poslow wynosi "+sum;
    }
    //posła/posłanki, który wykonał najwięcej podróży zagranicznych
    public String mostTravelAbroud(OfficeTerm officeTerm){
        int maxAmountOf=0;
        String firstName="";
        String lastName="";
        for(Deputy element : officeTerm.getDeputies()){
           // int k=element.getData().getPoslowieLiczbaWyjazdow();
            if(element.getData().getPoslowieLiczbaWyjazdow() >maxAmountOf) {
                maxAmountOf=element.getData().getPoslowieLiczbaWyjazdow();
                firstName=element.getFirstName();
                lastName=element.getLastName();

            }

        }
        return "Poseł, który wykonał najwięcej podróży zagranicznych to "+firstName+" "+lastName+". Liczba wyjazdów "+maxAmountOf ;

    }
    //posła/posłanki, który najdłużej przebywał za granicą
    public String longestJourney (OfficeTerm officeTerm){
        int longest=0;
        int tmp;
        String firstName="";
        String lastName="";
     for(Deputy element : officeTerm.getDeputies() ){
         int suma=0;
         int counter=element.getSizeTravel();
             while(counter>0){
                 int k=counter-1;
               String daysNumber= element.getElementNamed(k,"liczba_dni");
               tmp=Integer.parseInt(daysNumber);
               suma+=tmp;
               counter--;
             }

         if(suma>longest){
             longest=suma;
             firstName=element.getFirstName();
             lastName=element.getLastName();
         }

     }
        return "Poseł, który najdłużej przebywał za granicą: " + firstName+" "+lastName+" "+longest+" dni";


    }


    //posła/posłanki, który odbył najdroższą podróż zagraniczną
    public String theMostExpensiveTrip (OfficeTerm kadencja){
        double mostExpensive=0;
        String firstName="";
        String lastName="";
        double mostTmp;
        for(Deputy element : kadencja.getDeputies() ){
            int k=element.getSizeTravel();
            while(k!=0) {
                String tmp = element.getElementNamed(k-1, "koszt_suma");
                mostTmp=Double.parseDouble(tmp);
                if(mostTmp>mostExpensive){
                    mostExpensive=mostTmp;
                    firstName=element.getFirstName();
                    lastName=element.getLastName();

                }
                k--;
            }

        }
        return "Najdroższą podróżą była podróz posła "+firstName+" "+lastName+". Wynosiła: "+mostExpensive;
    }
    //listę wszystkich posłów, którzy odwiedzili Włochy
    public String italyVisitors(OfficeTerm officeTerm){
        List<String> italyVisitorsList = new ArrayList<>();

        for(Deputy element : officeTerm.getDeputies()){
            int k=element.getSizeTravel();
            while(k!=0){
                if(element.getElementNamed(k-1, "kraj").equals("Włochy")){
                    StringBuilder name= new StringBuilder();
                    name.append(element.getFirstName());
                    name.append("\n");
                    name.append(element.getLastName());
                    italyVisitorsList.add(String.valueOf(name)); //dodanie elementu zrzutowanego na String
                    break;

                }
                k--;
            }
        }
        return listToString(italyVisitorsList);
    }
public String listToString(List<String> list){
        StringBuilder result = new StringBuilder();
        result.append("Posłowie, którzy odwiedzili Włochy: \n");
        for(String element : list){
            result.append(element);
            result.append(", ");
        }

    return result.toString();
}




    public Deputy findDeputy(String firstName, String lastName, OfficeTerm officeTerm){
        boolean found=false;
        Deputy deputy=null;
        for(Deputy element : officeTerm.getDeputies()){

            if(element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)){
                deputy=element;
                found=true;
                break;
            }
        }
        if(!found) throw new IllegalArgumentException("Nie ma posła o danym imieniu i nazwisku w wybranej kadencji.");
        return deputy;

    }
}
