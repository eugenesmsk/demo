package com.example.demo.unitexample;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class RandomSquareProducer {

    private final Random random;

    public int getNextSquare() {
        int value = random.nextInt(10);
        return value * value;
    }

}
