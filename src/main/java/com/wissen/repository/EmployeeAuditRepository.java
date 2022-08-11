package com.wissen.repository;

import com.wissen.entity.EmployeeAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAuditRepository extends JpaRepository<EmployeeAudit, Integer> {
}
