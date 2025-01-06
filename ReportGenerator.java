package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ReportGenerator {
    Scanner concole = new Scanner(System.in);
    private String reportType;
    private BinarySearchTree patientsReport = new BinarySearchTree();
    private ArrayList<Integer> revenueReport = new ArrayList<Integer>();
    private WaitingList appointmentReport = new WaitingList();


    public void setAppointmentReport(WaitingList appointmentReport) {
        this.appointmentReport = appointmentReport;
    }

    public ReportGenerator(String reportType, BinarySearchTree patientsReport) {
        this.reportType = reportType;
        this.patientsReport = patientsReport;
    }

    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }

        }

        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }

    public static void quickSort(int [] array, int begin, int end) {
        if (end <= begin) return;

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);

    }

    public ReportGenerator() {
    }


    public void generatePatientReport() {
        System.out.println("enter patient id");
        int id = concole.nextInt();
        Patient patient=patientsReport.search(id);
        System.out.println("patient vist dates :"+ patient.getVisitRecords()+" , ");
    }


    // public void generateAppointmentReport() {
    //     if (reportType.equalsIgnoreCase("Appointment")) {
    //         quickSort(data, 0, data.length - 1);
    //         return "Appointment Statistics " + Arrays.toString(data);
    //     } else {
    //         return "Error";
    //     }
    // }

    // public String generateRevenueReport() {
    //     if (reportType.equalsIgnoreCase("Revenue")) {
    //         quickSort(data, 0, data.length - 1);
    //         return "Revenue Summary  " + Arrays.toString(data);
    //     } else {
    //         return "Error";
    //     }
//use it as example///

    // }
    // public void generateRevenueSummary(){
    //     int[]revenueArray=new int[revenueReport.size()];
    //     for(int i=0;i<revenueReport.size();i++){
    //         revenueArray[i]=revenueReport.get(i);
    //     }
    //     quickSort(revenueArray, 0, revenueReport.size());
    //     int sum=0;
    //     for(int i=0;i<revenueArray.length;i++){
    //         sum+=revenueArray[i];
    //     }
    //     System.out.println(revenueArray);
    //     System.out.println("Revenue Summary : "+sum);
    // }

    public void setRevenueReport(ArrayList<Integer> revenueReport) {
        this.revenueReport = revenueReport;
    }
    //***************************************************************************************** */
    // private List<Integer> quicksort(List<Integer> input){
		
	// 	if(input.size() <= 1){
	// 		return input;
	// 	}
		
	// 	int middle = (int) Math.ceil((double)input.size() / 2);
	// 	int pivot = input.get(middle);

	// 	List<Integer> less = new ArrayList<Integer>();
	// 	List<Integer> greater = new ArrayList<Integer>();
		
	// 	for (int i = 0; i < input.size(); i++) {
	// 		if(input.get(i) <= pivot){
	// 			if(i == middle){
	// 				continue;
	// 			}
	// 			less.add(input.get(i));
	// 		}
	// 		else{
	// 			greater.add(input.get(i));
	// 		}
	// 	}
		
	// 	return concatenate(quicksort(less), pivot, quicksort(greater));
	// }
	
	
	// public List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater){
		
	// 	List<Integer> list = new ArrayList<Integer>();
		
	// 	for (int i = 0; i < less.size(); i++) {
	// 		list.add(less.get(i));
	// 	}
		
	// 	list.add(pivot);
		
	// 	for (int i = 0; i < greater.size(); i++) {
	// 		list.add(greater.get(i));
	// 	}
		
	// 	return list;
	// }
    public void generateRevenueSummary() {
    if (revenueReport.isEmpty()) {
        System.out.println("No revenue data available.");
        return;
    }

    int[] revenueArray = new int[revenueReport.size()];
    for (int i = 0; i < revenueReport.size(); i++) {
        revenueArray[i] = revenueReport.get(i);
    }
    quickSort(revenueArray, 0, revenueArray.length - 1);
    int sum = 0;
    for (int i = 0; i < revenueArray.length; i++) {
        sum += revenueArray[i];
    }
    System.out.println("Sorted Revenue Array: " + Arrays.toString(revenueArray));
    System.out.println("Revenue Summary: " + sum);
}

}
