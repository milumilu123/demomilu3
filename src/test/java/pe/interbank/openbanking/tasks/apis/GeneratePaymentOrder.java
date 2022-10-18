package pe.interbank.openbanking.tasks.apis;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import pe.interbank.openbanking.models.*;
import pe.interbank.openbanking.utils.WebServiceEndpoints;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GeneratePaymentOrder implements Task {

    private String accessToken;
    private String card;
    private String description;

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

        Item item = Item.builder()
                .identifier(card)
                .description(description)
                .quantity(1)
                .value(100)
                .build();

        Email email = Email.builder()
                .value("SIXFLAGSIBK.PRUEBAS1@GMAIL.COM")
                .build();

        Buyer buyer = Buyer.builder()
                .id("0090909090")
                .email(Arrays.asList(email))
                .build();

        PaymentOrder paymentOrder = PaymentOrder.builder()
                .amount(100)
                .currency("PEN")
                .buyer(buyer)
                .items(Arrays.asList(item))
                .build();

        PaymentOrderRequest paymentOrderRequest = PaymentOrderRequest.builder()
                .paymentOrder(paymentOrder)
                .build();

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
                                .body(paymentOrderRequest)
                )
        );
    }
}
