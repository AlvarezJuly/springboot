package com.julissajocelyn.app_crud.Service;

import java.util.List;

import com.julissajocelyn.app_crud.Models.Cliente;

public interface IClienteService {
    
   
    public List<Cliente> GetAll();

    public Cliente Insert(Cliente cliente);

    public Cliente GetId (long Id_Cliente);

    public void Delete (long Id_Cliente);



}
