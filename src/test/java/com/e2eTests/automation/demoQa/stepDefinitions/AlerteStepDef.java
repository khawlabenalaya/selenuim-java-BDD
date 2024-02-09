package com.e2eTests.automation.demoQa.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2eTests.automation.demoQa.pageObjects.AlertePage;
import com.e2eTests.automation.pageObjects.AuthenticationPage;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlerteStepDef {
	public WebDriver driver;
	private WebDriverWait wait;
	private AlertePage alertePage=new AlertePage();
	private ConfigFileReader configFileReader = new ConfigFileReader();
	
	public  AlerteStepDef() {
		driver = Setup.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, AlertePage.class);
		
	}
	
	
	
	@Given("L'utilisateur est sur la page d'alertes")
	public void l_utilisateur_est_sur_la_page_d_alertes() {
		String pageUrl = configFileReader.getProperties("urlDemoQA");
		driver.get(pageUrl);
		
		driver.manage().deleteAllCookies();
		wait.until(d ->alertePage.firstalerteButton.get(0)).isDisplayed();
		alertePage.firstalerteButton.get(0).click();
		//Actions actions = new Actions(driver);
		//actions.moveToElement(alertePage.firstalerteButton.get(0)).perform();
		//alertePage.verifyFirstAletePresent();
	    
	}

	@When("L'utilisateur clique sur le bouton pour afficher une alerte")
	public void l_utilisateur_clique_sur_le_bouton_pour_afficher_une_alerte() {
		alertePage.selectAlete();
	    
	}

	@And("L'alerte s'affiche")
	public void l_alerte_s_affiche() {
		alertePage.verifyAletePresent();
	    
	}

	@And("L'utilisateur clique sur le bouton OK pour fermer l'alerte")
	public void l_utilisateur_clique_sur_le_bouton_ok_pour_fermer_l_alerte() {
		alertePage.acceptAlete();
	    
	}

	@Then("L'alerte est fermée avec succès")
	public void l_alerte_est_fermée_avec_succès() {
		alertePage.verifyAlerteClosed();
	   
	}




}
