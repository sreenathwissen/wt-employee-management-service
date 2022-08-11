package com.wissen.service;

import com.wissen.entity.Employee;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface Service {
    public String createEmployee(Employee employee);
    public String createEmployeeFromExcel(MultipartFile file)  throws IOException;
    public List<Employee> readEmployee();
    public Employee readEmployee(int id);
    public List<Employee> readEmployee(boolean active);
    public String updateEmployee(Employee employee, int id);
    public String deleteEmployee(int id);
}
