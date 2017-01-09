package com.company;
import com.company.Functions;
import java.util.List;

public class ArgumentsParser
{
    private String[] args;
    private int number;
    private OfficeTerm Kadencja= new OfficeTerm();
    private Functions functions = new Functions();


    public ArgumentsParser(String[] args){
    this.args= args;
    }
    public void argumentParse(String[] args) throws Exception {

        if(this.args.length==0) throw new IllegalArgumentException("Brak argumentów");
        if (this.args.length <2)
            throw new IllegalArgumentException("Wprowadzono niepoprawną ilość argumentów.");

        switch (this.args[0]) {
            case "8":
                number = 8;
                Kadencja = generateCadence(number);
                break;
            case "7":
                number = 7;
                Kadencja = generateCadence(number);
                break;
            default:
                throw new IllegalArgumentException("Nieprawidlowy argument pierwszy. Do wyboru 7 lub 8 kadencja");
        }


    for(int i=1; i<args.length; i++) {
        switch (this.args[i]) {
            case "p": //suma wydatków posła/posłanki o określonym imieniu i nazwisku
                if(i+2>args.length)  throw new IllegalArgumentException("Do podanej funkcji potrzeba 2 argumenty");
                String suma = functions.addAllSpendings(args[i+1], args[i+2], Kadencja);
                i=i+2;
                System.out.println(suma);
                break;
            case "s": //wysokości wydatków na 'drobne naprawy i remonty biura poselskiego' określonego posła/posłanki
                if(i+2>args.length)  throw new IllegalArgumentException("Do podanej funkcji potrzeba 2 argumenty");
                System.out.println(functions.smallExpenses(args[i+1], args[i+2], Kadencja));
                i=i+2;
                break;
            case "a": //średniej wartości sumy wydatków wszystkich posłów
                System.out.println(functions.avgSum(Kadencja));
                break;
            case "t": //posła/posłanki, który wykonał najwięcej podróży zagranicznych
                System.out.println(functions.mostTravelAbroud(Kadencja));
                break;
            case "l": //posła/posłanki, który najdłużej przebywał za granicą
                System.out.println(functions.longestJourney(Kadencja));
                break;
            case "e": //posła/posłanki, który odbył najdroższą podróż zagraniczną
                System.out.println(functions.theMostExpensiveTrip(Kadencja));
                break;
            case "i": //listę wszystkich posłów, którzy odwiedzili Włochy
                System.out.println(functions.italyVisitors(Kadencja));
                break;
            default:
                System.out.println("Argument "+args[i]+" niepoprawny. Zostaje on pominięty.");
        }
    }

    }
    public OfficeTerm generateCadence( int a) throws Exception {
        JsonParser jsonParser = new JsonParser();
        OfficeTerm officeTerm=new OfficeTerm();
        officeTerm=jsonParser.deputyParse(a);
        return officeTerm;
    }

}
