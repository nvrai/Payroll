package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class AppTest {

    PayrollCalculator payrollCalculator;

    @BeforeEach
    void setUp(){
        payrollCalculator = new PayrollCalculator();
    }

    @Test 
    void itCalculatesGrossPayCorrectly(){
        assertEquals(167.80, payrollCalculator.grossPay(10));
    }

    @Test 
    void itCalculatesSocialSecurityCorrectly(){
        double gross = payrollCalculator.grossPay(10); // 167.80
        assertEquals(10.4036, payrollCalculator.socialSecurity(gross));
    }

    @Test 
    void itCalculatesFederalTaxCorrectly(){
        double gross = payrollCalculator.grossPay(10);
        assertEquals(23.492, payrollCalculator.federalTax(gross), 0.001);
    }

    @Test 
    void itCalculatesStateTaxCorrectly(){
        double gross = payrollCalculator.grossPay(10);
        assertEquals(8.39, payrollCalculator.stateTax(gross));
    }

    @Test 
    void itAddsInsuranceCostIfDependentsAre3OrMore(){
        assertEquals(35.0, payrollCalculator.insuranceCost(3));
        assertEquals(35.0, payrollCalculator.insuranceCost(4));
        assertEquals(0.0, payrollCalculator.insuranceCost(2));
    }

    @Test 
    void itCalculatesTotalDeductionsCorrectly(){
        double gross = payrollCalculator.grossPay(10); // 167.80
        assertEquals(87.2856, payrollCalculator.totalDeductions(gross, 3));
    }

    @Test 
    void itCalculatesNetPayCorrectly(){
        double net = payrollCalculator.netPay(10, 3); // hours=10, dependents=3
        assertEquals(80.5144, net, 0.001);
    }

    @Test 
    void itCalculatesNetPayWithoutInsurance(){
        double net = payrollCalculator.netPay(10, 2); // no insurance cost
        assertEquals(115.5144, net, 0.001);
    }
}
