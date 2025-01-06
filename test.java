package com.example;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class test {
    public static void main(String[] args) {
        PatientManagementSystem system = new PatientManagementSystem();
        LinkedList<Patient> patients = DataBase.getAllPatients();
        for (Node<Patient> node = patients.head; node != null; node = node.next) {
            Patient patient = node.data;
            system.readPatients(patient);
        }

        
        SwingUtilities.invokeLater(() -> new PatientManagementGUI(system));
    }

    public static void test(PatientManagementSystem system) {
        Scanner console = new Scanner(System.in);

        System.out.println("add patient or find patient or schedule appointment or cancel appointment or generate report or update contact info or add visit record");
        String choice = console.nextLine();
        if (choice.equalsIgnoreCase("add patient")) {
            system.addPatient();
        } else if (choice.equalsIgnoreCase("find patient")) {
            system.findPatient();
        } else if (choice.equalsIgnoreCase("schedule appointment")) {
            system.ScheduleAppointment();
        } else if (choice.equalsIgnoreCase("cancel appointment")) {
            system.cancelAppointment();
        } else if (choice.equalsIgnoreCase("generate report")) {
            system.generateReport();
        } else if (choice.equalsIgnoreCase("update contact info")) {
            system.updatePatientInfo();
        } else if (choice.equalsIgnoreCase("add visit record")) {
            system.addVisitRecords();   
        } else {
            System.out.println("enter valid choice");
        }
        System.out.println("make payment");
        String answer = console.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            system.makePayment();
            System.out.println("payment finished");
        } else {
            System.out.println("payment cancelled");
        }
        test(system);
    }
}

class PatientManagementGUI {
    public PatientManagementGUI(PatientManagementSystem system) {
        JFrame frame = new JFrame("Patient Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JButton addPatientButton = new JButton("Add Patient");
        addPatientButton.addActionListener(e -> system.addPatient());

        JButton findPatientButton = new JButton("Find Patient");
        findPatientButton.addActionListener(e -> system.findPatient());

        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        scheduleAppointmentButton.addActionListener(e -> system.ScheduleAppointment());

        JButton cancelAppointmentButton = new JButton("Cancel Appointment");
        cancelAppointmentButton.addActionListener(e -> system.cancelAppointment());

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.addActionListener(e -> system.generateReport());

        JButton updateContactInfoButton = new JButton("Update Contact Info");
        updateContactInfoButton.addActionListener(e -> system.updatePatientInfo());

        JButton addVisitRecordButton = new JButton("Add Visit Record");
        addVisitRecordButton.addActionListener(e -> system.addVisitRecords());

        JButton makePaymentButton = new JButton("Make Payment");
        makePaymentButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame, "Would you like to make a payment?", "Payment Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                system.makePayment();
                JOptionPane.showMessageDialog(frame, "Payment finished.");
            } else {
                JOptionPane.showMessageDialog(frame, "Payment cancelled.");
            }
        });

        panel.add(addPatientButton);
        panel.add(findPatientButton);
        panel.add(scheduleAppointmentButton);
        panel.add(cancelAppointmentButton);
        panel.add(generateReportButton);
        panel.add(updateContactInfoButton);
        panel.add(addVisitRecordButton);
        panel.add(makePaymentButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}