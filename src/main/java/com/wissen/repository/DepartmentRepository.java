package com.wissen.repository;

import com.wissen.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
    public Department findByDepName(String name);

    @Query("SELECT c FROM Department c WHERE c.depName LIKE CONCAT('%',:searchString, '%')")
    public List<Department> getDepartmentByPattern(String searchString);
}
