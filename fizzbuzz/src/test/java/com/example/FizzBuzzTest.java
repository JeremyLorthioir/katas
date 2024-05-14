package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple FizzBuzz.
 */
class FizzBuzzTest {

    @Test
    void shouldGetOneForOne() {
        assertEquals("1", FizzBuzz.of(1));
    }

    @Test
    void shouldGetFizzForThree() {
        assertEquals("Fizz", FizzBuzz.of(3));
    }

    @Test
    void shouldGetFizzForSix() {
        assertEquals("Fizz", FizzBuzz.of(6));
    }

    @Test
    void shouldGetBuzzForFive() {
        assertEquals("Buzz", FizzBuzz.of(5));
    }

    @Test
    void shouldGetBuzzForTen() {
        assertEquals("Buzz", FizzBuzz.of(10));
    }

    @Test
    void shouldGetFizzBuzzForFifteen() {
        assertEquals("FizzBuzz", FizzBuzz.of(15));
    }
}
