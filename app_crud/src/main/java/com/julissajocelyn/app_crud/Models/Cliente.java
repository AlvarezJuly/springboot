package com.julissajocelyn.app_crud.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id_Cliente;
    private String Nombre;
    private String Apellido;
    private String Telefono;

    
    public Cliente() {
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public long getId_Cliente() {
        return Id_Cliente;
    }
    public void setId_Cliente(long id_Cliente) {
        Id_Cliente = id_Cliente;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    

    
}
