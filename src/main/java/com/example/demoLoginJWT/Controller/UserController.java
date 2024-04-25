package com.example.demoLoginJWT.Controller;

import com.example.demoLoginJWT.Models.Alumno;
import com.example.demoLoginJWT.Models.Profesor;
import com.example.demoLoginJWT.Models.User;
import com.example.demoLoginJWT.Service.AuthService;
import com.example.demoLoginJWT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${colegio-api-url}")
    private String colegioApiUrl;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User request) {
        // Lógica para registrar al usuario en la base de datos de autenticación
        User user = userService.createUser(request);

        // Determinar el rol del usuario y crear el modelo correspondiente en la API del colegio
        if (user.getRol().equals("alumno")) {
            createAlumnoInColegio(user);
        } else if (user.getRol().equals("profesor")) {
            createProfesorInColegio(user);
        }

        return ResponseEntity.ok("User registered successfully");
    }

    private void createAlumnoInColegio(User user) {
        // Crear el modelo de alumno con los datos del usuario
        Alumno alumno = new Alumno();
        alumno.setNombre(user.getUsername()); // Asignar el nombre del usuario como nombre del alumno
        alumno.setDni(user.getDni()); // Asignar el DNI del usuario al alumno
        // Asignar otros atributos del alumno si es necesario

        // Llamar a la API del colegio para crear el modelo de alumno
        restTemplate.postForObject(colegioApiUrl + "/alumnos", alumno, Alumno.class);
    }

    private void createProfesorInColegio(User user) {
        // Crear el modelo de profesor con los datos del usuario
        Profesor profesor = new Profesor();
        profesor.setNombre(user.getUsername()); // Asignar el nombre del usuario como nombre del profesor
        profesor.setDni(user.getDni()); // Asignar el DNI del usuario al profesor
        // Asignar otros atributos del profesor si es necesario

        // Llamar a la API del colegio para crear el modelo de profesor
        restTemplate.postForObject(colegioApiUrl + "/profesores", profesor, Profesor.class);
    }
}