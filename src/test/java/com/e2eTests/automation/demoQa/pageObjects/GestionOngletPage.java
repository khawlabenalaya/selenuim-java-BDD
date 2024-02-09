package com.e2eTests.automation.demoQa.pageObjects;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

public class GestionOngletPage {
	public WebDriver driver;
	private ConfigFileReader configFileReader = new ConfigFileReader();
	
	public GestionOngletPage() {
		driver=Setup.getDriver();
	}

/*@FindBy*/
final static String WINDOWS_ID = "messageWindowButton";
final static String ELEMENTPAGE_ID ="sampleHeading";
final static String CLICKSIMPLE_XPATH ="//*[@class='btn btn-primary' and text()='Click Me']";
final static String CLICKRIGHT_ID ="rightClickBtn";
final static String CLICKDOUBLE_ID ="doubleClickBtn";
final static String MESSAGESIMPLE_ID ="dynamicClickMessage";
final static String MESSAGERIGHT_ID ="rightClickMessage";
final static String MESSAGEDOUBLE_ID ="doubleClickBtn";

/*@FindBy*/

@FindBy(how = How.ID, using = WINDOWS_ID)
public static WebElement windowsButton;
@FindBy(how = How.ID, using = ELEMENTPAGE_ID)
public static List <WebElement> elementPage;
@FindBy(how = How.XPATH, using = CLICKSIMPLE_XPATH)
public static WebElement simpleButon;
@FindBy(how = How.ID, using = CLICKRIGHT_ID)
public static WebElement rightButon;
@FindBy(how = How.ID, using = CLICKDOUBLE_ID)
public static WebElement doubleButon;
@FindBy(how = How.ID, using = MESSAGESIMPLE_ID)
public static WebElement simpleMessage;
@FindBy(how = How.ID, using = MESSAGERIGHT_ID)
public static WebElement rightMessage;
@FindBy(how = How.ID, using = MESSAGEDOUBLE_ID)
public static WebElement doubleMessage;





/*Methods*/

public void clickWindowButton() {
	String principalWindow=driver.getWindowHandle();
	windowsButton.click(); 
}
	
	public void getWindows() {
	//Store and print the name of all the windows open
			Set<String> handles = driver.getWindowHandles();
			System.out.println(handles);
	}
	public void verifyWindowOpened() {
		
		Assert.assertTrue("l'onglet ne s'ouvre pas", elementPage.size()>0);
		
		}
	
	
	
	public void retourOngletPrécédent() {
        // Récupérer les identifiants de tous les onglets
        String mainTab = driver.getWindowHandle();

        // Fermer l'onglet actuel
        driver.close();

        // Revenir à l'onglet précédent
        driver.switchTo().window(mainTab);
    }

    // Méthode pour vérifier si l'utilisateur est revenu à l'onglet précédent
    public boolean verifieRetourOngletPrécédent() {
        // Vérifier si le titre de la page correspond au titre de l'onglet précédent
        String expectedTitle = "DEMOQA";
        return driver.getTitle().equals(expectedTitle);
    }
    
    public void clickButtonWithType(String typeClic) {
    	System.out.println("Type de clic " +typeClic);
    	System.out.println(typeClic.equals("Double"));
    	
    	
    	if (typeClic.equals("Simple")) {
    		simpleButon.click();
    		
    	}
    	
    	
    	else if (typeClic.equals("Double")) {
    		Actions actions = new Actions(driver);
    		actions.doubleClick(doubleButon).perform();
    		
    	}
    	
    	
    	else if (typeClic.equals("Clic droit")) {
    		Actions actions = new Actions(driver);
    		actions.contextClick(rightButon).build().perform();
    	}
    	else {
    		System.out.println("Type de clic non reconnu");
    		
    	}
    	
    }

public void reactionWithTypeClic(String typeClic) {

    	
    	if(typeClic=="Simple") {
    		Assert.assertTrue("l'action de click simple est echoué ", simpleMessage.isDisplayed());
    		
    	}
    	
    	else if (typeClic=="Double") {
    		Assert.assertTrue("l'action de click double est echoué ", doubleMessage.isDisplayed());
    		
    	}
    	
    	else if (typeClic=="Clic droit") {
    		
    		Assert.assertTrue("l'action de click droite est echoué ", rightMessage.isDisplayed());
    		
    	}
    	else {
    		System.out.println("Type de clic non reconnu");
    		
    	}
    	
    }

					

}
