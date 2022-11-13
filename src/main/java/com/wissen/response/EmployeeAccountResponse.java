package com.wissen.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeAccountResponse {

    String pan;
    String uan;
    String pfNo;
    int empId;
}
