package pe.interbank.openbanking.questions.web;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import pe.interbank.openbanking.userinterfaces.pages.LoginPage;

public class LoginQuestion {

    public static Question<String> errorMessage(){
        return actor -> TextContent.of(LoginPage.ERROR_TEXT).answeredBy(actor);
    }
}
