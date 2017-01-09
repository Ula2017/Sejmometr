package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataDeputyTest {

        Functions functions = new Functions();
        OfficeTerm kadencja1 = new JsonParser().deputyParse(7);

    public DataDeputyTest() throws Exception {
    }


    @Test
    public void getPoslowieLiczbaWyjazdow() throws Exception {
        assertEquals("0", kadencja1.getDeputies().get(0).getData().getPoslowieLiczbaWyjazdow().toString());

    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("Sławomir", kadencja1.getDeputies().get(0).getData().getFirstName().toString());


    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("Kłosowski", kadencja1.getDeputies().get(0).getData().getLastName());


    }

}