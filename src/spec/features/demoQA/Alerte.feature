@testAlert
Feature: Test d'alertes

  Scenario: Vérifier l'affichage et la fermeture d'une alerte
    Given L'utilisateur est sur la page d'alertes
    When L'utilisateur clique sur le bouton pour afficher une alerte
    Then L'alerte s'affiche
    When L'utilisateur clique sur le bouton OK pour fermer l'alerte
    Then L'alerte est fermée avec succès
