package com.teachmeskills.homework4_computer;

import static com.teachmeskills.homework4_computer.Computer.CPU.*;

public class ComputerRunner {

    public static void main(String[] args) {
        Computer computer = new Computer("678");
        computer.setHdd(100);
        computer.setRam(4);
        computer.setCpu(INTEL_CORE);
        computer.printDescription();

        computer.turnOn();
        computer.printDescription();
        computer.turnOff();
        computer.printDescription();
    }

}
