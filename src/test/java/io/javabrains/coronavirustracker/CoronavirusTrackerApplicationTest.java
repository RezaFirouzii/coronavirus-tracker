package io.javabrains.coronavirustracker;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoronavirusTrackerApplicationTests {

	// Performing tests
	public static void main(String[] args) throws Exception {

		// Test Home Controller
		new HomeControllerTest().testHomeController();

		// Test Location Stats
		new LocationStatsTest().testLocationStats();

		// Test CoronaVirus Data Service
		new CoronaVirusDataServiceTest().testFetchVirusData();
		new CoronaVirusDataServiceTest().testFetchVirusData2();

	}

}