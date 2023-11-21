package com.julissajocelyn.app_crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julissajocelyn.app_crud.Models.Cliente;
import com.julissajocelyn.app_crud.Repository.ClienteRepository;


@Service

public class ClienteServiceImplement implements IClienteService{


    @Autowired
    
    ClienteRepository clienterepository;


    @Override
    public List<Cliente> GetAll() {
      return clienterepository.findAll(); //propio de la ClienteRepository interface

    }

    @Override
    public Cliente Insert(Cliente cliente) {
        return clienterepository.save(cliente);

    }

    @Override
    public Cliente GetId(long Id_Cliente) {
     return clienterepository.findById(Id_Cliente).orElse(null);
    }

    @Override
    public void Delete(long Id_Cliente) {
        clienterepository.deleteById(Id_Cliente);
    }




    
}
