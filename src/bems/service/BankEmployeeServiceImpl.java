package bems.service;

import bems.exceptions.DuplicateEmployeeIdException;
import bems.exceptions.InvalidEmployeeIdException;
import bems.exceptions.NoEmployeeException;
import bems.model.BankEmployee;
import bems.repository.BankEmployeeRepository;
import bems.utility.SalaryComparator;

import java.util.*;

public class BankEmployeeServiceImpl implements BankEmployeeService{

    BankEmployeeRepository repository = new BankEmployeeRepository();

    @Override
    public boolean addBankEmployee(BankEmployee emp) {
        if(repository.employeeAlreadyExists(emp)){
            throw new DuplicateEmployeeIdException("Employee ID already exists.");
        }
        repository.add(emp);
        return true;
    }

    @Override
    public List<BankEmployee> getAllEmployees() {
        if (repository.isNoEmployee()){
            throw new NoEmployeeException("No employees available.");
        }
        return new ArrayList<>(repository.getAllEmployees());
    }

    @Override
    public BankEmployee searchById(String bempId) {
        if (repository.isNoEmployee()){
            throw new NoEmployeeException("No employees Exist yet.");
        }
        if(repository.isInvalidId(bempId)){
            throw new InvalidEmployeeIdException("Employee Id does not exist");
        }
        return repository.searchById(bempId);
    }

    @Override
    public boolean updateEmployeeDetail(BankEmployee emp, int statusCode, String upname, double upsalary) {
        if(repository.isInvalidId(emp.getId())) {
            throw new InvalidEmployeeIdException("Employee Id does not exist");
        }
        repository.updateEmployeeDetail(emp, statusCode, upname, upsalary);
        return true;
    }

    @Override
    public BankEmployee deleteBankEmployee(String bempId) {
        if (repository.isNoEmployee()){
            throw new NoEmployeeException("No employees Exist yet.");
        }
        if(repository.isInvalidId(bempId)){
            throw new InvalidEmployeeIdException("Employee Id does not exist");
        }
        return repository.delete(bempId);
    }

    @Override
    public List<BankEmployee> getEmployeesSortedBySalary() {
        List<BankEmployee> allEmployees = getAllEmployees();
        allEmployees.sort(new SalaryComparator());
        return allEmployees;
    }


}
