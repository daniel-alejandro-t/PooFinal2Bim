package com.utpl.controller;

import java.sql.SQLException;
import java.util.List;

// Importamos el modelo
import com.utpl.model.PlanPostPagoMinutosMegas;
import com.utpl.model.dao.PlanPostPagoMinutosMegasDAO;

public class PlanPostPagoMinutosMegasController {
    private PlanPostPagoMinutosMegasDAO dao;

    public PlanPostPagoMinutosMegasController() {
        dao = new PlanPostPagoMinutosMegasDAO();
    }

    public void create(PlanPostPagoMinutosMegas plan) throws SQLException {
        dao.create(plan);
    }

    public List<PlanPostPagoMinutosMegas> findAll() throws SQLException {
        return dao.findAll();
    }

    public PlanPostPagoMinutosMegas findById(String id) throws SQLException {
        return dao.findById(id);
    }

    public void update(PlanPostPagoMinutosMegas plan) throws SQLException {
        dao.update(plan);
    }

    public void delete(PlanPostPagoMinutosMegas plan) throws SQLException {
        dao.delete(plan.getId());
    }

}
