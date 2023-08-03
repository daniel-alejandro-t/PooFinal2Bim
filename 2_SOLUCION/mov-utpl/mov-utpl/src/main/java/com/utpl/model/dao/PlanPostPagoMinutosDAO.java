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
import com.utpl.model.PlanPostPagoMinutos;

public class PlanPostPagoMinutosDAO {
    /*
     * Obtiene todos los planes de la base de datos.
     */

    public void create(PlanPostPagoMinutos plan) throws SQLException {
        String sql = "INSERT INTO PLANPOSTPAGOMINUTOS (id, minutos_nacionales, costo_minuto_nacional, minutos_internacionales, costo_minutos_internaciones) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getId());
            pstmt.setInt(2, plan.getMinutos_nacionales());
            pstmt.setDouble(3, plan.getCosto_minuto_nacional());
            pstmt.setInt(4, plan.getMinutos_internacionales());
            pstmt.setDouble(5, plan.getCosto_minuto_internacional());

            pstmt.executeUpdate();
        }
    }

    public List<PlanPostPagoMinutos> findAll() throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMINUTOS";
        List<PlanPostPagoMinutos> planes;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            planes = new ArrayList<>();

            while (rs.next()) {
                PlanPostPagoMinutos plan = new PlanPostPagoMinutos(rs.getString("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("minutos_nacionales"), rs.getInt("minutos_internacionales"), rs.getDouble("costo_minuto_nacional"), rs.getDouble("costo_minuto_internacional"));
                planes.add(plan);
            }
        }

        return planes;
    }

    public PlanPostPagoMinutos findById(String id) throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMINUTOS WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    PlanPostPagoMinutos plan = new PlanPostPagoMinutos(rs.getString("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("minutos_nacionales"), rs.getInt("minutos_internacionales"), rs.getDouble("costo_minuto_nacional"), rs.getDouble("costo_minuto_internacional"));
                    return plan;
                }
            }
        }

        return null;
    }

    public void update(PlanPostPagoMinutos plan) throws SQLException {
        String sql = "UPDATE PLANPOSTPAGOMINUTOS SET nombre = ?, precio = ?, minutos_nacionales = ?, minutos_internacionales = ?, costo_minuto_nacional = ? , costo_minuto_internacional = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getNombre());
            pstmt.setDouble(2, plan.getPrecio());
            pstmt.setDouble(3, plan.getMinutos_nacionales());
            pstmt.setDouble(4, plan.getMinutos_internacionales());
            pstmt.setDouble(5, plan.getCosto_minuto_nacional());
            pstmt.setDouble(6, plan.getCosto_minuto_internacional());
            pstmt.setString(7, plan.getId());

            pstmt.executeUpdate();
        }
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM PLANPOSTPAGOMINUTOS WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();
        }
    }

}