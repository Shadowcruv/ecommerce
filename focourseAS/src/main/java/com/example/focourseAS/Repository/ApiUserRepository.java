package com.example.focourseAS.Repository;

import com.example.focourseAS.Entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {
    ApiUser findByuserName(String username);
    void deleteByuserName(String username);
}
