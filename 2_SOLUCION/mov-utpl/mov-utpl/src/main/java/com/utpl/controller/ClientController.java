import java.sql.SQLException;
import java.util.List;

// Importamos el modelo
import com.utpl.model.Cliente;

public class ClientController {
    private ClientDao clientDao;

    public ClientController() {
        this.clientDao = new ClientDao();
    }

    public Cliente addClient(String name, String passport, String city, String brand, String model, String cellNumber, double monthlyPayment) {
        Cliente client = new Cliente(name, passport, city, brand, model, cellNumber, monthlyPayment);
        try {
            clientDao.addClient(client);
        } catch (SQLException e) {
            System.out.println("Error al agregar el cliente: " + e.getMessage());
        }
        return client;
    }

    public List<Client> getAllClients() {
        try {
            return clientDao.getAllClients();
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;
        }
    }

    public void updateClient(Client client) {
        try {
            clientDao.updateClient(client);
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    public void deleteClient(Client client) {
        try {
            clientDao.deleteClient(client);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }
}
