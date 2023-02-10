import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void testFetchVirusData() {
        String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/02-09-2020.csv";

        String csv = "Province/State,Country/Region,Last Update,Confirmed,Deaths,Recovered\n" +
                "Hubei,Mainland China,2020-02-09T23:23:02,66433.0,2706.0,10794.0\n" +
                "Guangdong,Mainland China,2020-02-09T13:23:02,1374.0,8.0,153.0\n" +
                "Henan,Mainland China,2020-02-09T13:23:02,1239.0,22.0,103.0\n";

        when(restTemplate.getForObject(url, String.class)).thenReturn(csv);

        List<LocationStats> stats = coronaVirusDataService.fetchVirusData(url);

        assertNotNull(stats);
        assertEquals(3, stats.size());
        assertEquals("Hubei", stats.get(0).getProvince());
        assertEquals("Mainland China", stats.get(0).getCountry());
        assertEquals(66433, stats.get(0).getLatestTotalCases());
        assertEquals(2706, stats.get(0).getDeaths());
        assertEquals(10794, stats.get(0).getRecovered());
        assertEquals("Guangdong", stats.get(1).getProvince());
        assertEquals("Mainland China", stats.get(1).getCountry());
        assertEquals(1374, stats.get(1).getLatestTotalCases());
        assertEquals(8, stats.get(1).getDeaths());
        assertEquals(153, stats.get(1).getRecovered());
        assertEquals("Henan", stats.get(2).getProvince());
        assertEquals("Mainland China", stats.get(2).getCountry());
        assertEquals(1239, stats.get(2).getLatestTotalCases());
        assertEquals(22, stats.get(2).getDeaths());
        assertEquals(103, stats.get(2).getRecovered());
    }

	@Test
    public void testFetchVirusData2() throws IOException {
        List<LocationStats> locationStatsList = coronaVirusDataService.fetchVirusData();
        assertNotNull(locationStatsList);
        assertTrue(locationStatsList.size() > 0);
    }
}