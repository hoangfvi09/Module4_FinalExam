package com.hoangfvi.luyentap.repository;

import com.hoangfvi.luyentap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}