package com.e2eTests.automation.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automation.pageObjects.AuthenticationPage;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepDef {

	public WebDriver driver;
	private AuthenticationPage authenticationPage = new AuthenticationPage();
	private ConfigFileReader configFileReader = new ConfigFileReader();

	public AuthenticationStepDef() {
		driver = Setup.getDriver();
		PageFactory.initElements(driver, AuthenticationPage.class);

	}



	@Given("L'utilisateur est sur la page Swag Labs")
	public void l_utilisateur_est_sur_la_page_Swag_Labs() {
		String pageUrl = configFileReader.getProperties("urSwagLabs");
		driver.get(pageUrl);
	}

	@When("Il saisit son adresse e-mail et son mot de passe")
	public void il_saisit_son_adresse_e_mail_et_son_mot_de_passe() {
		authenticationPage.fillUserName();
		authenticationPage.fillPassword();
		
	}

	@And("Il clique sur le bouton s'identifier")
	public void il_clique_sur_le_bouton_s_identifier() {
		authenticationPage.clickLoginButton();
	}

	@Then("Il devrait être redirigé vers la page d'accueil connectée")
	public void il_devrait_être_redirigé_vers_la_page_d_accueil_connectée() {
		String currentUrl = driver.getCurrentUrl();
		String UrlAmazonConnected = configFileReader.getProperties("urlSwagLabsConnected");
		assertEquals("la connection a echoué", UrlAmazonConnected, currentUrl);
		
		
	}

	@When("Il saisit une adresse e-mail et un mot de passe incorrects")
	public void il_saisit_une_adresse_e_mail_et_un_mot_de_passe_incorrects() {
		authenticationPage.fillPasswordAndUserNameIncorect();
		authenticationPage.clickLoginButton();
		
	}

	@Then("Il devrait voir un message d'erreur indiquant que la connexion a échoué")
	public void il_devrait_voir_un_message_d_erreur_indiquant_que_la_connexion_a_échoué() {
		assertTrue("le message d'erreur n'est pas affiché", authenticationPage.ErrorMessage.isDisplayed());
	
	}

	


}
