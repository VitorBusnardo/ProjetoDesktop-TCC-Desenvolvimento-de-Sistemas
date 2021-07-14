package view;

import conexao.ConexaoSQLite;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaRegistrosBrutosEmployees extends javax.swing.JFrame {
    
    public TelaRegistrosBrutosEmployees() {
        initComponents();

        setIcon();
        pesquisar_Employees_Sem();
        
        tabelaEmployeesBruto.getTableHeader().setOpaque(false);
        tabelaEmployeesBruto.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaEmployeesBruto.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaEmployeesBruto.setRowHeight(25);
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }
    
    public void pesquisar_Employees_Sem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, FullName, Age, Telephone, Address, Email, Cpf, BirthDate, Salary, OccupationArea, Sex from Employees;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaEmployeesBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void pesquisar_Employees() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Id, FullName, Age, Telephone, Address, Email, Cpf, BirthDate, Salary, OccupationArea, Sex from Employees where FullName like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarEmployees.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaEmployeesBruto.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    protected void Deletar_Employees() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Employees where FullName=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deleteEmployees.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deleteEmployees.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisar_Employees_Sem();
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }
    
    private void setar_camposEmployees() {

            int setar = tabelaEmployeesBruto.getSelectedRow();
            deleteEmployees.setText(tabelaEmployeesBruto.getModel().getValueAt(setar, 1).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelBlue = new javax.swing.JPanel();
        painelWhithe = new javax.swing.JPanel();
        painelEmployees = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaEmployeesBruto = new javax.swing.JTable();
        pesquisarEmployees = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JLabel();
        deleteEmployees = new javax.swing.JTextField();
        btn_DeletarEmployees = new javax.swing.JLabel();
        btn_Change = new javax.swing.JLabel();
        btn_Editions = new javax.swing.JLabel();
        txt_Editar1 = new javax.swing.JTextField();
        txt_Editar2 = new javax.swing.JTextField();
        txt_Editar4 = new javax.swing.JTextField();
        txt_Editar3 = new javax.swing.JTextField();
        txt_Editar5 = new javax.swing.JTextField();
        txt_Editar6 = new javax.swing.JTextField();
        txt_Editar7 = new javax.swing.JTextField();
        txt_Editar8 = new javax.swing.JTextField();
        txt_Editar9 = new javax.swing.JTextField();
        txt_Editar10 = new javax.swing.JTextField();
        txtSex = new javax.swing.JComboBox<>();
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

        painelEmployees.setBackground(new java.awt.Color(255, 255, 255));
        painelEmployees.setForeground(new java.awt.Color(102, 102, 102));
        painelEmployees.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaEmployeesBruto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaEmployeesBruto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaEmployeesBruto.setFocusable(false);
        tabelaEmployeesBruto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaEmployeesBruto.setRowHeight(25);
        tabelaEmployeesBruto.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaEmployeesBruto.setShowVerticalLines(false);
        tabelaEmployeesBruto.getTableHeader().setReorderingAllowed(false);
        tabelaEmployeesBruto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEmployeesBrutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaEmployeesBruto);

        pesquisarEmployees.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarEmployees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarEmployeesKeyReleased(evt);
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

        deleteEmployees.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteEmployees.setToolTipText("");
        deleteEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeesActionPerformed(evt);
            }
        });

        btn_DeletarEmployees.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeletarEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeletarEmployees.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeletarEmployees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeletarEmployees.setText("Delete");
        btn_DeletarEmployees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeletarEmployees.setOpaque(true);
        btn_DeletarEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeletarEmployeesMouseClicked(evt);
            }
        });

        btn_Change.setBackground(new java.awt.Color(23, 35, 51));
        btn_Change.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Change.setForeground(new java.awt.Color(255, 255, 255));
        btn_Change.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Change.setText("Change");
        btn_Change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Change.setOpaque(true);
        btn_Change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ChangeMouseClicked(evt);
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

        txt_Editar1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar1KeyReleased(evt);
            }
        });

        txt_Editar2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Editar2ActionPerformed(evt);
            }
        });
        txt_Editar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar2KeyReleased(evt);
            }
        });

        txt_Editar4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar4KeyReleased(evt);
            }
        });

        txt_Editar3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar3KeyReleased(evt);
            }
        });

        txt_Editar5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar5KeyReleased(evt);
            }
        });

        txt_Editar6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar6KeyReleased(evt);
            }
        });

        txt_Editar7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar7KeyReleased(evt);
            }
        });

        txt_Editar8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar8KeyReleased(evt);
            }
        });

        txt_Editar9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar9KeyReleased(evt);
            }
        });

        txt_Editar10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Editar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Editar10ActionPerformed(evt);
            }
        });
        txt_Editar10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Editar10KeyReleased(evt);
            }
        });

        txtSex.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "             ", "Female", "Male" }));

        javax.swing.GroupLayout painelEmployeesLayout = new javax.swing.GroupLayout(painelEmployees);
        painelEmployees.setLayout(painelEmployeesLayout);
        painelEmployeesLayout.setHorizontalGroup(
            painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEmployeesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEmployeesLayout.createSequentialGroup()
                        .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Change, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Editions, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Editar10, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEmployeesLayout.createSequentialGroup()
                        .addComponent(pesquisarEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DeletarEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(painelEmployeesLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelEmployeesLayout.createSequentialGroup()
                            .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Editar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(89, 89, 89)
                            .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Editar4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Editar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(89, 89, 89)
                            .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Editar6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Editar5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(painelEmployeesLayout.createSequentialGroup()
                            .addComponent(txt_Editar7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addComponent(txt_Editar8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addComponent(txt_Editar9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        painelEmployeesLayout.setVerticalGroup(
            painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEmployeesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Change, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Editions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Editar10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Editar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Editar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Editar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEmployeesLayout.createSequentialGroup()
                        .addComponent(txt_Editar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txt_Editar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEmployeesLayout.createSequentialGroup()
                        .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Editar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Editar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Editar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_DeletarEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisarEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelWhitheLayout = new javax.swing.GroupLayout(painelWhithe);
        painelWhithe.setLayout(painelWhitheLayout);
        painelWhitheLayout.setHorizontalGroup(
            painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        painelWhitheLayout.setVerticalGroup(
            painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(painelWhitheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
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

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void txt_Editar10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar10KeyReleased

    private void txt_Editar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Editar10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar10ActionPerformed

    private void txt_Editar9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar9KeyReleased

    private void txt_Editar8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar8KeyReleased

    private void txt_Editar7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar7KeyReleased

    private void txt_Editar6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar6KeyReleased

    private void txt_Editar5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar5KeyReleased

    private void txt_Editar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar3KeyReleased

    private void txt_Editar4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar4KeyReleased

    private void txt_Editar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar2KeyReleased

    private void txt_Editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Editar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar2ActionPerformed

    private void txt_Editar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Editar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Editar1KeyReleased

    private void btn_EditionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditionsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EditionsMouseClicked

    private void btn_ChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ChangeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ChangeMouseClicked

    private void btn_DeletarEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeletarEmployeesMouseClicked
        Deletar_Employees();
    }//GEN-LAST:event_btn_DeletarEmployeesMouseClicked

    private void deleteEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeesActionPerformed
        Deletar_Employees();
    }//GEN-LAST:event_deleteEmployeesActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
        pesquisar_Employees();
    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void pesquisarEmployeesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarEmployeesKeyReleased
        pesquisar_Employees();
    }//GEN-LAST:event_pesquisarEmployeesKeyReleased

    private void tabelaEmployeesBrutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmployeesBrutoMouseClicked
        setar_camposEmployees();
    }//GEN-LAST:event_tabelaEmployeesBrutoMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrosBrutosEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrosBrutosEmployees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFechar;
    public javax.swing.JLabel btn_Change;
    public javax.swing.JLabel btn_DeletarEmployees;
    public javax.swing.JLabel btn_Editions;
    public javax.swing.JLabel btn_Refresh;
    private javax.swing.JTextField deleteEmployees;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel painelBlue;
    public javax.swing.JPanel painelEmployees;
    private javax.swing.JPanel painelWhithe;
    public javax.swing.JTextField pesquisarEmployees;
    public javax.swing.JTable tabelaEmployeesBruto;
    private javax.swing.JComboBox<String> txtSex;
    public javax.swing.JTextField txt_Editar1;
    public javax.swing.JTextField txt_Editar10;
    public javax.swing.JTextField txt_Editar2;
    public javax.swing.JTextField txt_Editar3;
    public javax.swing.JTextField txt_Editar4;
    public javax.swing.JTextField txt_Editar5;
    public javax.swing.JTextField txt_Editar6;
    public javax.swing.JTextField txt_Editar7;
    public javax.swing.JTextField txt_Editar8;
    public javax.swing.JTextField txt_Editar9;
    // End of variables declaration//GEN-END:variables
}
