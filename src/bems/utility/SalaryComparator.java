package bems.utility;

import bems.model.BankEmployee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<BankEmployee> {
    @Override
    public int compare(BankEmployee be1, BankEmployee be2) {
        return Double.compare(be1.getSalary(), be2.getSalary());
    }
}
