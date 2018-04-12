package samplePackage.integration.testLink;

import java.net.MalformedURLException;


import testlink.api.java.client.*;

public class TestLinkIntegration {
	
	public static void updateResult(String testCaseName, String exception,  String results) throws TestLinkAPIException{
		TestLinkAPIClient client = new TestLinkAPIClient(samplePackage.Setting.TestLink.TESTLINK_KEY, samplePackage.Setting.TestLink.TESTLINK_URL);
		client.reportTestCaseResult(
				samplePackage.Setting.TestLink.PROJECT_NAME, 
				samplePackage.Setting.TestPlan.TEST_PLAN_AUT, 
				testCaseName,
				samplePackage.Setting.TestLink.BUILD_NAME,
				exception,
				results
				);
	}	
	
	
	
}
