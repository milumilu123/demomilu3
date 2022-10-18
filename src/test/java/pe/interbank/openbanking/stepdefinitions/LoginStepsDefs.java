package pe.interbank.openbanking.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pe.interbank.openbanking.questions.web.InventoryDisplayed;
import pe.interbank.openbanking.questions.web.LoginQuestion;
import pe.interbank.openbanking.tasks.web.Login;
import pe.interbank.openbanking.tasks.web.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepsDefs {
    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario (Scenario scenario){
        this.scenario = scenario;
    }

    @Given("^que el (.*) se encuentra en la página SauceDemo$")
    public void queElClienteSeEncuentraEnLaPáginaSauceDemo(String actor) {
        theActorCalled(actor).attemptsTo(
                NavigateTo.sauceDemoPage()
        );
        screenShot();
    }

    @When("inicia sesión con las credenciales: {string}, {string}")
    public void iniciaSesiónConLasCredenciales(String user, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(user, password)
        );
        screenShot();
    }

    @Then("el login es satisfactorio")
    public void el_login_es_satisfactorio() {
        theActorInTheSpotlight().should(
                seeThat("El título products es visible", InventoryDisplayed.titleProducts(), equalTo(true))
        );
        screenShot();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Then("se muestra el mensaje de error {string}")
    public void seMuestraElMensajeDeError(String message) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de error", LoginQuestion.errorMessage(), equalTo(message))
        );
    }
}
