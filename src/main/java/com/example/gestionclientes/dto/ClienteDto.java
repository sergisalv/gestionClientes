package com.example.gestionclientes.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ClienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}
