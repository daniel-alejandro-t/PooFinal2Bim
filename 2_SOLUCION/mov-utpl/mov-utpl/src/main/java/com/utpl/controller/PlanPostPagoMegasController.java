package com.utpl.controller;

import java.sql.SQLException;
import java.util.List;

// Importamos el modelo
import com.utpl.model.PlanPostPagoMegas;
import com.utpl.model.dao.PlanPostPagoMegasDAO;

public class PlanPostPagoMegasController {
    private PlanPostPagoMegasDAO dao;

    public PlanPostPagoMegasController() {
        dao = new PlanPostPagoMegasDAO();
    }

    public void create(PlanPostPagoMegas plan) throws SQLException {
        dao.create(plan);
    }

    public List<PlanPostPagoMegas> findAll() throws SQLException {
        return dao.findAll();
    }

    public PlanPostPagoMegas findById(String id) throws SQLException {
        return dao.findById(id);
    }

    public void update(PlanPostPagoMegas plan) throws SQLException {
        dao.update(plan);
    }

    public void delete(PlanPostPagoMegas plan) throws SQLException {
        dao.delete(plan.getId());
    }

}
