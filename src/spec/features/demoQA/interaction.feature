@dragAndDrop
Feature: Tester le glisser-déposer

  Scenario: Glisser un élément et le déposer sur une cible
   Given l'utilisateur est sur une page web
    When l'utilisateur effectue un glisser-déposer de l'élément source vers la cible
    Then l'élément source est déplacé et déposé avec succès sur la cible

