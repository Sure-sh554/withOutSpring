package org.example;


public class Main {
    public static void main(String[] args) {
//Manual Dependency
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);
        ConsoleUI consoleUI = new ConsoleUI(studentService);
        consoleUI.start();


    }
}
