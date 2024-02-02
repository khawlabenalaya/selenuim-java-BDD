package com.e2eTests.automation.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automation.pageObjects.ProductPage;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef {
	
	public WebDriver driver;
	//private ProductPage productPage = new ProductPage(driver);
	private ConfigFileReader configFileReader = new ConfigFileReader();
	private ProductPage productPage;

	public ProductStepDef() {
		driver = Setup.getDriver();
		PageFactory.initElements(driver, ProductPage.class);
        productPage = new ProductPage(driver); // Pass the driver instance


	}
	
	
	
	
	@Given("l'utilisateur est sur la page d'accueil")
	public void l_utilisateur_est_sur_la_page_d_accueil() {
		String UrlAmazonConnected = configFileReader.getProperties("urlSwagLabsConnected");
		driver.get(UrlAmazonConnected);
	    
	}

	@When("l'utilisateur clique sur un produit spécifique")
	public void l_utilisateur_clique_sur_un_produit_spécifique() {
		productPage.choiseSac();
	    
	}

	@Then("il devrait être redirigé vers la page des détails du produit")
	public void il_devrait_être_redirigé_vers_la_page_des_détails_du_produit() {
		String currentUrl = driver.getCurrentUrl();
		String urlDetaiProduit = configFileReader.getProperties("urlDetaiProduit");
		assertEquals("la connection a echoué", urlDetaiProduit, currentUrl);
		 
	}

	@And("les détails du produit devraient être affichés correctement")
	public void les_détails_du_produit_devraient_être_affichés_correctement() {
		assertTrue("on est pas redirigé vers la page de détail de produit", productPage.pageSacDetail.isDisplayed());
	   
	}

	@Given("l'utilisateur est sur la page des détails du produit")
	public void l_utilisateur_est_sur_la_page_des_détails_du_produit() {
		productPage.choiseSac();
		  
	}

	@When("l'utilisateur clique sur le bouton Ajouter au panier")
	public void l_utilisateur_clique_sur_le_bouton_Ajouter_au_panier() {
		productPage.addProductToCard(); 
		
	}

	@Then("le produit devrait être ajouté avec succès au panier")
	public void le_produit_devrait_être_ajouté_avec_succès_au_panier() {
		productPage.AccessCard();
		
		assertTrue("le produit n'est pas ajouté", productPage.productAdded.isDisplayed());
		
	    
	}

	@And("le nombre d'articles dans le panier devrait être mis à jour")
	public void le_nombre_d_articles_dans_le_panier_devrait_être_mis_à_jour() {
		int qantityProductAdded=Integer.parseInt(productPage.productQuantity.getText());
		assertTrue("la quantité de produit ajouté au panier est 0", qantityProductAdded>0);
		
	   
	}

	@When("l'utilisateur est sur la page du panier")
	public void l_utilisateur_est_sur_la_page_du_panier() {
		String urlPanier = configFileReader.getProperties("urlPanier");
		driver.get(urlPanier);
		
	}

	@When("l'utilisateur supprime un produit du panier")
	public void l_utilisateur_supprime_un_produit_du_panier() {
		productPage.removeProduct();
		
	    
	}

	@Then("le produit devrait être retiré avec succès du panier")
	public void le_produit_devrait_être_retiré_avec_succès_du_panier() {
		productPage.AccessCard();
		assertTrue("le produit n'est pas supprimé", productPage.productsInCart.size()==0);
	   
	}


	@When("l'utilisateur vérifie le prix du produit")
	public void l_utilisateur_vérifie_le_prix_du_produit() {
	   
	}

	@Then("le prix affiché du produit devrait correspondre au prix réel du produit")
	public void le_prix_affiché_du_produit_devrait_correspondre_au_prix_réel_du_produit() {
	   
	}

	@And("l'état de disponibilité du produit devrait être affiché correctement")
	public void l_état_de_disponibilité_du_produit_devrait_être_affiché_correctement() {
	   
	}

	@Given("l'utilisateur est sur la page d'une catégorie de produits")
	public void l_utilisateur_est_sur_la_page_d_une_catégorie_de_produits() {
	    
	}

	@When("l'utilisateur utilise les boutons de navigation ou la pagination")
	public void l_utilisateur_utilise_les_boutons_de_navigation_ou_la_pagination() {
	    
	}

	@Then("il devrait pouvoir naviguer entre différents produits de la catégorie")
	public void il_devrait_pouvoir_naviguer_entre_différents_produits_de_la_catégorie() {
	    
	}

	@When("l'utilisateur applique des filtres pour afficher des produits spécifiques")
	public void l_utilisateur_applique_des_filtres_pour_afficher_des_produits_spécifiques() {
	    
	}

	@Then("seuls les produits correspondant aux critères sélectionnés devraient être affichés")
	public void seuls_les_produits_correspondant_aux_critères_sélectionnés_devraient_être_affichés() {
	    
	}

	@When("l'utilisateur saisit un mot-clé dans la barre de recherche et appuie sur {string}")
	public void l_utilisateur_saisit_un_mot_clé_dans_la_barre_de_recherche_et_appuie_sur(String string) {
	    
	}

	@Then("les produits correspondant au mot-clé devraient être affichés dans les résultats de recherche")
	public void les_produits_correspondant_au_mot_clé_devraient_être_affichés_dans_les_résultats_de_recherche() {
	   
	}

	@And("le produit devrait être ajouté avec succès à la liste de souhaits")
	public void le_produit_devrait_être_ajouté_avec_succès_à_la_liste_de_souhaits() {
	    
	}

	@And("le produit devrait apparaître dans la liste de souhaits de l'utilisateur")
	public void le_produit_devrait_apparaître_dans_la_liste_de_souhaits_de_l_utilisateur() {
	   
	}




}
