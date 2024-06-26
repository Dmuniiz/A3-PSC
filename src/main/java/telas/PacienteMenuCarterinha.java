/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;


import Entidades.Admin;
import telas.ModalCadastros.ModalConsultas;

/**
 *
 * @author Davy
 */
public class PacienteMenuCarterinha extends javax.swing.JFrame {

    /**
     * Creates new form PacienteMenuCarterinha
     */
    public PacienteMenuCarterinha() {
        initComponents();
        
    }

    public void MenuCarterinha(String nome, String CPF, int idade, int telefone, int id){
        labelNome.setText(nome);
        labelNome1.setText(nome);
        labelCPF.setText(CPF);
        labeldade.setText(Integer.toString(idade));
        labelTelefone.setText(Integer.toString(telefone));
        labelId.setText(Integer.toString(id));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNavConsultasAgendadas = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        labelTelefone = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        labeldade = new javax.swing.JLabel();
        btnNavMarcarConsultas = new javax.swing.JButton();
        labelNome1 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        btnNavPacienteExames = new javax.swing.JButton();
        backgroundPacienteCarterinha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

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

        btnQuit.setText("Sair");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuit);
        btnQuit.setBounds(20, 20, 90, 23);

        labelTelefone.setText("jLabel2");
        getContentPane().add(labelTelefone);
        labelTelefone.setBounds(740, 480, 140, 30);

        labelNome.setText("jLabel2");
        getContentPane().add(labelNome);
        labelNome.setBounds(160, 240, 140, 20);

        labelCPF.setText("jLabel2");
        getContentPane().add(labelCPF);
        labelCPF.setBounds(740, 360, 140, 16);

        labeldade.setText("jLabel2");
        getContentPane().add(labeldade);
        labeldade.setBounds(740, 420, 140, 20);

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

        labelNome1.setText("jLabel2");
        getContentPane().add(labelNome1);
        labelNome1.setBounds(740, 290, 140, 20);

        labelId.setText("jLabel1");
        getContentPane().add(labelId);
        labelId.setBounds(130, 220, 37, 16);

        btnNavPacienteExames.setBorder(null);
        btnNavPacienteExames.setContentAreaFilled(false);
        btnNavPacienteExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNavPacienteExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPacienteExamesActionPerformed(evt);
            }
        });
        getContentPane().add(btnNavPacienteExames);
        btnNavPacienteExames.setBounds(0, 440, 400, 60);

        backgroundPacienteCarterinha.setIcon(new javax.swing.ImageIcon("D:\\1 SEM\\Programação de soluções computacionais\\projetoA3psc\\src\\main\\java\\imgs\\ImgTelaPacienteCarterinha.png")); // NOI18N
        getContentPane().add(backgroundPacienteCarterinha);
        backgroundPacienteCarterinha.setBounds(0, 0, 1260, 720);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavConsultasAgendadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavConsultasAgendadasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        PacienteConsultas pacienteConsultas = new PacienteConsultas();
        pacienteConsultas.obterPaciente(labelId.getText(), labelNome.getText());
        pacienteConsultas.setVisible(true);

    }//GEN-LAST:event_btnNavConsultasAgendadasActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:
        dispose();

        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnNavMarcarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavMarcarConsultasActionPerformed
        // TODO add your handling code here:
        ModalConsultas modalConsultas = new ModalConsultas();
        modalConsultas.setVisible(true);
        modalConsultas.obterIdPaciente(labelId);
        
    }//GEN-LAST:event_btnNavMarcarConsultasActionPerformed

    private void btnNavPacienteExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavPacienteExamesActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        PacienteExames pacienteExames = new PacienteExames();
        pacienteExames.obterPaciente(labelId.getText(), labelNome.getText());
        pacienteExames.setVisible(true);
    }//GEN-LAST:event_btnNavPacienteExamesActionPerformed

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
            java.util.logging.Logger.getLogger(PacienteMenuCarterinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteMenuCarterinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteMenuCarterinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteMenuCarterinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacienteMenuCarterinha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundPacienteCarterinha;
    private javax.swing.JButton btnNavConsultasAgendadas;
    private javax.swing.JButton btnNavMarcarConsultas;
    private javax.swing.JButton btnNavPacienteExames;
    private javax.swing.JButton btnQuit;
    private javax.swing.JLabel labelCPF;
    public javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNome1;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labeldade;
    // End of variables declaration//GEN-END:variables
}
