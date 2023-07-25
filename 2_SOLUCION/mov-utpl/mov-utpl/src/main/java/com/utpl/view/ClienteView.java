package com.utpl.view;

import java.util.List;
import java.util.Scanner;

import com.utpl.model.Cliente;

public class ClienteView {
    private Scanner scanner;

    public ClienteView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public void showClient(Cliente cliente) {
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Cédula: " + cliente.getCedula());
        System.out.println("Ciudad: " + cliente.getCiudad());
        System.out.println("Marca: " + cliente.getMarca());
        System.out.println("Modelo: " + cliente.getModelo());
        System.out.println("Número de celular: " + cliente.getNumeroCelular());
        System.out.println("Pago mensual: " + cliente.getPagoMensual());
        System.out.println("------------------------------------");
    }

    public void showClients(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            showClient(cliente);
        }
    }

    public void showSuccess(String message) {
        System.out.println("Éxito: " + message);
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
