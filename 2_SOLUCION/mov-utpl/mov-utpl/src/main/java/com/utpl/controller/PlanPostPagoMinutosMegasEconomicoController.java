package com.utpl.controller;

import java.sql.SQLException;
import java.util.List;

// Importamos el modelo
import com.utpl.model.PlanPostPagoMinutosMegasEconomico;
import com.utpl.model.dao.PlanPostPagoMinutosMegasEconomicoDAO;

public class PlanPostPagoMinutosMegasEconomicoController {
    private PlanPostPagoMinutosMegasEconomicoDAO dao;

    public PlanPostPagoMinutosMegasEconomicoController() {
        dao = new PlanPostPagoMinutosMegasEconomicoDAO();
    }

    public void create(PlanPostPagoMinutosMegasEconomico plan) throws SQLException {
        dao.create(plan);
    }

    public List<PlanPostPagoMinutosMegasEconomico> findAll() throws SQLException {
        return dao.findAll();
    }

    public PlanPostPagoMinutosMegasEconomico findById(String id) throws SQLException {
        return dao.findById(id);
    }

    public void update(PlanPostPagoMinutosMegasEconomico plan) throws SQLException {
        dao.update(plan);
    }

    public void delete(PlanPostPagoMinutosMegasEconomico plan) throws SQLException {
        dao.delete(plan.getId());
    }

}
