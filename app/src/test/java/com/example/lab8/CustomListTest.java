package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

    /**
     * create a city
     * try to delete, expects an exception
     * add a city, check if city is indeed in the list
     * attempt to delete it from the list
     * checks if city is no longer in list
     */
    @Test void testDeleteCity(){
        list = MockCityList();
        City city = new City("Red Deer", "AB");
        assertThrows( IllegalArgumentException.class, () -> { list.deleteCity(city); });

        list.addCity(city);
        assertEquals(true, list.hasCity(city));
        list.deleteCity(city);
        assertEquals(false, list.hasCity(city));

    }
}
