import java.time.Month;
import java.time.Year;
import java.util.Random;

public class Exercise {

    public static void main(String[] args) {
        Month month = Month.of(5);

        System.out.println(month.length(Year.now().isLeap()));
//        gross = Math.rint(annual / 12);
//        net = Math.rint(gross - getIncomeTax(annual));
//        supar = Math.rint(gross * sup);
//
//        System.out.printf("Annual = %d, Gross Income = %d, Income Tax = %d, Net Income = %d, Super = %d", (int) annual, (int) gross, getIncomeTax(annual), (int) net, (int) supar);
    }
}
