package com.wissen.service.impl;

import com.wissen.entity.Department;
import com.wissen.repository.DepartmentRepository;
import com.wissen.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void saveDepartments (final List<String> departments){
        List<Department> departmentEntities = departments.stream()
                .map(department -> getDepartment(department))
                .collect(Collectors.toList());

        this.departmentRepository.saveAll(departmentEntities);
    }

    private Department getDepartment(final String department) {
        Department departmentEntity = new Department();
        departmentEntity.setDepName(department);

        return departmentEntity;
    }

    @Override
    public List<Department> getAllDepartments(){
        List<Department> departments = new ArrayList<Department>();
        departmentRepository.findAll().forEach(department -> departments.add(department));
        return departments;
    }

    @Override
    public Department getDepartmentById(int id){
        return departmentRepository.findById(id).get();
    }
}
