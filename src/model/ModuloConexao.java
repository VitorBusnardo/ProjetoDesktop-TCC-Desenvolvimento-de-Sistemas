package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloConexao {

    //método responsavel por estabelecer a conexão com o banco 
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // a linha abaixo "chama" o driver
        String driver = "com.mysql.jdbc.Driver";
        //armazenando informações referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "";
        //Estabelecendo a conexão com o banco de dados
        try {
            Class.forName(driver);
            try {
                conexao = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conexao;
        } catch (ClassNotFoundException e) {
            // a linha abaixo serve de apoio para saber o erro
            System.out.println(e);
            return null;
        }
    }
}
