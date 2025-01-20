/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fdyr1.relationaldatabases.POJO;

import com.mycompany.fdyr1.relationaldatabases.DAO.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class CourseMapper {
    //This is a data access object (DAO)
    
    public static List<Course> getAllCourses(Connection conn) {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";
        
        try (PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setInstructor(rs.getString("instructor"));
                courses.add(course);     
            }
            
        } catch (Exception e) {
            System.out.println("Error fetching enrollments: " + e.getMessage());
        }
        
        return courses;
    }

}
