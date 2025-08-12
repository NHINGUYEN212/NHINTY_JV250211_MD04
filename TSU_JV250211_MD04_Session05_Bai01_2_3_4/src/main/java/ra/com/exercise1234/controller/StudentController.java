package ra.com.exercise1234.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.com.exercise1234.model.Student;
import ra.com.exercise1234.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(@RequestParam(required = false, name = "search") String search,
                               @RequestParam(required = false, name = "sort") String sort,
                               Model model) {
        List<Student> students = studentService.getAllStudents(search, sort);
        model.addAttribute("students", students);
        model.addAttribute("sort", sort);
        model.addAttribute("search", search);
        return "studentList";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        boolean result = studentService.addStudent(student);
        if (result) {
            redirectAttributes.addFlashAttribute("message", "Student has been added successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "An error occurred while adding the student");
        }
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        student.setId(id);
        boolean result = studentService.updateStudent(student);
        if (result) {
            redirectAttributes.addFlashAttribute("message", "Student has been updated successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "An error occurred while updating the student");
        }
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
