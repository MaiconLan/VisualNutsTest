package com.lanzendorf.maicon.visualnutstest.firstexercise;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FirstExerciceTest {

    @InjectMocks
    private FirstExercise firstExercise;


    @Test
    void shouldThrowIllegalArgumentExceptionWhenParametersAreNull() {
        assertThrows(IllegalArgumentException.class, () -> firstExercise.execute(null, 100));
        assertThrows(IllegalArgumentException.class, () -> firstExercise.execute(1, null));
    }

    @Test
    void shouldReturnNumber() {
        final var printingValue = firstExercise.getPrintingValue(1);

        assertEquals("1", printingValue);
    }

    @Test
    void shouldReturnVisual() {
        final var printingValue = firstExercise.getPrintingValue(3);

        assertEquals("Visual", printingValue);
    }

    @Test
    void shouldReturnNuts() {
        final var printingValue = firstExercise.getPrintingValue(5);

        assertEquals("Nuts", printingValue);
    }

    @Test
    void shouldReturnVisualNuts() {
        final var printingValue = firstExercise.getPrintingValue(15);

        assertEquals("Visual Nuts", printingValue);
    }

    @Test
    void shouldReturnTrue10Mod2Laves0() {
        final var result = firstExercise.mod(10, 2, 0);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalse7Mod2Leaves0() {
        final var result = firstExercise.mod(7, 2, 0);

        assertFalse(result);
    }

    @Test
    void shouldReturnTrue15Mod3Leaves0() {
        final var result = firstExercise.mod(15, 3, 0);

        assertTrue(result);
    }

}
