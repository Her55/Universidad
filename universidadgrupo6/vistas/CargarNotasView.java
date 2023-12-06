/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo6.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo6.AccesoADatos.AlumnoData;
import universidadgrupo6.AccesoADatos.InscripcionData;
import universidadgrupo6.AccesoADatos.MateriaData;
import universidadgrupo6.Entidades.Alumno;
import universidadgrupo6.Entidades.Inscripcion;
import universidadgrupo6.Entidades.Materia;

/**
 *
 * @author Juan
 */
public class CargarNotasView extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(){        
        @Override
        public boolean isCellEditable(int fila, int columna){
            if (columna == 2){
                return true;
            }
            return false;
        }
    };
            
    private int idAlumno;
    /**
     * Creates new form CargarNotasView
     */
    public CargarNotasView() {
        initComponents();
        armarCabecera();
        llenarComboBox();
        jlNota.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNotas = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlNota = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cargar notas");

        jLabel2.setText("Seleccione un alumno: ");

        jComboBoxAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlumnoActionPerformed(evt);
            }
        });

        jtNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNotasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNotasKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtNotas);

        jbGuardar.setText("Guardar");
        jbGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbGuardarMouseExited(evt);
            }
        });
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlNota.setForeground(new java.awt.Color(255, 0, 0));
        jlNota.setText("Cargue la nota y haga click fuera de la tabla");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlNota)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNota, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlumnoActionPerformed
        Alumno alu = (Alumno) jComboBoxAlumno.getSelectedItem();
        idAlumno = alu.getIdAlumno();
        if (jtNotas.getRowCount() > 0) {
            limpiarTabla();
        }
        buscarInscripciones();
    }//GEN-LAST:event_jComboBoxAlumnoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        Inscripcion inscr = new Inscripcion();
        InscripcionData insdat = new InscripcionData();        
        int filas = jtNotas.getSelectedRow();
        try{
        inscr = insdat.buscarInscripcion((Integer)jtNotas.getValueAt(filas, 0)); 
        double nota= Double.parseDouble(jtNotas.getValueAt(filas, 2).toString());        
        insdat.ActualizarNota(idAlumno, inscr.getIdMateria(), nota);
        limpiarTabla();
        buscarInscripciones(); 
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese un valor correcto");
        }       
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtNotasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNotasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNotasKeyTyped

    private void jtNotasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNotasKeyPressed
        
    }//GEN-LAST:event_jtNotasKeyPressed

    private void jbGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbGuardarMouseEntered
            jlNota.setVisible(true);
    }//GEN-LAST:event_jbGuardarMouseEntered

    private void jbGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbGuardarMouseExited
       jlNota.setVisible(false);
    }//GEN-LAST:event_jbGuardarMouseExited
    private void armarCabecera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Materia");
        modelo.addColumn("Nota");
        jtNotas.setModel(modelo);
    }  
    
    private void buscarInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        InscripcionData id = new InscripcionData();
        inscripciones = id.listarInscripcionPorAlumno(idAlumno);
        for (Inscripcion inscripcion : inscripciones) {
            cargarDatos(inscripcion);
        }
    }

    private void cargarDatos(Inscripcion inscripcion) {
        Materia mat= new Materia();
        MateriaData md=new MateriaData();
        mat=md.buscarMateria(inscripcion.getIdMateria());        
        modelo.addRow(new Object[]{inscripcion.getIdInscripto(),
        mat.getNombre(), inscripcion.getNota()});
    }

    public void llenarComboBox() {
        Alumno alu = new Alumno();
        ArrayList<Alumno> alumnos = new ArrayList<>();
        AlumnoData ad = new AlumnoData();
        alumnos = ad.listarAlumno();
        for (Alumno alumno : alumnos) {
            jComboBoxAlumno.addItem(alumno);
        }
    }

    private void limpiarTabla() {

        for (int i = 0; i < jtNotas.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> jComboBoxAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlNota;
    private javax.swing.JTable jtNotas;
    // End of variables declaration//GEN-END:variables
}