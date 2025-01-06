package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Appointment {
    private String appointmentID;
    private String Patient;
    private String Date;
    private String Time;
    private String Status;
    private String PatientCondition;

    public String getPatientCondition() {
        return PatientCondition;
    }

    public void setPatientCondition(String patientCondition) {
        PatientCondition = patientCondition;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatient() {
        return Patient;
    }

    public void setPatient(String patient) {
        this.Patient = patient;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public Appointment(String ID, String patient, String date, String time, String status, String condition) {
        appointmentID = ID;
        Patient = patient;
        Date = date;
        Time = time;
        Status = status;
        PatientCondition = condition;
    }

    public void ScheduleAppointment(String id, String date, String time, String condition) {
        setAppointmentID(id);
        setPatientCondition(condition);
        setDate(date);
        setTime(time);
        setStatus("Scheduled");
    }

    public void CancelAppointment(String appointmentId) {
        appointmentID = null;
        Patient = null;
        Date = null;
        Time = null;
        Status = "Cancelled";
    }

    public void RescheduleAppointment(String newDate, String newTime) {
        setDate(newDate);
        setTime(newTime);
        setStatus("Rescheduled");
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Appointment Services");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 200);
        mainFrame.setLayout(new GridLayout(4, 1, 5, 5));

        JLabel titleLabel = new JLabel("Choose a Service", SwingConstants.CENTER);
        JButton scheduleButton = new JButton("Schedule Appointment");
        JButton cancelButton = new JButton("Cancel Appointment");
        JButton rescheduleButton = new JButton("Reschedule Appointment");

        mainFrame.add(titleLabel);
        mainFrame.add(scheduleButton);
        mainFrame.add(cancelButton);
        mainFrame.add(rescheduleButton);

        Appointment appointment = new Appointment("", "", "", "", "", "");

        scheduleButton.addActionListener(e -> {
            JFrame scheduleFrame = new JFrame("Schedule Appointment");
            scheduleFrame.setSize(400, 300);
            scheduleFrame.setLayout(new GridLayout(6, 2, 5, 4));

            JTextField idField = new JTextField();
            JTextField conditionField = new JTextField();
            JTextField dateField = new JTextField();
            JTextField timeField = new JTextField();
            JButton submitButton = new JButton("Submit");

            scheduleFrame.add(new JLabel("Appointment ID:"));
            scheduleFrame.add(idField);
            scheduleFrame.add(new JLabel("Patient's Condition:"));
            scheduleFrame.add(conditionField);
            scheduleFrame.add(new JLabel("Date:"));
            scheduleFrame.add(dateField);
            scheduleFrame.add(new JLabel("Time:"));
            scheduleFrame.add(timeField);
            scheduleFrame.add(new JLabel(""));
            scheduleFrame.add(submitButton);

            submitButton.addActionListener(a -> {
                String appointmentId = idField.getText().trim();
                String condition = conditionField.getText().trim();
                String date = dateField.getText().trim();
                String time = timeField.getText().trim();

                if (appointmentId.isEmpty() || condition.isEmpty() || date.isEmpty() || time.isEmpty()) {
                    JOptionPane.showMessageDialog(scheduleFrame, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                appointment.ScheduleAppointment(appointmentId, date, time, condition);
                JOptionPane.showMessageDialog(scheduleFrame, "Appointment Scheduled:\n" +
                        "ID: " + appointment.getAppointmentID() + "\n" +
                        "Condition: " + appointment.getPatientCondition() + "\n" +
                        "Date: " + appointment.getDate() + "\n" +
                        "Time: " + appointment.getTime());
                scheduleFrame.dispose();
            });

            scheduleFrame.setVisible(true);
        });

        cancelButton.addActionListener(e -> {
            JFrame cancelFrame = new JFrame("Cancel Appointment");
            cancelFrame.setSize(300, 150);
            cancelFrame.setLayout(new BorderLayout());

            JLabel confirmLabel = new JLabel("Do you want to cancel your appointment?", SwingConstants.CENTER);
            JButton yesButton = new JButton("Yes");
            JButton noButton = new JButton("No");

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(yesButton);
            buttonPanel.add(noButton);

            cancelFrame.add(confirmLabel, BorderLayout.CENTER);
            cancelFrame.add(buttonPanel, BorderLayout.SOUTH);

            yesButton.addActionListener(a -> {
                String appointmentId = JOptionPane.showInputDialog(cancelFrame, "Enter the appointment ID:");
                if (appointmentId != null && !appointmentId.trim().isEmpty()) {
                    appointment.CancelAppointment(appointmentId);
                    JOptionPane.showMessageDialog(cancelFrame, "Appointment " + appointmentId + " is cancelled.");
                } else {
                    JOptionPane.showMessageDialog(cancelFrame, "Appointment ID is required to cancel.");
                }
                cancelFrame.dispose();
            });

            noButton.addActionListener(a -> cancelFrame.dispose());

            cancelFrame.setVisible(true);
        });

        rescheduleButton.addActionListener(e -> {
            JFrame rescheduleFrame = new JFrame("Reschedule Appointment");
            rescheduleFrame.setSize(400, 250);
            rescheduleFrame.setLayout(new GridLayout(4, 2, 5, 5));

            JTextField appointmentIdField = new JTextField();
            JTextField newDateField = new JTextField();
            JTextField newTimeField = new JTextField();
            JButton submitButton = new JButton("Submit");

            rescheduleFrame.add(new JLabel("Appointment ID:"));
            rescheduleFrame.add(appointmentIdField);
            rescheduleFrame.add(new JLabel("New Date:"));
            rescheduleFrame.add(newDateField);
            rescheduleFrame.add(new JLabel("New Time:"));
            rescheduleFrame.add(newTimeField);
            rescheduleFrame.add(new JLabel(""));
            rescheduleFrame.add(submitButton);

            submitButton.addActionListener(a -> {
                String appointmentId = appointmentIdField.getText();
                String newDate = newDateField.getText();
                String newTime = newTimeField.getText();

                if (appointmentId.isEmpty() || newDate.isEmpty() || newTime.isEmpty()) {
                    JOptionPane.showMessageDialog(rescheduleFrame, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                appointment.RescheduleAppointment(newDate, newTime);
                JOptionPane.showMessageDialog(rescheduleFrame, "Appointment " + appointmentId + " has been rescheduled.");
                rescheduleFrame.dispose();
            });

            rescheduleFrame.setVisible(true);
        });

        mainFrame.setVisible(true);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Appointment{");
        sb.append("appointmentID=").append(appointmentID);
        sb.append(", Patient=").append(Patient);
        sb.append(", Date=").append(Date);
        sb.append(", Time=").append(Time);
        sb.append(", Status=").append(Status);
        sb.append(", PatientCondition=").append(PatientCondition);
        sb.append(", PatientCondition=").append(PatientCondition);
        sb.append('}');
        return sb.toString();
    }
}