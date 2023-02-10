package io.javabrains.coronavirustracker;

import io.javabrains.coronavirustracker.models.LocationStats;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocationStatsTest {

    @Test
    public void testLocationStats() {
        LocationStats locationStats = new LocationStats();
        locationStats.setState("Hubei");
        locationStats.setCountry("Mainland China");
        locationStats.setLatestTotalCases(1795);
        locationStats.setDeaths(2706);
        locationStats.setRecovered(10794);

        assertEquals("Hubei", locationStats.getState());
        assertEquals("Mainland China", locationStats.getCountry());
        assertEquals(1795, locationStats.getLatestTotalCases());
        assertEquals(2706, locationStats.getDeaths());
        assertEquals(10794, locationStats.getRecovered());
    }
}