package com.reqres.taks;

import com.reqres.interactions.SolicitudCreacionInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.log4j.Logger;

import static com.reqres.services.api.Implementacion.RESOURCE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearSolicitudRestPost implements Task {

    private static final Logger LOGGER = Logger.getLogger(CrearSolicitudRestPost.class);

    private final Object bodyRequest;

    public CrearSolicitudRestPost(Object bodyRequest) {
        this.bodyRequest = bodyRequest;
    }

    public static Performable enviada(Object bodyRequest){
        return instrumented(CrearSolicitudRestPost.class, bodyRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(RESOURCE)
                        .with(requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .body(bodyRequest))
        );
        LOGGER.info(LastResponse.received().answeredBy(actor).prettyPrint());
    }
}
