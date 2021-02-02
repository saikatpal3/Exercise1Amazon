package com.amazon.pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pom.base.BaseTest;

public class SearchPage extends BaseTest{
	
	@FindBy(xpath = "//h2/a[@class='a-link-normal a-text-normal' and contains(@href,'Unit-Testing-Principles-Practices-Patterns')]")
	WebElement firstSearchResult;
	
	@FindBy(xpath = "//*[@id='search']//span[3]/div[2]/div[2]/div/span//a/span[1]/span[2]/span[@class='a-price-whole']")
	WebElement priceWhole;
	
	@FindBy(xpath = "//*[@id='search']//span[3]/div[2]/div[2]/div/span//a/span[1]/span[2]/span[@class='a-price-fraction']")
	WebElement priceFraction;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public BookDetailsPage clickOnElement() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", firstSearchResult);
		return new BookDetailsPage();		
	}
	
	public String getPrice() {
		return "$"+priceWhole.getText()+"."+priceFraction.getText();
	}

}
