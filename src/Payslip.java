import java.time.Month;
import java.util.Date;

public class Payslip {

    private double gross;
    private double net;
    private double superRate;
    private int tax;
    private Month payPeriod;

    public Payslip(Month month, double annual, double superRate) {

    }

    public static int getIncomeTax(double annual) {
        double tax = 0;

        if (annual <= 18200) {
            tax = annual / 12;
            System.out.println("$0 - $18,200");
        } else if (annual <= 37000) {
            tax = Math.rint(((annual - 37000) * 0.19) / 12);
            System.out.println("$18,201 - $37,000");
        } else if (annual <= 87000) {
            tax = Math.rint((3572 + (annual - 37000) * 0.325)/12);
            System.out.println("$37,001 - $87,000");
        } else if (annual <= 180000) {
            tax = Math.rint((19822 + (annual - 87000) * 0.37)/12);
            System.out.println("$87,001 - $180,000");
        } else if (annual >= 180001) {
            tax = Math.rint((54232 + (annual - 180000) * 0.45)/12);
            System.out.println("$180,001 and over");
        } else {
            System.out.println("Incorrect Input, please try again later");
        }

        return (int) tax;
    }
}
