package com.amazon.pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.pom.base.BaseTest;

public class BookDetailsPage extends BaseTest {
	
	@FindBy(id="newBuyBoxPrice")
	WebElement price;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addToCart;
	
	public BookDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		return price.getText();
	}
	
	public void addToCart() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", addToCart);
	}

}
