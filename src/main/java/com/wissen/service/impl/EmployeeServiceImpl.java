package com.wissen.service.impl;


import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.entity.*;
import com.wissen.entity.key.EmployeeProjectId;
import com.wissen.exception.EmployeeNotFoundException;
import com.wissen.repository.*;
import com.wissen.response.*;
import com.wissen.service.AddressService;
import com.wissen.service.EmployeeAccountService;
import com.wissen.service.EmployeeService;
import com.wissen.service.EmployeeSkillService;
import com.wissen.utils.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Autowired EmployeeProjectRepository employeeProjectRepository;

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

    @Override
    public List<EmployeeSaveResponse> saveEmployeeDetails(List<EmployeeDetailDTO> employeeDetailDTOList){

        List<EmployeeSaveResponse> employeeSaveResponses = new ArrayList<>();
        employeeDetailDTOList.stream().filter(dto -> Objects.nonNull(dto))
                .forEach(dto -> {
                    EmployeeSaveResponse employeeSaveResponse = new EmployeeSaveResponse();

                    //Saving Employee
                    Employee employee = this.employeeRepository.save(EmployeeUtil.getEmployeeEntity(dto));
                    EmployeeResponse employeeResponse = EmployeeUtil.getEmployeeResponse(employee);
                    employeeSaveResponse.setEmployeeResponse(employeeResponse);

                    //Saving Employee Address
                    List<Address> addressList = dto.getAddressDTOList().parallelStream().map(addressDTO ->
                            EmployeeUtil.getAddressEntity(addressDTO, employee)).collect(Collectors.toList());
                    List<Address> saveAddresses = this.addressService.saveAddresses(addressList);
                    List<AddressResponse> addressResponseList = EmployeeUtil.getAddressResponseList(saveAddresses);
                    employeeSaveResponse.setAddressResponse(addressResponseList);

                    //Saving Employee Skill
                    List<EmployeeSkill> employeeSkillList = dto.getEmployeeSkillDTOList().parallelStream().map(employeeSkillDTO ->
                            EmployeeUtil.getEmployeeSkillEntity(employeeSkillDTO, employee)).collect(Collectors.toList());
                    List<EmployeeSkill> employeeSkill = this.employeeSkillService
                            .saveEmployeeSkills(employeeSkillList);
                    List<EmployeeSkillResponse> employeeSkillResponseList = EmployeeUtil.getEmployeeSkillResponse(employeeSkill);
                    employeeSaveResponse.setEmployeeSkillResponse(employeeSkillResponseList);

                    //Saving Employee Account
                    EmployeeAccount employeeAccount = this.employeeAccountService
                            .saveEmployeeAccount(EmployeeUtil.getEmployeeAccountEntity(dto.getEmployeeAccountDTO(), employee));
                    EmployeeAccountResponse employeeAccountResponse = EmployeeUtil.getEmployeeAccountResponse(employeeAccount);
                    employeeSaveResponse.setEmployeeAccountResponse(employeeAccountResponse);

                    employeeSaveResponses.add(employeeSaveResponse);

                });
        return employeeSaveResponses;
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public List<EmployeeProject> getEmployeeProjectByEmployeeId(int empId) {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        EmployeeProjectId employeeProjectId = new EmployeeProjectId();
        employeeProjectId.setEmployee(employee);
        return this.employeeProjectRepository.getEmployeeProjectByEmployeeProjectIdEmployee(employee);
    }

}
