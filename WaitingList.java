package com.example;

public class WaitingList {
    private PriorityQueue waitinglist;
    private class Node{
        Appointment appointment;

        Node next;
        public Node(Appointment a){
        appointment=a;

            next=null;
        }

    }private class PriorityQueue{
        Node top;
        public PriorityQueue(){
        top=null;

        }
        private boolean isHigherPriority(Appointment newAppointment, Appointment existingAppointment) {
            String newCondition = newAppointment.getPatientCondition();
            String existingCondition = existingAppointment.getPatientCondition();

            
            switch (newCondition) {
                case "Critical":
                    if (existingCondition.equals("Non-Critical")) {
                        return true;
                    } else if (existingCondition.equals("Critical")) {

                        return isBefore(newAppointment.getDate(), existingAppointment.getDate());
                    }
                    break;
                case "Non-Critical":
                    if (existingCondition.equals("Critical")) {
                        return false;
                    } else if (existingCondition.equals("Non-Critical")) {

                        return isBefore(newAppointment.getDate(), existingAppointment.getDate());
                    }
                    break;
            }
            return false;
        }private boolean isBefore(String date1, String date2) {

            return date1.compareTo(date2) < 0;
        }
        public void enqueue(Appointment appointment){




            Node n1=new Node(appointment);
            if (top==null){
            top=n1;
            }else {
            Node temp=top;
            Node previous=null;
            while (temp!=null&&!isHigherPriority(appointment,temp.appointment)){
                previous=temp;
                temp=temp.next;
            }if (previous==null){
                n1.next=top;
                top=n1;
                }else {
            n1.next=temp;
            previous.next=n1;
            }}
        }
        public Appointment dequeue() {
            if (top == null) {
                System.out.println("Queue is empty.");
                return null;
            }
        
            Appointment appointmentToRemove = top.appointment;
            top = top.next;
            System.out.println("Appointment with ID " + appointmentToRemove.getAppointmentID() + " has been dequeued.");
            return appointmentToRemove;
        }
            // public Appointment dequeue() {
            //     if (top == null) {
            //         System.out.println("Queue is empty.");
            //         return null;
            //     } else if (top!=null){

            //         Appointment appointmentToRemove = top.appointment;
            //         top = top.next;
            //         return appointmentToRemove;
            //     }else {
            //         Node temp = top;
            //         Node previous = null;


            //         while (temp != null) {
            //         String appointmentID;
            //             if (temp.appointment.getAppointmentID().equals(appointmentID)){

            //                 if (previous == null) {
            //                     Appointment appointmentToRemove = top.appointment;
            //                     top = top.next;
            //                     System.out.println("Appointment with ID " + appointmentID + " has been dequeued.");
            //                     return appointmentToRemove;
            //                 } else {

            //                     Appointment appointmentToRemove = temp.appointment;
            //                     previous.next = temp.next;
            //                     System.out.println("Appointment with ID " + appointmentID + " has been dequeued.");
            //                     return appointmentToRemove;


            //             previous = temp;
            //         temp = temp.next;



            //         System.out.println("Appointment with ID " + appointmentID + " not found.");
            //         return null;
            //     }}}
            // }}
        public boolean isEmpty(){
            if (top==null){
                return true;
            }else {
                return false;
            }
        }
        public void display(){
            if (isEmpty()){
                System.out.println("WaitingList is empty");

            }else {
                Node temp=top;
                while (temp!=null){
                    System.out.println(temp.appointment.toString());
                    temp=temp.next;
                }
            }
        }



    }
    public WaitingList(){
        waitinglist=new PriorityQueue();

    }
    public void addToWaitList(Appointment appointment){
        waitinglist.enqueue(appointment);
    }
    public Appointment removeFromWaitingList(){
    return waitinglist.dequeue();
    }
    public void displayWaitingList(){
        System.out.println("Current Waiting List:");
        waitinglist.display();
    }
    public boolean isWaitingListEmpty(){
        return waitinglist.isEmpty();
    }

}
