package com.example.focourseAS.Security;

import com.example.focourseAS.Entity.ApiRole;
import com.example.focourseAS.Entity.ApiUser;
import com.example.focourseAS.Repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class ExtraConfig {

    private final ApiUserRepository apiUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ExtraConfig(ApiUserRepository apiUserRepository, PasswordEncoder passwordEncoder) {
        this.apiUserRepository = apiUserRepository;
        this.passwordEncoder = passwordEncoder;
    }




    @Bean
    public ApiUser apiUser() {
        Collection<ApiRole> xc = (Collection<ApiRole>) new ArrayList<ApiRole>();
        xc.add(new ApiRole("role_Admin"));
        xc.add(new ApiRole("role_Student"));

        apiUserRepository.save(
                new ApiUser("samuel", passwordEncoder.encode("chidubem"),xc));
        return null;
    }

}
