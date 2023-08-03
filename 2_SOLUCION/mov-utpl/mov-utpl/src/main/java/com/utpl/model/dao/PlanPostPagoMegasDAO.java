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
import com.utpl.model.PlanPostPagoMegas;

public class PlanPostPagoMegasDAO {
    /*
     * Obtiene todos los planes de la base de datos.
     */

    
    public void create(PlanPostPagoMegas plan) throws SQLException {
        String sql = "INSERT INTO PLANPOSTPAGOMEGAS (id, gigas, costo_por_giga, tarifa_base)VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getId());
            pstmt.setDouble(2, plan.getGigas());
            pstmt.setDouble(3, plan.getCostoPorGiga());
            pstmt.setDouble(4, plan.getTarifaBase());

            pstmt.executeUpdate();
        }
    }
  
    public List<PlanPostPagoMegas> findAll() throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMEGAS";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            List<PlanPostPagoMegas> planes = new ArrayList<>();

            while (rs.next()) {
                PlanPostPagoMegas plan = new PlanPostPagoMegas(rs.getString("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getDouble("gigas"), rs.getDouble("costo_por_giga"), rs.getDouble("tarifa_base"));
                planes.add(plan);
            }

            return planes;
        }
    }

    public PlanPostPagoMegas findById(String id) throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMEGAS WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    PlanPostPagoMegas plan = new PlanPostPagoMegas(rs.getString("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getDouble("gigas"), rs.getDouble("costo_por_giga"), rs.getDouble("tarifa_base"));
                    return plan;
                }
            }
        }

        return null;
    }

    public void update(PlanPostPagoMegas plan) throws SQLException {
        String sql = "UPDATE PLANPOSTPAGOMEGAS SET id = ?, gigas = ?, costo_por_giga = ?, tarifa_base = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getId());
            pstmt.setDouble(2, plan.getGigas());
            pstmt.setDouble(3, plan.getCostoPorGiga());
            pstmt.setDouble(4, plan.getTarifaBase());
            pstmt.setString(5, plan.getId());

            pstmt.executeUpdate();
        }
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM PLANPOSTPAGOMEGAS WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();
        }
    }

}