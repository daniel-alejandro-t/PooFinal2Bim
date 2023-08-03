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
import com.utpl.model.PlanPostPagoMinutosMegasEconomico;

public class PlanPostPagoMinutosMegasEconomicoDAO {

    /*
     * Obtiene todos los planes de la base de datos.
     */

    public void create(PlanPostPagoMinutosMegasEconomico plan) throws SQLException {
        String sql = "INSERT INTO PLANPOSTPAGOMINUTOSMEGASECONOMICO (id, minutos, costo_minutos, gigas, costo_por_giga, porcentaje_de_descuento) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getId());
            pstmt.setInt(2, plan.getMinutos());
            pstmt.setDouble(3, plan.getCostoPorMinuto());
            pstmt.setDouble(4, plan.getGigas());
            pstmt.setDouble(5, plan.getCostoPorGiga());
            pstmt.setDouble(6, plan.getPorcentajeDescuento());

            pstmt.executeUpdate();
        }
    }

    public List<PlanPostPagoMinutosMegasEconomico> findAll() throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMINUTOSMEGASECONOMICO";
        List<PlanPostPagoMinutosMegasEconomico> planes;

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            planes = new ArrayList<>();

            while (rs.next()) {
                PlanPostPagoMinutosMegasEconomico plan = new PlanPostPagoMinutosMegasEconomico(rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"), rs.getInt("minutos"), rs.getDouble("costoPorMinuto"),
                        rs.getDouble("gigas"), rs.getDouble("costoPorGiga"), rs.getDouble("porcentajeDescuento"));
                planes.add(plan);
            }
        }
        return planes;

    }

    public PlanPostPagoMinutosMegasEconomico findById(String id) throws SQLException {
        String sql = "SELECT * FROM PLANPOSTPAGOMINUTOSMEGASECONOMICO WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    PlanPostPagoMinutosMegasEconomico plan = new PlanPostPagoMinutosMegasEconomico(rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"), rs.getInt("minutos"), rs.getDouble("costoPorMinuto"),
                        rs.getDouble("gigas"), rs.getDouble("costoPorgiga"), rs.getDouble("porcentajeDescuento"));
                    return plan;
                }
            }
        }

        return null;
    }

    public void update(PlanPostPagoMinutosMegasEconomico plan) throws SQLException {
        String sql = "UPDATE PLANPOSTPAGOMINUTOSMEGASECONOMICO SET  id = ?,minutos = ?, costo_minutos = ?, gigas = ? , costo_por_giga = ?, porcentaje_de_descuento = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getId());
            pstmt.setInt(2, plan.getMinutos());
            pstmt.setDouble(3, plan.getCostoPorMinuto());
            pstmt.setDouble(4, plan.getGigas());
            pstmt.setDouble(5, plan.getCostoPorGiga());
            pstmt.setDouble(6, plan.getPorcentajeDescuento());
            pstmt.setString(7, plan.getId());
            pstmt.executeUpdate();
        }
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM PLANPOSTPAGOMINUTOSMEGASECONOMICO WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();
        }
    }

}