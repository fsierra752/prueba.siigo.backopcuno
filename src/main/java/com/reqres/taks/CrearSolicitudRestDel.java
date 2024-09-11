package com.reqres.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.reqres.services.api.Implementacion.RESOURCE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearSolicitudRestDel implements Task {

    private final Integer userId;

    public CrearSolicitudRestDel(Integer userId) {
        this.userId = userId;
    }

    public static Performable conId(Integer userId) {
        return instrumented(CrearSolicitudRestDel.class, userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(RESOURCE + "/" + userId));
    }
}
