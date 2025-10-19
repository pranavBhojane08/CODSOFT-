package com.pack2;
import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        loadData();
    }

    // Add student
    public void addStudent(Student s) {
        students.add(s);
        saveData();
        System.out.println("✅ Student added successfully!");
    }

    // Remove student
    public void removeStudent(int roll) {
        boolean removed = students.removeIf(s -> s.getRollNumber() == roll);
        if (removed) {
            saveData();
            System.out.println("✅ Student removed successfully!");
        } else {
            System.out.println("❌ Student not found!");
        }
    }

    // Search student
    public void searchStudent(int roll) {
        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                System.out.println("🔍 Found: " + s);
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Update student
    public void updateStudent(int roll, String newName, String newGrade) {
        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                s.setName(newName);
                s.setGrade(newGrade);
                saveData();
                System.out.println("✅ Student updated successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found!");
            return;
        }
        System.out.println("\n📋 Student List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Save to file
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load from file
    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (Exception e) {
            students = new ArrayList<>(); // if file not found, start fresh
        }
    }
}
