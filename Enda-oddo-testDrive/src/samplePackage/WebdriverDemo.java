package samplePackage;

import java.util.ArrayList;
import java.util.List;


import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.beust.testng.TestNG;

public class WebdriverDemo extends MainTest{

	
	public static void main(String args[]) 
	{
		disableSSLCertificateChecking();
		TestNG runner = new TestNG();
		runner.setXmlSuites(createSuite("User entry", "samplePackage.user"));
		runner.run();
	}
	
	
	
	
}
