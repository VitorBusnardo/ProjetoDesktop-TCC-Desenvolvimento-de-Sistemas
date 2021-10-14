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

public class TelaRegistrosBrutosGastos extends javax.swing.JFrame {
    
    public TelaRegistrosBrutosGastos() {
        initComponents();

        setIcon();
        pesquisarGastosSem();
        
        txtEditar1.setDocument(new Letras());
        txtEditar6.setDocument(new Letras());
        txtEditar5.setDocument(new Numeros());
        txtEditar2.setDocument(new Letras());
        
        tabelaGastosBruto.getTableHeader().setOpaque(false);
        tabelaGastosBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaGastosBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaGastosBruto.setRowHeight(25);
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    private void alterarGastos(){
    
        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;
        
        String sql = "update Gastos set Titulo=?, Tipo=?, Descricao=?, Data=?, Valor=?, CompradoGasto=?, Classificacao=? where Id=?";
        
        try {
            
            comandoSQL = conexao.criarPreparedStatement(sql);
            
            
            comandoSQL.setString(1, txtEditar1.getText());
            comandoSQL.setString(2, txtEditar2.getText());
            comandoSQL.setString(3, txtEditar3.getText());
            comandoSQL.setString(4, txtEditar4.getText());
            comandoSQL.setString(5, txtEditar5.getText());
            comandoSQL.setString(6, txtEditar6.getText());
            comandoSQL.setString(7, txtClassificacao.getSelectedItem().toString());
            
            comandoSQL.setString(8, txtEditarCod.getText());
            
            
            if (txtEditar1.getText().isEmpty() || txtEditar2.getText().isEmpty() || txtEditar3.getText().isEmpty() || txtEditar4.getText().isEmpty() || txtEditar5.getText().isEmpty() || txtEditar6.getText().isEmpty()){
            
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
                    txtEditarCod.setText(null); 
                    
                    pesquisarGastosSem();
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
    
    protected void deletarGastos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Gastos where Titulo=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deletarGastos.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deletarGastos.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisarGastosSem();
                    txtEditar1.setText(null);
                    txtEditar2.setText(null);
                    txtEditar3.setText(null);
                    txtEditar4.setText(null);
                    txtEditar5.setText(null);
                    txtEditar6.setText(null);
                    txtEditarCod.setText(null);
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    public void pesquisarGastosSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Titulo, Tipo, Descricao, Data, Valor, CompradoGasto, Classificacao from Gastos;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaGastosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarGastos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Titulo, Tipo, Descricao, Data, Valor, CompradoGasto, Classificacao from Gastos where Title like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarGastos.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaGastosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setarCamposGastos() {

        int setar = tabelaGastosBruto.getSelectedRow();
        
        txtEditarCod.setText(tabelaGastosBruto.getModel().getValueAt(setar, 0).toString());
        txtEditar1.setText(tabelaGastosBruto.getModel().getValueAt(setar, 1).toString());
        txtEditar2.setText(tabelaGastosBruto.getModel().getValueAt(setar, 2).toString());
        txtEditar3.setText(tabelaGastosBruto.getModel().getValueAt(setar, 3).toString());
        txtEditar4.setText(tabelaGastosBruto.getModel().getValueAt(setar, 4).toString());
        txtEditar5.setText(tabelaGastosBruto.getModel().getValueAt(setar, 5).toString());
        txtEditar6.setText(tabelaGastosBruto.getModel().getValueAt(setar, 6).toString());
        
        deletarGastos.setText(tabelaGastosBruto.getModel().getValueAt(setar, 1).toString());

    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelAzul = new javax.swing.JPanel();
        painelBranco = new javax.swing.JPanel();
        painelGastos = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaGastosBruto = new javax.swing.JTable();
        pesquisarGastos = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JLabel();
        deletarGastos = new javax.swing.JTextField();
        btnDeletarGastos = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JLabel();
        txtEditar2 = new javax.swing.JTextField();
        txtEditar3 = new javax.swing.JTextField();
        txtEditar6 = new javax.swing.JTextField();
        txtEditar5 = new javax.swing.JTextField();
        txtEditar8 = new javax.swing.JTextField();
        txtEditar9 = new javax.swing.JTextField();
        txtEditar1 = new javax.swing.JTextField();
        txtEditar7 = new javax.swing.JTextField();
        txtEditarCod = new javax.swing.JTextField();
        txtClassificacao = new javax.swing.JComboBox<>();
        txtEditar4 = new javax.swing.JFormattedTextField();
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

        painelGastos.setBackground(new java.awt.Color(255, 255, 255));
        painelGastos.setForeground(new java.awt.Color(102, 102, 102));
        painelGastos.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaGastosBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaGastosBruto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaGastosBruto.setFocusable(false);
        tabelaGastosBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaGastosBruto.setRowHeight(25);
        tabelaGastosBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaGastosBruto.setShowVerticalLines(false);
        tabelaGastosBruto.getTableHeader().setReorderingAllowed(false);
        tabelaGastosBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaGastosBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaGastosBruto);

        pesquisarGastos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarGastos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarGastosKeyReleased(evt);
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

        deletarGastos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarGastos.setToolTipText("");
        deletarGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarGastosActionPerformed(evt);
            }
        });

        btnDeletarGastos.setBackground(new java.awt.Color(23, 35, 51));
        btnDeletarGastos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeletarGastos.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletarGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeletarGastos.setText("Deletar");
        btnDeletarGastos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletarGastos.setOpaque(true);
        btnDeletarGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletarGastosMouseClicked(evt);
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

        txtEditar2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar2KeyTyped(evt);
            }
        });

        txtEditar3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditar3ActionPerformed(evt);
            }
        });
        txtEditar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar3KeyTyped(evt);
            }
        });

        txtEditar6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar6KeyTyped(evt);
            }
        });

        txtEditar5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar5KeyTyped(evt);
            }
        });

        txtEditar8.setEditable(false);
        txtEditar8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar8KeyReleased(evt);
            }
        });

        txtEditar9.setEditable(false);
        txtEditar9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar9KeyReleased(evt);
            }
        });

        txtEditar1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar1KeyTyped(evt);
            }
        });

        txtEditar7.setEditable(false);
        txtEditar7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar7KeyReleased(evt);
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

        txtClassificacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gastos com produtos", "Despesas com serviços", "Despesa não operacional", "Despesa Rh", "Despesas de marketing", "Despesas operacionais", "Impostos" }));

        try {
            txtEditar4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEditar4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnRelatorio.setBackground(new java.awt.Color(23, 35, 51));
        btnRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRelatorio.setText("Gerar Relátorio");
        btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRelatorio.setOpaque(true);
        btnRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelatorioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelGastosLayout = new javax.swing.GroupLayout(painelGastos);
        painelGastos.setLayout(painelGastosLayout);
        painelGastosLayout.setHorizontalGroup(
            painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGastosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelGastosLayout.createSequentialGroup()
                        .addComponent(pesquisarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelGastosLayout.createSequentialGroup()
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGastosLayout.createSequentialGroup()
                        .addComponent(deletarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGastosLayout.createSequentialGroup()
                        .addComponent(txtClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(painelGastosLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelGastosLayout.createSequentialGroup()
                        .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelGastosLayout.createSequentialGroup()
                        .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(448, 448, 448)
                        .addComponent(txtEditar7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGastosLayout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
            .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelGastosLayout.createSequentialGroup()
                    .addGap(435, 435, 435)
                    .addComponent(txtEditar4)
                    .addGap(435, 435, 435)))
        );
        painelGastosLayout.setVerticalGroup(
            painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGastosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelGastosLayout.createSequentialGroup()
                        .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelGastosLayout.createSequentialGroup()
                        .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deletarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeletarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesquisarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGastosLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(235, Short.MAX_VALUE)))
            .addGroup(painelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelGastosLayout.createSequentialGroup()
                    .addGap(310, 310, 310)
                    .addComponent(txtEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(192, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout painelBrancoLayout = new javax.swing.GroupLayout(painelBranco);
        painelBranco.setLayout(painelBrancoLayout);
        painelBrancoLayout.setHorizontalGroup(
            painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelGastos, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        painelBrancoLayout.setVerticalGroup(
            painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelGastos, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
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

    private void pesquisarGastosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarGastosKeyReleased
        pesquisarGastos();
    }//GEN-LAST:event_pesquisarGastosKeyReleased

    private void btnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseClicked
        pesquisarGastos();
    }//GEN-LAST:event_btnAtualizarMouseClicked

    private void deletarGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarGastosActionPerformed
        deletarGastos();
    }//GEN-LAST:event_deletarGastosActionPerformed

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void tabelaGastosBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaGastosBrutoMouseClicked
        setarCamposGastos();
    }//GEN-LAST:event_tabelaGastosBrutoMouseClicked

    private void btnDeletarGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarGastosMouseClicked
        deletarGastos();
    }//GEN-LAST:event_btnDeletarGastosMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        alterarGastos();
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void txtEditar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar2KeyReleased

    private void txtEditar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar3KeyReleased

    private void txtEditar6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar6KeyReleased

    private void txtEditar5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar5KeyReleased

    private void txtEditar8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar8KeyReleased

    private void txtEditar9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar9KeyReleased

    private void txtEditar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar3ActionPerformed

    private void txtEditar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar1KeyReleased

    private void txtEditar7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar7KeyReleased

    private void txtEditarCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditarCodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditarCodKeyReleased

    private void txtEditarCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditarCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditarCodActionPerformed

    private void txtEditar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar1KeyTyped
        
        if (txtEditar1.getText().length() >= 20) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar1KeyTyped

    private void txtEditar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar2KeyTyped
        
        if (txtEditar2.getText().length() >= 15) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar2KeyTyped

    private void txtEditar3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar3KeyTyped
        
        if (txtEditar3.getText().length() >= 80) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar3KeyTyped

    private void txtEditar5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar5KeyTyped
        
        if (txtEditar5.getText().length() >= 10) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar5KeyTyped

    private void txtEditar6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar6KeyTyped
        
        if (txtEditar6.getText().length() >= 20) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar6KeyTyped

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
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrosBrutosGastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnAtualizar;
    public javax.swing.JLabel btnDeletarGastos;
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btnRelatorio;
    public javax.swing.JLabel btnSalvar;
    private javax.swing.JTextField deletarGastos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel painelAzul;
    private javax.swing.JPanel painelBranco;
    public javax.swing.JPanel painelGastos;
    public javax.swing.JTextField pesquisarGastos;
    public javax.swing.JTable tabelaGastosBruto;
    private javax.swing.JComboBox<String> txtClassificacao;
    public javax.swing.JTextField txtEditar1;
    public javax.swing.JTextField txtEditar2;
    public javax.swing.JTextField txtEditar3;
    private javax.swing.JFormattedTextField txtEditar4;
    public javax.swing.JTextField txtEditar5;
    public javax.swing.JTextField txtEditar6;
    public javax.swing.JTextField txtEditar7;
    public javax.swing.JTextField txtEditar8;
    public javax.swing.JTextField txtEditar9;
    public javax.swing.JTextField txtEditarCod;
    // End of variables declaration//GEN-END:variables
}
