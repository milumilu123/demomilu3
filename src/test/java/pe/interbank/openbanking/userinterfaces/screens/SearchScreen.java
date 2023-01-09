package pe.interbank.openbanking.userinterfaces.screens;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchScreen {
    public static final Target SEARCH_INPUT = Target.the("Search Input").located(By.id("2131432049"));
    public static final Target RESULT_TEXT = Target.the("Result Text").located(By.id("2131431007"));
}
