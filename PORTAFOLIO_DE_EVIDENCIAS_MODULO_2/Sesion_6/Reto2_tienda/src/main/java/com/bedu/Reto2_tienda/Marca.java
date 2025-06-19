package com.bedu.Reto2_tienda;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marca 
{
    @Id // Campo que funcionará como clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se generará automáticamente (autoincremental)
    private Long id;

    private String nombre;

    protected Marca() {}

    public Marca(String nombre) 
    {
        this.nombre = nombre;
    }

    public Long getId() 
    { 
        return id; 
    }

    public String getNombre() 
    { 
        return nombre; 
    }
}
