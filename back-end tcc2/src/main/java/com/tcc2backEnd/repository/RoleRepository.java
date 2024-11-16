package com.tcc2backEnd.repository;

import com.tcc2backEnd.models.ERole;
import com.tcc2backEnd.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
