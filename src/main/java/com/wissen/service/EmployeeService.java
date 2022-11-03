package com.wissen.service;

import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.entity.Employee;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee employee);

    String createEmployeeFromExcel(MultipartFile file)  throws IOException;

    List<Employee> readEmployee();

    Employee readEmployee(int id);

    String updateEmployee(Employee employee, int id);

    String deleteEmployee(int id);

    public List<EmployeeDetailDTO> saveEmployeeDetails(List<EmployeeDetailDTO> employeeDetailDTOList);

    public List<Employee> getEmployees();
}
