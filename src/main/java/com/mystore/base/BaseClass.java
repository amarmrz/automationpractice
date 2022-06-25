/**
 * 
 */
package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Poste-19
 *
 */
public class BaseClass {

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static Properties prop = null;

	@BeforeTest
	public void loadConfig() {

		try {

			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop = new Properties();
			prop.load(ip);
			// System.out.print("this the input stream" + ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void BeforeSuit() {
		DOMConfigurator.configure("log4j.xml");
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public static void launchApp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		if (browserName.contains("Chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.contains("Firefox")) {
			driver.set(new FirefoxDriver());
		}

		// Action.pageLoadTimeOut(driver, 30);
		getDriver().get(prop.getProperty("url"));
//		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
	}
}
