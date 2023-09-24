package edu.ifrs;


import edu.ifrs.business.Load;
import edu.ifrs.business.Vehicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle vehicle;

    private final int maxWeightLimit = 1000;

    @Before
    public void setUp() {
        vehicle = new Vehicle(maxWeightLimit);
    }

    @Test
    public void testAddWeight() {
        // Add a load of weight 500 to the vehicle
        vehicle.addWeight(new Load(500));

        // Check the load is added
        assertEquals(1, vehicle.getLoads().size());
        assertEquals(500, vehicle.getLoads().get(0).getWeight());
    }

    @Test
    public void testCheckWeightLimitExceededWithOneLoad() {
        // Add a load of weight 1500 to the vehicle
        vehicle.addWeight(new Load(1500));

        // Check that the weight limit is exceeded
        assertFalse(vehicle.checkWeightLimit());
    }

    @Test
    public void testCheckWeightLimitExceededWithManyLoads() {
        // Add a load of weight 1500 to the vehicle
        vehicle.addWeight(new Load(500));
        vehicle.addWeight(new Load(500));
        vehicle.addWeight(new Load(500));

        // Check that the weight limit is exceeded
        assertFalse(vehicle.checkWeightLimit());
    }

    @Test
    public void testCheckWeightLimitNotExceededWithOneLoad() {
        // Add a load of weight 500 to the vehicle
        vehicle.addWeight(new Load(500));

        // Check that the weight limit is not exceeded
        assertTrue(vehicle.checkWeightLimit());
    }

    @Test
    public void testCheckWeightLimitNotExceededWithManyLoads() {
        // Add a load of weight 750 to the vehicle
        vehicle.addWeight(new Load(500));
        vehicle.addWeight(new Load(250));

        // Check that the weight limit is not exceeded
        assertTrue(vehicle.checkWeightLimit());
    }

    @Test
    public void testCheckWeightLimitNotExceededWithExactlyMaxWeight() {
        // Add a load of weight maxWeightLimit to the vehicle
        vehicle.addWeight(new Load(maxWeightLimit));

        // Check that the weight limit is not exceeded
        assertTrue(vehicle.checkWeightLimit());
    }

    @Test
    public void testCheckWeightLimitWithNoLoads() {
        // Check that the weight limit is not exceeded when no loads are added
        assertTrue(vehicle.checkWeightLimit());
    }
}
