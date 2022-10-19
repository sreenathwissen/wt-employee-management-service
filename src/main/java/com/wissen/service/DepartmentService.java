package com.wissen.service;

import com.wissen.entity.Department;

import java.util.List;

public interface DepartmentService {
    public void saveDepartments(final List<String> departments);
    public List<Department> getAllDepartments();
    public Department getDepartmentById(int id);
}
