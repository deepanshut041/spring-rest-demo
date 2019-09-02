package io.github.deepanshut041.serendeepia.service;

import io.github.deepanshut041.serendeepia.domains.Role;

import java.util.List;

public interface RoleService {
    List<Role> findByName(String name);

}
