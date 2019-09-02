package io.github.deepanshut041.serendeepia.service;

import io.github.deepanshut041.serendeepia.domains.Role;
import io.github.deepanshut041.serendeepia.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public List<Role> findByName(String name) {
        return roleRepository.findAllByName(name);
    }
}
