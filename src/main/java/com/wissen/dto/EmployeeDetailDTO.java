package com.wissen.dto;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeAccount;
import com.wissen.entity.EmployeeSkill;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDetailDTO {

    private Employee employee;
    private Address address;
    private EmployeeSkill employeeSkill;
    private EmployeeAccount employeeAccount;
}
