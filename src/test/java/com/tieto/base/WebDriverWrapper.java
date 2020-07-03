package com.tieto.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tieto.utilities.PropUtils;

public class WebDriverWrapper {
	
	protected WebDriver driver;
	@Parameters({"browser"})
	
	@BeforeMethod
	public void init(@Optional("ch") String browserName) throws IOException {
		
		// Always use relative path and give path after project name only
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "Driver/IEDriverServer.exe");
		
		if (browserName.toLowerCase().equals("ch")) {
			driver = new ChromeDriver();
		}else if (browserName.toLowerCase().equals("ff")){
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		} 
		
		driver.manage().window().maximize(); //maximize window.
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String baseUrl = PropUtils.getValueFromKey("testdata/data.properties","url");
		driver.get(baseUrl);
		
	}
	
	
	
	@AfterMethod
	public void end() {
		driver.quit();
	}

}
