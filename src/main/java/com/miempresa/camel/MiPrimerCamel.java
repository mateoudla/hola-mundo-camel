package com.miempresa.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MiPrimerCamel {
    public static void main(String[] args) throws Exception {
        // Crear un contexto Camel
        CamelContext context = new DefaultCamelContext();

        // Configurar una ruta Camel
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("timer://miTimer?period=1000") // Fuente: Temporizador cada 1 segundo
                        .setBody(constant("Hola Mundo")) // Mensaje de salida
                        .to("stream:out"); // Destino: Consola
            }
        });

        // Iniciar el contexto Camel
        context.start();

        // Mantenerlo activo durante 5 segundos
        Thread.sleep(5000);

        // Detener el contexto Camel
        context.stop();
    }
}
