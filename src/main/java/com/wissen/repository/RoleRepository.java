package com.wissen.repository;

import com.wissen.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByRoleName(String name);

    public Role getRoleByRoleName(String name);

    @Query("SELECT CASE WHEN count(c) > 0 THEN true ELSE false END FROM Role c where UPPER(c.roleName) = UPPER(:roleName)")
    boolean isRoleExists(String roleName);
}
