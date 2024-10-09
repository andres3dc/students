package co.edu.umanizales.studends.controller;

import co.edu.umanizales.studends.controller.dto.PercentageByGenderDTO;
import co.edu.umanizales.studends.model.Student;
import co.edu.umanizales.studends.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        studentService.getStudents().add(student);
        return student;
    }

    @GetMapping("/list")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/gender-percentage/{gender}")
    public String getGenderPercentage(@PathVariable("gender") byte gender) {
        float percentage = studentService.getPercentageGender(gender);
        if(gender == 1 || gender == 2) {
            return "El porcentaje del genero " + gender + " es: " + percentage;
        }else {
            return "Ingrese un genero valido";
        }
    }

    @GetMapping("/gender-percentage-work-salary/{gender}")
    public PercentageByGenderDTO getGenderPercentageWorkSalary(@PathVariable("gender") byte gender) {
        if(studentService.getStudents().size() == 0) {
            return null;
        }
        return studentService.getPercentageWorkByGender(gender);
    }
}
