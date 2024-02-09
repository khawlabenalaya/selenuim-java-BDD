package com.e2eTests.automation.demoQa.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2eTests.automation.demoQa.pageObjects.AlertePage;
import com.e2eTests.automation.demoQa.pageObjects.GestionOngletPage;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TypeClicStepDef {
	public WebDriver driver;
	private WebDriverWait wait;
	private GestionOngletPage gestionOngletPage=new GestionOngletPage();
	private ConfigFileReader configFileReader = new ConfigFileReader();
	private AlertePage alertePage=new AlertePage();
	
	public  TypeClicStepDef() {
		driver = Setup.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, GestionOngletPage.class);
		PageFactory.initElements(driver, AlertePage.class);
		
		
	}
	
	
	@Given("l'utilisateur est sur la page web de DemoQA")
	public void l_utilisateur_est_sur_la_page_web_de_demo_qa() {
		String pageUrl = configFileReader.getProperties("urlDemoQAbutton");
		driver.get(pageUrl);
		driver.manage().deleteAllCookies();
		wait.until(d ->alertePage.firstalerteButton.get(0)).isDisplayed();
		alertePage.firstalerteButton.get(0).click();
	    
	}

	@When("l'utilisateur clique sur le bouton avec click {string}")
	public void l_utilisateur_clique_sur_le_bouton_avec_click(String typeClic) {
		gestionOngletPage.clickButtonWithType(typeClic);
		
	    
	}

	@Then("le bouton doit réagir en conséquence pour chaque click {string}")
	public void le_bouton_doit_réagir_en_conséquence_pour_chaque_click(String typeClic) {
		gestionOngletPage.reactionWithTypeClic(typeClic);
	   
	}
}
	
	


