package visao;

import conexao.ConexaoSQLite;
import formatacao.Letras;
import formatacao.Numeros;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class TelaCadastroClientes extends javax.swing.JFrame {

    private void buscarServico() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select Name from Services;";

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                txtServicos.addItem(resultSQL.getString("Name"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    protected void insertCadastro() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        PreparedStatement readComando = null;

        String insertSQL = "insert into Customers(FullName,Age,Email,Telephone,Address,Cpf,BirthDate,City,Sex,Services) VALUES(?,?,?,?,?,?,?,?,?,?);";

        String readSql = "select Name from Services where Name = ?";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String date = sdf.format(txtDataNascimento.getDate());

        //criando Stament para fazer insert 
        try {

            readComando = conexao.criarPreparedStatement(readSql);
            readComando.setString(1, txtServicos.getSelectedItem().toString());
            resultSQL = readComando.executeQuery();
            String idServices = resultSQL.getString("Name");
            
            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            comandoSQL.setString(1, txNomeCompleto.getText());
            comandoSQL.setString(2, txtIdade.getText());
            comandoSQL.setString(3, txtEmail.getText());
            comandoSQL.setString(4, txtTelefone.getText());
            comandoSQL.setString(5, txtEndereco.getText());
            comandoSQL.setString(6, txtCpf.getText());
            comandoSQL.setString(7, date);
            comandoSQL.setString(8, txtCidade.getText());
            comandoSQL.setString(9, txtSexo.getSelectedItem().toString());
            comandoSQL.setString(10, txtServicos.getSelectedItem().toString());

            if (txtEndereco.getText().isEmpty() || txtIdade.getText().isEmpty() || txtCidade.getText().isEmpty() || txtEmail.getText().isEmpty() || txNomeCompleto.getText().isEmpty() || txtTelefone.getText().isEmpty()) {

                TelaPreencherCadastro preencher = new TelaPreencherCadastro();
                preencher.setVisible(true);

            } else {

                int insert = comandoSQL.executeUpdate();

                if (insert > 0) {
                    TelaSucessoCadastro cadastro = new TelaSucessoCadastro();
                    cadastro.setVisible(true);
                    txtEndereco.setText(null);
                    txtIdade.setText(null);
                    txtCidade.setText(null);
                    txtCpf.setText(null);
                    txtEmail.setText(null);
                    txNomeCompleto.setText(null);
                    txtTelefone.setText(null);
                    txtSexo.setSelectedItem("Male");
                    txtDataNascimento.setCalendar(null);
                }

            }
        } catch (SQLException e) {
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

    public TelaCadastroClientes() {
        initComponents();

        setIcon();

        buscarServico();

        txNomeCompleto.setDocument(new Letras());
        txtIdade.setDocument(new Numeros());
        txtCidade.setDocument(new Letras());

    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFechar = new javax.swing.JPanel();
        btnFechar = new javax.swing.JLabel();
        menuSecundario = new javax.swing.JPanel();
        painel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JPanel();
        indRegistrar = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtServicos = new javax.swing.JComboBox<>();
        btnRegistros = new javax.swing.JPanel();
        indRegistros = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JPanel();
        txNomeCompleto = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JComboBox<>();
        txtDataNascimento = new com.toedter.calendar.JDateChooser();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);

        menuFechar.setBackground(new java.awt.Color(71, 120, 197));
        menuFechar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuFecharMouseDragged(evt);
            }
        });
        menuFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuFecharMousePressed(evt);
            }
        });

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

        javax.swing.GroupLayout menuFecharLayout = new javax.swing.GroupLayout(menuFechar);
        menuFechar.setLayout(menuFecharLayout);
        menuFecharLayout.setHorizontalGroup(
            menuFecharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuFecharLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuFecharLayout.setVerticalGroup(
            menuFecharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFechar)
        );

        menuSecundario.setBackground(new java.awt.Color(192, 192, 192));

        painel.setBackground(new java.awt.Color(23, 35, 51));
        painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clientes");
        painel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconBusinessman.png"))); // NOI18N
        painel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, 60));

        btnRegistrar.setBackground(new java.awt.Color(23, 35, 51));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseReleased(evt);
            }
        });

        indRegistrar.setOpaque(false);
        indRegistrar.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indRegistrarLayout = new javax.swing.GroupLayout(indRegistrar);
        indRegistrar.setLayout(indRegistrarLayout);
        indRegistrarLayout.setHorizontalGroup(
            indRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indRegistrarLayout.setVerticalGroup(
            indRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Registrar");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnRegistrarLayout = new javax.swing.GroupLayout(btnRegistrar);
        btnRegistrar.setLayout(btnRegistrarLayout);
        btnRegistrarLayout.setHorizontalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegistrarLayout.createSequentialGroup()
                .addComponent(indRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel15)
                .addGap(0, 43, Short.MAX_VALUE))
        );
        btnRegistrarLayout.setVerticalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegistrarLayout.createSequentialGroup()
                .addComponent(indRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Serviço");

        txtServicos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnRegistros.setBackground(new java.awt.Color(23, 35, 51));
        btnRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegistrosMouseReleased(evt);
            }
        });

        indRegistros.setOpaque(false);
        indRegistros.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indRegistrosLayout = new javax.swing.GroupLayout(indRegistros);
        indRegistros.setLayout(indRegistrosLayout);
        indRegistrosLayout.setHorizontalGroup(
            indRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indRegistrosLayout.setVerticalGroup(
            indRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Registros");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnRegistrosLayout = new javax.swing.GroupLayout(btnRegistros);
        btnRegistros.setLayout(btnRegistrosLayout);
        btnRegistrosLayout.setHorizontalGroup(
            btnRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegistrosLayout.createSequentialGroup()
                .addComponent(indRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        btnRegistrosLayout.setVerticalGroup(
            btnRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegistrosLayout.createSequentialGroup()
                .addComponent(indRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnRegistrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuSecundarioLayout = new javax.swing.GroupLayout(menuSecundario);
        menuSecundario.setLayout(menuSecundarioLayout);
        menuSecundarioLayout.setHorizontalGroup(
            menuSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuSecundarioLayout.createSequentialGroup()
                .addGroup(menuSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuSecundarioLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel11))
                    .addGroup(menuSecundarioLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuSecundarioLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(menuSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuSecundarioLayout.setVerticalGroup(
            menuSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuSecundarioLayout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtServicos, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(144, 144, 144)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        menuPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        txNomeCompleto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txNomeCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeCompletoActionPerformed(evt);
            }
        });
        txNomeCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNomeCompletoKeyTyped(evt);
            }
        });

        txtIdade.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });
        txtIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdadeKeyTyped(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Idade:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nome completo:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("CPF: ");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Endereço:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Telefone:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Email: ");

        txtEndereco.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyTyped(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Data Nascimento:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Cidade:");

        txtCidade.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });
        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCidadeKeyTyped(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Sexo:");

        txtSexo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino", "" }));

        txtDataNascimento.setBackground(new java.awt.Color(255, 255, 255));
        txtDataNascimento.setToolTipText("");
        txtDataNascimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDataNascimento.setOpaque(false);
        txtDataNascimento.setVerifyInputWhenFocusTarget(false);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout menuPrincipalLayout = new javax.swing.GroupLayout(menuPrincipal);
        menuPrincipal.setLayout(menuPrincipalLayout);
        menuPrincipalLayout.setHorizontalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPrincipalLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txNomeCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtIdade, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(txtSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCpf))
                .addGap(43, 43, 43))
        );
        menuPrincipalLayout.setVerticalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPrincipalLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addGroup(menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade))
                .addGroup(menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(menuPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtSexo))
                    .addGroup(menuPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int xx, xy;
    TelaRegistrosBrutosClientes brutosCustomers = new TelaRegistrosBrutosClientes();

    private void menuFecharMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFecharMousePressed

        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_menuFecharMousePressed

    private void menuFecharMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFecharMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_menuFecharMouseDragged

    private void btnRegistrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseReleased

    }//GEN-LAST:event_btnRegistrarMouseReleased

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked

        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void txNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeCompletoActionPerformed

    }//GEN-LAST:event_txNomeCompletoActionPerformed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        // TODO add your handling code here:

        this.insertCadastro();
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void txNomeCompletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeCompletoKeyTyped

        if (txNomeCompleto.getText().length() >= 30) {

            evt.consume();
        }

    }//GEN-LAST:event_txNomeCompletoKeyTyped

    private void txtIdadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdadeKeyTyped

        if (txtIdade.getText().length() >= 3) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txtIdadeKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped

        if (txtEmail.getText().length() >= 30) {

            evt.consume();
        }

    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyTyped

        if (txtEndereco.getText().length() >= 30) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txtEnderecoKeyTyped

    private void txtCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyTyped

        if (txtCidade.getText().length() >= 20) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txtCidadeKeyTyped

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        brutosCustomers.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseReleased

    private void btnRegistrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrosMouseReleased
        brutosCustomers.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrosMouseReleased

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroClientes().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFechar;
    private javax.swing.JPanel btnRegistrar;
    private javax.swing.JPanel btnRegistros;
    private javax.swing.JPanel indRegistrar;
    private javax.swing.JPanel indRegistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel menuFechar;
    private javax.swing.JPanel menuPrincipal;
    private javax.swing.JPanel menuSecundario;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField txNomeCompleto;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private com.toedter.calendar.JDateChooser txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JComboBox<Object> txtServicos;
    private javax.swing.JComboBox<String> txtSexo;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
