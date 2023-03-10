package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my city list
     * @return
     */

    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void AddCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan","SK"));
        assertEquals(listSize+1,list.getCount());
    }

    /**
     * create a city
     * checks if the city is in an empty list (should be false)
     * add city to the list
     * check if the city is in the list (should be true)
     */
    @Test void testHasCity(){
        list = MockCityList();
        City city = new City("Calgary", "AB");
        assertEquals(false, list.hasCity(city));

        list.addCity(city);
        assertEquals(true, list.hasCity(city));
    }
}
