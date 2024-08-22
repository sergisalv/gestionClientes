package com.example.gestionclientes.controllers;

import com.example.gestionclientes.dto.ClienteSearchCriteria;
import com.example.gestionclientes.models.Cliente;
import com.example.gestionclientes.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

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
