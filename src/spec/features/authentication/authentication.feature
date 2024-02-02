@tag1 @tag2
Feature: Authentification sur Amazon

  @connexion_reussie
  Scenario: Connexion réussie avec des identifiants valides
    Given L'utilisateur est sur la page Swag Labs
    When Il saisit son adresse e-mail et son mot de passe
    And Il clique sur le bouton s'identifier
    Then Il devrait être redirigé vers la page d'accueil connectée

  @echec_connexion
  Scenario: Échec de connexion avec des identifiants invalides
    Given L'utilisateur est sur la page Swag Labs
    When Il saisit une adresse e-mail et un mot de passe incorrects
    And Il clique sur le bouton s'identifier
    Then Il devrait voir un message d'erreur indiquant que la connexion a échoué

  

  @tag3
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
