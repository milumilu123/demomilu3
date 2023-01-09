package pe.interbank.openbanking.questions.mobile;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import pe.interbank.openbanking.userinterfaces.screens.SearchScreen;

public class SearchResult {

    public static Question<String> resultText(){
        return actor -> Text.of(SearchScreen.RESULT_TEXT).answeredBy(actor);
    }
}
