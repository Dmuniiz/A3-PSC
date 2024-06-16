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
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davy
 */
public class Exames {

    private int ID_exam;
    private int ID_pac;
    private int ID_med;
    private int ID_con;
    private String tipoExam;
    private String data;

    public int getID_con() {
        return ID_con;
    }

    public void setID_con(int ID_con) {
        this.ID_con = ID_con;
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

    public int getID_exam() {
        return ID_exam;
    }

    public void setID_exam(int ID_exam) {
        this.ID_exam = ID_exam;
    }

    public String getTipoExam() {
        return tipoExam;
    }

    public void setTipoExam(String tipoExam) {
        this.tipoExam = tipoExam;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void agendarExame() throws SQLException {
        String sql = "INSERT INTO Exames(Data, tipo_exame, fk_id_med, fk_id_pac) VALUES (?,?,?,?)";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, data);
            ps.setString(2, tipoExam);
            ps.setInt(3, ID_med);
            ps.setInt(4, ID_pac);
            

            ps.execute();
        }
    }

    public void deletarConsulta() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();

        String sqlCon = "DELETE FROM consulta WHERE ID_con = ?";
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sqlCon);
            ps.setInt(1, ID_con);
            ps.executeUpdate();
        }
        
    }

    public static DefaultTableModel mostrarConsultasMedicos(String idMedico) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Paciente", "Telefone", "Horário", "Data"}, 0);
        String sql = "SELECT consulta.ID_con, consulta.Data, consulta.Hora, Pacientes.Nome, Pacientes.Telefone FROM consulta "
                + "INNER JOIN Pacientes ON consulta.fk_id_pac = Pacientes.ID_pac WHERE fk_id_med = ?";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(idMedico));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idConsulta = rs.getInt("ID_con");
                String data = rs.getString("Data");
                String paciente = rs.getString("Pacientes.Nome");
                String telefone = rs.getString("Pacientes.Telefone");
                String hora = rs.getString("Hora");

                model.addRow(new Object[]{idConsulta, paciente, telefone, hora, data});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public static int obterIdPacienteByNome(String nome) throws SQLException {
        String sql = "SELECT ID_pac FROM Pacientes WHERE Nome = ?";
        int getId = 0;
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                getId = rs.getInt("ID_pac");
            }
        }
        return getId;
    }

    public static void listarTipoExame(JComboBox combox) throws SQLException {
        String sql = "SELECT DISTINCT tipo_exame FROM Exames";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String tipoExame = rs.getString("tipo_exame");
                combox.addItem(tipoExame);
            }
        }
    }

    public static DefaultTableModel mostrarExamesPacientes(String idPaciente){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Médico", "Data", "Categoria Exame"}, 0);
        String sql = "SELECT Exames.ID_exam, Exames.Data, Exames.tipo_exame, Medicos.Nome FROM Exames "
                + "INNER JOIN Medicos ON Exames.fk_id_med = Medicos.ID_med WHERE fk_id_pac = ?";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(idPaciente));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idExame = rs.getInt("ID_exam");
                String data = rs.getString("Data");
                String medico = rs.getString("Medicos.Nome");
                String categoria = rs.getString("tipo_exame");
                

                model.addRow(new Object[]{idExame, medico, data, categoria});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel pesquisarExames(String entrada) {

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Médico", "Data", "Categoria Exame"}, 0);
        String sql = "SELECT Exames.ID_exam, Exames.Data, Exames.tipo_exame, Medicos.Nome FROM Exames"
                + "INNER JOIN Medicos ON Exames.fk_id_med = Medicos.ID_med WHERE tipo_exame = ?";
        
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, entrada);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("ID_exam");
                String medico = rs.getString("Medicos.nome");
                String data = rs.getString("Data");
                String categoria = rs.getString("tipo_exame");
          
                model.addRow(new Object[]{id, data, categoria});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
    
    /*public static void listarPacientes(JComboBox combox, String idMedico) throws SQLException{
        String sql = "SELECT Pacientes.Nome FROM consulta INNER JOIN Pacientes ON consulta.fk_id_pac = Pacientes.ID_pac WHERE fk_id_med = ?";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(idMedico));
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("Pacientes.Nome");
                combox.addItem(nome);
            }
        }
    }*/
}
