package org.example;
import java.util.Scanner;

public class Payroll {
    public static void main(){
        System.out.println("Welcome to the Payroll Program!");

        Scanner userInput = new Scanner(System.in);

        System.out.println("How many hours have you worked?: ");
        Double hoursWorked = userInput.nextDouble();

        System.out.print("How many children do you have? ");
        int numDependents = userInput.nextInt();

        userInput.close(); 

        double ssRate = 0.062;
        double fedTaxRate = 0.14;
        double stateTaxRate = 0.05;
        double unionDues = 10.00;
        double insuranceCost = (numDependents >= 3) ? 35.00 : 0.00;

        double grossPay = hoursWorked * 16.78;
        double socSec = grossPay * ssRate;
        double fedTax = grossPay * fedTaxRate;
        double stateTax = grossPay * stateTaxRate;
        double totalDeductions = socSec + fedTax + stateTax + unionDues + insuranceCost;
        double netPay = grossPay - totalDeductions;

        

        System.out.printf("Hours: %.1f%n", hoursWorked);
        System.out.printf("Rate: $%.2f%n", 16.78);
        System.out.printf("Gross: $%.2f%n", grossPay);

        System.out.printf("Social Security: $%.2f%n", socSec);
        System.out.printf("Fed Tax: $%.2f%n", fedTax);
        System.out.printf("State Tax: $%.2f%n", stateTax);
        System.out.printf("Union Dues: $%.2f%n", unionDues);
        System.out.printf("Insurance Cost: $%.2f%n", insuranceCost);
        System.out.printf("Deductions: $%.2f%n", totalDeductions);
        System.out.printf("Net Pay: $%.2f%n", netPay);

        System.out.println("\nThank you for using the Payroll Program!");
    }
}