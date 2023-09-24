package edu.ifrs;


import edu.ifrs.business.Load;
import edu.ifrs.business.Vehicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle vehicle;

    @Before
    public void setUp() {
        // Initialize a new Vehicle object with a weight limit of 1000
        int maxWeightLimit = 1000;
        vehicle = new Vehicle(maxWeightLimit);
    }

    @Test
    public void testAddWeight() {
        // Add a load of weight 500 to the vehicle
        vehicle.addWeight(new Load(500));

        // Check the load is added
        assertEquals(1, vehicle.getLoads().size());
    }

    @Test
    public void testCheckWeightLimitExceeded() {
        // Add a load of weight 800 to the vehicle
        vehicle.addWeight(new Load(1500));

        // Check that the weight limit is exceeded
        assertFalse(vehicle.checkWeightLimit());
    }

    @Test
    public void testCheckWeightLimitNotExceeded() {
        // Add a load of weight 500 to the vehicle
        vehicle.addWeight(new Load(500));

        // Check that the weight limit is not exceeded
        assertTrue(vehicle.checkWeightLimit());
    }

    @Test
    public void testCheckWeightLimitWithNoLoads() {
        // Check that the weight limit is not exceeded when no loads are added
        assertTrue(vehicle.checkWeightLimit());
    }

}