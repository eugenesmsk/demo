package com.example.demo;

import com.example.demo.unitexample.RandomSquareProducer;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomSquareProducerTest {

    private Random mockedRandom = mock(Random.class);

    private RandomSquareProducer producer = new RandomSquareProducer(mockedRandom);

    @Test
    public void testIsSquare() {
        when(mockedRandom.nextInt(anyInt())).thenReturn(3);
        assertEquals(9, producer.getNextSquare());
    }

}
