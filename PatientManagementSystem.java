package com.example;
import java.util.ArrayList;
import java.util.*;
public class PatientManagementSystem {
    Scanner console=new Scanner(System.in);
    public BinarySearchTree patientList=new BinarySearchTree();
    public WaitingList waitingList=new WaitingList();
    private ArrayList<Integer> revenueSummarise = new ArrayList<Integer>();
    public void readPatients(Patient patient){
        patientList.insert(patient);
    }
    public void addPatient(){
        System.out.println("enter id");
        int id = console.nextInt();
        System.out.println("enter name ");
        String name = console.next();
        System.out.println("enter age");
        int age = console.nextInt();
        System.out.println("enter contact info");
        String contactInfo = console.next();
        System.out.println("enter medical history");
        String medicalHistory = console.next();
        Patient patient=new Patient(id, name, age, contactInfo, medicalHistory);
        patientList.insert(patient);
    }
    public void  findPatient(){
        System.out.println("enter id");
        int id = console.nextInt();
        Patient patient=patientList.search(id);
        if(patient!=null){
            patient.GetPatientInfo();
        }else{
            System.out.println("Patient not found");
        }
    }
    public void updatePatientInfo(){
        System.out.println("enter id");
        int id = console.nextInt();
        Patient patient=patientList.search(id);
        if(patient!=null){
            patient.UpdateContactInfo();
        } else{
            System.out.println("Patient not found");
        }
    }
    public void addVisitRecords(){
        System.out.println("enter id");
        int id = console.nextInt();
        Patient patient=patientList.search(id);
        if(patient!=null){
            patient.AddVisitRecords();
        } else{
            System.out.println("Patient not found");
        }
    }
    public void generateReport(){
        System.out.println("enter report type ");
        String reportType = console.nextLine();
        if (reportType.equalsIgnoreCase("patient")) {
            ReportGenerator report=new ReportGenerator(reportType,patientList);
            report.generatePatientReport();
        }else if (reportType.equalsIgnoreCase("revenue report")){
            ReportGenerator report=new ReportGenerator(reportType,patientList);
            report.setRevenueReport(revenueSummarise);
            report.generateRevenueSummary();
        }else if (reportType.equalsIgnoreCase("appointment report")){
            getWaitingList();
        }
    }
    public void makePayment(){
        System.out.println("enter id");
        int id =console.nextInt();
        System.out.println("enter billing ammount");
        int billingAmmount = console.nextInt();
        Billing payment=new Billing(billingAmmount,id);
        System.out.println("enter amount ");
        double amount = console.nextDouble();
        payment.addPayment(amount);
        payment.generatebill();
        revenueSummarise.add(billingAmmount);
    }
    public void ScheduleAppointment(){
        System.out.println("enter id");
        String id = console.nextLine();
        System.out.println("enter name");
        String name =console.nextLine();
        System.out.println("enter date");
        String date = console.nextLine();
        System.out.println("enter time");
        String time = console.nextLine();
        System.out.println("enter condition");
        String condition = console.nextLine();
        System.out.println("enter status");
        String status = console.nextLine();
        Appointment appointment = new Appointment(id, name, date, time,status,condition);
        appointment.ScheduleAppointment(id, date, time, condition);
        waitingList.addToWaitList(appointment);
    }
    public void cancelAppointment(){
        waitingList.removeFromWaitingList();
        // make it work//
    }

    // public ArrayList<Double> getRevenueSummarise() {
    //     return revenueSummarise;
    // }

    public void getWaitingList() {
        waitingList.displayWaitingList();
    }
}
