package com.example.demoLoginJWT.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@Document
public class Profesor {
    @Id
    private String id;
    private Long dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private int antiguedad;
    private byte[] matricula;
    public int getEdad() {
        if (fechaDeNacimiento != null) {
            LocalDate ahora = LocalDate.now();
            return Period.between(fechaDeNacimiento, ahora).getYears();
        } else {
            return 0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public byte[] getMatricula() {
        return matricula;
    }

    public void setMatricula(byte[] matricula) {
        this.matricula = matricula;
    }

    public Profesor() {
    }

    public Profesor(String id, Long dni, String nombre, String apellido, LocalDate fechaDeNacimiento, int antiguedad, byte[] matricula) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.antiguedad = antiguedad;
        this.matricula = matricula;
    }
}
