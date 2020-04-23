package edu.iust.advancejava.java8newfeatures.interfacechanges;

import static edu.iust.advancejava.java8newfeatures.interfacechanges.StaticMethods.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticMethodsTest {

    @Test
    void testSum() {
        assertEquals(
                5,
                new StaticMethods().sum(3, 2));
    }

    @Test
    void testCube(){
        assertEquals(
                8,
                new StaticMethods().cube(2));
    }

    @Test
    void testSquare() {
        assertEquals(
                99,
                new StaticMethods().square(4));
    }

    @Test
    void testCallToInterfaceSquare() {
        assertEquals(
                16,
                new StaticMethods().callToInterfaceSquare(4));
    }
}