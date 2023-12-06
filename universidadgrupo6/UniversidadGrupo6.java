/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo6;

import java.sql.Connection;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import universidadgrupo6.AccesoADatos.Conexion;
import universidadgrupo6.vistas.Escritorio;

/**
 *
 * @author Juan
 */
public class UniversidadGrupo6 {

    /**
     * @param args the command line arguments
     */
    //BIENBENIDOS ESTE ES EL COMIEZO DE LA GUIA 5 
    //REGLAS 1.1:
    // - ANTES DE MODIFICAR AVISAR
    // - DESCRIBIR LOS PROCESOS QUE HACEMOS Y COMENTARLOS EJEMPLOS (CONEXION A BASES DE DATOS, CONEXION A DRIVERS, ETC)
    // - HOLA MUNDO
    public static void main(String[] args) {
        // se estable conexion con la BD y los drivers
        Escritorio escr = new Escritorio();
        escr.setVisible(true);
        Connection con = Conexion.getConexion();

//        //Alumno alum1 = new Alumno(24542425,"Viltez", "Peron", LocalDate.of(2003, Month.MARCH, 21),true);
//        AlumnoData alum = new AlumnoData();
//        Alumno alum2 = new Alumno( 32422425, "veliz", "juana", LocalDate.of(2023, Month.MARCH, 23), true);
//        Alumno alum3 = new Alumno( 5353355, "Perez", "juan", LocalDate.of(2045, Month.MARCH, 12), true);
//        //alum.guardarAlumno(alum2);
        //alum.guardarAlumno(alum3);
        //alum.modificarAlumno(alum2);
        //alum.eliminarAlumno(3);
//        Materia m = new Materia("Matematicas", 1, true); 
//        Materia m1 = new Materia("Lengua", 2, true);
//        Materia m2 = new Materia("Historia", 1, true);
//        MateriaData md = new MateriaData(); 
//        //md.guardarMateria(m);
        //md.guardarMateria(m1);
        //md.guardarMateria(m2);
        ///Materia m2 = new Materia(2, "Historia Universal", 6, true); 
        ///md.modificarMateria(m2);
        ///md.eliminarMateria(3);
//        Inscripcion i = new Inscripcion(7, 3, 4);
//        Inscripcion i1 = new Inscripcion(5, 1, 5); 
//        Inscripcion i2 = new Inscripcion(5, 5, 1); 
        /// InscripcionData id = new InscripcionData(); 
//        id.guardarInscripcion(i);
//        id.guardarInscripcion(i1);
//        id.guardarInscripcion(i2);
        //id.BorrarInscripcion(1, 3);
//        for (int i = 0; i < id.ListarMateriasCursadas(3).size(); i++) {
//            Materia mat=new Materia();
//            System.out.println("");
//        }
        /// ArrayList<Materia> mater= (ArrayList<Materia>) id.ListarMateriasCursadas(3); 
//        for(Object mat: id.ListarMateriasNOCursadas(3)){
//            System.out.println(mat.toString());            
//        }
        ///  System.out.println("");
        /// for(Materia mat:(ArrayList<Materia>) id.ListarMateriasCursadas(3)){
        ///      System.out.println(mat.toString());            
        //  }
        //id.ActualizarNota(11, 4, 3);
        //for (Incripcion in: ) {      
        /// for (Object mat : id.ObtenerAlmunoPorMateria(1)) {
        ///    System.out.println(mat.toString());
        /// }
        

    }
    public JRadioButton jrMateCur;
    // Variables declaration - do not modify
    public ButtonGroup buttonGroup1;
}
