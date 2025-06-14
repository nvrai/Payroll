package org.example;

public class PayrollCalculator {

    double SS_RATE = 0.062;
    double FED_TAX_RATE = 0.14;
    double STATE_TAX_RATE = 0.05;
    double UNION_DUES = 10.00;
    double INSURANCE_COST_PER_3_PLUS_DEPENDENTS = 35.00;

    public double grossPay(double hoursWorked){
        return hoursWorked * 16.78;
    }

    public double socialSecurity(double grossPay){
        return grossPay * SS_RATE;
    }

    public double federalTax(double grossPay){
        return grossPay * FED_TAX_RATE;
    }

    public double stateTax(double grossPay){
        return grossPay * STATE_TAX_RATE;
    }

    public double insuranceCost(int numDependents){
        return (numDependents >= 3) ? INSURANCE_COST_PER_3_PLUS_DEPENDENTS : 0.00;
    }

    public double totalDeductions(double grossPay, int numDependents){
        return socialSecurity(grossPay) + federalTax(grossPay) + stateTax(grossPay) + UNION_DUES + insuranceCost(numDependents);
    }

    public double netPay(double hoursWorked, int numDependents){
        double gross = grossPay(hoursWorked);
        return gross - totalDeductions(gross, numDependents);
    }
}
