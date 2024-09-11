#language:es
Característica: Verifiacion de servicios a traves de solicitudes Rest metodo PUT

  Escenario: Creacion de usuario exitosa
    Cuando se modifique el usuario con id 1 y con campos nuevos nombre "fredy5" y puesto "admonUno"
    Entonces el servicio respondera correctamente