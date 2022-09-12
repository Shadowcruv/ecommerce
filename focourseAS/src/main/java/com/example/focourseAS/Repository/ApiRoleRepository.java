package com.example.focourseAS.Repository;

import com.example.focourseAS.Entity.ApiRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRoleRepository extends JpaRepository<ApiRole, Long> {
    ApiRole findByname(String rolename);
}
