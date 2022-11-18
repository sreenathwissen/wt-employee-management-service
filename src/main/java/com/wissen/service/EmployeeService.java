package com.wissen.service;

import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.entity.Employee;
import com.wissen.response.EmployeeSaveResponse;
import com.wissen.entity.EmployeeProject;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee employee);

    String createEmployeeFromExcel(MultipartFile file)  throws IOException;

    String updateEmployee(Employee employee, int id);

    String deleteEmployee(int id);

    public List<EmployeeSaveResponse> saveEmployeeDetails(List<EmployeeDetailDTO> employeeDetailDTOList);

    public List<Employee> getEmployees();

    public List<EmployeeProject> getEmployeeProjectByEmployeeId(int empId);
}
