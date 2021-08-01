import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

        JSONArray employeeList = new JSONArray();

        for(Payslip slip : payslips) {
            employeeList.add(slip.getJSONArray());
            System.out.println(slip.getJSONArray().toJSONString());
        }

        try(FileWriter file = new FileWriter("src/result3.json")) {
            file.write(employeeList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
