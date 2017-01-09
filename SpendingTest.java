package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpendingTest {
    Functions functions = new Functions();
    OfficeTerm kadencja2 = new JsonParser().deputyParse(8);
    Deputy deputy=kadencja2.getDeputies().get(1);
   Spending spending=deputy.getLayers().getSpending();

    public SpendingTest() throws Exception {
    }

    @Test
    public void getFields() throws Exception {

    }

    @Test
    public void getYears() throws Exception {

    }

    @Test
    public void getSum() throws Exception {
    //    assertTrue(0.0=spending.getSum());

    }

}