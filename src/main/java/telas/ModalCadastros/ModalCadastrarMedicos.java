/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas.ModalCadastros;
import Entidades.Consulta;
import Entidades.Medicos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Davy
 */
public class ModalCadastrarMedicos extends javax.swing.JFrame {

    /**
     * Creates new form ModalCadastrarMedicos
     */
    public ModalCadastrarMedicos() {
        initComponents();
        try {
            Consulta.listarEspecialidade(ComboBoxEspecialidade);
        } catch (SQLException ex) {
            Logger.getLogger(ModalCadastrarMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrarMedicos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeMedicos = new javax.swing.JTextField();
        txtSenhaMedicos = new javax.swing.JTextField();
        ComboBoxEspecialidade = new javax.swing.JComboBox<>();
        btnNovaEspecialidade = new javax.swing.JButton();
        btnDeletarEspecialidade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btnCadastrarMedicos.setText("Cadastrar");
        btnCadastrarMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarMedicosActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarMedicos);
        btnCadastrarMedicos.setBounds(50, 270, 150, 30);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 60, 50, 16);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 140, 50, 16);

        txtNomeMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMedicosActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomeMedicos);
        txtNomeMedicos.setBounds(140, 50, 210, 30);
        getContentPane().add(txtSenhaMedicos);
        txtSenhaMedicos.setBounds(140, 130, 210, 30);

        ComboBoxEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Especialidade" }));
        ComboBoxEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxEspecialidadeActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxEspecialidade);
        ComboBoxEspecialidade.setBounds(50, 200, 210, 30);

        btnNovaEspecialidade.setText("Nova Especialidade");
        btnNovaEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaEspecialidadeActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaEspecialidade);
        btnNovaEspecialidade.setBounds(230, 270, 150, 30);

        btnDeletarEspecialidade.setText("Deletar Especialidade");
        btnDeletarEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarEspecialidadeActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletarEspecialidade);
        btnDeletarEspecialidade.setBounds(130, 330, 160, 30);

        setSize(new java.awt.Dimension(473, 461));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxEspecialidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxEspecialidadeActionPerformed

    private void btnCadastrarMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMedicosActionPerformed
        // TODO add your handling code here:
        
        Medicos medico = new Medicos();
        medico.setNome(txtNomeMedicos.getText());
        medico.setSenha(txtSenhaMedicos.getText());
        medico.setEspecialidade(ComboBoxEspecialidade.getSelectedItem().toString());
        
        
        try {
            medico.cadastrarMedicos();
        } catch (SQLException ex) {
            Logger.getLogger(ModalCadastrarMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        limparCampos();
        
    }//GEN-LAST:event_btnCadastrarMedicosActionPerformed

    private void txtNomeMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeMedicosActionPerformed

    private void btnNovaEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaEspecialidadeActionPerformed
        // TODO add your handling code here:
        String novaEspecialiade = JOptionPane.showInputDialog(this, "Informe a nova especialidade", "Nova Especialidade", JOptionPane.INFORMATION_MESSAGE);
        
        if(!novaEspecialiade.isEmpty()){
            ComboBoxEspecialidade.addItem(novaEspecialiade);
        }
        
    }//GEN-LAST:event_btnNovaEspecialidadeActionPerformed

    private void btnDeletarEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarEspecialidadeActionPerformed
        // TODO add your handling code here:
       Object selecionadaEspecialidade = ComboBoxEspecialidade.getSelectedItem();
        
       int deletarEspecialidade = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar essa especialiadade (" + selecionadaEspecialidade + ")" , "Deletar Especialidade", JOptionPane.YES_NO_CANCEL_OPTION);
       
       if(deletarEspecialidade == JOptionPane.YES_OPTION){
           ComboBoxEspecialidade.removeItem(selecionadaEspecialidade);
       }
        
    }//GEN-LAST:event_btnDeletarEspecialidadeActionPerformed

    
    public void limparCampos(){
        txtNomeMedicos.setText("");
        txtSenhaMedicos.setText("");
        ComboBoxEspecialidade.setSelectedIndex(0);
    }
    
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
            java.util.logging.Logger.getLogger(ModalCadastrarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalCadastrarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalCadastrarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalCadastrarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModalCadastrarMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxEspecialidade;
    private javax.swing.JButton btnCadastrarMedicos;
    private javax.swing.JButton btnDeletarEspecialidade;
    private javax.swing.JButton btnNovaEspecialidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNomeMedicos;
    private javax.swing.JTextField txtSenhaMedicos;
    // End of variables declaration//GEN-END:variables
}
