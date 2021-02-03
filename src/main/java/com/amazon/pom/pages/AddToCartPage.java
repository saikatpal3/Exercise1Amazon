package com.amazon.pom.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.pom.base.BaseTest;

public class AddToCartPage extends BaseTest{
	
	@FindBy(xpath = "//div[@id='hlb-subcart']//span[contains(@class,'hlb-price')]")
	WebElement price;
	
	@FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
	WebElement proceedToCheckOut;
	
	public AddToCartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		return price.getText();
	}
	
	public void addToCart() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", proceedToCheckOut);
	}
}
