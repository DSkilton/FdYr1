/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fdyr1.relationaldatabases.POJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class EnrollmentMapper {
    //This is a data access object (DAO)
    
    public static List<Enrollment> getAllEnrollments(Connection conn) {
        List<Enrollment> enrollments = new ArrayList<>();
        String query = "SELECT * FROM enrollments";
        
        try (PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setStudentId(rs.getInt("student_id"));
                enrollment.setCourseId(rs.getInt("course_id"));
                enrollments.add(enrollment);     
            }
            
        } catch (Exception e) {
            System.out.println("Error fetching enrollments: " + e.getMessage());
        }
        
        return enrollments;
    }
    
}
