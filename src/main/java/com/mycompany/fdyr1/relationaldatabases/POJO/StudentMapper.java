/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fdyr1.relationaldatabases.POJO;

import com.mycompany.fdyr1.relationaldatabases.DAO.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class StudentMapper {
    //This is a data access object (DAO)
    
    public static List<Student> getAllStudents(Connection conn) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        
        try (PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            students.add(student);
        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        
        return students;
    }
    
    
}
