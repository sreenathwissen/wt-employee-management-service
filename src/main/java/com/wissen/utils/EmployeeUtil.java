package com.wissen.utils;

import com.wissen.dto.*;
import com.wissen.entity.*;
import com.wissen.entity.key.EmployeeAccountId;
import com.wissen.entity.key.EmployeeSkillId;

public final class EmployeeUtil {

    public static Employee getEmployeeEntity(EmployeeDetailDTO employeeDetailDTO){
        Employee employee = new Employee();

        employee.setFirstName(employeeDetailDTO.getFirstName());
        employee.setGender(employeeDetailDTO.getGender());
        employee.setDob(employeeDetailDTO.getDob());
        employee.setBloodGroup(employeeDetailDTO.getBloodGroup());
        employee.setPrimaryPhoneNumber(employeeDetailDTO.getPrimaryPhoneNumber());
        employee.setSecondaryPhoneNumber(employeeDetailDTO.getSecondaryPhoneNumber());
        employee.setLastName(employeeDetailDTO.getLastName());
        employee.setWorkPhone(employeeDetailDTO.getWorkPhone());
        employee.setPrimaryEmergencyContactNumber(employeeDetailDTO.getPrimaryEmergencyContactNumber());
        employee.setSecondaryEmergencyContactNumber(employeeDetailDTO.getSecondaryEmergencyContactNumber());
        employee.setMaritalStatusDate(employeeDetailDTO.getMaritalStatusDate());
        employee.setEmail(employeeDetailDTO.getEmail());
        employee.setDoj(employeeDetailDTO.getDoj());
        employee.setExpDoj(employeeDetailDTO.getExpDoj());
        employee.setExitDate(employeeDetailDTO.getExitDate());
        employee.setType(employeeDetailDTO.getType());
        employee.setJoiningLocation(employeeDetailDTO.getJoiningLocation());
        employee.setStatus(employeeDetailDTO.getStatus());
        employee.setManager(employeeDetailDTO.getManager());
        employee.setDesignation(getDesignationEntity(employeeDetailDTO.getDesignationDTO()));
        employee.setDepartment(getDepartmentEntity(employeeDetailDTO.getDepartmentDTO()));
        employee.setRole(getRoleEntity(employeeDetailDTO.getRoleDTO()));

        return employee;
    }

    public static Designation getDesignationEntity(DesignationDTO designationDTO){
        Designation designation = new Designation();
        designation.setDesgId(designationDTO.getDesgId());
        designation.setDesgName(designationDTO.getDesgName());
        return designation;
    }

    public static Department getDepartmentEntity(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setDepId(departmentDTO.getDepId());
        department.setDepName(departmentDTO.getDepName());
        return department;
    }

    public static Role getRoleEntity(RoleDTO roleDTO){
        Role role = new Role();
        role.setRoleId(roleDTO.getRoleId());
        role.setRoleName(roleDTO.getRoleName());
        return role;
    }

    public static Address getAddressEntity(AddressDTO addressDTO, Employee employee){
        Address address = new Address();
        address.setEmployee(employee);
        address.setFlatNo(addressDTO.getFlatNo());
        address.setStreet(addressDTO.getStreet());
        address.setPincode(addressDTO.getPincode());
        address.setAddressType(addressDTO.getAddressType());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setState(addressDTO.getState());

        return address;
    }

    public static EmployeeSkill getEmployeeSkillEntity(EmployeeSkillDTO employeeSkillDTO, Employee employee){
        EmployeeSkill employeeSkill = new EmployeeSkill();
        Skill skill = new Skill();
        skill.setSkillId(employeeSkillDTO.getSkillId());
        skill.setSkillName(employeeSkillDTO.getSkillName());

        EmployeeSkillId employeeSkillId = new EmployeeSkillId();
        employeeSkillId.setEmployee(employee);
        employeeSkillId.setSkill(skill);

        employeeSkill.setEmployeeSkillId(employeeSkillId);
        employeeSkill.setLevels(employeeSkillDTO.getLevels());

        return employeeSkill;
    }

    public  static EmployeeAccount getEmployeeAccountEntity(EmployeeAccountDTO employeeAccountDTO, Employee employee){
        EmployeeAccount employeeAccount = new EmployeeAccount();
        EmployeeAccountId employeeAccountId = new EmployeeAccountId();

        employeeAccountId.setEmployee(employee);
        employeeAccount.setEmployeeAccountId(employeeAccountId);
        employeeAccount.setPan(employeeAccountDTO.getPan());
        employeeAccount.setPfNo(employeeAccountDTO.getPfNo());
        employeeAccount.setUan(employeeAccountDTO.getUan());

        return employeeAccount;
    }
}
