@typeClick
Feature: Tester les différents types de clics sur un bouton

  Scenario Outline: Vérifier les différents types de clics sur un bouton
    Given l'utilisateur est sur la page web de DemoQA
    When l'utilisateur clique sur le bouton avec click "<Type de clic>"
    Then le bouton doit réagir en conséquence pour chaque click "<Type de clic>"

    Examples:
      | Type de clic  |
      | Simple        |
      | Double        |
      | Clic droit    |
      
       
      