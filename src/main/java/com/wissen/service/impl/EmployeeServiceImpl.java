package com.wissen.service.impl;


import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.entity.*;
import com.wissen.exception.EmployeeNotFoundException;
import com.wissen.repository.*;
import com.wissen.service.AddressService;
import com.wissen.service.EmployeeAccountService;
import com.wissen.service.EmployeeService;
import com.wissen.service.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DesignationRepository designationRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private EmployeeSkillService employeeSkillService;

    @Autowired
    private EmployeeAccountService employeeAccountService;

    public String createEmployee(Employee employee) {
        employee.setStatus("active");
        Designation designation = designationRepository.findByDesgName(employee.getDesignation().getDesgName());
        if(designation != null) employee.setDesignation(designation);
        Department department = departmentRepository.findByDepName(employee.getDepartment().getDepName());
        if(department != null) employee.setDepartment(department);
        Role role = roleRepository.findByRoleName(employee.getRole().getRoleName());
        if(role != null) employee.setRole(role);
        employeeRepository.save(employee);
        return "Employee added successfully";
    }

    public String createEmployeeFromExcel(MultipartFile file) throws IOException {
        List<Employee> employees = null;//ExcelHelper.excelToTutorials(file.getInputStream());
        for (Employee employee : employees) {
            Designation designation = designationRepository.findByDesgName(employee.getDesignation().getDesgName());
            if(designation != null) employee.setDesignation(designation);
            Department department = departmentRepository.findByDepName(employee.getDepartment().getDepName());
            if(department != null) employee.setDepartment(department);
            Role role = roleRepository.findByRoleName(employee.getRole().getRoleName());
            if(role != null) employee.setRole(role);
            employeeRepository.save(employee);
        }
        return "Employees added successfully from file";
    }

    public List<Employee> readEmployee() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    public Employee readEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    public String updateEmployee(Employee employee, int id) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        boolean needUpdate = false;
        if (StringUtils.hasLength(employee.getFirstName())) {
            employee1.setFirstName(employee.getFirstName());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getGender())) {
            employee1.setGender(employee.getGender());
            needUpdate = true;
        }
        if (StringUtils.hasLength((CharSequence) employee.getDob())) {
            employee1.setDob(employee.getDob());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getBloodGroup())) {
            employee1.setBloodGroup(employee.getBloodGroup());
            needUpdate = true;
        }
        if (StringUtils.hasLength(String.valueOf(employee.getPrimaryPhoneNumber()))) {
            employee1.setPrimaryPhoneNumber(employee.getPrimaryPhoneNumber());
            needUpdate = true;
        }
        if (StringUtils.hasLength(String.valueOf(employee.getSecondaryPhoneNumber()))) {
            employee1.setSecondaryPhoneNumber(employee.getSecondaryPhoneNumber());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getLastName())) {
            employee1.setLastName(employee.getLastName());
            needUpdate = true;
        }
        if (StringUtils.hasLength(String.valueOf(employee.getWorkPhone()))) {
            employee1.setWorkPhone(employee.getWorkPhone());
            needUpdate = true;
        }
        if (StringUtils.hasLength(String.valueOf(employee.getPrimaryEmergencyContactNumber()))) {
            employee1.setPrimaryEmergencyContactNumber(employee.getPrimaryEmergencyContactNumber());
            needUpdate = true;
        }
        if (StringUtils.hasLength(String.valueOf(employee.getSecondaryEmergencyContactNumber()))) {
            employee1.setSecondaryEmergencyContactNumber(employee.getSecondaryEmergencyContactNumber());
            needUpdate = true;
        }
        if (StringUtils.hasLength((CharSequence) employee.getMaritalStatusDate())) {
            employee1.setMaritalStatusDate(employee.getMaritalStatusDate());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getEmail())) {
            employee1.setEmail(employee.getEmail());
            needUpdate = true;
        }
        if (StringUtils.hasLength((CharSequence) employee.getDoj())) {
            employee1.setDoj(employee.getDoj());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getExpDoj())) {
            employee1.setExpDoj(employee.getExpDoj());
            needUpdate = true;
        }
        if (StringUtils.hasLength((CharSequence) employee.getExitDate())) {
            employee1.setExitDate(employee.getExitDate());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getType())) {
            employee1.setType(employee.getType());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getJoiningLocation())) {
            employee1.setJoiningLocation(employee.getJoiningLocation());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getStatus())) {
            employee1.setStatus(employee.getStatus());
            needUpdate = true;
        }
        if (StringUtils.hasLength(employee.getManager())) {
            employee1.setManager(employee.getManager());
            needUpdate = true;
        }
        if (!String.valueOf(employee.getRole()).equals("null")) {
            employee1.setRole(employee.getRole());
            needUpdate = true;
        }
        if (!String.valueOf(employee.getDesignation()).equals("null")) {
            employee1.setDesignation(employee.getDesignation());
            needUpdate = true;
        }
        if (!String.valueOf(employee.getDepartment()).equals("null")) {
            employee1.setDepartment(employee.getDepartment());
            needUpdate = true;
        }
        if (needUpdate) {
            employeeRepository.save(employee1);
            return "Employee updated successfully";
        }
        return "Nothing to update";
    }

    public String deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setStatus("inactive");
        employeeRepository.save(employee);
        return "Employee with given id is deleted";
    }

    public List<EmployeeDetailDTO> saveEmployeeDetails(List<EmployeeDetailDTO> employeeDetailDTOList){
        List<EmployeeDetailDTO> result = new ArrayList<>();
        employeeDetailDTOList.stream().filter(dto -> Objects.nonNull(dto))
                .forEach(dto -> {
                    EmployeeDetailDTO employeeDetailDTO = new EmployeeDetailDTO();

                    //Saving Employee
                    Employee employee = this.employeeRepository.save(dto.getEmployee());
                    employeeDetailDTO.setEmployee(employee);

                    //Saving Employee Address
                    Address address = this.addressService.saveAddress(dto.getAddress(), employee);
                    employeeDetailDTO.setAddress(address);

                    //Saving Employee Skill
                    EmployeeSkill employeeSkill = this.employeeSkillService
                            .saveEmployeeSkill(employee, dto.getEmployeeSkill());
                    employeeDetailDTO.setEmployeeSkill(employeeSkill);

                    //Saving Employee Account
                    EmployeeAccount employeeAccount = this.employeeAccountService
                            .saveEmployeeAccount(employee, dto.getEmployeeAccount());
                    employeeDetailDTO.setEmployeeAccount(employeeAccount);

                    result.add(employeeDetailDTO);
                });

        return result;
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

}
