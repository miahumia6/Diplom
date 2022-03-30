package com.prep.library.repository;

import java.util.Optional;

import com.prep.library.entity.ERole;
import com.prep.library.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
