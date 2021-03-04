package com.teachmeskills.homework12;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class PatientsThread implements Runnable {

    private final Queue<Patient> patients;
    private final BlockingQueue<Doctor> doctors;

    public PatientsThread(Queue<Patient> patients, BlockingQueue<Doctor> doctors) {
        this.patients = patients;
        this.doctors = doctors;
    }

    @Override
    public void run() {
        try {
            Patient patient = patients.remove();
            Doctor doctor = doctors.take();
            System.out.println(patient + " обслуживается у доктора " + doctor);
            Thread.sleep(1000);
            System.out.println("Доктор " + doctor + " свободен");
            doctors.add(doctor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
