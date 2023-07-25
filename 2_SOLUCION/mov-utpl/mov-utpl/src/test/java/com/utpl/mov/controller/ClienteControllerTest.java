package com.utpl.mov.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Importamos Cliente y ClienteController
import com.utpl.model.Cliente;
import com.utpl.controller.ClientController;

class ClienteControllerTest {
    private ClientController controller;
    private Cliente testClient;

    @BeforeEach
    void setUp() {
        controller = new ClientController();
        testClient = new Cliente("1104645454", "Test Client", "Quito", "Pichincha", "Quito", "Samsung", "Galaxy S20", "0999999999", 50.00);
    }

    @Test
    void shouldCreateClient() {
        assertDoesNotThrow(() -> controller.addClient(testClient.getCedula(), testClient.getNombre(), testClient.getCiudad(), testClient.getProvincia(), testClient.getCanton(), testClient.getMarca(), testClient.getModelo(), testClient.getNumeroCelular(), testClient.getPagoMensual()));
    }

    @Test
    void shouldGetAllClients() {
        assertDoesNotThrow(() -> controller.getAllClients());
    }

    @Test
    void shouldUpdateClient() {
        assertDoesNotThrow(() -> controller.updateClient(testClient));
    }
    
    @Test
    void shouldDeleteClient() {
        assertDoesNotThrow(() -> controller.deleteClient(testClient));
    }
}
