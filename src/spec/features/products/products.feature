@tag35
Feature: Gestion des produits

  Background: 
    Given L'utilisateur est sur la page Swag Labs
    When Il saisit son adresse e-mail et son mot de passe
    And Il clique sur le bouton s'identifier
    Then Il devrait être redirigé vers la page d'accueil connectée

  @affichageProduit
  Scenario: Affichage des détails du produit
    Given l'utilisateur est sur la page d'accueil
    When l'utilisateur clique sur un produit spécifique
    Then il devrait être redirigé vers la page des détails du produit
    And les détails du produit devraient être affichés correctement
	
	@AjoutProduitPannier
  Scenario: Ajout de produits au panier
    Given l'utilisateur est sur la page des détails du produit
    When l'utilisateur clique sur le bouton Ajouter au panier
    Then le produit devrait être ajouté avec succès au panier
    And le nombre d'articles dans le panier devrait être mis à jour
	
	@deletteProductPanier
  Scenario: Suppression de produits du panier
  	Given l'utilisateur est sur la page des détails du produit
    When l'utilisateur clique sur le bouton Ajouter au panier
    And l'utilisateur est sur la page du panier
    And l'utilisateur supprime un produit du panier
    Then le produit devrait être retiré avec succès du panier
 

  Scenario: Vérification du prix du produit
    Given l'utilisateur est sur la page des détails du produit
    When l'utilisateur vérifie le prix du produit
    Then le prix affiché du produit devrait correspondre au prix réel du produit

  Scenario: Vérification de la disponibilité du produit
    Given l'utilisateur est sur la page des détails du produit
    Then l'état de disponibilité du produit devrait être affiché correctement

  Scenario: Navigation entre les produits
    Given l'utilisateur est sur la page d'une catégorie de produits
    When l'utilisateur utilise les boutons de navigation ou la pagination
    Then il devrait pouvoir naviguer entre différents produits de la catégorie

  Scenario: Filtrage des produits
    Given l'utilisateur est sur la page d'une catégorie de produits
    When l'utilisateur applique des filtres pour afficher des produits spécifiques
    Then seuls les produits correspondant aux critères sélectionnés devraient être affichés

  Scenario: Recherche de produits
    Given l'utilisateur est sur la page d'accueil
    When l'utilisateur saisit un mot-clé dans la barre de recherche et appuie sur "Entrée"
    Then les produits correspondant au mot-clé devraient être affichés dans les résultats de recherche

  Scenario: Ajout de produits à une liste de souhaits
    Given l'utilisateur est sur la page des détails du produit
    When l'utilisateur clique sur le bouton "Ajouter à la liste de souhaits"
    Then le produit devrait être ajouté avec succès à la liste de souhaits
    And le produit devrait apparaître dans la liste de souhaits de l'utilisateur
