package com.mycompany.fdyr1;


import com.mycompany.fdyr1.relationaldatabases.POJO.EnrollmentMapper;
import com.mycompany.fdyr1.relationaldatabases.DAO.Enrollment;
import com.mycompany.fdyr1.relationaldatabases.SQLite3DB;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class FdYr1 { // start of our file/ class
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) { // start of main
        SQLite3DB.initialiseDatabase();
        Connection conn = SQLite3DB.connect();
        
        EnrollmentMapper.getAllEnrollments(conn);
        System.out.println(EnrollmentMapper.getAllEnrollments(conn));
        
    }
    
} // end of the class 
