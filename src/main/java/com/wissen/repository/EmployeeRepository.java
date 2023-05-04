package com.wissen.repository;

import com.wissen.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Employee repository class.
 */
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE CONCAT('%',:searchString, '%') OR e.lastName LIKE CONCAT('%',:searchString, '%') OR " +
            "e.wissenId LIKE CONCAT('%',:searchString, '%') OR e.email LIKE CONCAT('%',:searchString, '%')")
    public List<Employee> searchEmployee(String searchString);

}
