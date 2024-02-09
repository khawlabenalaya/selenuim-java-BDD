package com.e2eTests.automation.demoQa.stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2eTests.automation.demoQa.pageObjects.AlertePage;
import com.e2eTests.automation.demoQa.pageObjects.GestionOngletPage;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GestionOngletStepDef {
	public WebDriver driver;
	private WebDriverWait wait;
	private GestionOngletPage gestionOngletPage=new GestionOngletPage();
	private ConfigFileReader configFileReader = new ConfigFileReader();
	private AlertePage alertePage=new AlertePage();
	
	public  GestionOngletStepDef() {
		driver = Setup.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, GestionOngletPage.class);
		PageFactory.initElements(driver, AlertePage.class);
		
	}
	
	
	@Given("l'utilisateur est sur la page web")
	public void l_utilisateur_est_sur_la_page_web() {
		String pageUrl = configFileReader.getProperties("urlDemoQAwindow");
		driver.get(pageUrl);
		driver.manage().deleteAllCookies();
		wait.until(d ->alertePage.firstalerteButton.get(0)).isDisplayed();
		alertePage.firstalerteButton.get(0).click();
	    
	}

	@When("l'utilisateur clique sur un bouton pour ouvrir un nouvel onglet")
	public void l_utilisateur_clique_sur_un_bouton_pour_ouvrir_un_nouvel_onglet() {
		
		gestionOngletPage.clickWindowButton();
	   
	}

	@Then("un nouvel onglet s'ouvre")
	public void un_nouvel_onglet_s_ouvre() {
		gestionOngletPage.verifyWindowOpened();
	   
	}


	@When("l'utilisateur revient à l'onglet précédent")
	public void l_utilisateur_revient_à_l_onglet_précédent() {
		gestionOngletPage.retourOngletPrécédent();
	   
	}

	@Then("l'utilisateur est revenu à l'onglet précédent")
	public void l_utilisateur_est_revenu_à_l_onglet_précédent() {
		
		Assert.assertTrue("l'onglet précédent n'est pas affiché", gestionOngletPage.verifieRetourOngletPrécédent());
		
		
	    
	}


}
