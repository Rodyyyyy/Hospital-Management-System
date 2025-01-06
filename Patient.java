package com.example;

import java.util.ArrayList;
import java.util.Scanner;
public class Patient {
    Scanner console=new Scanner(System.in);
    private int id;
    private String name;
    private int age;
    private String ContactInfo;
    private String MedicalHistory;
    private ArrayList VisitRecords=new ArrayList();//list of date of visits //
    private String ConditionType;
    public Patient(String conditionType) {
        ConditionType = conditionType;
    }
    public Patient(int id, String name, int age, String contactInfo, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.age = age;
        ContactInfo = contactInfo;
        MedicalHistory = medicalHistory;
    }
    public void UpdateContactInfo(){
        System.out.println("enter new number");
        String newnum=console.next();
        ContactInfo=newnum;
    }
    public void AddVisitRecords(){
        System.out.println("enter visit date");
        String date = console.next();
        VisitRecords.add(date);
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getContactInfo() {
        return ContactInfo;
    }
    public ArrayList getVisitRecords() {
        return VisitRecords;
    }
    public void GetPatientInfo(){
        //get it by id from database//
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact Information: " + ContactInfo);
        System.out.println("Medical History: " + MedicalHistory);
        System.out.println("Visit Records: " + VisitRecords);
    }
    public String getConditionType() {
        return ConditionType;
    }
}
