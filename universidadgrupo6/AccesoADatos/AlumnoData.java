/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo6.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo6.Entidades.Alumno;

/**
 *
 * @author Juan
 */
public class AlumnoData {

    private Connection con = null;
    
    public AlumnoData() {

        con = Conexion.getConexion();

    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try {            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimento()));//localDate a Date
            ps.setBoolean(5, alumno.isEstado()); // if reducido
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
               alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
    }
    
    public Alumno buscarAlumno(int id) {
        Alumno alu = new Alumno();
        try {
            String query = "SELECT dni, apellido,nombre, fechaNacimiento, estado FROM alumno WHERE idAlumno=? and estado=1";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el alumno con id: " + id);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alu;
    }

    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alu = new Alumno();
        try {
            String query = "SELECT idAlumno, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE dni=?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(dni);
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el alumno con DNI: " + dni);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alu;
    }
    
    public ArrayList listarAlumno(){
        ArrayList<Alumno>alumnos=new ArrayList<>();        
        try {
            String sql = "SELECT * FROM alumno WHERE estado=1";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet rs = ps.executeQuery(); 
            int cont=0;
            while (rs.next()) {
                Alumno alu = new Alumno();
                cont++;
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(true);
                alumnos.add(alu);
            }
            if (cont==0) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }
    
    public void modificarAlumno(Alumno alumno){       
        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=?, estado=? where idAlumno=?";
        try {            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);            
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimento()));//localDate a Date
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado==1) {               
                JOptionPane.showMessageDialog(null, "Alumno modificado con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el alumno.");
            }          
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar alumno" + ex.getMessage());
        }
    }
    
    public void eliminarAlumno(int id){  
        String sql = "UPDATE alumno SET estado=0 where idAlumno="+id;
        try {            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            int resultado = ps.executeUpdate();          
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado==1) {               
                JOptionPane.showMessageDialog(null, "Alumno dado de baja.");
            } else{
                JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
            }     
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
