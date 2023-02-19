package com.wissen.controller;

import com.wissen.entity.Role;
import com.wissen.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Role controller class.
 *
 * @author Vishal Tomar
 */
@Validated
@RestController
@RequestMapping("/api/role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @author Vishal Tomar
     * @description Method to fetch all roles.
     * @return List of roles.
     */
    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        log.info("START: Getting all roles");
        List<Role> roles = this.roleService.getAllRoles();
        log.info("START: Getting all roles");
        return ResponseEntity.status(HttpStatus.OK)
                .body(roles);
    }

    @PostMapping("/roles")
    public  ResponseEntity<List<Role>> saveRoles(@RequestBody final List<Role> roles) {
        log.info("START: Saving all roles");
        List<Role> savedRoles = this.roleService.saveRoles(roles);
        log.info("START: Saving all roles");
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedRoles);
    }
}
