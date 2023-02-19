package com.wissen.service.impl;

import com.wissen.constants.Constants;
import com.wissen.entity.Role;
import com.wissen.exception.DataAlreadyExistException;
import com.wissen.repository.RoleRepository;
import com.wissen.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation class for role service.
 *
 * @author Vishal Tomar
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getRoleByName(String name) {
        return this.roleRepository.getRoleByRoleName(name);
    }

    @Override
    public List<Role> saveRoles(List<Role> roles) {
        roles.stream().forEach(role -> {
            if(roleRepository.isRoleExists(role.getRoleName())) {
                log.error(Constants.SKILL_DETAILS_ALREADY_PRESENT_LOG_MESSAGE, role.toString());
                throw new DataAlreadyExistException(Constants.DETAILS_ALREADY_PRESENT_MESSAGE);
            }
        });

        return this.roleRepository.saveAll(roles);
    }


}
