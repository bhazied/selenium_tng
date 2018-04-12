package samplePackage;

import com.beust.testng.TestNG;

public class dashboard extends MainTest{

	
	public static void main(String args[]) {
		disableSSLCertificateChecking();
		TestNG runner = new TestNG();
		runner.setXmlSuites(createSuite("User entry", "samplePackage.Dashboard"));
		runner.run();
	}
}
