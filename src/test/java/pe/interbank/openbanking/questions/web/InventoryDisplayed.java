package pe.interbank.openbanking.questions.web;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import pe.interbank.openbanking.userinterfaces.pages.InventoryPage;

public class InventoryDisplayed {

    public static Question<Boolean> titleProducts(){
        return actor -> Visibility.of(InventoryPage.PRODUCTS_TITLE).answeredBy(actor).booleanValue();
    }

    public static Question <String> text(){
        return actor -> Text.of(InventoryPage.PRODUCTS_TITLE.of("").called("")).answeredBy(actor);
    }
}
