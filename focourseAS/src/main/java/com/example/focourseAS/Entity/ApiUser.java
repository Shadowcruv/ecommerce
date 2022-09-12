package com.example.focourseAS.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class ApiUser {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "student_sequence"
    )

    private Long Id;
    private String userName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }
   )
    private Collection<ApiRole> authoritiess;

    public ApiUser() {

    }

    public ApiUser( String userName, String password, Collection<ApiRole> authoritiess) {

        this.userName = userName;
        this.password = password;
        this.authoritiess = authoritiess;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<ApiRole> getAuthoritiess() {
        return authoritiess;
    }

    public void setAuthoritiess(Collection<ApiRole> authoritiess) {
        this.authoritiess = authoritiess;
    }
}
