package resources.commonLibs.implementations;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDriver {
	
	private WebDriver driver;
	
	private int pageLoadTimeout;
	
	private int elementDetectionTimeout;
	
	private String currentWorkingDir;
	
	public CommonDriver(String browserType) throws Exception {
		
		pageLoadTimeout = 10;
		
		elementDetectionTimeout = 10;
		
		currentWorkingDir = System.getProperty("user.dir");
		
		if (browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					currentWorkingDir + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browserType.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.chrome.driver",
					currentWorkingDir + "/drivers/firefoxdriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver",
					currentWorkingDir + "/drivers/firefoxdriver.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Invalid driver type" + browserType);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public void navigateToURL(String url) {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));
		driver.get(url);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	

}
