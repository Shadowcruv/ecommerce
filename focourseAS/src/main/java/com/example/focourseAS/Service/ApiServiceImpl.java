package com.example.focourseAS.Service;

import com.example.focourseAS.Entity.ApiUser;
import com.example.focourseAS.Repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService, UserDetailsService {

    private final ApiUserRepository apiUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApiServiceImpl(ApiUserRepository apiUserRepository, PasswordEncoder passwordEncoder) {
        this.apiUserRepository = apiUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveApiUser(ApiUser apiUser) {
        apiUser.setPassword(passwordEncoder.encode(apiUser.getPassword()));
        apiUserRepository.save(apiUser);
    }

    @Override
    public ApiUser retrieveUser(String username) {
        ApiUser apiUser = apiUserRepository.findByuserName(username);
        return apiUser;
    }

    @Override
    public List<ApiUser> retrieveUsers() {
      List<ApiUser> apiUsers = apiUserRepository.findAll();
        return apiUsers;
    }

    @Override
    public void deleteUser(String username) {
     //   apiUserRepository.deleteByuserName(username);
        ApiUser apiUser = apiUserRepository.findByuserName(username);
        apiUserRepository.deleteById(apiUser.getId());
      // apiUserRepository.remove
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiUser apiUser = apiUserRepository.findByuserName(username);
        if (apiUser == null){
            System.out.println("ApiUser not found in the database");
            throw new UsernameNotFoundException("ApiUser not found in the database");
        }else {
            System.out.println("User found in the database: "+ username);
        }
        Collection<SimpleGrantedAuthority> authoritiessList = new ArrayList<>();
        apiUser.getAuthoritiess().forEach(apiRole->{
            authoritiessList.add(new SimpleGrantedAuthority(apiRole.getName()));
        });

       /*
       Collection<ApiRole> authoritiess = apiUser.getAuthoritiess();
        for(ApiRole apiRole: authoritiess){
            authoritiessList.add(new SimpleGrantedAuthority(apiRole.getName()));

        }
      */

        return new org.springframework.security.core.userdetails.User(apiUser.getUserName(),apiUser.getPassword(),authoritiessList);
    }
}
