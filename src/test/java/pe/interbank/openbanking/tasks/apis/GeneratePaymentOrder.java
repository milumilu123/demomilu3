package pe.interbank.openbanking.tasks.apis;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import pe.interbank.openbanking.models.*;
import pe.interbank.openbanking.utils.Utils;
import pe.interbank.openbanking.utils.WebServiceEndpoints;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GeneratePaymentOrder implements Task {

    private String accessToken;
    private String card;
    private String description;

    public static final String TEMPLATE = "/templates/pasarela.json";

    public GeneratePaymentOrder(String accessToken, String card, String description){
        this.accessToken = accessToken;
        this.card = card;
        this.description = description;
    }

    public static Performable withData(String accessToken, String card, String description){
        return instrumented(GeneratePaymentOrder.class, accessToken, card, description);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        String body = Utils.getTemplate(TEMPLATE)
                        .replace("{identifier}", card)
                        .replace("{description}", description);

        actor.attemptsTo(
                Post.to(WebServiceEndpoints.PAYMENT_ORDER.getPath()).with(
                        requestSpecification -> requestSpecification
                                .contentType("application/json")
                                .header("X-Correlation-Id", timestamp)
                                .header("X-Api-Version", "v1")
                                .header("X-Api-Force-Sync", "true")
                                .header("Ocp-Apim-Subscription-Key", "332a09a749cd4b0eb2d760af339d569f")
                                .header("X-Origin-Id", "179.7.48.197")
                                .header("Authorization", "Bearer " + accessToken)
                                .body(body)
                )
        );
    }
}
