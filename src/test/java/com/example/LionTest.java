package com.example;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensWithoutParamsReturnsCorrectDefaultAmountOfKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        int expectedKittensAmount = 1;
        int actualKittensAmount = lion.getKittens();
        assertEquals("Returned kittens amount is not correct",
                expectedKittensAmount, actualKittensAmount);
    }

    @Test
    public void shouldThrowExceptionWithWrongSexValue() {
        Exception exception = assertThrows(Exception.class,
                () -> { Lion lion = new Lion("Львёнок", feline);
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();

        assertEquals("Exception message is incorrect",
                expectedMessage, actualMessage);
    }

    @Test
    public void getFoodReturnsPredatorsFoodTypes() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", feline);
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualListOfFood = lion.getFood();
        assertEquals("Food list is incorrect",
                expectedListOfFood, actualListOfFood);
    }
}