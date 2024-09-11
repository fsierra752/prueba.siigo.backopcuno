package com.reqres.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.reqres.services.api.Implementacion.RESOURCE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearSolicitudRestGet implements Task {

    private final Integer userId;

    public CrearSolicitudRestGet(Integer userId) {
        this.userId = userId;
    }

    public static Performable conId(Integer userId) {
        return instrumented(CrearSolicitudRestGet.class, userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(RESOURCE + "/" + userId));
    }
}
