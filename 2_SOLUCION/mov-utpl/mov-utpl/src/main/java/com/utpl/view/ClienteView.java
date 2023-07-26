package com.utpl.view;

import java.util.List;
import java.util.Scanner;

import com.utpl.model.Cliente;

public class ClienteView {
    private Scanner scanner;

    public ClienteView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Solicita una entrada al usuario y devuelve la entrada del usuario como una cadena de texto.
     *
     * Este método imprime el mensaje solicitado y luego devuelve la línea siguiente
     * ingresada por el usuario desde la consola.
     *
     * @param prompt El mensaje que se mostrará al usuario antes de que introduzca la entrada.
     * @return String La línea de entrada proporcionada por el usuario.
     */
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    /**
     * Imprime los detalles de un cliente en la consola.
     *
     * Este método muestra la información detallada de un objeto Cliente, incluyendo
     * su nombre, cédula, ciudad, marca del celular, modelo del celular,
     * número de celular y el pago mensual. Cada detalle se imprime en una línea separada.
     *
     * @param cliente El objeto Cliente del cual se mostrarán los detalles.
     */
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

    /**
     * Imprime los detalles de una lista de clientes en la consola.
     *
     * Este método itera sobre una lista de objetos Cliente e invoca el método 
     * showClient() para cada uno de ellos para mostrar sus detalles.
     *
     * @param clientes La lista de objetos Cliente que se mostrarán.
     */
    public void showClients(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            showClient(cliente);
        }
    }

    /**
     * Imprime un mensaje de éxito en la consola.
     *
     * Este método se utiliza para indicar al usuario que una operación se ha 
     * completado con éxito. Prepende el término "Éxito: " al mensaje de entrada 
     * para indicar que es un mensaje de éxito.
     *
     * @param message El mensaje de éxito que se mostrará.
     */
    public void showSuccess(String message) {
        System.out.println("Éxito: " + message);
    }

    /**
     * Imprime un mensaje de error en la consola.
     *
     * Este método se utiliza para indicar al usuario que ha ocurrido un error. 
     * Prepende el término "Error: " al mensaje de entrada para indicar que es 
     * un mensaje de error.
     *
     * @param message El mensaje de error que se mostrará.
     */
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
