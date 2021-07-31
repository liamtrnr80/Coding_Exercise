import java.util.Random;

public class Main {

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

    public static void main(String[] args) {

        double[] annArray = new double[]{60050, 120000, 80000, 200000, 251909, 248335, 102598, 20000, 18000};
        double annual = annArray[new Random().nextInt(annArray.length)];
        double sup = .1;

        double gross;
        double net;
        double supar;

        gross = Math.rint(annual / 12);
        net = Math.rint(gross - getIncomeTax(annual));
        supar = Math.rint(gross * sup);

        System.out.printf("Annual = %d, Gross Income = %d, Income Tax = %d, Net Income = %d, Super = %d", (int) annual, (int) gross, getIncomeTax(annual), (int) net, (int) supar);
    }
}
