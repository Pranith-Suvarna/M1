package com.qkm1.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Sample {

	AndroidDriver driver;
	
	@BeforeClass	  
	@Parameters({"devicefullname","platformVersion","appiumEndPoint","apiKey"})
	public void startDriver(String devicefullname, String platformVersion, String appiumEndPoint, String apiKey) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
		capabilities.setCapability("Capability_ApiKey", apiKey);
		capabilities.setCapability("Capability_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("Capability_DeviceFullName", devicefullname);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("Capability_ApplicationName", "cricbuzz.apk");
		capabilities.setCapability("appPackage", "com.cricbuzz.android.vernacular");
		capabilities.setCapability("appActivity", "com.cricbuzz.android.ALGNSplashScreen");
		capabilities.setCapability("Capability_WildNet", "false");
		capabilities.setCapability("Capability_EnableVideo", "true");
		capabilities.setCapability("Capability_EnablePerformanceData", "true");
		capabilities.setCapability("Capability_EnableDeviceLogs", "true");
		capabilities.setCapability("appiumVersion", "1.20.2");
		driver = new AndroidDriver<WebElement>(new URL(appiumEndPoint), capabilities);
		
	}
	
	@Test
	public void test_01() throws InterruptedException {

      ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Select Language']")))).isDisplayed();
	  driver.findElementByXPath("//*[@text='English']").click();
      Thread.sleep(4000);
      if (driver.findElementsByXPath("//*[@text='OK']").size() > 0) {
  		if ( driver.findElementByXPath("//*[@text='OK']").isDisplayed()) {
  				      driver.findElementByXPath("//*[@text='OK']").click();
  				}
  			}
      Thread.sleep(2000);
	  ((WebElement)(new WebDriverWait((WebDriver)driver, 30L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Home']")))).isDisplayed();

	}
    
	@Test
	public void test_02() throws InterruptedException {

       driver.findElementByXPath("//*[@text='Feedback']").click();
       Thread.sleep(2000);
	   ((WebElement)(new WebDriverWait((WebDriver)driver, 30L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Name']")))).isDisplayed();

	}
	
     @AfterClass
 	public void quitDriver() {
 		
      driver.quit();
 	}
	
}
