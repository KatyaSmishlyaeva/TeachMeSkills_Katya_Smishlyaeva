package com.teachmeskills.homework6.spaceship.spaceships;

import java.util.Random;

public interface IStart {
    Random random = new Random();

    boolean isSystemReady();
    void engineStart();
    void start();
}
