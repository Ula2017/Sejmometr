package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {
    Functions functions = new Functions();
    OfficeTerm kadencja2 = new JsonParser().deputyParse(8);
    Deputy deputy=kadencja2.getDeputies().get(1);
    Year year = deputy.getLayers().getSpending().getYears().get(0);

    public YearTest() throws Exception {
    }

    @Test
    public void getField() throws Exception {
        assertEquals(java.util.Optional.ofNullable(59400.0), java.util.Optional.ofNullable(year.getField().get(0)));

    }

    @Test
    public void getYear() throws Exception {
        assertEquals("2013", year.getYear());

    }


    ///????///
    @Test
    public void getYearsum() throws Exception {
      assertFalse(year.getYearsum()==0.0);

    }

}