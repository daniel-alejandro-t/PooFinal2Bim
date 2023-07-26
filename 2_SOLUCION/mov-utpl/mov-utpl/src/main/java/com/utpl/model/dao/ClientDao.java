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
     * Crea un nuevo cliente en la base de datos.
     *
     * Este método toma un objeto Cliente como entrada y extrae sus datos para insertar un nuevo registro 
     * en la base de datos utilizando una sentencia SQL INSERT. 
     * Los datos del cliente se insertan en las columnas correspondientes en la tabla CLIENT.
     *
     * @param cliente Objeto Cliente que contiene los datos del nuevo cliente a insertar. 
     *        Los atributos de Cliente son mapeados a las columnas en la tabla CLIENT de la base de datos.
     * 
     * @throws SQLException Si ocurre algún error durante la ejecución de la sentencia SQL, 
     *         se lanza una excepción de tipo SQLException.
     */
    public void create(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO CLIENT (cedula, nombres, ciudad, marca, modelo, numero_de_celular, pago_mensual) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getCedula());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getCiudad());
            pstmt.setString(4, cliente.getMarca());
            pstmt.setString(5, cliente.getModelo());
            pstmt.setString(6, cliente.getNumeroCelular());
            pstmt.setDouble(7, cliente.getPagoMensual());

            pstmt.executeUpdate();
        }
    }
    
    /**
     * Obtiene todos los clientes de la base de datos.
     *
     * Este método ejecuta una sentencia SQL SELECT para obtener todos los registros de la tabla CLIENT.
     * Los datos de cada registro se mapean a un objeto Cliente y se agregan a una lista de clientes.
     *
     * @return Una lista de objetos Cliente que contiene todos los clientes de la base de datos.
     * 
     * @throws SQLException Si ocurre algún error durante la ejecución de la sentencia SQL, 
     *         se lanza una excepción de tipo SQLException.
     */
    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENT";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombres"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setMarca(rs.getString("marca"));
                cliente.setModelo(rs.getString("modelo"));
                cliente.setNumeroCelular(rs.getString("numero_de_celular"));
                cliente.setPagoMensual(rs.getDouble("pago_mensual"));

                clientes.add(cliente);
            }
        }

        return clientes;
    }

    /**
    * Actualiza los datos de un cliente en la base de datos.
    *
    * Este método toma un objeto Cliente como entrada y extrae sus datos para actualizar un registro 
    * en la base de datos utilizando una sentencia SQL UPDATE. 
    * Los datos del cliente se actualizan en las columnas correspondientes en la tabla CLIENT.
    *
    * @param cliente Objeto Cliente que contiene los datos del cliente a actualizar. 
    *        Los atributos de Cliente son mapeados a las columnas en la tabla CLIENT de la base de datos.
    * 
    * @throws SQLException Si ocurre algún error durante la ejecución de la sentencia SQL, 
    *         se lanza una excepción de tipo SQLException.
    */
    public void updateClient(Cliente cliente) throws SQLException {
        String sql = "UPDATE CLIENT SET cedula = ?, nombres = ?, ciudad = ?, marca = ?, modelo = ?, numero_de_celular = ?, pago_mensual = ? WHERE cedula = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getCedula());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getCiudad());
            pstmt.setString(4, cliente.getMarca());
            pstmt.setString(5, cliente.getModelo());
            pstmt.setString(6, cliente.getNumeroCelular());
            pstmt.setDouble(7, cliente.getPagoMensual());
            pstmt.setString(8, cliente.getCedula());

            pstmt.executeUpdate();
        }
    }

    /**
     * Elimina un cliente de la base de datos.
     *
     * Este método ejecuta una sentencia SQL de eliminación (DELETE) que se basa en el número de cédula del cliente proporcionado.
     * El cliente se elimina de la tabla CLIENT en la base de datos.
     *
     * @param cliente el objeto Cliente a eliminar de la base de datos. La cédula del cliente se utiliza como criterio para la eliminación.
     * 
     * @throws SQLException Si ocurre algún error durante la ejecución de la sentencia SQL, 
     *         se lanza una excepción de tipo SQLException.
     */
    public void deleteClient(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM CLIENT WHERE cedula = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getCedula());

            pstmt.executeUpdate();
        }
    }
}
