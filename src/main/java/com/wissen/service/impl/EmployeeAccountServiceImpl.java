package com.wissen.service.impl;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeAccount;
import com.wissen.entity.key.EmployeeAccountId;
import com.wissen.repository.EmployeeAccountRepository;
import com.wissen.service.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAccountServiceImpl implements EmployeeAccountService {

    @Autowired
    private EmployeeAccountRepository employeeAccountRepository;

    @Override
    public EmployeeAccount saveEmployeeAccount(EmployeeAccount employeeAccount) {
        return this.employeeAccountRepository.save(employeeAccount);
    }
}
