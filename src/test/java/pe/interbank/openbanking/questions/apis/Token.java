package pe.interbank.openbanking.questions.apis;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class Token {

    public static Question<String> accessToken(){
        return Question.about("Access Token")
                .answeredBy(actor -> SerenityRest.lastResponse().jsonPath().getString("access_token"));
    }
}
