public class Employee {
    private String name;
    private double annual;
    private double superRate;

    public Employee(String firstName, String lastName, double annual, double superRate) {
        this.name = String.format("%s %s", firstName, lastName);
        this.annual = annual;
        this.superRate = superRate;
    }

    public double getAnnual() {
        return annual;
    }

    public double getSuperRate() {
        return superRate;
    }

    public String getName() {
        return name;
    }

}
