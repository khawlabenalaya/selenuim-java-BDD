package com.e2eTests.automation.pageObjects;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

public class ProductPage {

	private ConfigFileReader configFileReader = new ConfigFileReader();
	private WebDriver driver;
    private WebDriverWait wait;
    

	/*@FindBy*/

	final static String PRODUCT1_XPATH ="//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Backpack']";
	final static String PRODUCT1PAGE_XPATH ="//div[@class='inventory_details_name large_size']";		
	final static String ADDPRODUCT_ID="add-to-cart-sauce-labs-backpack";
	
	final static String CARD_XPATH="//a[@class='shopping_cart_link']";
	
	final static String PRODUCTADDED_XPATH="//*[contains(@class, 'inventory_item_name') and text()='Sauce Labs Backpack']";
			
	final static String PRODUCTQUANTITY_XPATH="//div[@class='cart_quantity']";
	final static String RemoveButton_ID="remove-sauce-labs-backpack";
	
	
	
	/*@FindBy*/


	@FindBy(how = How.XPATH, using = PRODUCT1_XPATH)
	public static WebElement productSac;

	@FindBy(how = How.XPATH, using = PRODUCT1PAGE_XPATH)
	public static WebElement pageSacDetail;

	@FindBy(how = How.ID, using = ADDPRODUCT_ID)
	public static WebElement addProductToCard;
	
	@FindBy(how = How.XPATH, using = CARD_XPATH)
	public static WebElement card;
	
	@FindBy(how = How.XPATH, using = PRODUCTADDED_XPATH)
	public static WebElement productAdded;
	@FindAll({@FindBy(how = How.XPATH, using = PRODUCTADDED_XPATH)})
    public static List<WebElement> productsInCart;
	
	@FindBy(how = How.XPATH, using = PRODUCTQUANTITY_XPATH)
	public static WebElement productQuantity;
	
	@FindBy(how = How.ID, using = RemoveButton_ID)
	public static WebElement removeButton;
	

	public ProductPage (WebDriver driver){
		 this.driver = Setup.getDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	     PageFactory.initElements(driver, this);
	     
	     
		
	}

	/*Methods*/


	public void choiseSac() {

		productSac.click();	
	}

	public void addProductToCard() {

		addProductToCard.click();	
	}
	
	public void AccessCard() {

		card.click();
		
	}
	
	public void removeProduct() {
		wait.until(d ->removeButton.isDisplayed());
		removeButton.click();
		
	}





}
