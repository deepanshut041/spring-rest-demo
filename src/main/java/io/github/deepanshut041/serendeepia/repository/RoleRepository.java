package io.github.deepanshut041.serendeepia.repository;

import io.github.deepanshut041.serendeepia.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findAllByName(String name);
}
