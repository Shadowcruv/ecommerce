package com.example.focourseAS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/studentspage")
@RestController
public class StudentPage {


    @GetMapping("/spage")
    public String getStudentsPage(){
        return "Hello Students";
    }

    @GetMapping("/dash")
    public String getDashBoard(){
        return "Students DashBoard";
    }

    @GetMapping("/courses")
    public String getCourses(){
        return "Courses available";
    }

    @GetMapping("/profile")
    public String getProfile(){
        return "Student Profile";
    }

    @GetMapping("/about")
    public String getAboutFocourse(){
        return "About Focourse app";
    }
}
