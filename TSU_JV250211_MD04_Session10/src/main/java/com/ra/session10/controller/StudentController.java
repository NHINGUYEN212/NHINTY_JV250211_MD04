package com.ra.session10.controller;
import com.ra.session10.model.dto.StudentDTO;
import com.ra.session10.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private com.ra.session10.service.StudentService studentService;

    @GetMapping
    public String listStudents( Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/studentList"; // Tạo view tương ứng
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        String rs = studentService.deleteStudentById(id);
        redirectAttributes.addFlashAttribute("message", rs);
        return "redirect:/students";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes , Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("student", studentDTO);
            return "student/addStudent";
        }

        boolean rs = studentService.saveStudent(studentDTO);
        if(rs) {
            redirectAttributes.addFlashAttribute("message", "Student added successfully");
        }else {
            redirectAttributes.addFlashAttribute("message", "Student added failed");
        }
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/editStudent";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable long id , @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                BindingResult bindingResult , Model model , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", studentDTO);
            return "student/editStudent";
        }

        boolean rs = studentService.updateStudent(id ,studentDTO);
        if(rs) {
            redirectAttributes.addFlashAttribute("message", "Student updated successfully");
        }else {
            redirectAttributes.addFlashAttribute("message", "Student updated failed");
        }
        return "redirect:/students";
    }


}
