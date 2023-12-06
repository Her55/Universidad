/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo6.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo6.Entidades.Alumno;
import universidadgrupo6.Entidades.Inscripcion;
import universidadgrupo6.Entidades.Materia;

/**
 *
 * @author Juan
 */
public class InscripcionData {
        
    private Connection con = null;
    private MateriaData materiaData = new MateriaData(); 
    private AlumnoData alumnoData= new AlumnoData(); 
    
    public InscripcionData() {
        con = Conexion.getConexion();
    }
    public void guardarInscripcion(Inscripcion inscripcion) {
       ///HABRÍA QUE VER CÓMO USAR LOS MÉTODOS DE LAS CLASES YA CREADAS DE MATERIADATA Y ALUMNODATA
        /*
       Alumno alu = new Alumno(0, 0, null, null, null, false);
       alu =alumnoData.buscarAlumno(inscripcion.getIdAlumno());
       Materia mate = new Materia(); 
       mate = materiaData.buscarMateria(inscripcion.getIdMateria()); 
        */
       
        int idAlu = inscripcion.getIdAlumno();
        int idMate = inscripcion.getIdMateria(); 
        boolean idAlu2=false; 
        boolean idMate2=false; 
        
       ///CONSULTA POR ESTADO DEL ALUMNO
      try {
          String Sqlalumno = "SELECT `estado` FROM `alumno` WHERE idAlumno ="+idAlu; 
            PreparedStatement ps = con.prepareStatement(Sqlalumno, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idAlu2 = rs.getBoolean("estado");                
            } 
            ///else {
           ///     JOptionPane.showMessageDialog(null, "No se encontro el alumno con id: " + idAlu);
           /// }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
         ////CONSULTA POR EL ESTADO DE LA MATERIA
         try {
          String Sqlmate = "SELECT `estado` FROM `materia` WHERE idMateria ="+idMate; 
            PreparedStatement ps = con.prepareStatement(Sqlmate, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idMate2 = rs.getBoolean("estado");                
            } 
            ///else {
           ///     JOptionPane.showMessageDialog(null, "No se encontro el alumno con id: " + idAlu);
           /// }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }     
       
       if(idAlu2==true && idMate2==true){
       
           String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
       
        try {            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getIdAlumno());
            ps.setInt(3, inscripcion.getIdMateria());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
              /// inscripcion.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción añadida con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
        } 
 
        
       }else{
       JOptionPane.showMessageDialog(null, "El alumno o la materia no está activa/o");
       }
       
       
    }
    
    public ArrayList listarInscripcion(){
        ArrayList<Inscripcion>inscripciones=new ArrayList<>();
          
        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet rs = ps.executeQuery(); 
            int cont=0;
            while (rs.next()) {  
                Inscripcion ins = new Inscripcion();      
                cont++;
                ins.setIdInscripto(rs.getInt("idInscripto"));
                ins.setNota(rs.getDouble("nota"));
                ins.setIdAlumno(rs.getInt("idAlumno"));
                ins.setIdMateria(rs.getInt("idMateria"));     
               inscripciones.add(ins); 
            }
            if (cont==0) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna inscripción");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos "+ex);
        }
        return inscripciones;
    }
    
    public ArrayList listarInscripcionPorAlumno(int id){
        
        ArrayList<Inscripcion>inscripciones=new ArrayList<>();
        
        
        try {
            String sql = "SELECT * FROM inscripcion WHERE idAlumno="+id;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet rs = ps.executeQuery(); 
            int cont=0;
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                cont++;
                ins.setIdInscripto(rs.getInt("idInscripto"));
                ins.setNota(rs.getDouble("nota"));
                ins.setIdAlumno(rs.getInt("idAlumno"));
                ins.setIdMateria(rs.getInt("idMateria"));     
               inscripciones.add(ins); 
            }
            if (cont==0) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna inscripción");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos "+ex);
        }
        return inscripciones;
    }
    
    public void BorrarInscripcion(int idMateria, int idAlumno){
        String sql="DELETE FROM inscripcion WHERE idMateria=? and idAlumno=?";         
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idMateria);
            ps.setInt(2, idAlumno);
            int rs= ps.executeUpdate();
            if(rs>0){
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos "+ex);
        }        
    }
    
    public ArrayList ListarMateriasCursadas(int idAlumnos){
        ArrayList<Materia>cursadas=new ArrayList<>(); 
        
        try {
            String sql="SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, materia WHERE "
                + "inscripcion.idMateria=materia.idMateria AND inscripcion.idAlumno=?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            ps.setInt(1, idAlumnos);
            ResultSet rs = ps.executeQuery(); 
            int cont=0;
            while (rs.next()) { 
                Materia mat=new Materia(); 
                cont++;
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setEstado(true);
               cursadas.add(mat); 
            }
            if (cont==0) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna materia");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos "+ex);
        }
        return cursadas;                
    }
    
    public ArrayList ListarMateriasNOCursadas(int idAlumnos){
        ArrayList<Materia>noCursadas=new ArrayList<>();             
        try {
            String sql="SELECT * FROM materia WHERE estado=1 AND idMAteria NOT in"
                    + "(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            ps.setInt(1, idAlumnos);
            ResultSet rs = ps.executeQuery(); 
            int cont=0;
            while (rs.next()) { 
                Materia mat=new Materia(); 
                cont++;
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setEstado(true);
               noCursadas.add(mat); 
            }
            if (cont==0) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna materia no cursadas");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos "+ex);
        }
        return noCursadas;                
    }
    
    public void ActualizarNota(int idAlumno, int idMateria, double nota){
        String sql = "UPDATE inscripcion SET nota=? where idAlumno=? AND idMateria=?";        
        try {            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);          
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);            
            ps.setInt(3, idMateria);            
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado==1) {               
                JOptionPane.showMessageDialog(null, "Nota modificada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar la nota.");
            }          
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la nota" + ex.getMessage());
        }
    }
    
    public ArrayList ObtenerAlmunoPorMateria(int idMateria){
        ArrayList<Alumno>alumnos=new ArrayList<>();        
        try {
            String sql="SELECT * FROM alumno, inscripcion WHERE "
                + "alumno.idAlumno=inscripcion.idAlumno AND inscripcion.idMAteria=?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery(); 
            int cont=0;
            while (rs.next()) { 
                cont++;
                Alumno alu=new Alumno();
                alu.setApellido(rs.getString("apellido"));
                alu.setDni(rs.getInt("dni"));
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setFechaNacimento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setNombre(rs.getString("nombre"));
                alu.setEstado(true);
                alumnos.add(alu);
            }
            if (cont==0) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun alumno en esta materia");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos "+ex);
        }
        return alumnos; 
    }
    
    public Inscripcion buscarInscripcion(int idInscripcion){
        Inscripcion inscr= new Inscripcion();
        try {            
            String query = "SELECT * FROM inscripcion WHERE idInscripto="+idInscripcion;
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inscr.setIdAlumno(rs.getInt("idAlumno"));
                inscr.setIdInscripto(rs.getInt("idInscripto")); 
                inscr.setIdMateria(rs.getInt("idMateria"));
                inscr.setNota(rs.getDouble("nota"));
               } else {
                JOptionPane.showMessageDialog(null, "No se encontro la inscripcion");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscr;
    }
    
} 








