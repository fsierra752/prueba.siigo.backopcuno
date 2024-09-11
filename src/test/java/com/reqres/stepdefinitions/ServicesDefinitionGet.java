package com.reqres.stepdefinitions;

import com.reqres.services.generics.SetUp;
import com.reqres.taks.CrearSolicitudRestGet;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;

import static com.reqres.services.api.Implementacion.URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;


public class ServicesDefinitionGet extends SetUp {

    @Before()
    public void setup(){
        setupLog4j();
        actor.can(CallAnApi.at(URL_BASE));
    }

    @Cuando("se solicite informacion de usuario con identificacion {int}")
    public void seSoliciteInformacionDeUsuarioConIdentificacion(Integer identificacion) {
        actor.attemptsTo(CrearSolicitudRestGet.conId(identificacion));
        LastResponse.received().answeredBy(actor).prettyPrint();
    }

    @Entonces("el servicio respondera con la informacion adecuada {string}")
    public void elServicioResponderaConLaInformacionAdecuada(String usuario) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser: " + HttpStatus.SC_OK,
                        response -> response.statusCode(HttpStatus.SC_OK)
                )
        );
        Response response = LastResponse.received().answeredBy(actor);
        String firstName = response.jsonPath().getString("data.first_name");
        actor.should(seeThat("El nombre del usuario debe ser", actor -> firstName, equalTo(usuario)));
    }

}
