#language:es
Característica: Verifiacion de servicios atraves de solicitudes Rest metodo GET

  Escenario: Solicitar informacion de un solo usuario
    Cuando se solicite informacion de usuario con identificacion 2
    Entonces el servicio respondera con la informacion adecuada "Janet"