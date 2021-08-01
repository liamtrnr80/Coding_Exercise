import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.sound.midi.SysexMessage;
import java.io.FileReader;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class Exercise {

    public static void main(String[] args) {

        ArrayList<Payslip> payslips = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("src/employee.json"));

            for(Object obj : array) {
                JSONObject employee = (JSONObject) obj;

                String firstName = (String) employee.get("firstName");
                String lastName = (String) employee.get("lastName");
                int annual = ((Long) employee.get("annualSalary")).intValue();
                int month = ((Long) employee.get("paymentMonth")).intValue();
                double superRate = (double) employee.get("superRate");

                payslips.add(new Payslip(firstName, lastName, annual, month, superRate));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Payslip slip : payslips) {
            System.out.println(slip.toString());
        }
    }
}
