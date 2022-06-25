/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mystore.base.BaseClass;

/**
 * @author Amar
 *
 */
public class IndexPageTest extends BaseClass {
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

}
