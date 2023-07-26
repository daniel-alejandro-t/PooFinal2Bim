package com.utpl.controller;

import java.sql.SQLException;
import java.util.List;

// Importamos el modelo
import com.utpl.model.Cliente;
import com.utpl.model.dao.ClientDao;

public class ClientController {
    private ClientDao clientDao;

    public ClientController() {
        this.clientDao = new ClientDao();
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * Este método crea un nuevo objeto Cliente con los parámetros dados y llama al método create de ClientDao 
     * para agregar el nuevo cliente a la base de datos. Si se produce algún error durante la inserción, 
     * se imprime un mensaje de error en la consola.
     *
     * @param cedula la cédula del nuevo cliente.
     * @param nombres los nombres del nuevo cliente.
     * @param ciudad la ciudad del nuevo cliente.
     * @param provincia la provincia del nuevo cliente.
     * @param canton el cantón del nuevo cliente.
     * @param marca la marca del celular del nuevo cliente.
     * @param modelo el modelo del celular del nuevo cliente.
     * @param numeroCelular el número de celular del nuevo cliente.
     * @param pagoMensual el pago mensual del nuevo cliente.
     * 
     * @return Retorna un objeto Cliente que representa al cliente que se acaba de agregar a la base de datos.
     */
    public Cliente addClient(String cedula, String nombres, String ciudad, String provincia, String canton, String marca, String modelo, String numeroCelular, double pagoMensual) {
        Cliente client = new Cliente(cedula, nombres, ciudad, provincia, canton, marca, modelo, numeroCelular, pagoMensual);
        try {
            clientDao.create(client);
        } catch (SQLException e) {
            System.out.println("Error al agregar el cliente: " + e.getMessage());
        }
        return client;
    }

    /**
     * Obtiene todos los clientes de la base de datos.
     *
     * Este método llama al método findAll de ClientDao para obtener todos los clientes de la base de datos.
     * Si se produce algún error durante la obtención de los clientes, se imprime un mensaje de error en la consola.
     *
     * @return Una lista de objetos Cliente que contiene todos los clientes de la base de datos.
     */
    public List<Cliente> getAllClients() {
        try {
            return clientDao.findAll();
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;
        }
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     *
     * Este método invoca el método updateClient de ClientDao para actualizar los detalles 
     * de un cliente en la base de datos. Si ocurre algún error durante el proceso, 
     * se imprime un mensaje de error en la consola.
     *
     * @param client Objeto Cliente con los datos actualizados.
     */
    public void updateClient(Cliente client) {
        try {
            clientDao.updateClient(client);
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    /**
     * Elimina un cliente de la base de datos.
     *
     * Este método invoca el método deleteClient de ClientDao para eliminar a un cliente
     * de la base de datos. Si ocurre algún error durante el proceso, se imprime un 
     * mensaje de error en la consola.
     *
     * @param client Objeto Cliente que se desea eliminar.
     */
    public void deleteClient(Cliente client) {
        try {
            clientDao.deleteClient(client);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }
}
