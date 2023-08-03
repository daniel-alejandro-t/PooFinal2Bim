package com.utpl.mov.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Importamos PlanPostPagoMinutosMegas y PlanPostPagoMinutosMegasController
import com.utpl.model.PlanPostPagoMinutosMegas;
import com.utpl.controller.PlanPostPagoMinutosMegasController;

public class PlanPostPagoMinutosMegasTest {
    private PlanPostPagoMinutosMegasController controller;
    private PlanPostPagoMinutosMegas testPlan;

    @BeforeEach
    void setUp() {
        controller = new PlanPostPagoMinutosMegasController();
        testPlan = new PlanPostPagoMinutosMegas("1", "Plan 1", 1, 2, 3, 4, 5);
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
