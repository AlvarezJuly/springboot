package com.julissajocelyn.app_crud.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julissajocelyn.app_crud.Models.Cliente;
import com.julissajocelyn.app_crud.Service.ClienteServiceImplement;

@RestController

@RequestMapping("/api/cliente")

public class ClienteControllers {

    @Autowired
      
    ClienteServiceImplement clienteservice;

  
    @GetMapping("/allclients")
    
    public List<Cliente> MostrarClientes(){
     return clienteservice.GetAll();

    }


    @GetMapping ("/client/{Id_Cliente}")
    public ResponseEntity<Cliente> MostrarClienteID(@PathVariable long Id_Cliente){
       Cliente clientePorId =clienteservice.GetId(Id_Cliente);

       return ResponseEntity.ok(clientePorId);
    }


    @PostMapping ("/insclient")
    
    public ResponseEntity<Cliente> GuardarClientes(@RequestBody Cliente cliente){
        Cliente Nuevo_Cliente = clienteservice.Insert(cliente);
        return new ResponseEntity<>(Nuevo_Cliente, HttpStatus.CREATED);
    }

    @PutMapping("/cllient/{Id_Cliente}")
    public ResponseEntity<Cliente> ActualizarClientes(@PathVariable long Id_Cliente, @RequestBody Cliente cliente){
       Cliente clientePorId = clienteservice.GetId(Id_Cliente);
       clientePorId.setNombre(cliente.getNombre());
       clientePorId.setApellido(cliente.getApellido());
       clientePorId.setTelefono(cliente.getTelefono());

       Cliente cliente_actualizado = clienteservice.Insert(clientePorId);
       return new ResponseEntity<Cliente>(cliente_actualizado, HttpStatus.CREATED);

    }

    @DeleteMapping("/Client/{Id_Cliente}")

    public ResponseEntity<HashMap<String, Boolean>> EliminarClientes(@PathVariable long Id_Cliente){
        this.clienteservice.Delete(Id_Cliente);

        HashMap<String, Boolean> statusClientsdeleted = new HashMap<>();

        statusClientsdeleted.put("Cliente eliminado", true);
        return ResponseEntity.ok(statusClientsdeleted);
    }

}
