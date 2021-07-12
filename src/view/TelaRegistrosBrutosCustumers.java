package view;

import conexao.ConexaoSQLite;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaRegistrosBrutosCustumers extends javax.swing.JFrame {
    
    public TelaRegistrosBrutosCustumers() {
        initComponents();

        setIcon();
        pesquisar_products_Sem();
        
        TabelaCustumersBruto.getTableHeader().setOpaque(false);
        TabelaCustumersBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        TabelaCustumersBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        TabelaCustumersBruto.setRowHeight(25);
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    public void pesquisar_products_Sem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select IdProducts, Name, Brand, Stock, Description, Value, Type from Products;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            TabelaCustumersBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    protected void Deletar_Products() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Products where Name=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, DeleteCustumers.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                DeleteCustumers.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisar_products_Sem();
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    public void pesquisar_products() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select IdProducts, Name, Brand, Stock, Description, Value, Type from Products where Name like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, PesquisarCustumers.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            TabelaCustumersBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

private void setar_camposProducts() {

        int setar = TabelaCustumersBruto.getSelectedRow();
        DeleteCustumers.setText(TabelaCustumersBruto.getModel().getValueAt(setar, 1).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Custumers = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TabelaCustumersBruto = new javax.swing.JTable();
        PesquisarCustumers = new javax.swing.JTextField();
        btn_DeleteCustumers = new javax.swing.JLabel();
        DeleteCustumers = new javax.swing.JTextField();
        btn_AtualizarCustumers = new javax.swing.JLabel();
        btnFechar = new javax.swing.JLabel();

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Do you really want to delete this data?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(23, 35, 51));
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(71, 120, 197));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(444, 193));

        Custumers.setBackground(new java.awt.Color(255, 255, 255));
        Custumers.setForeground(new java.awt.Color(102, 102, 102));
        Custumers.setPreferredSize(new java.awt.Dimension(900, 565));

        TabelaCustumersBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TabelaCustumersBruto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "Endereço", "Email"
            }
        ));
        TabelaCustumersBruto.setFocusable(false);
        TabelaCustumersBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaCustumersBruto.setRowHeight(25);
        TabelaCustumersBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaCustumersBruto.setShowVerticalLines(false);
        TabelaCustumersBruto.getTableHeader().setReorderingAllowed(false);
        TabelaCustumersBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaCustumersBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TabelaCustumersBruto);

        PesquisarCustumers.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PesquisarCustumers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PesquisarCustumersKeyReleased(evt);
            }
        });

        btn_DeleteCustumers.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeleteCustumers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeleteCustumers.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeleteCustumers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeleteCustumers.setText("Refresh");
        btn_DeleteCustumers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteCustumers.setOpaque(true);
        btn_DeleteCustumers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteCustumersMouseClicked(evt);
            }
        });

        DeleteCustumers.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeleteCustumers.setToolTipText("");
        DeleteCustumers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCustumersActionPerformed(evt);
            }
        });

        btn_AtualizarCustumers.setBackground(new java.awt.Color(23, 35, 51));
        btn_AtualizarCustumers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_AtualizarCustumers.setForeground(new java.awt.Color(255, 255, 255));
        btn_AtualizarCustumers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_AtualizarCustumers.setText("Delete");
        btn_AtualizarCustumers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AtualizarCustumers.setOpaque(true);
        btn_AtualizarCustumers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AtualizarCustumersMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CustumersLayout = new javax.swing.GroupLayout(Custumers);
        Custumers.setLayout(CustumersLayout);
        CustumersLayout.setHorizontalGroup(
            CustumersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustumersLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(CustumersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustumersLayout.createSequentialGroup()
                        .addComponent(btn_DeleteCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CustumersLayout.createSequentialGroup()
                        .addComponent(PesquisarCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 461, Short.MAX_VALUE)
                        .addComponent(DeleteCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_AtualizarCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(CustumersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustumersLayout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        CustumersLayout.setVerticalGroup(
            CustumersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustumersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_DeleteCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                .addGroup(CustumersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustumersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DeleteCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_AtualizarCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PesquisarCustumers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(CustumersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustumersLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Custumers, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Custumers, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 1140, 530));

        btnFechar.setBackground(new java.awt.Color(23, 35, 51));
        btnFechar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(255, 255, 255));
        btnFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFechar.setText("X");
        btnFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFechar.setOpaque(true);
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
        });
        jPanel3.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PesquisarCustumersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisarCustumersKeyReleased
        pesquisar_products();
    }//GEN-LAST:event_PesquisarCustumersKeyReleased

    private void btn_DeleteCustumersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteCustumersMouseClicked
        pesquisar_products();
    }//GEN-LAST:event_btn_DeleteCustumersMouseClicked

    private void DeleteCustumersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCustumersActionPerformed
        Deletar_Products();
    }//GEN-LAST:event_DeleteCustumersActionPerformed

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void TabelaCustumersBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaCustumersBrutoMouseClicked
        setar_camposProducts();
    }//GEN-LAST:event_TabelaCustumersBrutoMouseClicked

    private void btn_AtualizarCustumersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AtualizarCustumersMouseClicked
        Deletar_Products();
    }//GEN-LAST:event_btn_AtualizarCustumersMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustumers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustumers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustumers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustumers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrosBrutosCustumers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Custumers;
    private javax.swing.JTextField DeleteCustumers;
    public javax.swing.JTextField PesquisarCustumers;
    public javax.swing.JTable TabelaCustumersBruto;
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btn_AtualizarCustumers;
    public javax.swing.JLabel btn_DeleteCustumers;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
