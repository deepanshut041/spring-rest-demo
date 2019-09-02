package io.github.deepanshut041.serendeepia.repository;

import io.github.deepanshut041.serendeepia.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Boolean existsByName(String name);
    List<Role> findAllByName(String name);
}
