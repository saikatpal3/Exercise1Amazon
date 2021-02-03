package com.amazon.pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.pom.base.BaseTest;
import com.amazon.pom.utils.CommonUtils;

public class SearchPage extends BaseTest{
	
	@FindBy(xpath = "//h2/a[@class=\"a-link-normal a-text-normal\" and contains(@href,\"Unit-Testing-Principles-Practices-Patterns\")]")
	WebElement firstSearchResult;
	
	@FindBy(xpath = "//*[@id=\"search\"]//span[3]/div[2]/div[2]/div/span//a/span[1]/span[2]/span[@class='a-price-whole']")
	WebElement priceWhole;
	
	@FindBy(xpath = "//*[@id=\"search\"]//span[3]/div[2]/div[2]/div/span//a/span[1]/span[2]/span[@class='a-price-fraction']")
	WebElement priceFraction;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnElement() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", firstSearchResult);
	}
	
	public String getPrice() {
		return CommonUtils.DOLLAR_SIGN + priceWhole.getText() 
				+ CommonUtils.DECIMAL_POINT + priceFraction.getText();
	}

}
