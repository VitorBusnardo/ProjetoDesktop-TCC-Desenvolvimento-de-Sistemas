package visao;

import conexao.ConexaoSQLite;
import formatacao.Letras;
import formatacao.Numeros;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaRegistrosBrutosServicos extends javax.swing.JFrame {
    
    public TelaRegistrosBrutosServicos() {
        initComponents();

        setIcon();
        pesquisar_services_Sem();
        
        txt_Editar1.setDocument(new Letras());
        txt_Editar2.setDocument(new Numeros());
        txt_Editar4.setDocument(new Letras());
        
        tabelaServicesBruto.getTableHeader().setOpaque(false);
        tabelaServicesBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaServicesBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaServicesBruto.setRowHeight(25);
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    private void alterar_services(){
    
        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;
        
        String sql = "update Services set Name=?, Type=?, Description=?, Value=? where Id=?";
    
        try {
            
            comandoSQL = conexao.criarPreparedStatement(sql);
            
            
            comandoSQL.setString(1, txt_Editar1.getText());
            comandoSQL.setString(2, txt_Editar2.getText());
            comandoSQL.setString(3, txt_Editar3.getText());
            comandoSQL.setString(4, txt_Editar4.getText());
            comandoSQL.setString(5, txt_EditarCod.getText());
            
            
            
            if (txt_Editar1.getText().isEmpty() || txt_Editar2.getText().isEmpty() || txt_Editar3.getText().isEmpty() || txt_Editar4.getText().isEmpty()){
            
                TelaPreencherCadastro preencher = new TelaPreencherCadastro();
                preencher.setVisible(true);
                
            } else {
        
            int adicionar = comandoSQL.executeUpdate();
            
                if (adicionar > 0) {
                    
                   JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
                    txt_Editar1.setText(null);
                    txt_Editar2.setText(null);
                    txt_Editar3.setText(null);
                    txt_Editar4.setText(null);
                    txt_EditarCod.setText(null); 
                    
                    pesquisar_services_Sem();
                }
            
            }
            
        } catch (Exception e) {
            TelaErroAlterar error = new TelaErroAlterar();
            error.setVisible(true);
        } finally {

            try {

                comandoSQL.close();

                resultSQL.close();

                conexao.desconectar();

            } catch (SQLException e) {
                TelaErroAlterar error = new TelaErroAlterar();
                error.setVisible(true);
            }
        }
    }
    
    public void pesquisar_services_Sem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Name, Type, Description, Value from Services;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaServicesBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    protected void Deletar_Services() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Services where Name=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deleteServices.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deleteServices.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisar_services_Sem();
                    txt_Editar1.setText(null);
                    txt_Editar2.setText(null);
                    txt_Editar3.setText(null);
                    txt_Editar4.setText(null);
                    txt_EditarCod.setText(null); 
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    public void pesquisar_services() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Name, Type, Description, Value from Services where Name like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarServices.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaServicesBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void setar_camposServices() {

        int setar = tabelaServicesBruto.getSelectedRow();
        
        txt_EditarCod.setText(tabelaServicesBruto.getModel().getValueAt(setar, 0).toString());
        txt_Editar1.setText(tabelaServicesBruto.getModel().getValueAt(setar, 1).toString());
        txt_Editar2.setText(tabelaServicesBruto.getModel().getValueAt(setar, 2).toString());
        txt_Editar3.setText(tabelaServicesBruto.getModel().getValueAt(setar, 3).toString());
        txt_Editar4.setText(tabelaServicesBruto.getModel().getValueAt(setar, 4).toString());
            
        deleteServices.setText(tabelaServicesBruto.getModel().getValueAt(setar, 1).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelBlue = new javax.swing.JPanel();
        painelWhite = new javax.swing.JPanel();
        painelServices = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaServicesBruto = new javax.swing.JTable();
        pesquisarServices = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JLabel();
        deleteServices = new javax.swing.JTextField();
        btn_DeleteServices = new javax.swing.JLabel();
        txt_Editar1 = new javax.swing.JTextField();
        txt_Editar2 = new javax.swing.JTextField();
        txt_Editar3 = new javax.swing.JTextField();
        txt_Editar4 = new javax.swing.JTextField();
        txt_Editar5 = new javax.swing.JTextField();
        txt_Editar6 = new javax.swing.JTextField();
        btn_Editions = new javax.swing.JLabel();
        txt_EditarCod = new javax.swing.JTextField();
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

        painelBlue.setBackground(new java.awt.Color(71, 120, 197));
        painelBlue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelWhite.setBackground(new java.awt.Color(255, 255, 255));
        painelWhite.setPreferredSize(new java.awt.Dimension(444, 193));

        painelServices.setBackground(new java.awt.Color(255, 255, 255));
        painelServices.setForeground(new java.awt.Color(102, 102, 102));
        painelServices.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaServicesBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaServicesBruto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaServicesBruto.setFocusable(false);
        tabelaServicesBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaServicesBruto.setRowHeight(25);
        tabelaServicesBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaServicesBruto.setShowVerticalLines(false);
        tabelaServicesBruto.getTableHeader().setReorderingAllowed(false);
        tabelaServicesBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaServicesBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaServicesBruto);

        pesquisarServices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarServices.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarServicesKeyReleased(evt);
            }
        });

        btn_Refresh.setBackground(new java.awt.Color(23, 35, 51));
        btn_Refresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_Refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Refresh.setText("Atualizar");
        btn_Refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Refresh.setOpaque(true);
        btn_Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_RefreshMouseClicked(evt);
            }
        });

        deleteServices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteServices.setToolTipText("");
        deleteServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteServicesActionPerformed(evt);
            }
        });

        btn_DeleteServices.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeleteServices.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeleteServices.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeleteServices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeleteServices.setText("Deletar");
        btn_DeleteServices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteServices.setOpaque(true);
        btn_DeleteServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteServicesMouseClicked(evt);
            }
        });

        txt_Editar1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar1KeyTyped(evt);
            }
        });

        txt_Editar2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar2KeyTyped(evt);
            }
        });

        txt_Editar3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar3KeyTyped(evt);
            }
        });

        txt_Editar4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar4KeyTyped(evt);
            }
        });

        txt_Editar5.setEditable(false);
        txt_Editar5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar5KeyReleased(evt);
            }
        });

        txt_Editar6.setEditable(false);
        txt_Editar6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar6KeyReleased(evt);
            }
        });

        btn_Editions.setBackground(new java.awt.Color(23, 35, 51));
        btn_Editions.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Editions.setForeground(new java.awt.Color(255, 255, 255));
        btn_Editions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Editions.setText("Salvar Alterações");
        btn_Editions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Editions.setOpaque(true);
        btn_Editions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EditionsMouseClicked(evt);
            }
        });

        txt_EditarCod.setEditable(false);
        txt_EditarCod.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_EditarCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_EditarCodKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout painelServicesLayout = new javax.swing.GroupLayout(painelServices);
        painelServices.setLayout(painelServicesLayout);
        painelServicesLayout.setHorizontalGroup(
            painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicesLayout.createSequentialGroup()
                .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelServicesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelServicesLayout.createSequentialGroup()
                                .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Editions, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_EditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelServicesLayout.createSequentialGroup()
                                .addComponent(pesquisarServices, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteServices, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btn_DeleteServices, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelServicesLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Editar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Editar4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Editar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addGap(35, 35, 35))
            .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicesLayout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        painelServicesLayout.setVerticalGroup(
            painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Editions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_EditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelServicesLayout.createSequentialGroup()
                        .addComponent(txt_Editar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txt_Editar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelServicesLayout.createSequentialGroup()
                        .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Editar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Editar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_DeleteServices, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
            .addGroup(painelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicesLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout painelWhiteLayout = new javax.swing.GroupLayout(painelWhite);
        painelWhite.setLayout(painelWhiteLayout);
        painelWhiteLayout.setHorizontalGroup(
            painelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(painelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelServices, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        painelWhiteLayout.setVerticalGroup(
            painelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(painelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelServices, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        painelBlue.add(painelWhite, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 1140, 530));

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
        painelBlue.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarServicesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarServicesKeyReleased
        pesquisar_services();
    }//GEN-LAST:event_pesquisarServicesKeyReleased

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
        pesquisar_services();
    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void deleteServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteServicesActionPerformed
        Deletar_Services();
    }//GEN-LAST:event_deleteServicesActionPerformed

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void tabelaServicesBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaServicesBrutoMouseClicked
        setar_camposServices();
    }//GEN-LAST:event_tabelaServicesBrutoMouseClicked

    private void btn_DeleteServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteServicesMouseClicked
        Deletar_Services();
    }//GEN-LAST:event_btn_DeleteServicesMouseClicked

    private void txt_Editar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar1KeyReleased

    private void txt_Editar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar2KeyReleased

    private void txt_Editar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar3KeyReleased

    private void txt_Editar4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar4KeyReleased

    private void txt_Editar5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar5KeyReleased

    private void txt_Editar6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar6KeyReleased

    private void btn_EditionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditionsMouseClicked
        alterar_services();
    }//GEN-LAST:event_btn_EditionsMouseClicked

    private void txt_EditarCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EditarCodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EditarCodKeyReleased

    private void txt_Editar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar1KeyTyped
        
        if (txt_Editar1.getText().length() >= 20) {
            evt.consume();
        }
                
    }//GEN-LAST:event_txt_Editar1KeyTyped

    private void txt_Editar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar2KeyTyped
        
        if (txt_Editar2.getText().length() >= 20) {
            evt.consume();
        }
                
    }//GEN-LAST:event_txt_Editar2KeyTyped

    private void txt_Editar3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar3KeyTyped
        
        if (txt_Editar3.getText().length() >= 80) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txt_Editar3KeyTyped

    private void txt_Editar4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar4KeyTyped
        
        if (txt_Editar4.getText().length() >= 10) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txt_Editar4KeyTyped

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrosBrutosServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btn_DeleteServices;
    public javax.swing.JLabel btn_Editions;
    public javax.swing.JLabel btn_Refresh;
    private javax.swing.JTextField deleteServices;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel painelBlue;
    public javax.swing.JPanel painelServices;
    private javax.swing.JPanel painelWhite;
    public javax.swing.JTextField pesquisarServices;
    public javax.swing.JTable tabelaServicesBruto;
    public javax.swing.JTextField txt_Editar1;
    public javax.swing.JTextField txt_Editar2;
    public javax.swing.JTextField txt_Editar3;
    public javax.swing.JTextField txt_Editar4;
    public javax.swing.JTextField txt_Editar5;
    public javax.swing.JTextField txt_Editar6;
    public javax.swing.JTextField txt_EditarCod;
    // End of variables declaration//GEN-END:variables
}
