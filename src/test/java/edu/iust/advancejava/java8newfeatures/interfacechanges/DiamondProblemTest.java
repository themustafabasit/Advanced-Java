package edu.iust.advancejava.java8newfeatures.interfacechanges;

import org.junit.jupiter.api.Test;
import static  edu.iust.advancejava.java8newfeatures.interfacechanges.DiamondProblem.*;


import static org.junit.jupiter.api.Assertions.*;

class DiamondProblemTest {

    @Test
    void testMethod1() {
        assertEquals(
                "method1()",
                new DiamondProblem().method1());
    }

    @Test
    void testMethod2() {
        assertEquals(
                "method2()",
                new DiamondProblem().method2());
    }

    @Test
    void testLog() {
        String logMessage = "CRITICAL:root:This is a critical message";

        assertEquals(
                "Overridden Extension Method log() logging:: " + logMessage,
                new DiamondProblem().log(logMessage));
    }
}