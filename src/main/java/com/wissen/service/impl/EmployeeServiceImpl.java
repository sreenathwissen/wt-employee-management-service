package com.wissen.service.impl;


import com.wissen.entity.Client;
import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeAudit;
import com.wissen.exception.EmployeeNotFoundException;
import com.wissen.helper.ExcelHelper;
import com.wissen.repository.ClientRepository;
import com.wissen.repository.EmployeeAuditRepository;
import com.wissen.repository.EmployeeRepository;
import com.wissen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeAuditRepository employeeAuditRepository;
    @Autowired
    ClientRepository clientRepository;

    public String createEmployee(Employee employee) {
        employee.setActive(true);
        Client client = clientRepository.findByCname(employee.getClient().getCname());
        if (client != null) employee.setClient(client);
        employeeRepository.save(employee);
        EmployeeAudit employeeAudit = new EmployeeAudit(employee.getId(), employee.getEmail(), employee.getFirstName(), employee.getPan(), employee.getLastName(), employee.getDateOfJoining(), employee.getYearExperience(), employee.getManager(), employee.isActive(), employee.getRole(), employee.getDesignation(), employee.getAccountDetails(), employee.getClient());
        employeeAuditRepository.save(employeeAudit);
        return "Employee added successfully";
    }

    public String createEmployeeFromExcel(MultipartFile file) throws IOException {
        List<Employee> employees = ExcelHelper.excelToTutorials(file.getInputStream());
        for (Employee employee : employees) {
            Client client = clientRepository.findByCname(employee.getClient().getCname());
            if (client != null) employee.setClient(client);
            employeeRepository.save(employee);
            EmployeeAudit employeeAudit = new EmployeeAudit(employee.getId(), employee.getEmail(), employee.getFirstName(), employee.getPan(), employee.getLastName(), employee.getDateOfJoining(), employee.getYearExperience(), employee.getManager(), employee.isActive(), employee.getRole(), employee.getDesignation(), employee.getAccountDetails(), employee.getClient());
            employeeAuditRepository.save(employeeAudit);
        }
        return "Employees added successfully from file";
    }

    public List<Employee> readEmployee() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    public Employee readEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> readEmployee(boolean active) {
        return new ArrayList<>(employeeRepository.findAllByActive(active));
    }

    public String updateEmployee(Employee employee, int id) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        EmployeeAudit employeeAudit = new EmployeeAudit();
        boolean needUpdate = false;
        if (StringUtils.hasLength(employee.getFirstName())) {
            employee1.setFirstName(employee.getFirstName());
            employeeAudit.setFirstName(employee.getFirstName());
            needUpdate = true;
        } else employeeAudit.setFirstName(employee1.getFirstName());
        if (StringUtils.hasLength(employee.getPan())) {
            employee1.setPan(employee.getPan());
            employeeAudit.setPan(employee.getPan());
            needUpdate = true;
        } else employeeAudit.setPan(employee1.getPan());
        if (StringUtils.hasLength(employee.getLastName())) {
            employee1.setLastName(employee.getLastName());
            employeeAudit.setLastName(employee.getLastName());
            needUpdate = true;
        } else employeeAudit.setLastName(employee1.getLastName());
        if (StringUtils.hasLength(employee.getEmail())) {
            employee1.setEmail(employee.getEmail());
            employeeAudit.setEmail(employee.getEmail());
            needUpdate = true;
        } else employeeAudit.setEmail(employee1.getEmail());
        if (StringUtils.hasLength(employee.getDateOfJoining())) {
            employee1.setDateOfJoining(employee.getDateOfJoining());
            employeeAudit.setDateOfJoining(employee.getDateOfJoining());
            needUpdate = true;
        } else employeeAudit.setDateOfJoining(employee1.getDateOfJoining());
        if (!String.valueOf(employee.getYearExperience()).equals("null")) {
            employee1.setYearExperience(employee.getYearExperience());
            employeeAudit.setYearExperience(employee.getYearExperience());
            needUpdate = true;
        } else employeeAudit.setYearExperience(employee1.getYearExperience());
        if (StringUtils.hasLength(employee.getManager())) {
            employee1.setManager(employee.getManager());
            employeeAudit.setManager(employee.getManager());
            needUpdate = true;
        } else employeeAudit.setManager(employee1.getManager());
        if (!String.valueOf(employee.getRole()).equals("null")) {
            employee1.setRole(employee.getRole());
            employeeAudit.setRole(employee.getRole());
            needUpdate = true;
        } else employeeAudit.setRole(employee1.getRole());
        if (!String.valueOf(employee.getDesignation()).equals("null")) {
            employee1.setDesignation(employee.getDesignation());
            employeeAudit.setDesignation(employee.getDesignation());
            needUpdate = true;
        } else employeeAudit.setDesignation(employee1.getDesignation());
        if (!String.valueOf(employee.getAccountDetails()).equals("null")) {
            employee1.setAccountDetails(employee.getAccountDetails());
            employeeAudit.setAccountDetails(employee.getAccountDetails());
            needUpdate = true;
        } else employeeAudit.setAccountDetails(employee1.getAccountDetails());
        if (!String.valueOf(employee.getClient()).equals("null")) {
            employee1.setClient(employee.getClient());
            employeeAudit.setClient(employee.getClient());
            needUpdate = true;
        } else employeeAudit.setClient(employee1.getClient());
        if (needUpdate) {
            Client client = clientRepository.findByCname(employee1.getClient().getCname());
            if (client != null) employee1.setClient(client);
            employeeRepository.save(employee1);
            employeeAudit.setActive(employee1.isActive());
            client = clientRepository.findByCname(employeeAudit.getClient().getCname());
            if (client != null) employeeAudit.setClient(client);
            employeeAuditRepository.save(employeeAudit);
            return "Employee updated successfully";
        }
        return "Nothing to update";
    }

    public String deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setActive(false);
        employeeRepository.save(employee);
        EmployeeAudit employeeAudit = new EmployeeAudit(employee.getId(), employee.getEmail(), employee.getFirstName(), employee.getPan(), employee.getLastName(), employee.getDateOfJoining(), employee.getYearExperience(), employee.getManager(), employee.isActive(), employee.getRole(), employee.getDesignation(), employee.getAccountDetails(), employee.getClient());
        employeeAuditRepository.save(employeeAudit);
        return "Employee with given id is deleted";
    }
}
