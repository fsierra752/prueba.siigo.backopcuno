package com.reqres.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.reqres.services.api.Implementacion.RESOURCE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearSolicitudRestPut implements Task {

    private final Integer userId;
    private final Object bodyRequest;

    public CrearSolicitudRestPut(Integer userId, Object bodyRequest) {
        this.userId = userId;
        this.bodyRequest = bodyRequest;
    }

    public static Performable conIdBody(Integer userId, Object bodyRequest) {
        return instrumented(CrearSolicitudRestPut.class, userId, bodyRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(RESOURCE + "/" + userId)
                        .with(requestSpecification -> requestSpecification
                                .body(bodyRequest)));
    }

}
