@getionOnglet
Feature: Manipulation des onglets
  
  Scenario: Vérifier la manipulation des onglets
    Given l'utilisateur est sur la page web
    When l'utilisateur clique sur un bouton pour ouvrir un nouvel onglet
    Then un nouvel onglet s'ouvre
    When l'utilisateur revient à l'onglet précédent
    Then l'utilisateur est revenu à l'onglet précédent
