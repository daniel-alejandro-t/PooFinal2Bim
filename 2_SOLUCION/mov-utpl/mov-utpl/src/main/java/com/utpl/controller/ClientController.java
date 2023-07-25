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

    public Cliente addClient(String name, String passport, String city, String brand, String model, String cellNumber, double monthlyPayment) {
        Cliente client = new Cliente(name, passport, city, brand, model, cellNumber, monthlyPayment);
        try {
            clientDao.create(client);
        } catch (SQLException e) {
            System.out.println("Error al agregar el cliente: " + e.getMessage());
        }
        return client;
    }

    public List<Cliente> getAllClients() {
        try {
            return clientDao.findAll();
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;
        }
    }

    public void updateClient(Cliente client) {
        try {
            clientDao.updateClient(client);
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    public void deleteClient(Cliente client) {
        try {
            clientDao.deleteClient(client);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }
}
