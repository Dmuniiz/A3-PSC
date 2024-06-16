/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas.ModalEditar;

import Entidades.Medicos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davy
 */
public class EditarCadastroMedico extends javax.swing.JFrame {

    /**
     * Creates new form ModalCadastrarMedicos
     */
    public EditarCadastroMedico() {
        initComponents();

    }
    
    public EditarCadastroMedico(Medicos medico){
        initComponents();  
        txtNomeMedicos.setText(medico.getNome());
        txtSenhaMedicos.setText(medico.getSenha());
        ComboBoxEspecialidade.addItem(medico.getEspecialidade());
        txtIdMedicos.setText(medico.getId().toString());
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAplicarEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdMedicos = new javax.swing.JTextField();
        txtSenhaMedicos = new javax.swing.JTextField();
        ComboBoxEspecialidade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNomeMedicos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btnAplicarEdit.setText("Aplicar");
        btnAplicarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnAplicarEdit);
        btnAplicarEdit.setBounds(50, 320, 150, 30);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 140, 50, 16);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 200, 50, 16);

        txtIdMedicos.setEnabled(false);
        txtIdMedicos.setFocusable(false);
        txtIdMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMedicosActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdMedicos);
        txtIdMedicos.setBounds(140, 60, 210, 30);
        getContentPane().add(txtSenhaMedicos);
        txtSenhaMedicos.setBounds(140, 190, 210, 30);

        ComboBoxEspecialidade.setEnabled(false);
        ComboBoxEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxEspecialidadeActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxEspecialidade);
        ComboBoxEspecialidade.setBounds(50, 260, 120, 30);

        jLabel3.setText("ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 70, 12, 16);

        txtNomeMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMedicosActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomeMedicos);
        txtNomeMedicos.setBounds(140, 120, 210, 30);

        setSize(new java.awt.Dimension(434, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxEspecialidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxEspecialidadeActionPerformed

    private void btnAplicarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarEditActionPerformed
        // TODO add your handling code here:
        Medicos medico = new Medicos();
        medico.setNome(txtNomeMedicos.getText());
        medico.setSenha(txtSenhaMedicos.getText());
        medico.setEspecialidade(ComboBoxEspecialidade.getSelectedItem().toString());
        medico.setId(txtIdMedicos.getText());
        
        
        
        try {
            medico.editarMedicos();
        } catch (SQLException ex) {
            Logger.getLogger(EditarCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnAplicarEditActionPerformed

    private void txtIdMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMedicosActionPerformed

    private void txtNomeMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeMedicosActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCadastroMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxEspecialidade;
    private javax.swing.JButton btnAplicarEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIdMedicos;
    private javax.swing.JTextField txtNomeMedicos;
    private javax.swing.JTextField txtSenhaMedicos;
    // End of variables declaration//GEN-END:variables
}