package view;

import conexao.ConexaoSQLite;
import formatting.Letras;
import formatting.Numeros;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaRegistrosBrutosCustomers extends javax.swing.JFrame {
    
    public TelaRegistrosBrutosCustomers() {
        initComponents();

        setIcon();
        pesquisar_Customers_Sem();
        Buscar_Services();
        
        tabelaCustomersBruto.getTableHeader().setOpaque(false);
        tabelaCustomersBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaCustomersBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaCustomersBruto.setRowHeight(25);
        
        txt_Editar1.setDocument(new Letras());
        txt_Editar2.setDocument(new Numeros());
        txt_Editar8.setDocument(new Letras());
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    private void alterar_customers(){
    
        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;
        
        String sql = "update Customers set FullName=?, Age=?, Email=?, Telephone=?, Address=?, Cpf=?, BirthDate=?, City=?, Sex=?, Services=? where Id=?";
        
        try {
            
            comandoSQL = conexao.criarPreparedStatement(sql);
            
            
            comandoSQL.setString(1, txt_Editar1.getText());
            comandoSQL.setString(2, txt_Editar2.getText());
            comandoSQL.setString(3, txt_Editar3.getText());
            comandoSQL.setString(4, txt_Editar4.getText());
            comandoSQL.setString(5, txt_Editar5.getText());
            comandoSQL.setString(6, txt_Editar6.getText());
            comandoSQL.setString(7, txt_Editar7.getText());
            comandoSQL.setString(8, txt_Editar8.getText());
            comandoSQL.setString(9, txtSex.getSelectedItem().toString());
            comandoSQL.setString(10, txtServices.getSelectedItem().toString());
            
            comandoSQL.setString(11, txt_EditarCod.getText());
            
            
            if (txt_Editar1.getText().isEmpty() || txt_Editar2.getText().isEmpty() || txt_Editar3.getText().isEmpty() || txt_Editar4.getText().isEmpty() || txt_Editar5.getText().isEmpty() || txt_Editar6.getText().isEmpty() || txt_Editar7.getText().isEmpty() || txt_Editar8.getText().isEmpty()){
            
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
                    txt_Editar5.setText(null);
                    txt_Editar6.setText(null);
                    txt_Editar7.setText(null);
                    txt_Editar8.setText(null);
                    txt_EditarCod.setText(null); 
                    
                    pesquisar_Customers_Sem();
                }
            
            }
            
        } catch (Exception e) {
           TelaErroCadastro error = new TelaErroCadastro();
           error.setVisible(true);
        } finally {

            try {

                comandoSQL.close();

                resultSQL.close();

                conexao.desconectar();

            } catch (SQLException e) {

                TelaErroCadastro error = new TelaErroCadastro();
                error.setVisible(true);

            }
        }
    }
    
    private void Buscar_Services() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select Name from Services;";

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                txtServices.addItem(resultSQL.getString("Name"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }
    
    protected void pesquisar_Customers_Sem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, FullName, Age, Email, Telephone, Address, Cpf, BirthDate, City, Sex, Services from Customers where FullName like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarCustomers.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaCustomersBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    protected void Deletar_Customers() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Customers where FullName=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deleteCustomers.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deleteCustomers.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisar_Customers_Sem();
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    public void pesquisar_Customers() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, FullName, Age, Email, Telephone, Address, Email, Cpf, BirthDate, City, Sex, Services from Customers where FullName like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarCustomers.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaCustomersBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void setar_camposCustomers() {

        int setar = tabelaCustomersBruto.getSelectedRow();
        
        txt_EditarCod.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 0).toString());
        txt_Editar1.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 1).toString());
        txt_Editar2.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 2).toString());
        txt_Editar3.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 3).toString());
        txt_Editar4.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 4).toString());
        txt_Editar5.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 5).toString());
        txt_Editar6.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 6).toString());
        txt_Editar7.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 7).toString());
        txt_Editar8.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 8).toString());
        
        deleteCustomers.setText(tabelaCustomersBruto.getModel().getValueAt(setar, 1).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelBlue = new javax.swing.JPanel();
        painelWhithe = new javax.swing.JPanel();
        painelCustomers = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaCustomersBruto = new javax.swing.JTable();
        pesquisarCustomers = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JLabel();
        deleteCustomers = new javax.swing.JTextField();
        btn_DeletarCostumers = new javax.swing.JLabel();
        btn_Editions = new javax.swing.JLabel();
        txt_Editar2 = new javax.swing.JTextField();
        txt_Editar3 = new javax.swing.JTextField();
        txt_Editar5 = new javax.swing.JTextField();
        txt_Editar8 = new javax.swing.JTextField();
        txt_Editar9 = new javax.swing.JTextField();
        txt_Editar1 = new javax.swing.JTextField();
        txt_EditarCod = new javax.swing.JTextField();
        txtSex = new javax.swing.JComboBox<>();
        txtServices = new javax.swing.JComboBox<>();
        txt_Editar4 = new javax.swing.JFormattedTextField();
        txt_Editar6 = new javax.swing.JFormattedTextField();
        txt_Editar7 = new javax.swing.JFormattedTextField();
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

        painelWhithe.setBackground(new java.awt.Color(255, 255, 255));
        painelWhithe.setPreferredSize(new java.awt.Dimension(444, 193));

        painelCustomers.setBackground(new java.awt.Color(255, 255, 255));
        painelCustomers.setForeground(new java.awt.Color(102, 102, 102));
        painelCustomers.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaCustomersBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaCustomersBruto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaCustomersBruto.setFocusable(false);
        tabelaCustomersBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaCustomersBruto.setRowHeight(25);
        tabelaCustomersBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaCustomersBruto.setShowVerticalLines(false);
        tabelaCustomersBruto.getTableHeader().setReorderingAllowed(false);
        tabelaCustomersBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCustomersBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaCustomersBruto);

        pesquisarCustomers.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarCustomers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarCustomersKeyReleased(evt);
            }
        });

        btn_Refresh.setBackground(new java.awt.Color(23, 35, 51));
        btn_Refresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_Refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Refresh.setText("Refresh");
        btn_Refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Refresh.setOpaque(true);
        btn_Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_RefreshMouseClicked(evt);
            }
        });

        deleteCustomers.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteCustomers.setToolTipText("");
        deleteCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomersActionPerformed(evt);
            }
        });

        btn_DeletarCostumers.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeletarCostumers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeletarCostumers.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeletarCostumers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeletarCostumers.setText("Delete");
        btn_DeletarCostumers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeletarCostumers.setOpaque(true);
        btn_DeletarCostumers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeletarCostumersMouseClicked(evt);
            }
        });

        btn_Editions.setBackground(new java.awt.Color(23, 35, 51));
        btn_Editions.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Editions.setForeground(new java.awt.Color(255, 255, 255));
        btn_Editions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Editions.setText("Save Editions");
        btn_Editions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Editions.setOpaque(true);
        btn_Editions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EditionsMouseClicked(evt);
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
        txt_Editar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Editar3ActionPerformed(evt);
            }
        });
        txt_Editar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar3KeyTyped(evt);
            }
        });

        txt_Editar5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar5KeyTyped(evt);
            }
        });

        txt_Editar8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar8KeyTyped(evt);
            }
        });

        txt_Editar9.setEditable(false);
        txt_Editar9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar9KeyReleased(evt);
            }
        });

        txt_Editar1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Editar1ActionPerformed(evt);
            }
        });
        txt_Editar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Editar1KeyTyped(evt);
            }
        });

        txt_EditarCod.setEditable(false);
        txt_EditarCod.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_EditarCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EditarCodActionPerformed(evt);
            }
        });
        txt_EditarCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_EditarCodKeyReleased(evt);
            }
        });

        txtSex.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));

        txtServices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        try {
            txt_Editar4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_Editar4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        try {
            txt_Editar6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_Editar6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        try {
            txt_Editar7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_Editar7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout painelCustomersLayout = new javax.swing.GroupLayout(painelCustomers);
        painelCustomers.setLayout(painelCustomersLayout);
        painelCustomersLayout.setHorizontalGroup(
            painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCustomersLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesquisarCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelCustomersLayout.createSequentialGroup()
                        .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Editions, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCustomersLayout.createSequentialGroup()
                        .addComponent(deleteCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DeletarCostumers, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCustomersLayout.createSequentialGroup()
                        .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_EditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(painelCustomersLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Editar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Editar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Editar4)
                    .addComponent(txt_Editar5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addGap(89, 89, 89)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Editar9, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txt_Editar8, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txt_Editar7))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCustomersLayout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
            .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCustomersLayout.createSequentialGroup()
                    .addGap(435, 435, 435)
                    .addComponent(txt_Editar6)
                    .addGap(435, 435, 435)))
        );
        painelCustomersLayout.setVerticalGroup(
            painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCustomersLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Editions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_EditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Editar1)
                    .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Editar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Editar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCustomersLayout.createSequentialGroup()
                        .addComponent(txt_Editar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txt_Editar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCustomersLayout.createSequentialGroup()
                        .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Editar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(txt_Editar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_DeletarCostumers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisarCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCustomersLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(235, Short.MAX_VALUE)))
            .addGroup(painelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCustomersLayout.createSequentialGroup()
                    .addGap(427, 427, 427)
                    .addComponent(txt_Editar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout painelWhitheLayout = new javax.swing.GroupLayout(painelWhithe);
        painelWhithe.setLayout(painelWhitheLayout);
        painelWhitheLayout.setHorizontalGroup(
            painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        painelWhitheLayout.setVerticalGroup(
            painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        painelBlue.add(painelWhithe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 1140, 530));

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

    private void pesquisarCustomersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarCustomersKeyReleased
        pesquisar_Customers();
    }//GEN-LAST:event_pesquisarCustomersKeyReleased

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
        pesquisar_Customers();
        Buscar_Services();
    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void deleteCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomersActionPerformed
        Deletar_Customers();
    }//GEN-LAST:event_deleteCustomersActionPerformed

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void tabelaCustomersBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCustomersBrutoMouseClicked
        setar_camposCustomers();
    }//GEN-LAST:event_tabelaCustomersBrutoMouseClicked

    private void btn_DeletarCostumersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeletarCostumersMouseClicked
        Deletar_Customers();
    }//GEN-LAST:event_btn_DeletarCostumersMouseClicked

    private void btn_EditionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditionsMouseClicked
        alterar_customers();
        pesquisar_Customers_Sem();
    }//GEN-LAST:event_btn_EditionsMouseClicked

    private void txt_Editar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar2KeyReleased

    private void txt_Editar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar3KeyReleased

    private void txt_Editar5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar5KeyReleased

    private void txt_Editar8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar8KeyReleased

    private void txt_Editar9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar9KeyReleased

    private void txt_Editar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Editar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar3ActionPerformed

    private void txt_Editar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar1KeyReleased

    private void txt_EditarCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EditarCodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EditarCodKeyReleased

    private void txt_EditarCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EditarCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EditarCodActionPerformed

    private void txt_Editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Editar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar1ActionPerformed

    private void txt_Editar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar1KeyTyped
        
        if (txt_Editar1.getText().length() >= 30) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txt_Editar1KeyTyped

    private void txt_Editar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar2KeyTyped
        
        if (txt_Editar2.getText().length() >= 3) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txt_Editar2KeyTyped

    private void txt_Editar3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar3KeyTyped
        
        if (txt_Editar3.getText().length() >= 30) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txt_Editar3KeyTyped

    private void txt_Editar5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar5KeyTyped
        
        if (txt_Editar5.getText().length() >= 30) {

            evt.consume();
        }
                
    }//GEN-LAST:event_txt_Editar5KeyTyped

    private void txt_Editar8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar8KeyTyped
        
         if (txt_Editar8.getText().length() >= 20) {

            evt.consume();
        }
         
    }//GEN-LAST:event_txt_Editar8KeyTyped

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrosBrutosCustomers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btn_DeletarCostumers;
    public javax.swing.JLabel btn_Editions;
    public javax.swing.JLabel btn_Refresh;
    private javax.swing.JTextField deleteCustomers;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel painelBlue;
    public javax.swing.JPanel painelCustomers;
    private javax.swing.JPanel painelWhithe;
    public javax.swing.JTextField pesquisarCustomers;
    public javax.swing.JTable tabelaCustomersBruto;
    private javax.swing.JComboBox<String> txtServices;
    private javax.swing.JComboBox<String> txtSex;
    public javax.swing.JTextField txt_Editar1;
    public javax.swing.JTextField txt_Editar2;
    public javax.swing.JTextField txt_Editar3;
    private javax.swing.JFormattedTextField txt_Editar4;
    public javax.swing.JTextField txt_Editar5;
    private javax.swing.JFormattedTextField txt_Editar6;
    private javax.swing.JFormattedTextField txt_Editar7;
    public javax.swing.JTextField txt_Editar8;
    public javax.swing.JTextField txt_Editar9;
    public javax.swing.JTextField txt_EditarCod;
    // End of variables declaration//GEN-END:variables
}
