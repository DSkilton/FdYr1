package com.mycompany.fdyr1.relationaldatabases;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite3DB {
    private static final String URL = "jdbc:sqlite:example.db"; // SQLite database file

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
            
//            if (conn != null) {
//                ExampleData.insertRandomData(conn, 1000);
//            }
            return conn;
        } catch (SQLException e) {
            System.out.println("Failed to connect to SQLite: " + e.getMessage());
            return null;
        }
    }

    public static void initialiseDatabase() {
        File dbFile = new File("example.db");
        if (!dbFile.exists()) {
            System.out.println("Database not found. Creating new database...");
            try (Connection conn = DriverManager.getConnection(URL); 
                Statement stmt = conn.createStatement()) {
                System.out.println("HERE " + dbFile.getAbsolutePath());

                // Create tables
                String createStudents = """
                        CREATE TABLE IF NOT EXISTS students (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            name TEXT NOT NULL,
                            age INTEGER
                        );
                    """;

                String createCourses = """
                        CREATE TABLE IF NOT EXISTS courses (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            name TEXT NOT NULL,
                            lecturer TEXT
                        );
                    """;

                String createEnrollments = """
                        CREATE TABLE IF NOT EXISTS enrollments (
                            student_id INTEGER,
                            course_id INTEGER,
                            FOREIGN KEY (student_id) REFERENCES students (id),
                            FOREIGN KEY (course_id) REFERENCES courses (id)
                        );
                    """;

                stmt.execute(createStudents);
                stmt.execute(createCourses);
                stmt.execute(createEnrollments);

                System.out.println("Database and tables created successfully.");
            } catch (Exception e) {
                System.out.println("Error while creating database: " + e.getMessage());
            }
        } else {
            System.out.println("Database found. No action needed.");
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close SQLite connection: " + e.getMessage());
            }
        }
    }
}
