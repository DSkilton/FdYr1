/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fdyr1.relationaldatabases.DAO;

/**
 *
 * @author Student
 */
public class Course {
    private int id;
    private String name;
    private String instructor;
    
    public Course() {   }

    public Course(int Id, String name, String instructor) {
        this.id = Id;
        this.name = name;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }    
    
    
}
