package com.example.gestionclientes.jobs;

import com.example.gestionclientes.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailJob {

    @Autowired
    @Qualifier("jetMailService")  // Qualifier Igual que Autowired pero nos permite elegir el parámetro que queremos traer
    private IEmailService service;

    @Scheduled(cron = "0 0 22 ? * MON")
    public void enviarCampanaPublicitaria(){
        String asunto ="Monday News";
        List<String> to =new ArrayList<>();
        to.add("sergisalv@gmail.com");
        String body ="Hola, Aquí las noticias más impactantes";

        service.enviarEmailDeBienvenida(asunto, to, "Sergio");
    }

}
