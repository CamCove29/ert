package com.example.demo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


    @Component
    public class EmailListener {
        @Autowired
        private EmailService emailService;


        @EventListener
        @Async
        public void handleHelloEmailEvent(HelloEmailEvent event) {
            String htmlBody = "<!DOCTYPE html>\n" +
                    "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Email Template</title>\n" +
                    "</head>\n" +
                    "<body style=\"font-family: Arial, sans-serif; color: #333;\">\n" +
                    "<div style=\"max-width: 600px; margin: auto; border: 1px solid #ddd; padding: 20px; text-align: center;\">\n" +
                    "    <h1 style=\"color: #4A90E2;\">Bienvenido/a, <span th:text=\"${name}\">Nombre</span>!</h1>\n" +
                    "    <p style=\"font-size: 16px; color: #555;\">Gracias por unirte a nuestra comunidad. Ahora eres Premium.</p>\n" +
                    "    <a href=\"https://cdn.sixt.io/cms/originals/5eaffd97-0907-4868-9767-ae8f2230b0ba.jpg\" style=\"display: inline-block; text-decoration: none; color: white; background-color: #4A90E2; padding: 10px 20px; border-radius: 5px; font-weight: bold; margin-top: 20px;\">Visitar sitio</a>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>\n";
            emailService.sendHtmlMessage(event.getEmail(), "Correo de Bienvenida", htmlBody);

        }
    }


