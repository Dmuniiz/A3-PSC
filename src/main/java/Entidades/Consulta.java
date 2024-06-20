/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import DAO.ConnectionFactory;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davy
 */
public class Consulta {

    private String Data;
    private String Hora;
    private int ID_med;
    private int ID_pac;
    private int ID_con;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public int getID_med() {
        return ID_med;
    }

    public void setID_med(int ID_med) {
        this.ID_med = ID_med;
    }

    public int getID_pac() {
        return ID_pac;
    }

    public void setID_pac(int ID_pac) {
        this.ID_pac = ID_pac;
    }

    public int getID_con() {
        return ID_con;
    }

    public void setID_con(int ID_con) {
        this.ID_con = ID_con;
    }
    
    public void agendarConsulta() throws SQLException, ParseException {
        String sql = "INSERT INTO consulta(fk_id_med, fk_id_pac, Data, Hora) VALUES (?,?,?,?)";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, ID_med);
            ps.setInt(2, ID_pac);
            ps.setString(3, Data);
            ps.setString(4, Hora);

            ps.execute();
        }
    }
    
    public static DefaultTableModel mostrarConsultasPaciente(String idPaciente) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Data", "Médico", "Especialidade","Horário"},0);
        
        String sql = "SELECT consulta.ID_con, consulta.Data, consulta.Hora, Medicos.Nome, Medicos.Especialidade FROM consulta "
                + "INNER JOIN Medicos ON consulta.fk_id_med = Medicos.ID_med WHERE fk_id_pac = ?";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(idPaciente));
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int idConsulta = rs.getInt("ID_con");
                String data = rs.getString("Data");
                String medico = rs.getString("Medicos.Nome");
                String especialidade = rs.getString("Medicos.Especialidade");
                String hora = rs.getString("Hora");
            
                model.addRow(new Object[]{idConsulta, data, medico, especialidade , hora});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return model;
    }
   
    public void deletarConsulta() throws SQLException{
        String sql = "DELETE FROM consulta WHERE ID_con = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1, ID_con);
            
            ps.executeUpdate();
        }
    }
    
    public String obterSenhaByNome(String nome) throws SQLException{
        String sql = "SELECT Senha FROM Pacientes WHERE Nome = ?";
        String senha = null;
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                senha = rs.getString("Senha");
            }
        }
        return senha;
    }
    
    public int obterIdMedicoByNome(String nome) throws SQLException {
        String sql = "SELECT ID_med FROM Medicos WHERE Nome = ?";
        int getId = 0;
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                getId = rs.getInt("ID_med");
            }
        }
        return getId;
    }

    public static void listarEspecialidade(JComboBox combox) throws SQLException {
        String sql = "SELECT DISTINCT Especialidade FROM Medicos";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                String especialidade = rs.getString("Especialidade");
                combox.addItem(especialidade);

            }
        }
    }

    public static void listarMedicoByEspecialidade(String especialidade, JComboBox combox) throws SQLException {
        String sql = "SELECT DISTINCT Nome FROM Medicos WHERE Especialidade = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, especialidade);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("Nome");
                combox.addItem(nome);

            }

        }
    }

    public static List<String> verificarHorarioConsulta(int id_med, String data) throws SQLException {
        List<String> horariosOcupados = new ArrayList<>();
        String sql = "SELECT Hora FROM consulta WHERE fk_id_med = ? AND Data = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id_med);
            ps.setString(2, data);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                horariosOcupados.add(rs.getString("Hora"));
                
            }

        }
        return horariosOcupados;
    }

}
