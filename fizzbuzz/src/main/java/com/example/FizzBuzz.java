package com.example;

/**
 * FizzBuzz
 */
public class FizzBuzz {
    private static int FIZZ_VALUE = 3;
    private static int BUZZ_VALUE = 5;
    private static String FIZZ = "Fizz";
    private static String BUZZ = "Buzz";
    private static String FIZZBUZZ = FIZZ + BUZZ;

    public static String of(int value) {
        if (isFizzBuzz(value)) {
            return FIZZBUZZ;
        }

        if (isFizz(value)) {
            return FIZZ;
        }

        if (isBuzz(value)) {
            return BUZZ;
        }

        return String.valueOf(value);
    }

    private static boolean isFizz(int value) {
        return value % FIZZ_VALUE == 0;
    }

    private static boolean isBuzz(int value) {
        return value % BUZZ_VALUE == 0;
    }

    private static boolean isFizzBuzz(int value) {
        return isFizz(value) && isBuzz(value);
    }
}
