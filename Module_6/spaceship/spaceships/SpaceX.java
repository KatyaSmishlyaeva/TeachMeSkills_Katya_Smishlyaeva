package com.teachmeskills.homework6.spaceship.spaceships;

public class SpaceX implements IStart {

    @Override
    public boolean isSystemReady() {
        int randomValue = random.nextInt(21);
        boolean result = true;
        for (int i = 2; i < randomValue; i++) {
            if (randomValue % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void engineStart() {
        System.out.println("Двигатели SpaceX запущены.");
    }

    @Override
    public void start() {
        System.out.println("Старт SpaceX.");
    }
}
