package com.wissen.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeSaveResponse {

    private EmployeeResponse employeeResponse;

    private List<AddressResponse> addressResponse;

    private List<EmployeeSkillResponse> employeeSkillResponse;

    private EmployeeAccountResponse employeeAccountResponse;
}
