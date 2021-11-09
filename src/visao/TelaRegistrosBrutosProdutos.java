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

public class TelaRegistrosBrutosProdutos extends javax.swing.JFrame {
    
    public TelaRegistrosBrutosProdutos() {
        initComponents();

        setIcon();
        pesquisarProdutosSem();
        
        tabelaProdutosBruto.getTableHeader().setOpaque(false);
        tabelaProdutosBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaProdutosBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaProdutosBruto.setRowHeight(25);
        
        txtEditar1.setDocument(new Letras());
        txtEditar2.setDocument(new Letras());
        txtEditar3.setDocument(new Numeros());
        txtEditar5.setDocument(new Numeros());
        txtEditar6.setDocument(new Letras());
    
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    private void alterarProdutos(){
    
        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;
        
        String sql = "update Produtos set Nome=?, Marca=?, Estoque=?, Descricao=?, Valor=?, Tipo=? where Id=?";
    
        try {
            
            comandoSQL = conexao.criarPreparedStatement(sql);
            
            
            comandoSQL.setString(1, txtEditar1.getText());
            comandoSQL.setString(2, txtEditar2.getText());
            comandoSQL.setString(3, txtEditar3.getText());
            comandoSQL.setString(4, txtEditar4.getText());
            comandoSQL.setString(5, txtEditar5.getText());
            comandoSQL.setString(6, txtEditar6.getText());
            comandoSQL.setString(7, txtEditarCod.getText());
            
            
            
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
                    
                    pesquisarProdutosSem();
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
    
    public void pesquisarProdutosSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Nome, Marca, Estoque, Descricao, Valor, Tipo from Produtos;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaProdutosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    protected void deletarProdutos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Produtos where Nome=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deletarProdutos.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deletarProdutos.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                
                    txtEditar1.setText(null);
                    txtEditar2.setText(null);
                    txtEditar3.setText(null);
                    txtEditar4.setText(null);
                    txtEditar5.setText(null);
                    txtEditar6.setText(null);
                    txtEditarCod.setText(null); 
                
                pesquisarProdutosSem();
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    public void pesquisarProdutos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Nome, Marca, Estoque, Descricao, Valor, Tipo from Produtos where Nome like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarProdutos.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaProdutosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void setarCamposProdutos() {

            int setar = tabelaProdutosBruto.getSelectedRow();
            
            txtEditarCod.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 0).toString());
            txtEditar1.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 1).toString());
            txtEditar2.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 2).toString());
            txtEditar3.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 3).toString());
            txtEditar4.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 4).toString());
            txtEditar5.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 5).toString());
            txtEditar6.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 6).toString());
            
            
            deletarProdutos.setText(tabelaProdutosBruto.getModel().getValueAt(setar, 1).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelAzul = new javax.swing.JPanel();
        painelBranco = new javax.swing.JPanel();
        painelProdutos = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaProdutosBruto = new javax.swing.JTable();
        pesquisarProdutos = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JLabel();
        deletarProdutos = new javax.swing.JTextField();
        btnDeletarProdutos = new javax.swing.JLabel();
        txtEditar1 = new javax.swing.JTextField();
        txtEditar2 = new javax.swing.JTextField();
        txtEditar3 = new javax.swing.JTextField();
        txtEditar4 = new javax.swing.JTextField();
        txtEditar5 = new javax.swing.JTextField();
        txtEditar6 = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JLabel();
        txtEditarCod = new javax.swing.JTextField();
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

        painelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelProdutos.setForeground(new java.awt.Color(102, 102, 102));
        painelProdutos.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaProdutosBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaProdutosBruto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaProdutosBruto.setFocusable(false);
        tabelaProdutosBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaProdutosBruto.setRowHeight(25);
        tabelaProdutosBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaProdutosBruto.setShowVerticalLines(false);
        tabelaProdutosBruto.getTableHeader().setReorderingAllowed(false);
        tabelaProdutosBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaProdutosBruto);

        pesquisarProdutos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarProdutosKeyReleased(evt);
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

        deletarProdutos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarProdutos.setToolTipText("");
        deletarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarProdutosActionPerformed(evt);
            }
        });

        btnDeletarProdutos.setBackground(new java.awt.Color(23, 35, 51));
        btnDeletarProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeletarProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletarProdutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeletarProdutos.setText("Deletar");
        btnDeletarProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletarProdutos.setOpaque(true);
        btnDeletarProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletarProdutosMouseClicked(evt);
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
        txtEditar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar3KeyTyped(evt);
            }
        });

        txtEditar4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar4KeyTyped(evt);
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

        txtEditar6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditar6KeyTyped(evt);
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
        txtEditarCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditarCodKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout painelProdutosLayout = new javax.swing.GroupLayout(painelProdutos);
        painelProdutos.setLayout(painelProdutosLayout);
        painelProdutosLayout.setHorizontalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProdutosLayout.createSequentialGroup()
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelProdutosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelProdutosLayout.createSequentialGroup()
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelProdutosLayout.createSequentialGroup()
                                .addComponent(pesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnDeletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelProdutosLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addGap(35, 35, 35))
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProdutosLayout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        painelProdutosLayout.setVerticalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProdutosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelProdutosLayout.createSequentialGroup()
                        .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProdutosLayout.createSequentialGroup()
                        .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProdutosLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout painelBrancoLayout = new javax.swing.GroupLayout(painelBranco);
        painelBranco.setLayout(painelBrancoLayout);
        painelBrancoLayout.setHorizontalGroup(
            painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        painelBrancoLayout.setVerticalGroup(
            painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
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

    private void pesquisarProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarProdutosKeyReleased
        pesquisarProdutos();
    }//GEN-LAST:event_pesquisarProdutosKeyReleased

    private void btnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseClicked
        pesquisarProdutos();
    }//GEN-LAST:event_btnAtualizarMouseClicked

    private void deletarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarProdutosActionPerformed
        deletarProdutos();
    }//GEN-LAST:event_deletarProdutosActionPerformed

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void tabelaProdutosBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosBrutoMouseClicked
        setarCamposProdutos();
    }//GEN-LAST:event_tabelaProdutosBrutoMouseClicked

    private void btnDeletarProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarProdutosMouseClicked
        deletarProdutos();
    }//GEN-LAST:event_btnDeletarProdutosMouseClicked

    private void txtEditar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar1KeyReleased

    private void txtEditar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar2KeyReleased

    private void txtEditar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar3KeyReleased

    private void txtEditar4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar4KeyReleased

    private void txtEditar5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar5KeyReleased

    private void txtEditar6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditar6KeyReleased

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        alterarProdutos();
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void txtEditarCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditarCodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditarCodKeyReleased

    private void txtEditar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar1KeyTyped
        if (txtEditar1.getText().length() >= 25) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar1KeyTyped

    private void txtEditar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar2KeyTyped
        if (txtEditar2.getText().length() >= 20) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar2KeyTyped

    private void txtEditar3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar3KeyTyped
        if (txtEditar3.getText().length() >= 8) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar3KeyTyped

    private void txtEditar4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar4KeyTyped
        if (txtEditar4.getText().length() >= 80) {

            evt.consume();
        }
    }//GEN-LAST:event_txtEditar4KeyTyped

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
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrosBrutosProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnAtualizar;
    public javax.swing.JLabel btnDeletarProdutos;
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btnRelatorio;
    public javax.swing.JLabel btnSalvar;
    private javax.swing.JTextField deletarProdutos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel painelAzul;
    private javax.swing.JPanel painelBranco;
    public javax.swing.JPanel painelProdutos;
    public javax.swing.JTextField pesquisarProdutos;
    public javax.swing.JTable tabelaProdutosBruto;
    public javax.swing.JTextField txtEditar1;
    public javax.swing.JTextField txtEditar2;
    public javax.swing.JTextField txtEditar3;
    public javax.swing.JTextField txtEditar4;
    public javax.swing.JTextField txtEditar5;
    public javax.swing.JTextField txtEditar6;
    public javax.swing.JTextField txtEditarCod;
    // End of variables declaration//GEN-END:variables
}
