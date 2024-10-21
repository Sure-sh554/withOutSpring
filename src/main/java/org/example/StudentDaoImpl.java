package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    private Map<Integer, Student> studentsDb = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        studentsDb.put(student.getId(), student);

    }

    @Override
    public Student getStudent(int id) {
        return studentsDb.get(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentsDb.values());
    }

    @Override
    public void updateStudent(Student student) {
        studentsDb.put(student.getId(), student);


    }

    @Override
    public void deleteStudent(int id) {
        studentsDb.remove(id);

    }
}
