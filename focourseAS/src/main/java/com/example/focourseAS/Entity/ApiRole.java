package com.example.focourseAS.Entity;

import javax.persistence.*;


@Entity
@Table

public class ApiRole {

    @javax.persistence.Id
    @SequenceGenerator(
            name = "apiRole_sequence",
            sequenceName = "apiRole_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "apiRole_sequence"
    )
    private Long id;
    private String name;

    public ApiRole() {

    }

    public ApiRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
