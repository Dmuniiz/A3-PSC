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
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davy
 */
public class Medicos {

    private Object id;
    private String senha;
    private String nome;
    private String especialidade;
    private int is_medico;
    
     public Medicos() {
        this.is_medico = 1;
    }
    

    public Object getId() {
        return id.toString();
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void cadastrarMedicos() throws SQLException {
        String sql = "INSERT INTO Medicos(Nome, Senha, Especialidade, is_medico) VALUES(?,?,?,?)";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, nome);
            ps.setString(2, senha);
            ps.setString(3, especialidade);
            ps.setInt(4, is_medico);
        
            ResultSet rs;
            
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int lastId = rs.getInt(1);
                    setId(lastId);
                }
            }  
        }
    }

    public DefaultTableModel mostrarMedicos() {

        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nome", "Senha", "Especialidade"}, 0);
        String sql = "SELECT * FROM Medicos ";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("ID_med");
                String nome = rs.getString("Nome");
                String senha = rs.getString("Senha");
                String especialidade = rs.getString("Especialidade");

                model.addRow(new Object[]{id, nome, senha, especialidade});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public DefaultTableModel pesquisarMedicos(String entrada) {

        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nome", "Senha", "Especialidade"}, 0);
        String sql = "SELECT * FROM Medicos WHERE ID_med = ? OR Nome = ? OR Especialidade = ? ";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, entrada);
            ps.setString(2, entrada);
            ps.setString(3, entrada);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("ID_med");
                String nome = rs.getString("Nome");
                String senha = rs.getString("Senha");
                String especialidade = rs.getString("Especialidade");

                model.addRow(new Object[]{id, nome, senha, especialidade});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public void editarMedicos() throws SQLException {
        String sql = "UPDATE Medicos SET Nome = ?, Senha = ?, Especialidade = ? WHERE ID_med = ?";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, senha);
            ps.setString(3, especialidade);
            ps.setObject(4, id);
            
            ps.executeUpdate();
        }

    }

    public void deletarMedicos() throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        
         String sqlfk = "DELETE FROM Exames WHERE fk_id_med = ?;";
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sqlfk);
            
            ps.setObject(1, id);
            
            
            ps.executeUpdate();
        }
        
        String sql = "DELETE FROM Medicos WHERE ID_med = ?;";
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setObject(1, id);
            
            
            ps.executeUpdate();
        }
        
    }
    
    public int quantidadeMedicos() throws SQLException{
        String sql = "SELECT COUNT(*) AS ID_med FROM Medicos";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            rs.next(); 
            int rowCount = rs.getInt("ID_med");
            return rowCount;
        }
    }
    
}
