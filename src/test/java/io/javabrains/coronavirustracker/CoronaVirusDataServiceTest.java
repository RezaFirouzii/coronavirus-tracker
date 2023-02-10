package io.javabrains.coronavirustracker;

import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CoronaVirusDataServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private CoronaVirusDataService coronaVirusDataService;

    @Test
    public void testFetchVirusData() throws IOException, InterruptedException {

        this.coronaVirusDataService = new CoronaVirusDataService();
        this.coronaVirusDataService.fetchVirusData();
        List<LocationStats> stats = this.coronaVirusDataService.getAllStats();

        assertNotNull(stats);
        assertEquals(108, stats.size());
        assertEquals("Hubei", stats.get(0).getState());
        assertEquals("Mainland China", stats.get(0).getCountry());
        assertEquals(1795, stats.get(0).getLatestTotalCases());
        assertEquals(0, stats.get(0).getDeaths());
        assertEquals(0, stats.get(0).getRecovered());
        assertEquals("Guangdong", stats.get(1).getState());
        assertEquals("Mainland China", stats.get(1).getCountry());
        assertEquals(141, stats.get(1).getLatestTotalCases());
        assertEquals(0, stats.get(1).getDeaths());
        assertEquals(0, stats.get(1).getRecovered());
        assertEquals("Zhejiang", stats.get(2).getState());
        assertEquals("Mainland China", stats.get(2).getCountry());
        assertEquals(201, stats.get(2).getLatestTotalCases());
        assertEquals(0, stats.get(2).getDeaths());
        assertEquals(0, stats.get(2).getRecovered());
    }

	@Test
    public void testFetchVirusData2() throws IOException, InterruptedException {
        this.coronaVirusDataService = new CoronaVirusDataService();
        this.coronaVirusDataService.fetchVirusData();
        List<LocationStats> locationStatsList = this.coronaVirusDataService.getAllStats();
        assertNotNull(locationStatsList);
        assertTrue(locationStatsList.size() > 0);
    }
}