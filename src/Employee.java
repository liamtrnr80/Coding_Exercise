public class Employee {
    private String name;
    private double annual;
    private int month;
    private double superRate;

    public Employee(String firstName, String lastName, double annual, int month, double superRate) {
        this.name = String.format("%s %s", firstName, lastName);
        this.annual = annual;
        this.month = month;
        this.superRate = superRate;
    }

    public double getAnnual() {
        return annual;
    }

    public double getSuperRate() {
        return superRate;
    }

    public int getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }

}
