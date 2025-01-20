package tutoSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tutoSpringBoot.domain.Student;

@RestController
@RequestMapping("/alumnos")
public class StudentController {
    
    private List<Student> students = new ArrayList<Student>(Arrays.asList(
        new Student(1, "Laura García", "laura.g@mail.com", 21, "Ciencias de la Computación"),
        new Student(2, "Carlos Fernandez", "carlos.f@mail.com", 23, "Ingeniería Mecánica"),
        new Student(3, "Ana Martinez", "ana.m@mail.com", 22, "Administración de Empresas"),
        new Student(4, "Miguel Lopez", "miguel.l@mail.com", 24, "Ingeniería Eléctrica")
    ));

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        return null;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @PutMapping
    public Student putStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setAge(student.getAge());
                s.setCourse(student.getCourse());

                return s;
            }
        }
        return null;
    }

    @PatchMapping
    public Student patchStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                if (student.getName() != null) {
                    s.setName(student.getName());
                }

                if (student.getEmail() != null) {
                    s.setEmail(student.getEmail());
                }

                if (student.getAge() != 0) {
                    s.setAge(student.getAge());
                }

                if (student.getCourse() != null) {
                    s.setCourse(student.getCourse());
                }

                return s;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                return s;
            }
        }
        return null;
    }
}
