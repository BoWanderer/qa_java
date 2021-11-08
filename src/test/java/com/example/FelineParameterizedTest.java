package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineParameterizedTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {15, 15}
        };
    }

    @Test
    public void getKittensParameterizedReturnsCorrectAmountOfKittens() {
        Feline feline = new Feline();
        int actualKittenCount = feline.getKittens(kittensCount);
        assertEquals("Amount of kittens is incorrect",
                expectedKittensCount, actualKittenCount);
    }
}
