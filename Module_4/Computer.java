package com.teachmeskills.homework4_computer;

import java.util.Random;
import java.util.Scanner;

/**
 * Создать класс компьютер.
 * Поля: - процессор - оперативка - жесткий диск - ресурс полных циклов работы (включений/выключений)
 * Методы: - метод описание(вывод всех полей)
 * - метод включить, при включении может произойти сбой,
 * - при вывзове метода рандом загадывает число (0 либо 1),
 * вы вводите число с клавиатуры, если угадали комп выключается, если нет сгорает.
 * Если комп сгорел, при попытке включить нужно выдать сообщение что ему конец
 * - выключить (аналогично включению)
 * - при превышении лимита ресурса комп сгорает
 */
public class Computer {

    private String id;
    private String cpu;
    private int ram;
    private int hdd;
    private FullWorkingCycles fullWorkingCycles;
    private boolean isOn = false;
    private int workingCycles = 8;


    public Computer(String id) {
        this.id = id;
        fullWorkingCycles = new FullWorkingCycles();
    }

    public void printDescription() {
        System.out.println("Computer: id = " + id + ", " +
                "ram = " + ram + ", hdd = " + hdd +
                ", cpu = " + cpu + ", isOn = " + isOn +
                ", workingCycles = " + workingCycles);
    }

    public void turnOn() {
        if ((cpu != null || ram != 0 || hdd != 0) && workingCycles > 0 && !isOn) {
            if (!fullWorkingCycles.random()) {
                fullWorkingCycles.crash();
            } else {
                System.out.println("Компьютер включен!");
                workingCycles--;
                isOn = true;
            }
        }
    }

    public void turnOff() {
        if (isOn) {
            if (!fullWorkingCycles.random()) {
                fullWorkingCycles.crash();
            } else {
                isOn = false;
                System.out.println("Компьютер выключен!");
            }
        } else {
            System.out.println("Компьютер не включен.");
        }
    }

    public void setCpu(String cpu) {
        for (String newCpu : CPU.cpuList) {
            if (newCpu == cpu) {
                this.cpu = cpu;
                workingCycles = fullWorkingCycles.lifeCycles(cpu);
                break;
            }
        }
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public class FullWorkingCycles {

        private int lifeCycles(String cpu) {
            switch (cpu) {
                case (CPU.INTEL_CORE):
                    return 5;
                case (CPU.INTEL_PENTIUM):
                    return 4;
                case (CPU.AMD):
                    return 3;
                case (CPU.RYZEN):
                    return 2;
                default:
                    return 0;
            }
        }

        private boolean random() {
            Random random = new Random();
            return (random.nextInt(2) == inputNumber());
        }

        private int inputNumber() {
            Scanner scanner = new Scanner(System.in);
            int result;
            while (true) {
                System.out.println("Введите число 0 или 1");
                result = scanner.nextInt();
                if (result == 0 || result == 1) {
                    break;
                }
            }
            return result;
        }

        private void crash() {
            workingCycles = 0;
            isOn = false;
            System.out.println("Компьютер сгорел!");
        }
    }

    public static class CPU {

        public final static String INTEL_CORE = "INTEL_CORE";
        public final static String INTEL_PENTIUM = "INTEL_PENTIUM";
        public final static String AMD = "AMD";
        public final static String RYZEN = "RYZEN";

        public static String[] cpuList = new String[]{INTEL_CORE, INTEL_PENTIUM, AMD, RYZEN};
    }
}
