import org.junit.Test;
import static org.junit.Assert.*;

public class LocationStatsTest {

    @Test
    public void testLocationStats() {
        LocationStats locationStats = new LocationStats();
        locationStats.setProvince("Hubei");
        locationStats.setCountry("Mainland China");
        locationStats.setLatestTotalCases(66433);
        locationStats.setDeaths(2706);
        locationStats.setRecovered(10794);

        assertEquals("Hubei", locationStats.getProvince());
        assertEquals("Mainland China", locationStats.getCountry());
        assertEquals(66433, locationStats.getLatestTotalCases());
        assertEquals(2706, locationStats.getDeaths());
        assertEquals(10794, locationStats.getRecovered());
    }
}