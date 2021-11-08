package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnsCorrectListOfFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualListOfFood = feline.eatMeat();
        assertEquals("Food list is incorrect",
                expectedListOfFood, actualListOfFood);
    }

    @Test
    public void getFamilyReturnsCorrectFamilyName() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Returned family is not correct",
                expectedFamily, actualFamily);
    }

    @Test
    public void getKittensWithoutParamsReturnsCorrectDefaultAmountOfKittens() {
        Feline feline = new Feline();
        int expectedKittensAmount = 1;
        int actualKittensAmount = feline.getKittens();
        assertEquals("Returned kittens amount is not correct",
                expectedKittensAmount, actualKittensAmount);
    }
}