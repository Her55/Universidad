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
import universidadgrupo6.Entidades.Materia;

/**
 *
 * @author Juan
 */
public class MateriaData {

    private Connection con = null;

    public MateriaData() {

        con = Conexion.getConexion();

    }

    public Materia buscarMateria(int id) {

        Materia mate = new Materia();
        try {
            ///String query = "SELECT idMateria, nombre, anio, estado FROM materia WHERE idMateria = ? AND estado = 1"; 
            String query = "SELECT idMateria, nombre, anio, estado FROM materia WHERE idMateria = ?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                mate.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la materia con id: " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mate;
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia(nombre, anio, estado) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Materia añadido con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }
    }

    public ArrayList listarMateria() {
         ArrayList<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int cont = 0;
            while (rs.next()) {
                Materia mate = new Materia();
                cont++;
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                mate.setEstado(true);
                materias.add(mate);
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna materia");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }
    
    public void eliminarMateria(int id){  
        try {
            String sql = "UPDATE materia SET estado=0 where idMateria="+id;
            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            int resultado = ps.executeUpdate();          
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado==1) {               
                JOptionPane.showMessageDialog(null, "Materia dada de baja.");
            } else {
                JOptionPane.showMessageDialog(null, "Materia no encontrado.");
            }     
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   
   public void modificarMateria(Materia materia){       
        String sql = "UPDATE materia SET nombre=?, anio=?, estado=? where idMateria=?";
       
        try {            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);            
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado==1) {               
                JOptionPane.showMessageDialog(null, "Materia modificada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar la materia.");
            }          
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar materia" + ex.getMessage());
        }
    }
    
    
    
}
