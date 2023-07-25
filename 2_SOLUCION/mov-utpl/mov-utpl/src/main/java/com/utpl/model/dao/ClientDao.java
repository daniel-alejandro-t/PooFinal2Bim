package com.utpl.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Importamos DBUtil
import com.util.DBUtil;

// Importamos los modelos
import com.utpl.model.Cliente;

public class ClientDao {

    /**
     * Crea un nuevo registro de cliente en la base de datos utilizando el objeto Cliente proporcionado.
     * 
     * Este método crea una consulta SQL para insertar un nuevo registro en la tabla de clientes, estableciendo 
     * los valores de cada columna en base a las propiedades del objeto Cliente. 
     * Después, se prepara y se ejecuta la declaración, utilizando una conexión a la base de datos obtenida 
     * desde DBUtil.
     *
     * @param cliente El objeto Cliente que contiene la información del cliente que se va a almacenar en la base de datos.
     * @throws SQLException Si ocurre un error al intentar ejecutar la declaración SQL.
     */
    public void create(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, pasaporte, ciudad, marca, modelo, numeroCelular, pagoMensual) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getPasaporte());
            pstmt.setString(3, cliente.getCiudad());
            pstmt.setString(4, cliente.getMarca());
            pstmt.setString(5, cliente.getModelo());
            pstmt.setString(6, cliente.getNumeroCelular());
            pstmt.setDouble(7, cliente.getPagoMensual());

            pstmt.executeUpdate();
        }
    }
    
    /**
     * Este método se utiliza para crear un nuevo cliente en la base de datos.
     *
     * @param cliente El objeto Cliente que contiene la información del cliente a ser creado.
     * @throws SQLException Si ocurre un error durante la ejecución de la declaración SQL.
     */
    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre"));
                cliente.setPasaporte(rs.getString("pasaporte"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setMarca(rs.getString("marca"));
                cliente.setModelo(rs.getString("modelo"));
                cliente.setNumeroCelular(rs.getString("numeroCelular"));
                cliente.setPagoMensual(rs.getDouble("pagoMensual"));

                clientes.add(cliente);
            }
        }

        return clientes;
    }

    // Implementación de updateClient
    public void updateClient(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, pasaporte = ?, ciudad = ?, marca = ?, modelo = ?, numeroCelular = ?, pagoMensual = ? WHERE pasaporte = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getPasaporte());
            pstmt.setString(3, cliente.getCiudad());
            pstmt.setString(4, cliente.getMarca());
            pstmt.setString(5, cliente.getModelo());
            pstmt.setString(6, cliente.getNumeroCelular());
            pstmt.setDouble(7, cliente.getPagoMensual());
            pstmt.setString(8, cliente.getPasaporte());

            pstmt.executeUpdate();
        }
    }

    // Implementación de deleteClient
    public void deleteClient(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM clientes WHERE pasaporte = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getPasaporte());

            pstmt.executeUpdate();
        }
    }
}
