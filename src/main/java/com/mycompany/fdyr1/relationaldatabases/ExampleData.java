package com.mycompany.fdyr1.relationaldatabases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ExampleData {

    private static final String[] STUDENT_NAMES = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"};
    private static final String[] COURSE_NAMES = {"Math", "Physics", "Chemistry", "Biology", "History", "Geography", "Art", "Music", "Programming", "Economics"};
    private static final String[] INSTRUCTORS = {"Dr. Smith", "Prof. Johnson", "Dr. Lee", "Prof. Brown", "Dr. Taylor"};

    public static void insertRandomData(Connection conn, int numberOfEntries) {
        Random rand = new Random();

        try {
            // Insert students
            String insertStudent = "INSERT INTO students (name, age) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertStudent)) {
                for (int i = 0; i < numberOfEntries; i++) {
                    String randomName = STUDENT_NAMES[rand.nextInt(STUDENT_NAMES.length)];
                    stmt.setString(1, randomName + " " + (i+1));
                    stmt.setInt(2, rand.nextInt(8) + 18); // Random age between 18-25
                    stmt.executeUpdate();
                }
            }

            // Insert courses
            String insertCourse = "INSERT INTO courses (name, instructor) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertCourse)) {
                for (int i = 0; i < numberOfEntries; i++) {
                    String randomCourse = COURSE_NAMES[rand.nextInt(COURSE_NAMES.length)];
                    stmt.setString(1, randomCourse);
                    stmt.setString(2, INSTRUCTORS[rand.nextInt(INSTRUCTORS.length)]);
                    stmt.executeUpdate();
                }
            }

            // Insert enrollments
            String insertEnrollment = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertEnrollment)) {
                for (int i = 0; i < numberOfEntries; i++) { // Assuming IDs 1 to 10 exist in both tables
                    stmt.setInt(1, rand.nextInt(numberOfEntries) + 1); // Random student_id
                    stmt.setInt(2, rand.nextInt(numberOfEntries) + 1); // Random course_id
                    stmt.executeUpdate();
                }
            }

            System.out.println("Random data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error while inserting data: " + e.getMessage());
        }
    }
}
