package io.javabrains.coronavirustracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoronavirusTrackerApplicationTests {

	// Performing tests
	public static void main(string[] args) {
		
		// Test Home Controller
		var test_result = new HomeControllerTest().testHomeController();
		system.out.println("Test Home Controller Result: " + test_result);


		// Test CoronaVirus Data Service
		var test_result = new CoronaVirusDataServiceTest().testFetchVirusData();
		system.out.println("Test CoronaVirus Data Service Result: " + test_result);

		var test_result = new CoronaVirusDataServiceTest().testFetchVirusData2();
		system.out.println("Test CoronaVirus Data Service Result 2: " + test_result);


		// Test Location Stats
		var test = new LocationStatsTest().testLocationStats();
		system.out.println("Test Location Stats Result: " + test_result);
	}

}