package com.wissen.service;

import com.wissen.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> saveDepartments(final List<String> departments);
    public List<Department> searchDepartments(final String searchString);
    public List<Department> getAllDepartments();
    public Department getDepartmentById(int id);
}
