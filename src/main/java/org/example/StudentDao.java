package org.example;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    Student getStudent(int id);

    List<Student> getAllStudents();

    void updateStudent(Student student);

    void deleteStudent(int id);
}
