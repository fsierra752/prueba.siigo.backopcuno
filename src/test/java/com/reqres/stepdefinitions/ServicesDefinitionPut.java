package com.reqres.stepdefinitions;

import com.reqres.services.generics.SetUp;
import com.reqres.taks.CrearSolicitudRestPost;
import com.reqres.taks.CrearSolicitudRestPut;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;

import static com.reqres.interactions.SolicitudCreacionInteraction.nuevoUsuario;
import static com.reqres.services.api.Implementacion.URL_BASE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ServicesDefinitionPut extends SetUp {

    @Before()
    public void setup(){
        setupLog4j();
        actor.can(CallAnApi.at(URL_BASE));
    }

    @Cuando("se modifique el usuario con id {int} y con campos nuevos nombre {string} y puesto {string}")
    public void seModifiqueElUsuarioConIdYConCamposNuevosNombreYPuesto(Integer identificacion, String nombre, String area) {
        actor.attemptsTo(CrearSolicitudRestPut.conIdBody(identificacion, nuevoUsuario(nombre, area)));
    }

    @Entonces("el servicio respondera correctamente")
    public void elServicioResponderaCorrectamente() {
        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser: " + HttpStatus.SC_OK,
                        response -> response.statusCode(HttpStatus.SC_OK)
                )
        );
    }

}
