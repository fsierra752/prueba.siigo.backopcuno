package com.reqres.stepdefinitions;

import com.reqres.services.generics.SetUp;
import com.reqres.taks.CrearSolicitudRestPost;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;

import static com.reqres.interactions.SolicitudCreacionInteraction.nuevoUsuario;
import static com.reqres.services.api.Implementacion.URL_BASE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ServicesDefinitionPost extends SetUp {

    @Before()
    public void setup(){
        setupLog4j();
        actor.can(CallAnApi.at(URL_BASE));
    }

    @Cuando("se envie nombre {string} y puesto {string}")
    public void seEnvieNombreYPuesto(String nombre, String area) {
        actor.attemptsTo(CrearSolicitudRestPost.enviada(nuevoUsuario(nombre, area)));
    }

    @Entonces("el servicio respondera exitosamente")
    public void elServicioResponderaExitosamente() {
        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser: " + HttpStatus.SC_CREATED,
                        response -> response.statusCode(HttpStatus.SC_CREATED)
                )
        );
    }
}
