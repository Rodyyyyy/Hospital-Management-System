package com.example;
import java.util.Date;
import java.util.ArrayList;
import java.util.*;
public class Billing {
    int PatientID;
    double BillingAmount;
    Date date=new Date();
    ArrayList<String> PaymentHistory = new ArrayList<String>();

    public Billing( double BillingAmount, int patientID ) {
        this.BillingAmount = BillingAmount;
    this.PatientID = patientID;
    }

    public void generatebill() {
        System.out.println("Generating bill for Patient: " + PatientID);
        System.out.println("Payment made on: " + date);
        System.out.println("Total Billing Amount: " + BillingAmount);
    }

    public void addPayment(double amount) {
        Date paymentDate = new Date();
        if (amount < 0) {
            System.out.println("Payment amount is not valid");
        }
        else if (amount > BillingAmount) {
            System.out.println("Payment exceeds the Billing Amount. Please increase the Billing Amount.");
        } else {
            BillingAmount -= amount;
            PaymentHistory.add("id "+PatientID +"Payment made on " + paymentDate.toString() + " amount: " + amount);
            System.out.println("Payment successful. Remaining balance: " + BillingAmount);
        }
    }

    public String getPaymentStatus() {
        return 
        "Payment Status for Patient " + PatientID+
        "Payment made on " + date+
        "Total Billing Amount: "+
        "Payment History: ";
        // for (String payment : PaymentHistory) {
        //     System.out.println(payment);
        // }
    }
}
