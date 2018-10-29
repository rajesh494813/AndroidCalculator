package base;

import io.appium.java_client.*;
import org.openqa.selenium.remote.*;
import java.net.*;
import org.openqa.selenium.*;
import java.util.concurrent.*;
import java.io.*;
import util.*;
import org.testng.annotations.*;

public class BaseTest extends ExtentReporter {
	protected static AppiumDriver<MobileElement> driver;
	public DesiredCapabilities capabilities;
	protected String appActivity;
	protected String appPackage;
	protected String deviceName;
	protected String platformName;
	protected String platformVersion;
	protected String serverUrl;

	
	// To initialize AppiumDriver with Desired capabilities
	@BeforeClass
	public void initialiseDriver() throws IOException, InterruptedException {
		this.setDesiredCapabilities();
		(this.capabilities = new DesiredCapabilities()).setCapability("deviceName", this.deviceName);
		this.capabilities.setCapability("platformVersion", this.platformVersion);
		this.capabilities.setCapability("platformName", this.platformName);
		this.capabilities.setCapability("unicodeKeyboard", true);
		this.capabilities.setCapability("appPackage", this.appPackage);
		this.capabilities.setCapability("appActivity", this.appActivity);
		
		//instantiate Appium driver
		driver = new AppiumDriver(new URL(serverUrl),capabilities);
		driver.manage().timeouts().implicitlyWait(80L, TimeUnit.SECONDS);
		Thread.sleep(10000L);
	}

	
	// To set the capabilities needed for driver
	public void setDesiredCapabilities() throws IOException {
		PropertyFileReader.loadPropertyFile(); 
		
		capabilities = new DesiredCapabilities();
		
		this.appPackage = PropertyFileReader.getString("testdata.appPackage");
		this.deviceName = PropertyFileReader.getString("testdata.deviceName");
		this.platformVersion = PropertyFileReader.getString("testdata.platformVersion");
		this.platformName = PropertyFileReader.getString("testdata.platformName");
		this.appActivity = PropertyFileReader.getString("testdata.appActivity");
		this.serverUrl = PropertyFileReader.getString("testdata.serverUrl");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}