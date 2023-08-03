package com.utpl.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Importamos DBUtil
import com.util.DBUtil;

//Importamos el modelo
import com.utpl.model.PlanPostPagoMinutosMegas;

public class PlanPostPagoMinutosMegasDAO {

    /*
     * Obtiene todos los planes de la base de datos.
     */

    public void create(PlanPostPagoMinutosMegas plan) throws SQLException {
        String sql = "INSERT INTO PLANPOSTPAGOMINUTOSMEGAS (id, minutos, costo_minutos, gigas, costo_por_giga) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getId());
            pstmt.setInt(2, plan.getMinutos());
            pstmt.setDouble(3, plan.getCosto_minutos());
            pstmt.setDouble(4, plan.getGigas());
            pstmt.setDouble(5, plan.getCosto_por_gigas());

            pstmt.executeUpdate();
        }
    }

    public List<PlanPostPagoMinutosMegas> findAll() throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMINUTOSMEGAS";
        List<PlanPostPagoMinutosMegas> planes;

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            planes = new ArrayList<>();

            while (rs.next()) {
                PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(rs.getString("id"), rs.getString("nombre"),
                        rs.getDouble("precio"), rs.getInt("minutos"), rs.getDouble("costo_minutos"),
                        rs.getDouble("gigas"), rs.getDouble("costo_por_gigas"));
                planes.add(plan);
            }
        }
        return planes;

    }

    public PlanPostPagoMinutosMegas findById(String id) throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMINUTOSMEGAS WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(rs.getString("id"), rs.getString("nombre"),
                        rs.getDouble("precio"), rs.getInt("minutos"), rs.getDouble("costo_minutos"),
                        rs.getDouble("gigas"), rs.getDouble("costo_por_gigas"));
                    return plan;
                }
            }
        }

        return null;
    }

    public void update(PlanPostPagoMinutosMegas plan) throws SQLException {
        String sql = "UPDATE PLANPOSTPAGOMINUTOSMEGAS SET id = ?, minutos = ?, costo_minutos = ?, gigas = ?, costo_por_giga = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getId());
            pstmt.setInt(2, plan.getMinutos());
            pstmt.setDouble(3, plan.getCosto_minutos());
            pstmt.setDouble(4, plan.getGigas());
            pstmt.setDouble(5, plan.getCosto_por_gigas());
            pstmt.setString(6, plan.getId());

            pstmt.executeUpdate();
        }
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM PLANPOSTPAGOMINUTOSMEGAS WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();
        }
    }

}