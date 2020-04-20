package com.test.baseclass;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.model.DeviceCapabilityModel;
import com.test.utility.GetMobileCapability;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();
	private GetMobileCapability getMobileCapability=new GetMobileCapability();
	private AppiumDriverLocalService appiumservice;
	private DesiredCapabilities dc;
	private DeviceCapabilityModel mobileType;

	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	public final void setWait(WebDriver driver, int timeinSeconds) throws Exception {
		wait.set(new WebDriverWait(driver, timeinSeconds));
	}

	public final void setDriver(String browser) throws Exception {

		switch (browser) {

		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("allow-file-access-from-files");
			chromeOptions.addArguments("use-fake-device-for-media-stream");
			chromeOptions.addArguments("use-fake-ui-for-media-stream");
			WebDriverManager.chromedriver().setup();
			webDriver.set(new ChromeDriver(chromeOptions));
			System.out.println((((RemoteWebDriver) getDriver()).getCapabilities()).getBrowserName()+"---"+(((RemoteWebDriver) getDriver()).getCapabilities()).getVersion());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver.set(new FirefoxDriver());
			System.out.println((((RemoteWebDriver) getDriver()).getCapabilities()).getBrowserName()+"---"+(((RemoteWebDriver) getDriver()).getCapabilities()).getVersion());
			break;
		case "edge":
			if(!System.getProperty("user.name").equals("bharaat"))
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "/src/test/resources/driver/"+"msedgedriver.exe");
			System.out.println("Current user-->"+System.getProperty("user.name"));
			//WebDriverManager.edgedriver().setup();
			//EdgeDriverService service = EdgeDriverService.createDefaultService();
			EdgeOptions options=new EdgeOptions();
			options.setCapability("ms:inPrivate", true);
			webDriver.set(new EdgeDriver(options));
			System.out.println((((RemoteWebDriver) getDriver()).getCapabilities()).getBrowserName()+"---"+(((RemoteWebDriver) getDriver()).getCapabilities()).getVersion());
			break;
		case "android":
			appiumservice=AppiumDriverLocalService.buildDefaultService();
			appiumservice.start();
			dc=new DesiredCapabilities();
			mobileType = getMobileCapability.getCapability(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, mobileType.getDeviceName());
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobileType.getPlatformVersion());
			dc.setCapability(CapabilityType.BROWSER_NAME, mobileType.getBrowserName());
			dc.setCapability("noReset", mobileType.getNoReset());
			webDriver.set(new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc));
			break;
		case "iphone":
			String USERNAME = "atulluta";
			String ACCESS_KEY = "71eee56d-9861-4de6-9975-a2818d17d7d0";
			String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
			dc=new DesiredCapabilities();
			mobileType = getMobileCapability.getCapability(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, mobileType.getDeviceName());
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobileType.getPlatformVersion());
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, mobileType.getPlatformName());
			dc.setCapability(MobileCapabilityType.BROWSER_NAME, mobileType.getBrowserName());
			dc.setCapability(MobileCapabilityType.APPIUM_VERSION, mobileType.getAppiumVersion());
			dc.setCapability("noReset", mobileType.getNoReset());
			webDriver.set(new IOSDriver(new URL(URL), dc));
			break;
		}
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public WebDriver getDriver() {
		return webDriver.get();
	}

	public void removeDriver() // Quits the driver and closes the browser
	{
		wait.remove();
		webDriver.get().quit();
		webDriver.remove();
		
	}
}