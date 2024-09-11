package com.reqres.interactions;

import com.reqres.models.ServicesModel;
import org.apache.log4j.Logger;

public class SolicitudCreacionInteraction {

    private static final Logger LOGGER = Logger.getLogger(SolicitudCreacionInteraction.class);

    public SolicitudCreacionInteraction() {
    }

    public static Object nuevoUsuario(String nombreUsuario, String area) {
        ServicesModel nuevoUsuario = new ServicesModel();
        try {
            nuevoUsuario.setName(nombreUsuario);
            nuevoUsuario.setJob(area);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return nuevoUsuario;
    }
}
