/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;
import Entidades.Admin;
import Entidades.Consulta;
import Entidades.Exames;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.ModalCadastros.ModalConsultas;

/**
 *
 * @author Davy
 */
public class PacienteExames extends javax.swing.JFrame {

    /**
     * Creates new form PacienteExames
     */
    public PacienteExames() {
        initComponents();
    }

    public void obterPaciente(String id, String nome){
        labelId.setText(id);
        labelNome.setText(nome);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnQuit = new javax.swing.JButton();
        btnMenuCarterinha = new javax.swing.JButton();
        labelId = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        btnNavMarcarConsultas = new javax.swing.JButton();
        btnNavConsultasAgendadas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableExamesPacientes = new javax.swing.JTable();
        btnAtualizarTabela = new javax.swing.JButton();
        txtPesquisarPacientes = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btnQuit.setText("Sair");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuit);
        btnQuit.setBounds(10, 80, 90, 30);

        btnMenuCarterinha.setText("Menu");
        btnMenuCarterinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuCarterinhaActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuCarterinha);
        btnMenuCarterinha.setBounds(10, 20, 90, 30);

        labelId.setText("jLabel1");
        getContentPane().add(labelId);
        labelId.setBounds(130, 230, 41, 16);

        labelNome.setText("jLabel2");
        getContentPane().add(labelNome);
        labelNome.setBounds(160, 250, 140, 30);

        btnNavMarcarConsultas.setBorder(null);
        btnNavMarcarConsultas.setContentAreaFilled(false);
        btnNavMarcarConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNavMarcarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavMarcarConsultasActionPerformed(evt);
            }
        });
        getContentPane().add(btnNavMarcarConsultas);
        btnNavMarcarConsultas.setBounds(10, 310, 400, 60);

        btnNavConsultasAgendadas.setBorder(null);
        btnNavConsultasAgendadas.setContentAreaFilled(false);
        btnNavConsultasAgendadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNavConsultasAgendadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavConsultasAgendadasActionPerformed(evt);
            }
        });
        getContentPane().add(btnNavConsultasAgendadas);
        btnNavConsultasAgendadas.setBounds(10, 380, 400, 50);

        TableExamesPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Médico", "Data", "Categoria Exame"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableExamesPacientes);
        if (TableExamesPacientes.getColumnModel().getColumnCount() > 0) {
            TableExamesPacientes.getColumnModel().getColumn(0).setResizable(false);
            TableExamesPacientes.getColumnModel().getColumn(1).setResizable(false);
            TableExamesPacientes.getColumnModel().getColumn(1).setHeaderValue("Médico");
            TableExamesPacientes.getColumnModel().getColumn(2).setResizable(false);
            TableExamesPacientes.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 290, 850, 380);

        btnAtualizarTabela.setText("Atualizar Tabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarTabela);
        btnAtualizarTabela.setBounds(470, 230, 170, 24);

        txtPesquisarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarPacientesActionPerformed(evt);
            }
        });
        getContentPane().add(txtPesquisarPacientes);
        txtPesquisarPacientes.setBounds(970, 230, 170, 24);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(1140, 230, 90, 24);

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Davy\\Documents\\NetBeansProjects\\projetoA3psc\\src\\main\\java\\imgs\\ImgTelaPacienteExames.png")); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background);
        background.setBounds(-10, 0, 1290, 730);

        setSize(new java.awt.Dimension(1280, 709));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:
        dispose();

        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnMenuCarterinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuCarterinhaActionPerformed
        // TODO add your handling code here:
        Consulta consulta = new Consulta();
        try {
            Admin.authenticatePaciente(labelNome.getText(), consulta.obterSenhaByNome(labelNome.getText()));
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMenuCarterinhaActionPerformed

    private void btnNavMarcarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavMarcarConsultasActionPerformed
        // TODO add your handling code here:
        ModalConsultas modalConsultas = new ModalConsultas();
        modalConsultas.setVisible(true);
        modalConsultas.obterIdPaciente(labelId);

    }//GEN-LAST:event_btnNavMarcarConsultasActionPerformed

    private void btnNavConsultasAgendadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavConsultasAgendadasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        PacienteConsultas pacienteConsultas = new PacienteConsultas();
        pacienteConsultas.obterPaciente(labelId.getText(), labelNome.getText());
        pacienteConsultas.setVisible(true);

    }//GEN-LAST:event_btnNavConsultasAgendadasActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        // TODO add your handling code here:
        Exames exames = new Exames();
        TableExamesPacientes.setModel(exames.mostrarExamesPacientes(labelId.getText()));
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void txtPesquisarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarPacientesActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        Exames exames = new Exames();
         if (!txtPesquisarPacientes.getText().equals("")) {
            TableExamesPacientes.setModel(exames.pesquisarExames(txtPesquisarPacientes.getText()));
        } else {
            TableExamesPacientes.setModel(exames.mostrarExamesPacientes(labelId.getText()));
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(PacienteExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacienteExames().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableExamesPacientes;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnMenuCarterinha;
    private javax.swing.JButton btnNavConsultasAgendadas;
    private javax.swing.JButton btnNavMarcarConsultas;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnQuit;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextField txtPesquisarPacientes;
    // End of variables declaration//GEN-END:variables
}