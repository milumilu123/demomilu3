@Login
Feature: Login en la página de SauceDemo

  @test1
  Scenario: Inicio de sesión exitoso

    Given que el Cliente se encuentra en la página SauceDemo
    When inicia sesión con las credenciales: "standard_user", "secret_sauce"
    Then el login es satisfactorio


  @test2
  Scenario: Inicio de sesión exitoso

    Given que el Cliente se encuentra en la página SauceDemo
    When inicia sesión con las credenciales
      | user          | password     |
      | standard_user | secret_sauce |
    And el Cliente visualiza un producto
    Then finaliza sesion

  @Unhappy
  Scenario: Inicio de sesión con usuario bloqueado

    Given que el Cliente se encuentra en la página SauceDemo
    When inicia sesión con las credenciales: "locked_out_user", "secret_sauce"
    Then se muestra el mensaje de error "Epic sadface: Sorry, this user has been locked out."


