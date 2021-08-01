import org.json.simple.JSONObject;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.LinkedHashMap;

public class Payslip {
    private final String firstName, lastName;
    private final int annualSalary, grossIncome, incomeTax, superAnnuation, netIncome;
    private final Month paymentMonth;
    private final double superRate;

    public Payslip(String first, String last, int annual, int month, double superRater) {
        this.firstName = first;
        this.lastName = last;
        this.annualSalary = annual;
        this.paymentMonth = Month.of(month + 1);
        this.superRate = superRater;
        this.grossIncome = (int) Math.rint((double) annual / 12);
        this.incomeTax = (int) Math.rint(getIncomeTax(annual));
        this.superAnnuation = (int) Math.rint(grossIncome * superRater);
        this.netIncome = (int) Math.rint(grossIncome - incomeTax);
    }

    public static int getIncomeTax(double annual) {
        double tax = 0;

        if (annual <= 18200) {
            tax = annual / 12;
        } else if (annual <= 37000) {
            tax = Math.rint(((annual - 37000) * 0.19) / 12);
        } else if (annual <= 87000) {
            tax = Math.rint((3572 + (annual - 37000) * 0.325) / 12);
        } else if (annual <= 180000) {
            tax = Math.rint((19822 + (annual - 87000) * 0.37) / 12);
        } else if (annual >= 180001) {
            tax = Math.rint((54232 + (annual - 180000) * 0.45) / 12);
        } else {
            System.out.println("Incorrect Input, please try again later");
        }

        return (int) tax;
    }

    public JSONObject getJSONObject() {

        //Employee:
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", firstName);
        employeeDetails.put("lastName", lastName);
        employeeDetails.put("annualSalary", annualSalary);
        employeeDetails.put("paymentMonth", paymentMonth.getValue() - 1);
        employeeDetails.put("superRate", superRate);

        JSONObject payslip = new JSONObject(new LinkedHashMap());
        payslip.put("toDate", String.format("%d %s", paymentMonth.length(Year.isLeap(Calendar.YEAR)), paymentMonth.name()));
        payslip.put("fromDate", String.format("01 %s", paymentMonth.name()));
        payslip.put("grossIncome", grossIncome);
        payslip.put("incomeTax", incomeTax);
        payslip.put("superannuation", superAnnuation);
        payslip.put("netIncome", netIncome);
        payslip.put("employee", employeeDetails);

        return payslip;
    }

    public double getSuperRate() {
        return superRate;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public Month getPaymentMonth() {
        return paymentMonth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public double getSuperAnnuation() {
        return superAnnuation;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", annualSalary=" + annualSalary +
                ", grossIncome=" + grossIncome +
                ", incomeTax=" + incomeTax +
                ", superAnnuation=" + superAnnuation +
                ", netIncome=" + netIncome +
                ", paymentMonth=" + paymentMonth.name() +
                ", superRate=" + superRate +
                '}';
    }
}
