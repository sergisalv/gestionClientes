package com.example.gestionclientes.controllers;

import com.example.gestionclientes.dto.ClienteSearchCriteria;
import com.example.gestionclientes.models.Cliente;
import com.example.gestionclientes.services.IClienteService;
import com.example.gestionclientes.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    IEmailService emailService;

    @Autowired
    IClienteService service;

    @GetMapping ("api/cliente/{id}")
    public Cliente getByID(@PathVariable("id") Integer id){
        return service.getByID(id);
    }

    @DeleteMapping ("api/cliente/{id}")
    public void removeByID(@PathVariable("id") Integer id){
        service.removeByID(id);
    }

    @PostMapping("api/cliente/")
    public void create(@RequestBody Cliente cliente){
        service.save(cliente);
        String asunto = "Su cuenta se creó correctamente";
        List<String> to = new ArrayList<>();
        to.add(cliente.getEmail());
        String body = "Bienvenido a nuestra WEB...";

        emailService.enviarEmailDeBienvenida(asunto,to, cliente.getNombre());
    }

    @PutMapping("api/cliente/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Cliente cliente){
        service.save(cliente);
    }

    @GetMapping ("api/cliente/buscar")
    public List<Cliente> buscar(@RequestBody ClienteSearchCriteria searchCriteria){
        return service.buscar(searchCriteria);
    }
}
