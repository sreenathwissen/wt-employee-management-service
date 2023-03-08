package com.wissen.controller;

import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.dto.EmployeeSearchDTO;
import com.wissen.entity.Employee;
import com.wissen.enums.ResponseStatus;
import com.wissen.helper.ExcelHelper;
import com.wissen.model.response.EmployeeManagementResponse;
import com.wissen.response.EmployeeSaveResponse;
import com.wissen.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/saveEmployeeDetails")
    @ApiOperation("Saves the details of an Employee")
    public ResponseEntity<List<EmployeeSaveResponse>> saveEmployeeDetails(@RequestBody @NotEmpty(message = "Details list is empty") final List<EmployeeDetailDTO> employeeDetails){
        List<EmployeeSaveResponse> employeeSaveResponses = this.service.saveEmployeeDetails(employeeDetails);

        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeSaveResponses);
    }

    @GetMapping("/employees")
    @ApiOperation("Get all employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        log.info("START : Getting all employees");
        List<Employee> employees = this.service.getEmployees();
        log.info("END : Getting all employees");
        return ResponseEntity.status(HttpStatus.OK)
                .body(employees);
    }

    /**
     * @autor Vishal Tomar
     * @description Method to search employee.
     * @param searchString
     * @return list of employeeSearch dto
     */
    @GetMapping("/search")
    public EmployeeManagementResponse searchEmployee(@RequestParam final String searchString) {
        log.info("START : Searching all employees");

        Set<EmployeeSearchDTO> employeesSearchDTOs = this.service.searchEmployee(searchString);
        log.info("END : Searching all employees");
        return EmployeeManagementResponse.builder()
                        .responseStatus(ResponseStatus.SUCCESS)
                        .responseData(employeesSearchDTOs)
                        .build();
    }

    /**
     * @autor Vishal Tomar
     * Method to get employee by employee id.
     * @param employeeId
     * @return employee
     */
    @GetMapping("/employee")
    public EmployeeManagementResponse getEmployee(@RequestParam final int employeeId) {
        log.info("START :  Getting employee for employee id : {}", employeeId);
        Employee employee = this.service.getEmployee(employeeId);
        log.info("END :  Getting employee for employee id : {}", employeeId);
        return EmployeeManagementResponse.builder()
                .responseStatus(ResponseStatus.SUCCESS)
                .responseData(employee)
                .build();
    }

}