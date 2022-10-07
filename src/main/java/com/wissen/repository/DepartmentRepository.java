package com.wissen.repository;

import com.wissen.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
    public Department findByDepName(String name);
}
