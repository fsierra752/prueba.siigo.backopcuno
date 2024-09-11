package com.reqres.services.generics;


import net.serenitybdd.screenplay.*;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

import static com.reqres.utils.enums.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class SetUp {

    protected final Actor actor = Actor.named("analista");
    protected final HashMap<String, Object> headers = new HashMap<>();

    protected void setupLog4j(){
        PropertyConfigurator.configure(LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
