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
public class Paciente {
 
    private Object id;
    private String nome;
    private String senha;
    private int telefone;
    private int idade;
    private int CPF;
    private int is_paciente;

    public Paciente() {
        this.is_paciente = 1;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(String Telefone) {
        this.telefone = Integer.parseInt(Telefone);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }
    
    public void cadastrarPaciente() throws SQLException{
        String sql = "INSERT INTO Pacientes (Nome, Senha, Telefone, Idade, CPF, is_paciente) VALUES (?,?,?,?,?,?)";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, nome);
            ps.setString(2, senha);
            ps.setInt(3, telefone);
            ps.setInt(4, idade);
            ps.setInt(5, CPF);
            ps.setInt(6, is_paciente);
            
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
    
    public DefaultTableModel mostrarPacientes() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nome", "Senha", "Idade", "Telefone", "CPF"},0);
        String sql = "SELECT * FROM Pacientes";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("ID_pac");
                String nome = rs.getString("Nome");
                String senha = rs.getString("Senha");
                int idade = rs.getInt("Idade");
                String telefone = rs.getString("Telefone");
                String cpf = rs.getString("CPF");
                
                model.addRow(new Object[]{id,nome,senha,idade,telefone,cpf});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return model;
        
    }
    
    public DefaultTableModel pesquisarPacientes(String entrada){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nome", "Senha", "Idade", "Telefone", "CPF"},0);
        String sql = "SELECT * FROM Pacientes WHERE ID_pac = ? OR Nome = ? OR Senha = ? OR CPF = ?";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
           PreparedStatement ps = c.prepareStatement(sql);
           
           ps.setString(1, entrada);
           ps.setString(2, entrada);
           ps.setString(3, entrada);
           ps.setString(4, entrada);
           
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
                String id = rs.getString("ID_pac");
                String nome = rs.getString("Nome");
                String senha = rs.getString("Senha");
                int idade = rs.getInt("Idade");
                String telefone = rs.getString("Telefone");
                String cpf = rs.getString("CPF");
                
                model.addRow(new Object[]{id,nome,senha,idade,telefone,cpf});
           }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return model;
    }
    
    public void editarPacientes() throws SQLException{
        String sql = "UPDATE Pacientes SET Nome = ?, Senha = ?, Idade = ?, Telefone = ?, CPF = ? WHERE ID_pac = ?";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setString(2, senha);
            ps.setInt(3, idade);
            ps.setInt(4, telefone);
            ps.setInt(5, CPF);
            ps.setObject(6, id);
            
            ps.executeUpdate();
        }
    }
    
    public void deletarPacientes() throws SQLException{
        String sql = "DELETE FROM Pacientes WHERE ID_pac = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setObject(1, id);
            
            ps.executeUpdate();
        }
    }
    
      public int quantidadePacientes() throws SQLException{
        String sql = "SELECT COUNT(*) AS ID_pac FROM Pacientes";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            rs.next(); // Mover o cursor para a primeira linha
            int rowCount = rs.getInt("ID_pac");
            return rowCount;
        }
    }
    
}
