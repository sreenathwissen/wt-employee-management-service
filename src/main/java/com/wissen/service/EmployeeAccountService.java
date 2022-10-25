package com.wissen.service;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeAccount;

public interface EmployeeAccountService {

    public EmployeeAccount saveEmployeeAccount(Employee employee, EmployeeAccount employeeAccount);
}
