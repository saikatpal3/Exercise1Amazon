package com.amazon.pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.pom.base.BaseTest;

public class HomePage extends BaseTest {
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement submitButton;
	
	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	WebElement selectBooks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void performSearch(){
		Select select = new Select(selectBooks);
		select.selectByVisibleText("Books");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='qa testing for beginners';", searchBox);
		jse.executeScript("arguments[0].click();", submitButton);
	}

}
