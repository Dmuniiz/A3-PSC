/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Davy
 */
/*mysql connection server */
public class ConnectionFactory {
    
   //abrir uma porta para conectar com o banco de dados
    private String usuario = "root";
    private String senha = "Egv&2w6w2";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "db_clinica_a3";

    
    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd + "?serverTimezone=UTC",
                    usuario,
                    senha
            );
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
}
