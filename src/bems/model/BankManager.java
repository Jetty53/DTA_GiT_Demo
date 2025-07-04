package bems.model;

public class BankManager extends BankEmployee{

    public BankManager(String id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public String identifyRole() {
        return "Manager";
    }

    @Override
    public String toString() {
        return "Employee [Id: " + super.id + ", Name: " + super.name + ", Salary: " + super.salary + ", Role: " + identifyRole() + "]";
    }
}
