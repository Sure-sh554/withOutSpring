package org.example;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);

    }

    @Override
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);

    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);

    }
}
