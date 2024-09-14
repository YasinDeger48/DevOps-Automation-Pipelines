package com.devops.unitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {


    @DisplayName("Unit Test 1")
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @DisplayName("Unit Test 2")
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(5, 3);
        assertEquals(2, result);
    }


}
