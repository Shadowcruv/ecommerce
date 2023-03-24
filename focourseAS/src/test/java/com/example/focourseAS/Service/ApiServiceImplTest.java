package com.example.focourseAS.Service;

import com.example.focourseAS.Entity.ApiRole;
import com.example.focourseAS.Entity.ApiUser;
import com.example.focourseAS.Repository.ApiUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
class ApiServiceImplTest {

    private final ApiUserRepository apiUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    ApiServiceImplTest(ApiUserRepository apiUserRepository, PasswordEncoder passwordEncoder) {
        this.apiUserRepository = apiUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void saveApiUser() {
        Collection<ApiRole> xc = (Collection<ApiRole>) new ArrayList<ApiRole>();

        xc.add(new ApiRole("role_AdminTrainee"));
        ApiUser apiUser = new ApiUser("ebuka","chima12345",xc);
        apiUser.setPassword(passwordEncoder.encode(apiUser.getPassword()));
        apiUserRepository.save(apiUser);
    }


}