package org.example.domain.usuario;

import lombok.Data;

import java.io.Serializable;

@Data
public class Usuario implements Serializable {
    private Long id;
    private String nombre;
    private String email;


}
