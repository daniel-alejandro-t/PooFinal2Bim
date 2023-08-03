package com.utpl.mov.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Importamos Cliente y ClienteController
import com.utpl.model.PlanPostPagoMegas;
import com.utpl.controller.PlanPostPagoMegasController;

public class PlanPostPagoMegasMinutosController {
    private PlanPostPagoMegasController controller;
    private PlanPostPagoMegas testPlan;

    @BeforeEach
    void setUp() {
        controller = new PlanPostPagoMegasController();
        testPlan = new PlanPostPagoMegas("1", "f", 1, 10.00, 10.00, 10.00);
    }

    @Test
    void shouldCreatePlan() {
        assertDoesNotThrow(() -> controller.create(testPlan));
    }

    @Test
    void shouldGetAllPlans() {
        assertDoesNotThrow(() -> controller.findAll());
    }

    @Test
    void shouldUpdatePlan() {
        assertDoesNotThrow(() -> controller.update(testPlan));
    }

    @Test
    void shouldDeletePlan() {
        assertDoesNotThrow(() -> controller.delete(testPlan));
    }

}
