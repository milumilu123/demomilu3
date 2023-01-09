Feature: Búsqueda en Airbnb

  @mobile
  Scenario: Búsqueda simple de hospedaje

    Given que el Usuario se encuentra en el login de Airbnb
    When busca "Cancun Mexico"
    Then muestra el texto "Over 1,000 homes"