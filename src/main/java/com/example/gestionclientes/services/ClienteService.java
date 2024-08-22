package com.example.gestionclientes.services;

import com.example.gestionclientes.dto.ClienteSearchCriteria;
import com.example.gestionclientes.models.Cliente;
import com.example.gestionclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    ClienteRepository repository;

    @Override
    public Cliente getByID(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void removeByID(Integer id) {
         repository.deleteById(id);
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public List<Cliente> buscar(ClienteSearchCriteria searchCriteria) {
        return repository.buscarClientes(searchCriteria.getNombreCompleto(), searchCriteria.getEmail(), searchCriteria.getTelefono());
    }
}
