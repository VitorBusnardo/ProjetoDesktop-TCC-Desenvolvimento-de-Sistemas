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

public class TelaRegistrosBrutosFuncionarios extends javax.swing.JFrame {
    
    public TelaRegistrosBrutosFuncionarios() {
        initComponents();

        setIcon();
        pesquisarFuncionariosSem();
        
        txtEditar1.setDocument(new Letras());
        txtEditar2.setDocument(new Numeros());
        txtEditar9.setDocument(new Letras());
        txtEditar8.setDocument(new Numeros());
        
        tabelaFuncionariosBruto.getTableHeader().setOpaque(false);
        tabelaFuncionariosBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaFuncionariosBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaFuncionariosBruto.setRowHeight(25);
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    private void alterarFuncionarios(){
    
        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;
        
        String sql = "update Funcionarios set NomeCompleto=?, Idade=?, Email=?, Telefone=?, Endereco=?, Cpf=?, DataNascimento=?, Salario=?, AreaOcupacao=?, Sexo=? where Id=?";
        
        try {
            
            comandoSQL = conexao.criarPreparedStatement(sql);
            
            comandoSQL.setString(1, txtEditar1.getText());
            comandoSQL.setString(2, txtEditar2.getText());
            comandoSQL.setString(3, txtEditar3.getText());
            comandoSQL.setString(4, txtEditar4.getText());
            comandoSQL.setString(5, txtEditar5.getText());
            comandoSQL.setString(6, txtEditar6.getText());
            comandoSQL.setString(7, txtEditar7.getText());
            comandoSQL.setString(8, txtEditar8.getText());
            comandoSQL.setString(9, txtEditar9.getText());
            comandoSQL.setString(10, txtSexo.getSelectedItem().toString());
            
            
            comandoSQL.setString(11, txtEditarCod.getText());
            
            
            if (txtEditar1.getText().isEmpty() || txtEditar2.getText().isEmpty() || txtEditar4.getText().isEmpty() || txtEditar4.getText().isEmpty() || txtEditar5.getText().isEmpty() || txtEditar6.getText().isEmpty() || txtEditar7.getText().isEmpty() || txtEditar8.getText().isEmpty() || txtEditar9.getText().isEmpty()){
            
                TelaPreencherCadastro preencher = new TelaPreencherCadastro();
                preencher.setVisible(true);
                
            } else {
        
            int adicionar = comandoSQL.executeUpdate();
            
                if (adicionar > 0) {
                    
                   TelaSucessoAlterar sucesso = new TelaSucessoAlterar();
                   sucesso.setVisible(true);
                    txtEditar1.setText(null);
                    txtEditar2.setText(null);
                    txtEditar3.setText(null);
                    txtEditar4.setText(null);
                    txtEditar5.setText(null);
                    txtEditar6.setText(null);
                    txtEditar7.setText(null);
                    txtEditar8.setText(null);
                    txtEditar9.setText(null);
                    txtEditarCod.setText(null); 
                    
                    pesquisarFuncionariosSem();
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
    
    public void pesquisarFuncionariosSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, NomeCompleto, Idade, Email, Telefone, Endereco, Cpf, DataNascimento, Salario, AreaOcupacao, Sexo from Funcionarios;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaFuncionariosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void pesquisarFuncionarios() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, NomeCompleto, Idade, Email, Telefone, Endereco, Cpf, DataNascimento, Salario, AreaOcupacao, Sexo from Funcionarios where NomeCompleto like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarFuncionarios.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaFuncionariosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    protected void deletarFuncionarios() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Funcionarios where NomeCompleto=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deletarFuncionarios.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deletarFuncionarios.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisarFuncionariosSem();
                    txtEditar1.setText(null);
                    txtEditar2.setText(null);
                    txtEditar3.setText(null);
                    txtEditar4.setText(null);
                    txtEditar5.setText(null);
                    txtEditar6.setText(null);
                    txtEditar7.setText(null);
                    txtEditar8.setText(null);
                    txtEditar9.setText(null);
                    txtEditarCod.setText(null);
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }
    
    private void setarCamposFuncionarios() {

        int setar = tabelaFuncionariosBruto.getSelectedRow();
            
        txtEditarCod.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 0).toString());
        txtEditar1.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 1).toString());
        txtEditar2.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 2).toString());
        txtEditar3.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 3).toString());
        txtEditar4.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 4).toString());
        txtEditar5.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 5).toString());
        txtEditar6.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 6).toString());
        txtEditar7.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 7).toString());
        txtEditar8.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 8).toString());
        txtEditar9.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 9).toString());
        
        deletarFuncionarios.setText(tabelaFuncionariosBruto.getModel().getValueAt(setar, 1).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelAzul = new javax.swing.JPanel();
        painelBranco = new javax.swing.JPanel();
        painelFuncionarios = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaFuncionariosBruto = new javax.swing.JTable();
        pesquisarFuncionarios = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JLabel();
        deletarFuncionarios = new javax.swing.JTextField();
        btnDeletarFuncionarios = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JLabel();
        txtEditarCod = new javax.swing.JTextField();
        txtEditar1 = new javax.swing.JTextField();
        txtEditar2 = new javax.swing.JTextField();
        txtEditar4 = new javax.swing.JFormattedTextField();
        txtEditar5 = new javax.swing.JTextField();
        txtEditar6 = new javax.swing.JFormattedTextField();
        txtEditar7 = new javax.swing.JFormattedTextField();
        txtEditar8 = new javax.swing.JTextField();
        txtEditar9 = new javax.swing.JTextField();
        txtSexo = new javax.swing.JComboBox<>();
        txtEditar3 = new javax.swing.JTextField();
        btnRelatorio = new javax.swing.JLabel();
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

        painelAzul.setBackground(new java.awt.Color(71, 120, 197));
        painelAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelBranco.setBackground(new java.awt.Color(255, 255, 255));
        painelBranco.setPreferredSize(new java.awt.Dimension(444, 193));

        painelFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        painelFuncionarios.setForeground(new java.awt.Color(102, 102, 102));
        painelFuncionarios.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaFuncionariosBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaFuncionariosBruto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaFuncionariosBruto.setFocusable(false);
        tabelaFuncionariosBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaFuncionariosBruto.setRowHeight(25);
        tabelaFuncionariosBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaFuncionariosBruto.setShowVerticalLines(false);
        tabelaFuncionariosBruto.getTableHeader().setReorderingAllowed(false);
        tabelaFuncionariosBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaFuncionariosBruto);

        pesquisarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarFuncionarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarFuncionariosKeyReleased(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(23, 35, 51));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.setOpaque(true);
        btnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtualizarMouseClicked(evt);
            }
        });

        deletarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarFuncionarios.setToolTipText("");
        deletarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarFuncionariosActionPerformed(evt);
            }
        });

        btnDeletarFuncionarios.setBackground(new java.awt.Color(23, 35, 51));
        btnDeletarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeletarFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletarFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeletarFuncionarios.setText("Deletar");
        btnDeletarFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletarFuncionarios.setOpaque(true);
        btnDeletarFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletarFuncionariosMouseClicked(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(23, 35, 51));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalvar.setText("Salvar Alterações");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setOpaque(true);
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });

        txtEditarCod.setEditable(false);
        txtEditarCod.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditarCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditarCodActionPerformed(evt);
            }
        });
        txtEditarCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditarCodKeyReleased(evt);
            }
        });

        txtEditar1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditar1ActionPerformed(evt);
            }
        });
        txtEditar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar1KeyTyped(evt);
            }
        });

        txtEditar2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar2KeyTyped(evt);
            }
        });

        try {
            txtEditar4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEditar4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtEditar5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar5KeyTyped(evt);
            }
        });

        try {
            txtEditar6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEditar6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        try {
            txtEditar7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEditar7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtEditar8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar8KeyTyped(evt);
            }
        });

        txtEditar9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar9KeyTyped(evt);
            }
        });

        txtSexo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino", " " }));

        txtEditar3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar3KeyTyped(evt);
            }
        });

        btnRelatorio.setBackground(new java.awt.Color(23, 35, 51));
        btnRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRelatorio.setText("Gerar Relatório");
        btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRelatorio.setOpaque(true);
        btnRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelatorioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelFuncionariosLayout = new javax.swing.GroupLayout(painelFuncionarios);
        painelFuncionarios.setLayout(painelFuncionariosLayout);
        painelFuncionariosLayout.setHorizontalGroup(
            painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionariosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFuncionariosLayout.createSequentialGroup()
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFuncionariosLayout.createSequentialGroup()
                        .addComponent(pesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(painelFuncionariosLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7)
                    .addGroup(painelFuncionariosLayout.createSequentialGroup()
                        .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEditar9, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txtEditar8, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txtEditar7, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        painelFuncionariosLayout.setVerticalGroup(
            painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFuncionariosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFuncionariosLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(txtEditar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelFuncionariosLayout.createSequentialGroup()
                        .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFuncionariosLayout.createSequentialGroup()
                        .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(txtEditar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtEditar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFuncionariosLayout.createSequentialGroup()
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelBrancoLayout = new javax.swing.GroupLayout(painelBranco);
        painelBranco.setLayout(painelBrancoLayout);
        painelBrancoLayout.setHorizontalGroup(
            painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        painelBrancoLayout.setVerticalGroup(
            painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        painelAzul.add(painelBranco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 1140, 530));

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
        painelAzul.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void txtEditarCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditarCodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditarCodKeyReleased

    private void txtEditarCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditarCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditarCodActionPerformed

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        alterarFuncionarios();
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnDeletarFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarFuncionariosMouseClicked
        deletarFuncionarios();
    }//GEN-LAST:event_btnDeletarFuncionariosMouseClicked

    private void deletarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarFuncionariosActionPerformed
        deletarFuncionarios();
    }//GEN-LAST:event_deletarFuncionariosActionPerformed

    private void btnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseClicked
        pesquisarFuncionarios();
    }//GEN-LAST:event_btnAtualizarMouseClicked

    private void pesquisarFuncionariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarFuncionariosKeyReleased
        pesquisarFuncionarios();
    }//GEN-LAST:event_pesquisarFuncionariosKeyReleased

    private void tabelaFuncionariosBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosBrutoMouseClicked
        setarCamposFuncionarios();
    }//GEN-LAST:event_tabelaFuncionariosBrutoMouseClicked

    private void txtEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar1ActionPerformed

    private void txtEditar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar1KeyReleased

    private void txtEditar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar1KeyTyped

        if (txtEditar1.getText().length() >= 30) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar1KeyTyped

    private void txtEditar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar2KeyReleased

    private void txtEditar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar2KeyTyped

        if (txtEditar2.getText().length() >= 3) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar2KeyTyped

    private void txtEditar5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar5KeyReleased

    private void txtEditar5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar5KeyTyped

        if (txtEditar5.getText().length() >= 30) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar5KeyTyped

    private void txtEditar8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar8KeyReleased

    private void txtEditar8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar8KeyTyped

        if (txtEditar8.getText().length() >= 10) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar8KeyTyped

    private void txtEditar9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar9KeyReleased

    private void txtEditar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar3KeyReleased

    private void txtEditar3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar3KeyTyped
        
        if (txtEditar3.getText().length() >= 30) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar3KeyTyped

    private void txtEditar9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar9KeyTyped
       
        if (txtEditar9.getText().length() >= 20) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar9KeyTyped

    private void btnRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelatorioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRelatorioMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrosBrutosFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnAtualizar;
    public javax.swing.JLabel btnDeletarFuncionarios;
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btnRelatorio;
    public javax.swing.JLabel btnSalvar;
    private javax.swing.JTextField deletarFuncionarios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel painelAzul;
    private javax.swing.JPanel painelBranco;
    public javax.swing.JPanel painelFuncionarios;
    public javax.swing.JTextField pesquisarFuncionarios;
    public javax.swing.JTable tabelaFuncionariosBruto;
    public javax.swing.JTextField txtEditar1;
    public javax.swing.JTextField txtEditar2;
    public javax.swing.JTextField txtEditar3;
    private javax.swing.JFormattedTextField txtEditar4;
    public javax.swing.JTextField txtEditar5;
    private javax.swing.JFormattedTextField txtEditar6;
    private javax.swing.JFormattedTextField txtEditar7;
    public javax.swing.JTextField txtEditar8;
    public javax.swing.JTextField txtEditar9;
    public javax.swing.JTextField txtEditarCod;
    private javax.swing.JComboBox<String> txtSexo;
    // End of variables declaration//GEN-END:variables
}
