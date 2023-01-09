package pe.interbank.openbanking.tasks.mobile;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import pe.interbank.openbanking.userinterfaces.screens.LoginScreen;
import pe.interbank.openbanking.userinterfaces.screens.SearchDetailsScreen;
import pe.interbank.openbanking.userinterfaces.screens.SearchScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Search implements Task {

    private final String place;

    public Search(String place) {
        this.place = place;
    }

    public static Performable withPlace(String place){
        return instrumented(Search.class, place);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchScreen.SEARCH_INPUT),
                Click.on(SearchDetailsScreen.SEARCH_DETAIL_INPUT),
                Enter.theValue(place).into(SearchDetailsScreen.SEARCH_DETAIL_INPUT_TEXT),
                Click.on(SearchDetailsScreen.FIRST_OPTION),
                Click.on(SearchDetailsScreen.NEXT_BUTTON),
                Click.on(SearchDetailsScreen.SEARCH_BUTTON)
        );
    }
}
