package pe.interbank.openbanking.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.interbank.openbanking.userinterfaces.pages.InventoryPage;
import pe.interbank.openbanking.userinterfaces.pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Logout implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.BTN_MENU),
                Click.on(InventoryPage.BTN_LOGOUT),
                WaitUntil.the(LoginPage.USERNAME_INPUT, isVisible()).forNoMoreThan(10).seconds()
        );

    }
}
