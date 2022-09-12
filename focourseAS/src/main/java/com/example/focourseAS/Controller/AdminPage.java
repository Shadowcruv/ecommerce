package com.example.focourseAS.Controller;

import com.example.focourseAS.Entity.ApiUser;
import com.example.focourseAS.Service.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/adminpage")
@RestController
public class AdminPage {

    private final ApiServiceImpl apiService;

    @Autowired
    public AdminPage(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('role_Admin')")
    public List<ApiUser> retrieveApiUsersList(){
        List<ApiUser> apiUsers = apiService.retrieveUsers();
        return apiUsers;
    }

    @GetMapping(path = "{studentUsername}")
    @PreAuthorize("hasAnyAuthority('role_AdminTrainee')")
    public ApiUser retrieveApiUser(@PathVariable("studentUsername") String username){
        ApiUser apiUser = apiService.retrieveUser(username);
        return apiUser;
    }
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
//    @PreAuthorize("hasAnyAuthority('role_AdminTrainee','role_Admin')")

    @GetMapping("/check")
    @PreAuthorize("hasAnyAuthority('role_AdminTrainee','role_Admin')")
    public String getStudentsPage(){
        return "You are an admin";
    }

    @PostMapping

    public void saveCApiUser(@RequestBody ApiUser apiUser){
     apiService.saveApiUser(apiUser);
        System.out.println("Added Successfully");
    }

    @DeleteMapping(path = "{studentUsername}")
    @PreAuthorize("hasAnyAuthority('role_Admin')")
    public void deleteUser(@PathVariable("studentUsername") String username){

        apiService.deleteUser(username);
    }






}
