package com.bestbuy.qa.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bestbuy.qa.common.CommonWaits;
import com.bestbuy.qa.common.Commons;
import com.bestbuy.qa.objects.CreateAccount;
import com.bestbuy.qa.objects.HomePage;
import com.bestbuy.qa.objects.Ps5PackagePage;
import com.bestbuy.qa.utils.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Configuration configuration = new Configuration(null);

	WebDriver driver;
	WebDriverWait wait;

	protected Commons commons;
	CommonWaits waits;
	protected HomePage homePage;
	protected Ps5PackagePage ps5PackagePage;
	protected CreateAccount createAccount;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser1) {
		driver = localDriver(browser1);
		driver.manage().window().maximize();
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("explicitWait"))));
		initClasses();
	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
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

	protected WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}
}
