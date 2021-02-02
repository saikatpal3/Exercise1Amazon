package com.amazon.pom.pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.pom.base.BaseTest;

public class CheckoutPage extends BaseTest {
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Checkout Page requires Login hence actions not included

}
