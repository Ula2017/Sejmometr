package com.company;

import org.junit.Test;

import static org.junit.Assert.*;
public class FunctionsTest {
    @Test
    public void test() throws  Exception{
        Functions functions = new Functions();
       OfficeTerm kadencja1 = new JsonParser().deputyParse(7);
        OfficeTerm kadencja2 = new JsonParser().deputyParse(8);

        assertEquals("Srednia suma wydatkow wszystkich poslow wynosi 144882.96463829788", functions.avgSum(kadencja2));
        assertEquals("Srednia suma wydatkow wszystkich poslow wynosi 272247.607894737", functions.avgSum(kadencja1));
        assertEquals("Poseł, który wykonał najwięcej podróży zagranicznych to Tadeusz Iwiński. Liczba wyjazdów 72", functions.mostTravelAbroud(kadencja1 ));
        assertEquals("Poseł, który najdłużej przebywał za granicą: Jan Dziedziczak 165 dni", functions.longestJourney(kadencja2 ));
        assertEquals("Najdroższą podróżą była podróz posła Adam Szejnfeld. Wynosiła: 27529.35", functions.theMostExpensiveTrip(kadencja1));
        assertEquals("Wszystkie wydatki Agata Borowiec wynosza 0.0", functions.addAllSpendings("Agata", "Borowiec", kadencja2));
        assertEquals("Wydatki na drobne naprawy i remonty biura poselskiego posła Agata Borowiec wynosza 0.0", functions.smallExpenses("Agata", "Borowiec", kadencja2));
       // assertEquals("Posłowie, którzy odwiedzili Włochy:\n" +
         //       "Andrzej Czerwiński, Joanna Fabisiak, Rafał Grupiński, Cezary Grabarczyk, Jan Dziedziczak, Agnieszka Pomaska, Grzegorz Raniewicz, Roman Kosecki, Antoni Mężydło, Ireneusz Raś, Grzegorz Schetyna, Stefan Niesiołowski, Sławomir Neumann, Jakub Rutnicki, Jacek Falfus, Krystyna Skowrońska, Adam Abramowicz, Ewa Kopacz, Anna Nemś, Robert Tyszkiewicz, Marek Rząsa, Cezary Tomczyk, Marek Matuszewski, Michał Jaros, Wojciech Ziemniak,", functions.italyVisitors(kadencja2) );


    }
}