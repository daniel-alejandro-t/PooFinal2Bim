package com.utpl.controller;

import java.sql.SQLException;
import java.util.List;

// Importamos el modelo
import com.utpl.model.PlanPostPagoMinutos;
import com.utpl.model.dao.PlanPostPagoMinutosDAO;

public class PlanPostPagoMinutosController {
    private PlanPostPagoMinutosDAO dao;

    public PlanPostPagoMinutosController() {
        dao = new PlanPostPagoMinutosDAO();
    }

    public void create(PlanPostPagoMinutos plan) throws SQLException {
        dao.create(plan);
    }

    public List<PlanPostPagoMinutos> findAll() throws SQLException {
        return dao.findAll();
    }

    public PlanPostPagoMinutos findById(String id) throws SQLException {
        return dao.findById(id);
    }

    public void update(PlanPostPagoMinutos plan) throws SQLException {
        dao.update(plan);
    }

    public void delete(PlanPostPagoMinutos plan) throws SQLException {
        dao.delete(plan.getId());
    }

}
