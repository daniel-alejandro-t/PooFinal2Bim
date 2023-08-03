package com.utpl.mov.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Importamos PlanPostPagoMinutosMegasEconomico y PlanPostPagoMinutosMegasEconomicoController
import com.utpl.model.PlanPostPagoMinutosMegasEconomico;
import com.utpl.controller.PlanPostPagoMinutosMegasEconomicoController;

public class PlanPostPagoMinutosMegasEconomicoTest {
    private PlanPostPagoMinutosMegasEconomicoController controller;
    private PlanPostPagoMinutosMegasEconomico testPlan;

    @BeforeEach
    void setUp() {
        controller = new PlanPostPagoMinutosMegasEconomicoController();
        testPlan = new PlanPostPagoMinutosMegasEconomico("1", "Plan 1", 1, 2, 3, 4, 5, 6);
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
