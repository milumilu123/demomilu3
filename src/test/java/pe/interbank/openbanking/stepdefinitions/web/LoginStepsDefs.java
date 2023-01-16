package pe.interbank.openbanking.stepdefinitions.web;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pe.interbank.openbanking.questions.web.InventoryDisplayed;
import pe.interbank.openbanking.questions.web.LoginQuestion;
import pe.interbank.openbanking.tasks.web.Login;
import pe.interbank.openbanking.tasks.web.Logout;
import pe.interbank.openbanking.tasks.web.NavigateTo;
<<<<<<< HEAD
import pe.interbank.openbanking.userinterfaces.pages.InventoryPage;
import pe.interbank.openbanking.userinterfaces.pages.LoginPage;

=======
>>>>>>> 2b57ff3c38c9786b1d730b950944be7b65f8f586
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Map;

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
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        screenShot();
    }

    @When("inicia sesión con las credenciales: {string}, {string}")
    public void iniciaSesiónConLasCredenciales(String user, String password) throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(user, password)
        );
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        screenShot();
    }

    @When("inicia sesión con las credenciales")
    public void iniciaSesiónConLasCredenciales(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> user : data){
            theActorInTheSpotlight().attemptsTo(
                    Login.withCredentials(user.get("user"), user.get("password"))
            );
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        screenShot();
    }


    @And("^el (.*) visualiza un producto$")
    public void visualiza(String actor) {


        theActorCalled(actor).attemptsTo(
                Click.on(InventoryPage.PRODUCT_NAME)
        );
        //theActorInTheSpotlight().should(
               // seeThat("El producto Sauce Labs Backpack es visible", InventoryDisplayed.nameProducts(), equalTo(true))

        //);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        screenShot();
    }



    @Then("finaliza sesion")
    public void finalizasesion() {
        //List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        //for(Map<String, String> user : data){
            theActorInTheSpotlight().attemptsTo(
                    new Logout()
            );
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        //}
        screenShot();
    }

    @Then("el login es satisfactorio")
    public void el_login_es_satisfactorio() {
        theActorInTheSpotlight().should(
                seeThat("El título products es visible", InventoryDisplayed.titleProducts(), equalTo(true))
        );
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
