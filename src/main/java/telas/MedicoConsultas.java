/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import Entidades.Consulta;
import Entidades.Exames;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import telas.ModalCadastros.ModalMarcarExames;

/**
 *
 * @author Davy
 */
public class MedicoConsultas extends javax.swing.JFrame {

    /**
     * Creates new form MedicoExames
     */
    public MedicoConsultas() {
        initComponents();
    }
    
    public void obterMedico(int id, String nome){
        labelId.setText(Integer.toString(id));
        labelNome.setText(nome);
    }
    
    
    
    public void atualizarTabela(){
        TableConsultasMedicos.setModel(Exames.mostrarConsultasMedicos(labelId.getText()));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableConsultasMedicos = new javax.swing.JTable();
        labelId = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        btnAtualizarTabela = new javax.swing.JButton();
        btnMarcarExame = new javax.swing.JButton();
        btnConsultaRealizada = new javax.swing.JButton();
        ImgTelaMedicoConsultas = new javax.swing.JLabel();

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
        btnQuit.setBounds(160, 510, 90, 23);

        TableConsultasMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Paciente", "Horário", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableConsultasMedicos);
        if (TableConsultasMedicos.getColumnModel().getColumnCount() > 0) {
            TableConsultasMedicos.getColumnModel().getColumn(0).setResizable(false);
            TableConsultasMedicos.getColumnModel().getColumn(1).setResizable(false);
            TableConsultasMedicos.getColumnModel().getColumn(2).setResizable(false);
            TableConsultasMedicos.getColumnModel().getColumn(3).setResizable(false);
            TableConsultasMedicos.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 310, 840, 370);

        labelId.setText("jLabel1");
        getContentPane().add(labelId);
        labelId.setBounds(130, 236, 110, 20);

        labelNome.setText("jLabel2");
        getContentPane().add(labelNome);
        labelNome.setBounds(160, 260, 110, 20);

        btnAtualizarTabela.setText("Atualizar Tabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarTabela);
        btnAtualizarTabela.setBounds(480, 250, 150, 23);

        btnMarcarExame.setContentAreaFilled(false);
        btnMarcarExame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarcarExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarExameActionPerformed(evt);
            }
        });
        getContentPane().add(btnMarcarExame);
        btnMarcarExame.setBounds(0, 400, 420, 50);

        btnConsultaRealizada.setText("Consulta Realizada");
        btnConsultaRealizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaRealizadaActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultaRealizada);
        btnConsultaRealizada.setBounds(690, 250, 170, 23);

        ImgTelaMedicoConsultas.setIcon(new javax.swing.ImageIcon("D:\\1 SEM\\Programação de soluções computacionais\\projetoA3psc\\src\\main\\java\\imgs\\ImgTelaMedicoConsultas.png")); // NOI18N
        getContentPane().add(ImgTelaMedicoConsultas);
        ImgTelaMedicoConsultas.setBounds(0, 0, 1280, 720);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:
        dispose();

        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        // TODO add your handling code here:
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void btnMarcarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarExameActionPerformed
        // TODO add your handling code here:
        ModalMarcarExames modalMarcarExames = new ModalMarcarExames();
        
        
        int selectedRow = TableConsultasMedicos.getSelectedRow();
        
         if (selectedRow != -1) {
            Object id = TableConsultasMedicos.getValueAt(selectedRow, 0);
            Object name = TableConsultasMedicos.getValueAt(selectedRow, 1);
           
            
            modalMarcarExames.obterIdConsulta(id.toString());
            modalMarcarExames.obterPacienteNome(name.toString());
        }
         
        modalMarcarExames.setVisible(true);
        modalMarcarExames.obterIdMedico(labelId);
    }//GEN-LAST:event_btnMarcarExameActionPerformed

    private void btnConsultaRealizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaRealizadaActionPerformed
        // TODO add your handling code here:
        int fetchDelete = JOptionPane.showConfirmDialog(btnConsultaRealizada, "Você tem certeza que está consulta foi realizada?",
                "Confirmação de consulta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(fetchDelete == JOptionPane.YES_OPTION){
            Consulta consulta = new Consulta();
            int selectedRow = TableConsultasMedicos.getSelectedRow();
            
            if (selectedRow != -1) {
                Object idConsulta = TableConsultasMedicos.getValueAt(selectedRow, 0);
                consulta.setID_con(Integer.parseInt(idConsulta.toString()));
            }
            
            try {
                consulta.deletarConsulta();
            } catch (SQLException ex) {
                Logger.getLogger(AdminCadastrarMedicos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            atualizarTabela();
        }
    }//GEN-LAST:event_btnConsultaRealizadaActionPerformed

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
            java.util.logging.Logger.getLogger(MedicoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicoConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgTelaMedicoConsultas;
    private javax.swing.JTable TableConsultasMedicos;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnConsultaRealizada;
    private javax.swing.JButton btnMarcarExame;
    private javax.swing.JButton btnQuit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNome;
    // End of variables declaration//GEN-END:variables
}
