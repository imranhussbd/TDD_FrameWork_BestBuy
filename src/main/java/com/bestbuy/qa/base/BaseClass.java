package com.bestbuy.qa.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.bestbuy.qa.common.CommonWaits;
import com.bestbuy.qa.common.Commons;
import com.bestbuy.qa.objects.CreateAccount;
import com.bestbuy.qa.objects.HomePage;
import com.bestbuy.qa.objects.Ps5PackagePage;
import com.bestbuy.qa.reporting.ExtentManager;
import com.bestbuy.qa.reporting.ExtentTestManager;
import com.bestbuy.qa.utils.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Configuration configuration = Configuration.getInstance("config.properties");

	WebDriver driver;
	WebDriverWait wait;
	CommonWaits waits;
	ExtentReports extent;

	protected Commons commons;
	protected HomePage homePage;
	protected Ps5PackagePage ps5PackagePage;
	protected CreateAccount createAccount;

	@BeforeSuite
	public void initiatingReport() {
		extent = ExtentManager.initiatingReport();
	}

	@BeforeMethod
	public void beforeEachTest(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.creatingTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("browserStackCloud")) {
			driver = browserStackDriver();
		}else {
			driver = localDriver(browser);
		}
		configuration = Configuration.getInstance("configuration/config.properties");
		driver.manage().window().maximize();
		driver.get(configuration.get("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explicitWait"))));
		initClasses();
	}

	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for (String group : result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(group);
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "TEST PASSED");
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "TEST SKIPPED");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "TEST FAILED \n" + result.getThrowable());
			ExtentTestManager.getTest().addScreenCaptureFromPath(commons.getScreenshot(method.getName()));
		}
	}

	private WebDriver localDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public WebDriver browserStackDriver() {
		configuration = Configuration.getInstance("configuration/bsConfig.properties");
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", configuration.get("browser"));
		capabilities.setCapability("browserVersion", configuration.get("browserVersion"));
		capabilities.setCapability("browserstack.user", configuration.get("user"));
		capabilities.setCapability("browserstack.key", configuration.get("pass"));
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", configuration.get("os"));
		browserstackOptions.put("osVersion", configuration.get("osVersion"));
		capabilities.setCapability("bstack:options", browserstackOptions);
		try {
			driver = new RemoteWebDriver(new URL(configuration.get("url")), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	private void initClasses() {
		waits = new CommonWaits(wait);
		commons = new Commons(driver, waits);
		homePage = new HomePage(driver, commons);
		ps5PackagePage = new Ps5PackagePage(driver, commons);
		createAccount = new CreateAccount(driver, commons);
	}

	/*protected WebDriver getDriver() {
		return driver;
	}*/

	@AfterMethod
	public void terminate() {
		driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
