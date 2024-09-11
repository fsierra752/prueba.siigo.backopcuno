package com.reqres.stepdefinitions;

import com.reqres.services.generics.SetUp;
import com.reqres.taks.CrearSolicitudRestDel;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;

import static com.reqres.services.api.Implementacion.URL_BASE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ServicesDefinitionDel extends SetUp {

    @Before()
    public void setup(){
        setupLog4j();
        actor.can(CallAnApi.at(URL_BASE));
    }

    @Cuando("se elimine el usuario con identificacion {int}")
    public void seElimineElUsuarioConIdentificacion(Integer identificacion) {
        actor.attemptsTo(CrearSolicitudRestDel.conId(identificacion));
    }
    @Entonces("el servicio eliminara correctamente")
    public void elServicioEliminaraCorrectamente() {
        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser: " + HttpStatus.SC_NO_CONTENT,
                        response -> response.statusCode(HttpStatus.SC_NO_CONTENT)
                )
        );
    }

}
