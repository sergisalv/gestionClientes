package com.example.gestionclientes.controllers;

import com.example.gestionclientes.models.Cliente;
import com.example.gestionclientes.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmailController {

    @Autowired
    @Qualifier("jetMailService")  // Qualifier Igual que Autowired pero nos permite elegir el parámetro que queremos traer
    private IEmailService service;

    @GetMapping("api/email")
    public void sendEmail(){
        String asunto ="Gracias por registrarte";
        List<String> to =new ArrayList<>();
        to.add("sergisalv@gmail.com");
        String body ="Hola, Gracias por registrarte...";

        service.enviarEmailDeBienvenida(asunto, to, "Sergio");


    }
}
