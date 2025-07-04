package bems.service;

import bems.model.BankEmployee;

import java.util.*;

public interface BankEmployeeService {
    boolean addBankEmployee(BankEmployee emp);
    List<BankEmployee> getAllEmployees();
    BankEmployee searchById(String bempId);
    boolean updateEmployeeDetail(BankEmployee emp, int statusCode, String upname, double upsalary);
    BankEmployee deleteBankEmployee(String bempId);
    List<BankEmployee> getEmployeesSortedBySalary();
}
