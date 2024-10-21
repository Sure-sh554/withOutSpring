package org.example;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private StudentService studentService;
    private Scanner scanner;

    public ConsoleUI(StudentService studentService) {
        this.studentService = studentService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    public void printMenu() {
        System.out.println("\n1 Add Student");
        System.out.println("2.View Student");
        System.out.println("3.View All Student");
        System.out.println("4.Update Student");
        System.out.println("5.Delete Student");
        System.out.println("6.Exit");
        System.out.println("Enter your choice: ");
    }

    private void addStudent() {
        System.out.println("Enter Student ID");
        int id = scanner.nextInt();
        scanner.nextLine();//consume next line
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter student email: ");
        String email = scanner.nextLine();
        Student student = new Student(id, name, email);
        studentService.addStudent(student);
        System.out.println("Student added successfully");

    }

    private void viewStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = studentService.getStudent(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }


    }

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Student student = studentService.getStudent(id);
        if (student != null) {
            System.out.print("Enter new name (or press enter to skip): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                student.setName(name);
            }
            System.out.print("Enter new email (or press enter to skip): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                student.setEmail(email);
            }
            studentService.updateStudent(student);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }
}
