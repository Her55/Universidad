/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo6.Entidades;

import java.time.LocalDate;

/**
 *
 * @author Juan
 */
public class Alumno {

    //Se declarar los atributos privados de la clase
    private int idAlumno;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimento;
    private boolean estado;
//se realiza los constructores de los dichos atributos tanto uno vacio como uno con todo y otro sin idAlumno

    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNacimento, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimento = fechaNacimento;
        this.estado = estado;
    }

    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNacimento, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimento = fechaNacimento;
        this.estado = estado;
    }

    public Alumno() {
    }
// Luego se crea los geter y seter de los dichos atributos

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimento() {
        return fechaNacimento;
    }

    public void setFechaNacimento(LocalDate fechaNacimento) {
        this.fechaNacimento = fechaNacimento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
// Se realiza el toString para que muestre el resultado y no el lugar almacenado

    @Override
    public String toString() {
        return dni+", " + apellido+", " + nombre ;
    }

}
