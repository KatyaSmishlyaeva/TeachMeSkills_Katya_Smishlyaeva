package com.teachmeskills.homework12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Hospital {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Doctor> doctors = new ArrayBlockingQueue<>(3, true, List.of(new Doctor("Petrov"), new Doctor("Sidorov"), new Doctor("Ivanov")));
        Queue<Patient> patients = new ArrayDeque<>();
        for (int i = 1; i <= 20; i++) {
            patients.add(new Patient(i));
        }

        List<PatientsThread> patientThreads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            patientThreads.add(new PatientsThread(patients, doctors));
        }

        List<Thread> threads = patientThreads.stream()
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        long startTime = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.join();
        }
        long finishTime = System.currentTimeMillis();

        System.out.println("result time: " + (finishTime - startTime));
    }
}
