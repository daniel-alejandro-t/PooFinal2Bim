package com.utpl.mov.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Importamos Cliente y ClienteController
import com.utpl.model.Cliente;
import com.utpl.model.PlanPostPagoMegas;
import com.utpl.controller.ClientController;
import com.utpl.controller.PlanPostPagoMegasController;

public class PlanPostPagoMegasControllerTest {
    private PlanPostPagoMegasController controller;
    private PlanPostPagoMegas testPlan;
    
    @BeforeEach
    void setUp() {
        controller = new PlanPostPagoMegasController();
        testPlan = new PlanPostPagoMegas("1", "", 10, 10, 10, 0);
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
