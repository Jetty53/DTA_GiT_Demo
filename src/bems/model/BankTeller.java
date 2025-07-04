package bems.model;

public class BankTeller extends BankEmployee{
    public BankTeller(String id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public String identifyRole() {
        return "Teller";
    }

    @Override
    public String toString() {
        return "Employee [Id: " + super.id + ", Name: " + super.name + ", Salary: " + super.salary + ", Role: " + identifyRole() + "]";
    }
}
