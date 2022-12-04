package com.wissen.repository;

import com.wissen.entity.Department;
import com.wissen.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {

    public Designation findByDesgName(String name);

    @Query("SELECT c FROM Designation c WHERE c.desgName LIKE CONCAT('%',:searchString, '%')")
    public List<Designation> getDesignationByPattern(String searchString);

    public Designation getDesignationByDesgName(String name);
}
