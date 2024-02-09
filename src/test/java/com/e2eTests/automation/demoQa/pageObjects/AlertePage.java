package com.e2eTests.automation.demoQa.pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;



public class AlertePage {
	
	
			public WebDriver driver;
			private ConfigFileReader configFileReader = new ConfigFileReader();
			
			public AlertePage() {
				driver=Setup.getDriver();
			}

	/*@FindBy*/
	final static String ALERTE_ID = "alertButton";
	final static String ALERTE_XPATH ="//p[@class='fc-button-label' and contains(text(), 'Autoriser')]";
	

	/*@FindBy*/
	
	@FindBy(how = How.ID, using = ALERTE_ID)
	public static WebElement alerteButton;
	@FindBy(how = How.XPATH, using = ALERTE_XPATH)
	public static List <WebElement> firstalerteButton;
	
	
	
	

	/*Methods*/
	
	public void verifyFirstAletePresent() {
		// Gérer l'alerte
        if (firstalerteButton.size()>0){
        	firstalerteButton.get(0).click();     	       	
        	
        }
        			
	}
	
	public void selectAlete() {
		alerteButton.click();
		
	}
	
	public void verifyAletePresent() {
		// Gérer l'alerte
        Alert alert = driver.switchTo().alert();
        Assert.assertNotNull(alert);
        Assert.assertNotNull("l'alerte n'est pas affiché", alert);	
	}
	public void acceptAlete() {
		// Accepter l'alerte
         driver.switchTo().alert().accept();
	}
       
        
     public void verifyAlerteClosed() {
	     // Vérifier que l'alerte est fermée
	     try {
	        
	    	 driver.switchTo().alert();
	         Assert.fail("L'alerte est toujours présente.");
	     
	     } catch (NoAlertPresentException e) {
	         // L'alerte est fermée avec succès
	        }
	 }
        

}
