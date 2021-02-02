package com.amazon.pom.testscenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	}
	
	@Test
	public void checkPrice(){
		Assert.assertEquals(searchPage.getPrice(), bookDetailsPage.getPrice());
		Assert.assertEquals(searchPage.getPrice(), addToCartPage.getPrice());
	}

	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
