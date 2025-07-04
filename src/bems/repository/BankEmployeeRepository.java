package bems.repository;

import bems.model.BankEmployee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankEmployeeRepository {
    private Map<String, BankEmployee> employeeMap = new HashMap<>();

    public void add(BankEmployee bemp){
        employeeMap.put(bemp.getId(), bemp);
    }

    public Collection<BankEmployee> getAllEmployees(){
        return employeeMap.values();
    }

    public BankEmployee searchById(String bempId){
        return employeeMap.get(bempId);
    }

    public void updateEmployeeDetail(BankEmployee emp, int status, String upname, double upsalary){
        if(status == 1) {
            emp.setName(upname);
            emp.setSalary(upsalary);
        }else if(status == 2) {
            emp.setSalary(upsalary);
        }else if(status == 3) {
            emp.setName(upname);
        }
        employeeMap.put(emp.getId(), emp);
    }

    public BankEmployee delete(String bempId){
        return employeeMap.remove(bempId);
    }

    public boolean employeeAlreadyExists(BankEmployee bemp){
        return employeeMap.containsKey(bemp.getId());
    }

    public boolean isNoEmployee(){
        return employeeMap.isEmpty();
    }

    public boolean isInvalidId(String bempId){
        return !employeeMap.containsKey(bempId);
    }

}
