package bems.utility;

import bems.model.BankEmployee;
import bems.model.BankManager;
import bems.model.BankTeller;

public class BankEmployeeFactory {
    public static BankEmployee createBankEmployee(String role, String id, String name, double salary){
        return switch (role.toLowerCase()) {
            case "manager" -> new BankManager(id, name, salary);
            case "teller" -> new BankTeller(id, name, salary);
            default -> throw new IllegalArgumentException("Invalid Role: " + role );
        };
    }
}
