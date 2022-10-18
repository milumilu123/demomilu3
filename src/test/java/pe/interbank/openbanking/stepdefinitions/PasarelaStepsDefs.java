package pe.interbank.openbanking.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import pe.interbank.openbanking.questions.apis.ResponseCode;
import pe.interbank.openbanking.questions.apis.Token;
import pe.interbank.openbanking.tasks.apis.GeneratePaymentOrder;
import pe.interbank.openbanking.tasks.apis.GetToken;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PasarelaStepsDefs {
    EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^el (.*) accede a la aplicación$")
    public void el_usuario_accede_a_la_aplicación(String actor) {
        theActorCalled(actor)
                .whoCan(CallAnApi.at(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("api.manager")));

        theActorInTheSpotlight().attemptsTo(
                new GetToken()
        );

    }

    @Then("la respuesta es satisfactoria")
    public void la_respuesta_es_satisfactoria() {
        theActorInTheSpotlight().should(
                seeThat("El código de respuesta", new ResponseCode(), equalTo(200))
        );

        Serenity.setSessionVariable("accessToken").to(theActorInTheSpotlight().asksFor(Token.accessToken()));
    }

    @When("genero la orden de pago con la tarjeta {string} y descripcion {string}")
    public void generoLaOrdenDePagoConLaTarjetaYDescripcion(String card, String description) {
        String accessToken = Serenity.sessionVariableCalled("accessToken");

        theActorInTheSpotlight().attemptsTo(
                GeneratePaymentOrder.withData(accessToken, card, description)
        );
    }
}
