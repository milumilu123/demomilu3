@pasarela
Feature: Pasarela

  @pasarela_hp
  Scenario: [HAPPY PATH] Pasarela

    Given el Usuario accede a la aplicación
    Then la respuesta es satisfactoria
    When genero la orden de pago con la tarjeta "5444024587530845" y descripcion "Interbank Visa Signature"
    Then la respuesta es satisfactoria
