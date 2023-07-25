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

    public void deleteClient(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM CLIENT WHERE cedula = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getCedula());

            pstmt.executeUpdate();
        }
    }
}
