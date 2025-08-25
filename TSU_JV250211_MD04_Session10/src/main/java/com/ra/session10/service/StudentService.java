package com.ra.session10.service;

import com.ra.session10.model.dto.StudentDTO;
import com.ra.session10.model.entity.Student;
import com.ra.session10.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentRepository.getStudents();
    }

    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public boolean saveStudent(StudentDTO studentDTO) {
        Student student = convertStudentDTOToStudent(studentDTO);
        return studentRepository.saveStudent(student);
    }

    public boolean updateStudent(long id ,StudentDTO studentDTO) {
        Student student = convertStudentDTOToStudent(studentDTO);
        student.setId(id);
        return studentRepository.saveStudent(student);
    }

    @Transactional
    public String deleteStudentById(Long id) {
        Student student = findById(id);
        if (student != null) {
            if (student.getIsStudying()) {
                return "Không thể xóa học sinh đang học !" ;
            }else {
                studentRepository.deleteStudentById(id);
                return "Xóa học sinh thành công !" ;
            }
        }else {
            return "Không tìm thấy học sinh  !";
        }
    }

    public Student convertStudentDTOToStudent(StudentDTO studentDTO) {
        return Student
                .builder()
                .studentName(studentDTO.getStudentName())
                .ageMark(studentDTO.getAgeMark())
                .isStudying(studentDTO.getIsStudying())
                .email(studentDTO.getEmail())
                .build();
    }


}
