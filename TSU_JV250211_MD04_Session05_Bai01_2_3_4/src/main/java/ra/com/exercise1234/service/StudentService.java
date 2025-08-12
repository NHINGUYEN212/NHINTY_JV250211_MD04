package ra.com.exercise1234.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.exercise1234.model.Student;
import ra.com.exercise1234.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(String search, String sort) {
        return studentRepository.getAllStudents(search, sort);
    }

    public boolean addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    public boolean updateStudent(Student student) {
        return studentRepository.updateStudentById(student);
    }

    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudentById(id);
    }

}
