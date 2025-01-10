package com.example.rede_social_estudantes.controller;

import com.example.rede_social_estudantes.model.Student;
import com.example.rede_social_estudantes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(Student student, Model model) {
        studentRepository.save(student);
        model.addAttribute("message", "Cadastro realizado com sucesso!");
        return "register";
    }
}
