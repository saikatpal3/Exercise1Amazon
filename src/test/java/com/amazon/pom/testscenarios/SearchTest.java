package com.amazon.pom.testscenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.pom.base.BaseTest;
import com.amazon.pom.pages.HomePage;
import com.amazon.pom.pages.SearchPage;
import com.amazon.pom.pages.AddToCartPage;
import com.amazon.pom.pages.BookDetailsPage;

public class SearchTest extends BaseTest {
	HomePage homePage;
	SearchPage searchPage;
	BookDetailsPage bookDetailsPage;
	AddToCartPage addToCartPage;
	
	static String price = null;
	
	public SearchTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		homePage = new HomePage();
		searchPage = new SearchPage();
		bookDetailsPage = new BookDetailsPage();
		addToCartPage = new AddToCartPage();
	}
	
	@Test
	public void search(){
		homePage.performSearch();
		price = searchPage.getPrice();
	}
	
	@Test(dependsOnMethods = { "search" })
	public void verifyPriceSearchAndBookDetails(){
		searchPage.clickOnElement();
		String price2 = bookDetailsPage.getPrice();
		Assert.assertEquals(price, price2);
	}

	@Test(dependsOnMethods = { "verifyPriceSearchAndBookDetails" })
	public void verifyPriceSearchAndAddToCart(){
		bookDetailsPage.addToCart();
		String price3 = addToCartPage.getPrice();
		addToCartPage.addToCart();
		Assert.assertEquals(price, price3);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}


}
