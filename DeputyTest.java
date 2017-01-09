package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeputyTest {
    Functions functions = new Functions();
    OfficeTerm kadencja2 = new JsonParser().deputyParse(8);
    Deputy deputy=kadencja2.getDeputies().get(1);

    public DeputyTest() throws Exception {
    }

    @Test
    public void getId() throws Exception {
        assertEquals("197", deputy.getId().toString());

    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals(kadencja2.getDeputies().get(1).getData().getFirstName(), deputy.getFirstName());


    }

    @Test
    public void getLastName() throws Exception {
        assertEquals(kadencja2.getDeputies().get(1).getData().getLastName(), deputy.getLastName());

    }

    @Test
    public void getDeputySum() throws Exception {
        assertTrue(deputy.getDeputySum()==291868.23);

    }


    @Test
    public void getElementNamed() throws Exception {
assertEquals(kadencja2.getDeputies().get(1).getLayers().getTrips().get(1).get("kraj"), deputy.getElementNamed(1, "kraj"));
    }

    @Test
    public void getSizeTravel() throws Exception {
        assertEquals(5, deputy.getSizeTravel());

    }

}