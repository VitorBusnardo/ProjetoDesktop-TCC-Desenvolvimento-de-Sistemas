package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoSQLite {

    private Connection conexao;
    
    /*
    *Conectar ao banco de dados 
    *ou criar um novo banco caso não tenha
    */
    
    public boolean conectar(){
        try {
            
                String url = "jdbc:sqlite:DataBase/DataBaseIntermedix.db";
                this.conexao = DriverManager.getConnection(url);
                
            
            } catch (SQLException e) {
            
                JOptionPane.showMessageDialog(null,"ERROR SQL LITE" + e.getMessage());
                return false;
            
            }
    
        return true;
    
    }
    
    public Statement criarStetament(){
        
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return (Statement) e;
        }
    }
    public Connection getConexao(){
    
        return this.conexao;
    }
    
    public boolean desconectar(){
        
        try {
            if (this.conexao.isClosed() == false ) {
            this.conexao.close();
            
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public PreparedStatement criarPreparedStatement(String sql){
        try {
            return this.conexao.prepareStatement(sql);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error1 em prepara o statement" + e);
            return null;
        }
    }
}
    

