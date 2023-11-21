import React, { Suspense, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import axios from "axios";
import { Modal, ModalBody, ModalFooter, ModalHeader } from "reactstrap";
import { useEffect } from "react";

const CrudCliente =()=> {

const baseUrl="http://localhost:8080/api/cliente/allclients";
const [data, setData]=useState([]);

const peticionGet=async()=>{
  await axios.get(baseUrl)
  .then(response=>{
    setData(response.data);
  }).catch(error=>{
    console.log(error);
  })

}

useEffect(()=>{

peticionGet();

},[])


  //Structure table
  const TablaDatos = () =>{ 
    try {
      return ( 
        <div className="App">
          <h1>Mis Clientes</h1>
        <table className="styled-table">
          <thead>
            <tr>
            <th>Id_Cliente</th>
              <th>Nombre</th>
              <th>Apellido</th>
              <th>Telefono</th>
            </tr>
          </thead>
          <tbody>
            {data.map((cliente) => (
              <tr li key={cliente.id_Cliente}>
                 <td>{cliente.id_Cliente}</td>
                <td>{cliente.nombre}</td>
                <td>{cliente.apellido}</td>
                <td>{cliente.telefono}</td>
              </tr>
            ))}
          </tbody> 
        </table>
        </div>
      );

    } catch (error) {
      console.error('Error al obtener datos:', error);
      return null;
    }
  };
  return (
    <div>
      <Suspense fallback={<p>Cargando...</p>}>
        <TablaDatos />
      </Suspense>
    </div>
  );
}

export default CrudCliente;