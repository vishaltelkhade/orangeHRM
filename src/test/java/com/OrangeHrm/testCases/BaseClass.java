package com.OrangeHrm.testCases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OrangeHrm.utilities.ReadconfigUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    ReadconfigUtils readconfig= new ReadconfigUtils();
	public static WebDriver driver;
	public  String url = readconfig.getApplicationURL(); 
	public  String usernm = readconfig.getApplicationUserName(); 
	public String passw = readconfig.getApplicationPassword();

	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chroOP = new ChromeOptions();
			chroOP.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chroOP);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.err.println("browserName is invalid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		

	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
