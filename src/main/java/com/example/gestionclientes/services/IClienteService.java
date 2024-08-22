package com.example.gestionclientes.services;

import com.example.gestionclientes.dto.ClienteSearchCriteria;
import com.example.gestionclientes.models.Cliente;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IClienteService {
     public Cliente getByID( Integer id);

   public void removeByID(Integer id);

   public void save(Cliente cliente);

   public List<Cliente> buscar(ClienteSearchCriteria searchCriteria);
}
