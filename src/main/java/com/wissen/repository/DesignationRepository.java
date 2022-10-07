package com.wissen.repository;

import com.wissen.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {
    public Designation findByDesgName(String name);
}
