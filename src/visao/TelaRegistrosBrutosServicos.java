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
        pesquisarServicosSem();
        
        txtEditar1.setDocument(new Letras());
        txtEditar2.setDocument(new Letras());
        txtEditar4.setDocument(new Numeros());
        
        tabelaServicosBruto.getTableHeader().setOpaque(false);
        tabelaServicosBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaServicosBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaServicosBruto.setRowHeight(25);
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    private void alterarServicos(){
    
        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;
        
        String sql = "update Servicos set Nome=?, Tipo=?, Descricao=?, Valor=? where Id=?";
    
        try {
            
            comandoSQL = conexao.criarPreparedStatement(sql);
            
            
            comandoSQL.setString(1, txtEditar1.getText());
            comandoSQL.setString(2, txtEditar2.getText());
            comandoSQL.setString(3, txtEditar3.getText());
            comandoSQL.setString(4, txtEditar4.getText());
            comandoSQL.setString(5, txtEditarCod.getText());
            
            
            
            if (txtEditar1.getText().isEmpty() || txtEditar2.getText().isEmpty() || txtEditar3.getText().isEmpty() || txtEditar4.getText().isEmpty()){
            
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
                    txtEditarCod.setText(null); 
                    
                    pesquisarServicosSem();
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
    
    public void pesquisarServicosSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Nome, Tipo, Descricao, Valor from Servicos;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaServicosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    protected void deletarServicos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Servicos where Nome=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deletarServicos.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deletarServicos.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisarServicosSem();
                    txtEditar1.setText(null);
                    txtEditar2.setText(null);
                    txtEditar3.setText(null);
                    txtEditar4.setText(null);
                    txtEditarCod.setText(null); 
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    public void pesquisarServicos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, Nome, Tipo, Descricao, Valor from Servicos where Nome like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarServicos.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaServicosBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void setarCamposServicos() {

        int setar = tabelaServicosBruto.getSelectedRow();
        
        txtEditarCod.setText(tabelaServicosBruto.getModel().getValueAt(setar, 0).toString());
        txtEditar1.setText(tabelaServicosBruto.getModel().getValueAt(setar, 1).toString());
        txtEditar2.setText(tabelaServicosBruto.getModel().getValueAt(setar, 2).toString());
        txtEditar3.setText(tabelaServicosBruto.getModel().getValueAt(setar, 3).toString());
        txtEditar4.setText(tabelaServicosBruto.getModel().getValueAt(setar, 4).toString());
            
        deletarServicos.setText(tabelaServicosBruto.getModel().getValueAt(setar, 1).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelAzul = new javax.swing.JPanel();
        painelBranco = new javax.swing.JPanel();
        painelServicos = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaServicosBruto = new javax.swing.JTable();
        pesquisarServicos = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JLabel();
        deletarServicos = new javax.swing.JTextField();
        btnDeletarServicos = new javax.swing.JLabel();
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

        painelServicos.setBackground(new java.awt.Color(255, 255, 255));
        painelServicos.setForeground(new java.awt.Color(102, 102, 102));
        painelServicos.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaServicosBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaServicosBruto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaServicosBruto.setFocusable(false);
        tabelaServicosBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaServicosBruto.setRowHeight(25);
        tabelaServicosBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaServicosBruto.setShowVerticalLines(false);
        tabelaServicosBruto.getTableHeader().setReorderingAllowed(false);
        tabelaServicosBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaServicosBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaServicosBruto);

        pesquisarServicos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarServicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarServicosKeyReleased(evt);
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

        deletarServicos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarServicos.setToolTipText("");
        deletarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarServicosActionPerformed(evt);
            }
        });

        btnDeletarServicos.setBackground(new java.awt.Color(23, 35, 51));
        btnDeletarServicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeletarServicos.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletarServicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeletarServicos.setText("Deletar");
        btnDeletarServicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletarServicos.setOpaque(true);
        btnDeletarServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletarServicosMouseClicked(evt);
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

        txtEditar5.setEditable(false);
        txtEditar5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar5KeyReleased(evt);
            }
        });

        txtEditar6.setEditable(false);
        txtEditar6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEditar6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditar6KeyReleased(evt);
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

        javax.swing.GroupLayout painelServicosLayout = new javax.swing.GroupLayout(painelServicos);
        painelServicos.setLayout(painelServicosLayout);
        painelServicosLayout.setHorizontalGroup(
            painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicosLayout.createSequentialGroup()
                .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelServicosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelServicosLayout.createSequentialGroup()
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelServicosLayout.createSequentialGroup()
                                .addComponent(pesquisarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deletarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnDeletarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelServicosLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addGap(35, 35, 35))
            .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicosLayout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        painelServicosLayout.setVerticalGroup(
            painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditarCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelServicosLayout.createSequentialGroup()
                        .addComponent(txtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelServicosLayout.createSequentialGroup()
                        .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
            .addGroup(painelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicosLayout.createSequentialGroup()
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
                .addComponent(painelServicos, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        painelBrancoLayout.setVerticalGroup(
            painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(painelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelServicos, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
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

    private void pesquisarServicosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarServicosKeyReleased
        pesquisarServicos();
    }//GEN-LAST:event_pesquisarServicosKeyReleased

    private void btnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseClicked
        pesquisarServicos();
    }//GEN-LAST:event_btnAtualizarMouseClicked

    private void deletarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarServicosActionPerformed
        deletarServicos();
    }//GEN-LAST:event_deletarServicosActionPerformed

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void tabelaServicosBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaServicosBrutoMouseClicked
        setarCamposServicos();
    }//GEN-LAST:event_tabelaServicosBrutoMouseClicked

    private void btnDeletarServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarServicosMouseClicked
        deletarServicos();
    }//GEN-LAST:event_btnDeletarServicosMouseClicked

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
        alterarServicos();
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void txtEditarCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditarCodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditarCodKeyReleased

    private void txtEditar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar1KeyTyped
        
        if (txtEditar1.getText().length() >= 20) {
            evt.consume();
        }
                
    }//GEN-LAST:event_txtEditar1KeyTyped

    private void txtEditar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar2KeyTyped
        
        if (txtEditar2.getText().length() >= 20) {
            evt.consume();
        }
                
    }//GEN-LAST:event_txtEditar2KeyTyped

    private void txtEditar3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar3KeyTyped
        
        if (txtEditar3.getText().length() >= 80) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtEditar3KeyTyped

    private void txtEditar4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditar4KeyTyped
        
        if (txtEditar4.getText().length() >= 10) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtEditar4KeyTyped

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
    public javax.swing.JLabel btnAtualizar;
    public javax.swing.JLabel btnDeletarServicos;
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btnRelatorio;
    public javax.swing.JLabel btnSalvar;
    private javax.swing.JTextField deletarServicos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel painelAzul;
    private javax.swing.JPanel painelBranco;
    public javax.swing.JPanel painelServicos;
    public javax.swing.JTextField pesquisarServicos;
    public javax.swing.JTable tabelaServicosBruto;
    public javax.swing.JTextField txtEditar1;
    public javax.swing.JTextField txtEditar2;
    public javax.swing.JTextField txtEditar3;
    public javax.swing.JTextField txtEditar4;
    public javax.swing.JTextField txtEditar5;
    public javax.swing.JTextField txtEditar6;
    public javax.swing.JTextField txtEditarCod;
    // End of variables declaration//GEN-END:variables
}
