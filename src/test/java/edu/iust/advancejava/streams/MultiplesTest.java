package edu.iust.advancejava.streams;

import org.junit.jupiter.api.Test;

import static edu.iust.advancejava.streams.Multiples.*;
import static  java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MultiplesTest {
    @Test
    void testMultiplesOf5() {
        assertEquals(
                Stream.of(15, 30, 5).collect(toList()),
                multiplesOf5(Stream.of(1, 15, 22, 30, 1, 5)).collect(toList()));
    }

    @Test
    void testMultiplesOfN() {
        assertEquals(
                Stream.of(20, 2, 4, 6, 8).collect(toList()),
                multiplesOfN(Stream.of(20, 1, 2, 3, 4, 5, 6, 7, 8), 2).collect(toList())
        );
    }

    @Test
    void testSumOfMultiplesOfN() {
        assertEquals(
                Integer.valueOf(50),
                sumOfMultiplesOfN(Stream.of(3, 5, 30, 2, 10, 5), 5)
        );
    }

    @Test
    void testFactorsViaInefficientWay() {
        assertEquals(IntStream.of(1, 2, 5, 10).boxed().collect(toList()),
                factorsViaInefficientWay(10).boxed().collect(toList()));

    }

    @Test
    void testFactors() {
        assertEquals(IntStream.of(1, 2, 5, 10).boxed().collect(toList()),
                factors(10).boxed().collect(toList()));

    }

    @Test
    void testIsPrime() {
        assertTrue(isPrime(3));
        assertFalse(isPrime(10));
        assertFalse(isPrime(0));
        assertFalse(isPrime(1));
    }

    @Test
    void testFinitePrimeSeries() {
        assertEquals(
                IntStream.of(2, 3, 5, 7).boxed().collect(toSet()),
                finitePrimeSeries(10).boxed().collect(toSet())
        );

    }

    @Test
    void testInfinitePrimeSeries() {
        assertEquals(
                IntStream.of(2, 3, 5).boxed().collect(toSet()),
                infinitePrimeSeries().limit(3).boxed().collect(toSet()));
    }
}