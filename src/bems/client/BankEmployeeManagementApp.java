package bems.client;

import bems.exceptions.InvalidEmployeeIdException;
import bems.exceptions.NoEmployeeException;
import bems.model.BankEmployee;
import bems.service.BankEmployeeService;
import bems.service.BankEmployeeServiceImpl;
import bems.utility.BankEmployeeFactory;

import java.util.DuplicateFormatFlagsException;
import java.util.Scanner;

public class BankEmployeeManagementApp {

    public static void BEMS_Menu(BankEmployeeService service, Scanner sc) {
        while(true){
            System.out.println("\n1. Add Employee\n2. View All\n3. Search by ID\n4. Update\n5. Delete\n6. Sort by Salary\n7. Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    addBankEmployee(service, sc);
                    break;
                case 2:
                    getAllBankEmployees(service);
                    break;
                case 3:
                    System.out.println("Enter the employee id you want to find: ");
                    String bempId = sc.next();
                    searchBankEmployeeById(service, bempId);
                    break;
                case 4:
                    System.out.println("Enter the employee id whose details you want to update: ");
                    String updateId = sc.next();
                    updateBankEmployeeDetails(service, updateId, sc);
                    break;
                case 5:
                    System.out.println("Enter the employee id you want to delete: ");
                    String delBempId = sc.next();
                    deleteBankEmployee(service, delBempId);
                    break;
                case 6:
                    getEmployeeRecordsSortedBySalary(service);
                    break;
                case 7:
                    System.out.println("Thank you for using BEM System. Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    public static void addBankEmployee(BankEmployeeService service, Scanner sc){
        System.out.println("Enter Employee Name: ");
        String bemp_name = sc.next();
        System.out.println("Enter Employee Salary: ");
        double bemp_salary = sc.nextDouble();
        System.out.println("Enter Employee Role: ");
        String bemp_role = sc.next();
        BankEmployee bemp = BankEmployeeFactory.createBankEmployee(bemp_role, String.valueOf(System.currentTimeMillis()), bemp_name, bemp_salary);
        if(service.addBankEmployee(bemp)){
            System.out.println("Bank Employee Successfully Added");
        } else {
            System.out.println("Error Occurred. Employee details can't be added.");
        }
    }

    public static void getAllBankEmployees(BankEmployeeService service){

        for (BankEmployee emp: service.getAllEmployees()){
            System.out.println(emp);
        }

    }

    public static void searchBankEmployeeById(BankEmployeeService service, String bempId){
        BankEmployee emp = service.searchById(bempId);
        System.out.println(emp);
    }

    public static void deleteBankEmployee(BankEmployeeService service, String bempId){
        BankEmployee emp = service.deleteBankEmployee(bempId);
        System.out.println(emp + "...Employee Record Deleted Successfully.");
    }

    public static void updateBankEmployeeDetails(BankEmployeeService service, String bempId, Scanner sc){
        BankEmployee emp = service.searchById(bempId);
        System.out.println("Enter the updated name (Enter 0 if no updation needed): ");
        String upName = sc.next();
        System.out.println("Enter the updated salary (Enter 0 if no updation needed): ");
        double upsalary = sc.nextDouble();

        if(upName.equals("0") && upsalary == 0){
            System.out.println("No employee record updated.");
            return;
        }
        int statusCode = 1;
        if(upName.equals("0")){
            statusCode = 2;
        }else if(upsalary == 0){
            statusCode = 3;
        }
        if(service.updateEmployeeDetail(emp, statusCode, upName, upsalary)){
            System.out.println("Employee Record Updated Successfully");
        }else{
            System.out.println("Error Occurred. Employee details can't be updated.");
        }

    }

    public static void getEmployeeRecordsSortedBySalary(BankEmployeeService service){
        for(BankEmployee emp: service.getEmployeesSortedBySalary()){
            System.out.println(emp);
        }
    }

    public static void main(String[] args) {
        BankEmployeeService service = new BankEmployeeServiceImpl();
        Scanner sc = new Scanner(System.in);

        try{
            BEMS_Menu(service, sc);
        }catch (DuplicateFormatFlagsException | NoEmployeeException | InvalidEmployeeIdException e){
            System.out.println(e.getMessage());
        }

    }
}