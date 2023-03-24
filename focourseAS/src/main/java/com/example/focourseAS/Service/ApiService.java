package com.example.focourseAS.Service;

import com.example.focourseAS.Entity.ApiUser;

import java.util.List;

public interface ApiService {

    void saveApiUser(ApiUser apiUser);
    ApiUser retrieveUser(String username);
    List<ApiUser> retrieveUsers();
    void  deleteUser(String username);

}
