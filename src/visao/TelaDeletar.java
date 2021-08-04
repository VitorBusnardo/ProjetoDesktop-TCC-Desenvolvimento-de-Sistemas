package visao;

import conexao.ConexaoSQLite;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelaDeletar extends javax.swing.JFrame {

    public TelaDeletar() {
        initComponents();

        setIcon();
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }

    protected void Deletar_Customers() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Clientes";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            int apagado = comandoSQL.executeUpdate();

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    protected void Deletar_Products() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Produtos";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            int apagado = comandoSQL.executeUpdate();

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    protected void Deletar_Services() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Servicos";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            int apagado = comandoSQL.executeUpdate();

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }


    protected void Deletar_Employees() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Funcionarios";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            int apagado = comandoSQL.executeUpdate();

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }
    
    protected void Deletar_Sales() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Vendas";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            int apagado = comandoSQL.executeUpdate();

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }
    
        protected void Deletar_Spending() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Gastos";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            int apagado = comandoSQL.executeUpdate();

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        menuAlterar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnNao = new javax.swing.JLabel();
        btnSim = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        menu.setBackground(new java.awt.Color(71, 120, 197));

        menuAlterar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("<html> <br> Tem certeza que quer apagar </br> <br> <center> todos os dados registrados? </center> </br> </html>");

        btnNao.setBackground(new java.awt.Color(23, 35, 51));
        btnNao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNao.setForeground(new java.awt.Color(255, 255, 255));
        btnNao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNao.setText("Não");
        btnNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNao.setOpaque(true);
        btnNao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNaoMouseClicked(evt);
            }
        });

        btnSim.setBackground(new java.awt.Color(23, 35, 51));
        btnSim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSim.setForeground(new java.awt.Color(255, 255, 255));
        btnSim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSim.setText("Sim");
        btnSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSim.setOpaque(true);
        btnSim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconPlanetBig.png"))); // NOI18N

        javax.swing.GroupLayout menuAlterarLayout = new javax.swing.GroupLayout(menuAlterar);
        menuAlterar.setLayout(menuAlterarLayout);
        menuAlterarLayout.setHorizontalGroup(
            menuAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAlterarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuAlterarLayout.createSequentialGroup()
                        .addComponent(btnSim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuAlterarLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        menuAlterarLayout.setVerticalGroup(
            menuAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAlterarLayout.createSequentialGroup()
                .addGroup(menuAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(menuAlterarLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(menuAlterarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(menuAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(menuAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimMouseClicked

        Deletar_Customers();
        Deletar_Employees();
        Deletar_Products();
        Deletar_Services();
        Deletar_Sales();
        Deletar_Spending();

        this.dispose();

        TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
        sucesso.setVisible(true);

    }//GEN-LAST:event_btnSimMouseClicked

    private void btnNaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNaoMouseClicked

        this.dispose();
    }//GEN-LAST:event_btnNaoMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeletar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnNao;
    private javax.swing.JLabel btnSim;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuAlterar;
    // End of variables declaration//GEN-END:variables
}
