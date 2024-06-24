/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import telas.AdminCadastrarMedicos;
import telas.MedicoConsultas;
import telas.PacienteMenuCarterinha;

/**
 *
 * @author Davy
 */
public class Admin {

    public static boolean authenticateAdmin(String ID_adm, String password) {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection conn = factory.obtemConexao()) {
            String sql = "SELECT is_admin FROM Administradores WHERE ID_adm = ? AND Senha = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ID_adm);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                boolean isAdmin = rs.getBoolean("is_admin");
                if (isAdmin) {
                    AdminCadastrarMedicos adminCadastrarMedicos = new AdminCadastrarMedicos();
                    adminCadastrarMedicos.setVisible(true);
                }
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean authenticatePaciente(String nome, String senha) {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection conn = factory.obtemConexao()) {
            String sql = "SELECT is_paciente, Idade, CPF, Telefone, ID_pac FROM Pacientes WHERE Nome = ? AND Senha = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);//args
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                boolean isPaciente = rs.getBoolean("is_paciente");
                if (isPaciente) {
                    int getIdade = rs.getInt("Idade");
                    String getCPF = rs.getString("CPF");  
                    int getTelefone = rs.getInt("Telefone");
                    int getId = rs.getInt("ID_pac");  
                    
                    PacienteMenuCarterinha pacienteMenuCarterinha = new PacienteMenuCarterinha();
                    pacienteMenuCarterinha.MenuCarterinha(nome, getCPF, getIdade, getTelefone, getId);
                    pacienteMenuCarterinha.setVisible(true);
                 
                }
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean authenticateMedico(String nome, String senha) {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection conn = factory.obtemConexao()) {
            String sql = "SELECT is_medico, ID_med, Nome FROM Medicos WHERE Nome = ? AND Senha = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);//args
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                boolean isMedico = rs.getBoolean("is_medico");
                int idMedico = rs.getInt("ID_med");
                if (isMedico) {
                    MedicoConsultas medicoExames = new MedicoConsultas();
                    medicoExames.obterMedico(idMedico, nome);
                    medicoExames.setVisible(true);
                }
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
