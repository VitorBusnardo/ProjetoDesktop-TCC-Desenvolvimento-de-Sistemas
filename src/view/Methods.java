
package view;

import conexao.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Methods extends TelaRegistros{
        
    public void pesquisar_products() {		
    
        
    ConexaoSQLite conexao = new ConexaoSQLite();

    conexao.conectar();
    
    ResultSet resultSQL = null;  	 
    PreparedStatement comandoSQL = null;	    


    String sql = "select Name, Brand, Stock, Description, Value, Type from Products where Name like ?";
    
        try {
            
            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, PesquisarProducts.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            TabelaProducts.setModel(DbUtils.resultSetToTableModel(resultSQL));
            
           
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    

    private void setar_camposProducts() {
    
    int setar = TabelaProducts.getSelectedRow();
    DeleteProducts.setText(TabelaProducts.getModel().getValueAt(setar, 0).toString());

    
    }
    	
}


