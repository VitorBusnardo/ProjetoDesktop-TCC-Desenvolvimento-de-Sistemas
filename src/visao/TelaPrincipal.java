package visao;

import conexao.ConexaoMysql;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {

        initComponents();
        
        buscarNome();
        buscarTelefone();
        buscarEmail();
        buscarSobrenome();
        buscarUsuario();

        setIcon();

        setColor(btnHome);
        indHome.setOpaque(true);
        MenuConfiguracao.setVisible(false);
        MenuConfiguracao.setEnabled(false);

        MenuUsuario.setVisible(false);
        MenuUsuario.setEnabled(false);

        MenuCalendario.setVisible(false);
        MenuCalendario.setEnabled(false);

        MenuSegurança.setVisible(false);
        MenuSegurança.setEnabled(false);

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        DataCalendario.setText(formatador.format(data));

        Timer time = new Timer(1000, new hora());
        time.start();

    }

    private void buscarNome() {

        ConexaoMysql conexao = new ConexaoMysql();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select nome from Usuario;";

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                txtNome.setText(resultSQL.getString("nome"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    private void buscarTelefone() {

        ConexaoMysql conexao = new ConexaoMysql();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select Telefone from Usuario;";

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                txtTelefoneUsuario.setText(resultSQL.getString("Telefone"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    private void buscarEmail() {

        ConexaoMysql conexao = new ConexaoMysql();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select Email from Usuario;";

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                txtEmailUsuario.setText(resultSQL.getString("Email"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    private void buscarSobrenome() {

        ConexaoMysql conexao = new ConexaoMysql();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select sobrenome from Usuario;";

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                txtSobrenomeUsuario.setText(resultSQL.getString("sobrenome"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }
    
        private void buscarUsuario() {

        ConexaoMysql conexao = new ConexaoMysql();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select nomeUsuario from Usuario;";

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                txtNomeDeUsuario.setText(resultSQL.getString("nomeUsuario"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        btnHome = new javax.swing.JPanel();
        indHome = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnProdutosP = new javax.swing.JPanel();
        indProdutos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnClientesP = new javax.swing.JPanel();
        indClientes = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnFuncionariosP = new javax.swing.JPanel();
        indFuncionarios = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnServicosP = new javax.swing.JPanel();
        indServicos = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnVendasP = new javax.swing.JPanel();
        indVendas = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnGastoP = new javax.swing.JPanel();
        indGastos = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        menuSecundario = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        menuTerciario = new javax.swing.JPanel();
        subMenuTerciario = new javax.swing.JPanel();
        subMenuTerciario2 = new javax.swing.JPanel();
        btnUsuario = new javax.swing.JLabel();
        btnCalendario = new javax.swing.JLabel();
        btnSeguranca = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnConfigurações = new javax.swing.JLabel();
        btnSair = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        MenuSegurança = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JLabel();
        MenuCalendario = new javax.swing.JPanel();
        horaCalendario = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        DataCalendario = new javax.swing.JLabel();
        MenuUsuario = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtSobrenomeUsuario = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtNomeDeUsuario = new javax.swing.JLabel();
        txtTelefoneUsuario = new javax.swing.JLabel();
        txtEmailUsuario = new javax.swing.JLabel();
        MenuConfiguracao = new javax.swing.JPanel();
        btnMenuExit = new javax.swing.JLabel();
        btnMenuTroca = new javax.swing.JLabel();
        btnMenuResetar = new javax.swing.JLabel();
        btnRegistros = new javax.swing.JLabel();
        menuApresentacao = new javax.swing.JPanel();
        painelWebSite = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        painelSuport = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        painelLinkedIn = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        painelGitHub = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Intermedix");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(23, 35, 51));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setBackground(new java.awt.Color(23, 35, 51));
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
        });

        indHome.setOpaque(false);
        indHome.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indHomeLayout = new javax.swing.GroupLayout(indHome);
        indHome.setLayout(indHomeLayout);
        indHomeLayout.setHorizontalGroup(
            indHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indHomeLayout.setVerticalGroup(
            indHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home");

        javax.swing.GroupLayout btnHomeLayout = new javax.swing.GroupLayout(btnHome);
        btnHome.setLayout(btnHomeLayout);
        btnHomeLayout.setHorizontalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addComponent(indHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(0, 69, Short.MAX_VALUE))
        );
        btnHomeLayout.setVerticalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addComponent(indHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 140, -1));

        btnProdutosP.setBackground(new java.awt.Color(23, 35, 51));
        btnProdutosP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProdutosP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnProdutosPMouseReleased(evt);
            }
        });

        indProdutos.setOpaque(false);
        indProdutos.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indProdutosLayout = new javax.swing.GroupLayout(indProdutos);
        indProdutos.setLayout(indProdutosLayout);
        indProdutosLayout.setHorizontalGroup(
            indProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indProdutosLayout.setVerticalGroup(
            indProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Produtos");

        javax.swing.GroupLayout btnProdutosPLayout = new javax.swing.GroupLayout(btnProdutosP);
        btnProdutosP.setLayout(btnProdutosPLayout);
        btnProdutosPLayout.setHorizontalGroup(
            btnProdutosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProdutosPLayout.createSequentialGroup()
                .addComponent(indProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(0, 54, Short.MAX_VALUE))
        );
        btnProdutosPLayout.setVerticalGroup(
            btnProdutosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProdutosPLayout.createSequentialGroup()
                .addComponent(indProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnProdutosPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.add(btnProdutosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 140, -1));

        btnClientesP.setBackground(new java.awt.Color(23, 35, 51));
        btnClientesP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientesP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesPMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnClientesPMouseReleased(evt);
            }
        });

        indClientes.setOpaque(false);
        indClientes.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indClientesLayout = new javax.swing.GroupLayout(indClientes);
        indClientes.setLayout(indClientesLayout);
        indClientesLayout.setHorizontalGroup(
            indClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indClientesLayout.setVerticalGroup(
            indClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Clientes");

        javax.swing.GroupLayout btnClientesPLayout = new javax.swing.GroupLayout(btnClientesP);
        btnClientesP.setLayout(btnClientesPLayout);
        btnClientesPLayout.setHorizontalGroup(
            btnClientesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClientesPLayout.createSequentialGroup()
                .addComponent(indClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel13)
                .addGap(0, 60, Short.MAX_VALUE))
        );
        btnClientesPLayout.setVerticalGroup(
            btnClientesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClientesPLayout.createSequentialGroup()
                .addComponent(indClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnClientesPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.add(btnClientesP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 140, -1));

        btnFuncionariosP.setBackground(new java.awt.Color(23, 35, 51));
        btnFuncionariosP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionariosP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFuncionariosPMouseReleased(evt);
            }
        });

        indFuncionarios.setOpaque(false);
        indFuncionarios.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indFuncionariosLayout = new javax.swing.GroupLayout(indFuncionarios);
        indFuncionarios.setLayout(indFuncionariosLayout);
        indFuncionariosLayout.setHorizontalGroup(
            indFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indFuncionariosLayout.setVerticalGroup(
            indFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Funcionários");

        javax.swing.GroupLayout btnFuncionariosPLayout = new javax.swing.GroupLayout(btnFuncionariosP);
        btnFuncionariosP.setLayout(btnFuncionariosPLayout);
        btnFuncionariosPLayout.setHorizontalGroup(
            btnFuncionariosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFuncionariosPLayout.createSequentialGroup()
                .addComponent(indFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel18)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        btnFuncionariosPLayout.setVerticalGroup(
            btnFuncionariosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFuncionariosPLayout.createSequentialGroup()
                .addComponent(indFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnFuncionariosPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.add(btnFuncionariosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 140, -1));

        btnServicosP.setBackground(new java.awt.Color(23, 35, 51));
        btnServicosP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicosP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnServicosPMouseReleased(evt);
            }
        });

        indServicos.setOpaque(false);
        indServicos.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indServicosLayout = new javax.swing.GroupLayout(indServicos);
        indServicos.setLayout(indServicosLayout);
        indServicosLayout.setHorizontalGroup(
            indServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indServicosLayout.setVerticalGroup(
            indServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Serviços");

        javax.swing.GroupLayout btnServicosPLayout = new javax.swing.GroupLayout(btnServicosP);
        btnServicosP.setLayout(btnServicosPLayout);
        btnServicosPLayout.setHorizontalGroup(
            btnServicosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnServicosPLayout.createSequentialGroup()
                .addComponent(indServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel19)
                .addGap(0, 59, Short.MAX_VALUE))
        );
        btnServicosPLayout.setVerticalGroup(
            btnServicosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnServicosPLayout.createSequentialGroup()
                .addComponent(indServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnServicosPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.add(btnServicosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, -1));

        btnVendasP.setBackground(new java.awt.Color(23, 35, 51));
        btnVendasP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendasP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVendasPMouseReleased(evt);
            }
        });

        indVendas.setOpaque(false);
        indVendas.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indVendasLayout = new javax.swing.GroupLayout(indVendas);
        indVendas.setLayout(indVendasLayout);
        indVendasLayout.setHorizontalGroup(
            indVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indVendasLayout.setVerticalGroup(
            indVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Vendas");

        javax.swing.GroupLayout btnVendasPLayout = new javax.swing.GroupLayout(btnVendasP);
        btnVendasP.setLayout(btnVendasPLayout);
        btnVendasPLayout.setHorizontalGroup(
            btnVendasPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVendasPLayout.createSequentialGroup()
                .addComponent(indVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel21)
                .addGap(0, 64, Short.MAX_VALUE))
        );
        btnVendasPLayout.setVerticalGroup(
            btnVendasPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVendasPLayout.createSequentialGroup()
                .addComponent(indVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnVendasPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.add(btnVendasP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 140, 40));

        btnGastoP.setBackground(new java.awt.Color(23, 35, 51));
        btnGastoP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGastoP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGastoPMouseReleased(evt);
            }
        });

        indGastos.setOpaque(false);
        indGastos.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout indGastosLayout = new javax.swing.GroupLayout(indGastos);
        indGastos.setLayout(indGastosLayout);
        indGastosLayout.setHorizontalGroup(
            indGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        indGastosLayout.setVerticalGroup(
            indGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Gastos");

        javax.swing.GroupLayout btnGastoPLayout = new javax.swing.GroupLayout(btnGastoP);
        btnGastoP.setLayout(btnGastoPLayout);
        btnGastoPLayout.setHorizontalGroup(
            btnGastoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGastoPLayout.createSequentialGroup()
                .addComponent(indGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel22)
                .addGap(0, 67, Short.MAX_VALUE))
        );
        btnGastoPLayout.setVerticalGroup(
            btnGastoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGastoPLayout.createSequentialGroup()
                .addComponent(indGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnGastoPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.add(btnGastoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 140, -1));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 590));

        menuSecundario.setBackground(new java.awt.Color(71, 120, 197));
        menuSecundario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuSecundarioMouseDragged(evt);
            }
        });
        menuSecundario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuSecundarioMousePressed(evt);
            }
        });

        txtPesquisa.setBackground(new java.awt.Color(123, 156, 225));
        txtPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        txtPesquisa.setBorder(null);
        txtPesquisa.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPesquisa.setPreferredSize(new java.awt.Dimension(2, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconSearch.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout menuSecundarioLayout = new javax.swing.GroupLayout(menuSecundario);
        menuSecundario.setLayout(menuSecundarioLayout);
        menuSecundarioLayout.setHorizontalGroup(
            menuSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuSecundarioLayout.createSequentialGroup()
                .addContainerGap(737, Short.MAX_VALUE)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(34, 34, 34))
        );
        menuSecundarioLayout.setVerticalGroup(
            menuSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuSecundarioLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(menuSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(menuSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 940, 50));

        menuTerciario.setBackground(new java.awt.Color(192, 192, 192));
        menuTerciario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subMenuTerciario.setBackground(new java.awt.Color(23, 35, 51));
        subMenuTerciario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subMenuTerciario2.setBackground(new java.awt.Color(71, 120, 197));

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconUser.png"))); // NOI18N
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUsuarioMousePressed(evt);
            }
        });

        btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconCalendar.png"))); // NOI18N
        btnCalendario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCalendarioMousePressed(evt);
            }
        });

        btnSeguranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconLock.png"))); // NOI18N
        btnSeguranca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeguranca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSegurancaMousePressed(evt);
            }
        });

        btnConfigurações.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconSettings.png"))); // NOI18N
        btnConfigurações.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfigurações.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfiguraçõesMousePressed(evt);
            }
        });

        javax.swing.GroupLayout subMenuTerciario2Layout = new javax.swing.GroupLayout(subMenuTerciario2);
        subMenuTerciario2.setLayout(subMenuTerciario2Layout);
        subMenuTerciario2Layout.setHorizontalGroup(
            subMenuTerciario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuTerciario2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnConfigurações)
                .addGap(45, 45, 45)
                .addComponent(btnUsuario)
                .addGap(44, 44, 44)
                .addComponent(btnCalendario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnSeguranca)
                .addGap(39, 39, 39))
            .addGroup(subMenuTerciario2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subMenuTerciario2Layout.setVerticalGroup(
            subMenuTerciario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuTerciario2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(subMenuTerciario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeguranca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfigurações, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        subMenuTerciario.add(subMenuTerciario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 310, 130));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconExit.png"))); // NOI18N
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSairMousePressed(evt);
            }
        });
        subMenuTerciario.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 46));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconPlanetSmall.png"))); // NOI18N
        jLabel2.setText("  ");
        subMenuTerciario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeUsuario.setText("User");
        subMenuTerciario.add(lblNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        menuTerciario.add(subMenuTerciario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MenuSegurança.setBackground(new java.awt.Color(255, 255, 255));
        MenuSegurança.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSegurançaMousePressed(evt);
            }
        });
        MenuSegurança.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconPadLock.png"))); // NOI18N
        MenuSegurança.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 70, 50));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Segurança");
        MenuSegurança.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 50));

        btnVerificar.setBackground(new java.awt.Color(23, 35, 51));
        btnVerificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVerificar.setForeground(new java.awt.Color(255, 255, 255));
        btnVerificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVerificar.setText("Verificar");
        btnVerificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerificar.setOpaque(true);
        btnVerificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerificarMouseClicked(evt);
            }
        });
        MenuSegurança.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 160, 40));

        menuTerciario.add(MenuSegurança, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 345, 270, 173));

        MenuCalendario.setBackground(new java.awt.Color(255, 255, 255));
        MenuCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuCalendarioMousePressed(evt);
            }
        });
        MenuCalendario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horaCalendario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        horaCalendario.setText("Hora");
        MenuCalendario.add(horaCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Data e Hora Atuais");
        MenuCalendario.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        DataCalendario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DataCalendario.setText("Data");
        MenuCalendario.add(DataCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        menuTerciario.add(MenuCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 345, 270, 173));

        MenuUsuario.setBackground(new java.awt.Color(255, 255, 255));
        MenuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuUsuarioMousePressed(evt);
            }
        });
        MenuUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Informações do Usuário");
        MenuUsuario.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtSobrenomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSobrenomeUsuario.setText("Sobrenome");
        MenuUsuario.add(txtSobrenomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNome.setText("NomeCompleto");
        MenuUsuario.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtNomeDeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNomeDeUsuario.setText("NomeDeUsuario");
        MenuUsuario.add(txtNomeDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtTelefoneUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTelefoneUsuario.setText("Telefone");
        MenuUsuario.add(txtTelefoneUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtEmailUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmailUsuario.setText("Email");
        MenuUsuario.add(txtEmailUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        menuTerciario.add(MenuUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 345, 270, 173));

        MenuConfiguracao.setBackground(new java.awt.Color(255, 255, 255));

        btnMenuExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconLogout.png"))); // NOI18N
        btnMenuExit.setText(" Saída");
        btnMenuExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMenuExitMousePressed(evt);
            }
        });

        btnMenuTroca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMenuTroca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconPeople.png"))); // NOI18N
        btnMenuTroca.setText(" Trocar Usuários");
        btnMenuTroca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuTroca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMenuTrocaMousePressed(evt);
            }
        });

        btnMenuResetar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMenuResetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconStreamline.png"))); // NOI18N
        btnMenuResetar.setText(" Resetar Tudo");
        btnMenuResetar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuResetar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuResetarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuConfiguracaoLayout = new javax.swing.GroupLayout(MenuConfiguracao);
        MenuConfiguracao.setLayout(MenuConfiguracaoLayout);
        MenuConfiguracaoLayout.setHorizontalGroup(
            MenuConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuConfiguracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenuExit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuResetar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuTroca))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        MenuConfiguracaoLayout.setVerticalGroup(
            MenuConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuConfiguracaoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnMenuExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuTroca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuResetar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        menuTerciario.add(MenuConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 345, -1, -1));

        btnRegistros.setBackground(new java.awt.Color(23, 35, 51));
        btnRegistros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistros.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistros.setText("Registros");
        btnRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistros.setOpaque(true);
        btnRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrosMouseClicked(evt);
            }
        });
        menuTerciario.add(btnRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 160, 40));

        getContentPane().add(menuTerciario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 310, 540));

        menuApresentacao.setBackground(new java.awt.Color(255, 255, 255));
        menuApresentacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelWebSite.setBackground(new java.awt.Color(255, 255, 255));
        painelWebSite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelWebSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelWebSiteMousePressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconWebSite.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setText("Web Site");

        javax.swing.GroupLayout painelWebSiteLayout = new javax.swing.GroupLayout(painelWebSite);
        painelWebSite.setLayout(painelWebSiteLayout);
        painelWebSiteLayout.setHorizontalGroup(
            painelWebSiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelWebSiteLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(painelWebSiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        painelWebSiteLayout.setVerticalGroup(
            painelWebSiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelWebSiteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(44, 44, 44))
        );

        menuApresentacao.add(painelWebSite, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 173, 200));

        painelSuport.setBackground(new java.awt.Color(255, 255, 255));
        painelSuport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelSuport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelSuportMousePressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconSuport.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("  Suporte");

        javax.swing.GroupLayout painelSuportLayout = new javax.swing.GroupLayout(painelSuport);
        painelSuport.setLayout(painelSuportLayout);
        painelSuportLayout.setHorizontalGroup(
            painelSuportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuportLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(painelSuportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        painelSuportLayout.setVerticalGroup(
            painelSuportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(47, 47, 47))
        );

        menuApresentacao.add(painelSuport, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 160, 200));

        painelLinkedIn.setBackground(new java.awt.Color(255, 255, 255));
        painelLinkedIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelLinkedIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelLinkedInMousePressed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconLinkedIn.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel25.setText("       LinkedIn");

        javax.swing.GroupLayout painelLinkedInLayout = new javax.swing.GroupLayout(painelLinkedIn);
        painelLinkedIn.setLayout(painelLinkedInLayout);
        painelLinkedInLayout.setHorizontalGroup(
            painelLinkedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLinkedInLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(46, 46, 46))
            .addGroup(painelLinkedInLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        painelLinkedInLayout.setVerticalGroup(
            painelLinkedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLinkedInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(50, 50, 50))
        );

        menuApresentacao.add(painelLinkedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 160, 200));

        painelGitHub.setBackground(new java.awt.Color(255, 255, 255));
        painelGitHub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelGitHub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelGitHubMousePressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconGitHub.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setText("      GitHub");

        javax.swing.GroupLayout painelGitHubLayout = new javax.swing.GroupLayout(painelGitHub);
        painelGitHub.setLayout(painelGitHubLayout);
        painelGitHubLayout.setHorizontalGroup(
            painelGitHubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGitHubLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(painelGitHubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGitHubLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGitHubLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        painelGitHubLayout.setVerticalGroup(
            painelGitHubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGitHubLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(39, 39, 39))
        );

        menuApresentacao.add(painelGitHub, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 150, 190));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconMenu.jpg"))); // NOI18N
        menuApresentacao.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        getContentPane().add(menuApresentacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 630, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int xx, xy;

    TelaCadastroClientes customers = new TelaCadastroClientes();
    TelaCadastroProdutos products = new TelaCadastroProdutos();
    TelaCadastroFuncionarios employees = new TelaCadastroFuncionarios();
    TelaCadastroServicos services = new TelaCadastroServicos();
    TelaCadastroVendas sales = new TelaCadastroVendas();
    TelaCadastroGastos spending = new TelaCadastroGastos();


    private void btnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMousePressed

    }//GEN-LAST:event_btnHomeMousePressed

    private void btnProdutosPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutosPMouseReleased

        setColor(btnProdutosP);
        indProdutos.setOpaque(true);
        resetColor(new JPanel[]{btnClientesP, btnFuncionariosP, btnServicosP, btnVendasP, btnGastoP}, new JPanel[]{indClientes, indFuncionarios, indServicos, indGastos, indVendas});

        customers.setVisible(false);

        products.setVisible(true);

        employees.setVisible(false);

        services.setVisible(false);

        sales.setVisible(false);

        spending.setVisible(false);

    }//GEN-LAST:event_btnProdutosPMouseReleased

    private void menuSecundarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSecundarioMousePressed

        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_menuSecundarioMousePressed

    private void menuSecundarioMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSecundarioMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_menuSecundarioMouseDragged

    private void btnSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMousePressed

        System.exit(0);

    }//GEN-LAST:event_btnSairMousePressed

    private void btnClientesPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesPMouseReleased

        setColor(btnClientesP);
        indClientes.setOpaque(true);
        resetColor(new JPanel[]{btnProdutosP, btnFuncionariosP, btnServicosP, btnVendasP, btnGastoP}, new JPanel[]{indProdutos, indFuncionarios, indServicos, indGastos, indVendas});

        customers.setVisible(true);

        products.setVisible(false);

        employees.setVisible(false);

        services.setVisible(false);

        sales.setVisible(false);

        spending.setVisible(false);


    }//GEN-LAST:event_btnClientesPMouseReleased

    private void btnFuncionariosPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuncionariosPMouseReleased

        setColor(btnFuncionariosP);
        indFuncionarios.setOpaque(true);
        resetColor(new JPanel[]{btnProdutosP, btnClientesP, btnServicosP, btnVendasP, btnGastoP}, new JPanel[]{indProdutos, indClientes, indServicos, indGastos, indVendas});

        customers.setVisible(false);

        products.setVisible(false);

        employees.setVisible(true);

        services.setVisible(false);

        sales.setVisible(false);

        spending.setVisible(false);

    }//GEN-LAST:event_btnFuncionariosPMouseReleased

    private void btnServicosPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicosPMouseReleased

        setColor(btnServicosP);
        indServicos.setOpaque(true);
        resetColor(new JPanel[]{btnProdutosP, btnFuncionariosP, btnClientesP, btnVendasP, btnGastoP}, new JPanel[]{indProdutos, indFuncionarios, indClientes, indGastos, indVendas});

        customers.setVisible(false);

        products.setVisible(false);

        employees.setVisible(false);

        services.setVisible(true);

        sales.setVisible(false);

        spending.setVisible(false);

    }//GEN-LAST:event_btnServicosPMouseReleased

    private void btnVendasPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVendasPMouseReleased

        setColor(btnVendasP);
        indVendas.setOpaque(true);
        resetColor(new JPanel[]{btnProdutosP, btnClientesP, btnServicosP, btnFuncionariosP, btnGastoP}, new JPanel[]{indProdutos, indClientes, indServicos, indFuncionarios, indGastos});

        customers.setVisible(false);

        products.setVisible(false);

        employees.setVisible(false);

        services.setVisible(false);

        sales.setVisible(true);

        spending.setVisible(false);

    }//GEN-LAST:event_btnVendasPMouseReleased

    private void btnConfiguraçõesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguraçõesMousePressed

        MenuConfiguracao.setVisible(true);
        MenuConfiguracao.setEnabled(true);

        MenuUsuario.setVisible(false);
        MenuUsuario.setEnabled(false);

        MenuCalendario.setVisible(false);
        MenuCalendario.setEnabled(false);

        MenuSegurança.setVisible(false);
        MenuSegurança.setEnabled(false);

        horaCalendario.setVisible(false);


    }//GEN-LAST:event_btnConfiguraçõesMousePressed

    private void btnUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMousePressed

        MenuConfiguracao.setVisible(false);
        MenuConfiguracao.setEnabled(false);

        MenuUsuario.setVisible(true);
        MenuUsuario.setEnabled(true);

        MenuCalendario.setVisible(false);
        MenuCalendario.setEnabled(false);

        MenuSegurança.setVisible(false);
        MenuSegurança.setEnabled(false);

        horaCalendario.setVisible(false);

    }//GEN-LAST:event_btnUsuarioMousePressed

    private void btnCalendarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalendarioMousePressed

        MenuConfiguracao.setVisible(false);
        MenuConfiguracao.setEnabled(false);

        MenuUsuario.setVisible(false);
        MenuUsuario.setEnabled(false);

        MenuCalendario.setVisible(true);
        MenuCalendario.setEnabled(true);

        MenuSegurança.setVisible(false);
        MenuSegurança.setEnabled(false);

        horaCalendario.setVisible(true);

        Calendar dataa = Calendar.getInstance();
        int horas = dataa.get(Calendar.HOUR_OF_DAY);
        int minutos = dataa.get(Calendar.MINUTE);
        int segundos = dataa.get(Calendar.SECOND);

        horaCalendario.setText(horas + ":" + minutos + ":" + segundos);


    }//GEN-LAST:event_btnCalendarioMousePressed

    private void btnMenuExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuExitMousePressed

        System.exit(0);

    }//GEN-LAST:event_btnMenuExitMousePressed

    private void btnMenuTrocaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuTrocaMousePressed

        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnMenuTrocaMousePressed

    private void MenuUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsuarioMousePressed

    }//GEN-LAST:event_MenuUsuarioMousePressed

    private void MenuCalendarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCalendarioMousePressed

    }//GEN-LAST:event_MenuCalendarioMousePressed

    private void MenuSegurançaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSegurançaMousePressed

    }//GEN-LAST:event_MenuSegurançaMousePressed

    private void btnSegurancaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSegurancaMousePressed

        MenuConfiguracao.setVisible(false);
        MenuConfiguracao.setEnabled(false);

        MenuUsuario.setVisible(false);
        MenuUsuario.setEnabled(false);

        MenuSegurança.setVisible(true);
        MenuSegurança.setEnabled(true);

        horaCalendario.setVisible(false);

    }//GEN-LAST:event_btnSegurancaMousePressed

    private void painelWebSiteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelWebSiteMousePressed

        try {
            URI link = new URI("");
            Desktop.getDesktop().browse(link);
        } catch (Exception erro) {
            System.out.println(erro);
        }

    }//GEN-LAST:event_painelWebSiteMousePressed

    private void painelGitHubMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelGitHubMousePressed

        try {
            URI link = new URI("www.github.com/PauloHNDS");
            URI link2 = new URI("www.github.com/VitorBusnardo");
            Desktop.getDesktop().browse(link);
            Desktop.getDesktop().browse(link2);
        } catch (Exception erro) {
            System.out.println(erro);
        }

    }//GEN-LAST:event_painelGitHubMousePressed

    private void painelSuportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelSuportMousePressed

        try {
            URI link = new URI("www.youtube.com/?gl=BR");
            Desktop.getDesktop().browse(link);
        } catch (Exception erro) {
            System.out.println(erro);
        }

    }//GEN-LAST:event_painelSuportMousePressed

    private void painelLinkedInMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelLinkedInMousePressed

        try {
            URI link = new URI("");
            Desktop.getDesktop().browse(link);
        } catch (Exception erro) {
            System.out.println(erro);
        }

    }//GEN-LAST:event_painelLinkedInMousePressed

    private void btnClientesPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesPMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnClientesPMouseClicked

    private void btnMenuResetarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuResetarMouseClicked

        TelaDeletar delete = new TelaDeletar();
        delete.setVisible(true);

    }//GEN-LAST:event_btnMenuResetarMouseClicked

    private void btnGastoPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGastoPMouseReleased

        setColor(btnGastoP);
        indGastos.setOpaque(true);
        resetColor(new JPanel[]{btnProdutosP, btnClientesP, btnServicosP, btnFuncionariosP, btnVendasP}, new JPanel[]{indProdutos, indClientes, indServicos, indFuncionarios, indVendas});

        customers.setVisible(false);

        products.setVisible(false);

        employees.setVisible(false);

        services.setVisible(false);

        sales.setVisible(false);

        spending.setVisible(true);

    }//GEN-LAST:event_btnGastoPMouseReleased

    private void btnRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrosMouseClicked
        TelaPrincipal principal = new TelaPrincipal();
        TelaRegistros registros = new TelaRegistros();

        registros.lblNomeDeUsuarioRegistro.setText(lblNomeUsuario.getText());

        customers.setVisible(false);

        products.setVisible(false);

        employees.setVisible(false);

        services.setVisible(false);

        sales.setVisible(false);

        spending.setVisible(false);

        registros.setVisible(true);

        registros.criaGrafico();

        this.dispose();
    }//GEN-LAST:event_btnRegistrosMouseClicked

    private void btnVerificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerificarMouseClicked
        TelaProtecao protecao = new TelaProtecao();

        protecao.setVisible(true);
    }//GEN-LAST:event_btnVerificarMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    private void setColor(JPanel pane) {

        pane.setBackground(new Color(41, 57, 80));

    }

    private void resetColor(JPanel[] pane, JPanel[] indicators) {

        for (int i = 0; i < pane.length; i++) {

            pane[i].setBackground(new Color(23, 35, 51));

        }
        for (int i = 0; i < indicators.length; i++) {

            indicators[i].setOpaque(false);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataCalendario;
    private javax.swing.JPanel MenuCalendario;
    private javax.swing.JPanel MenuConfiguracao;
    private javax.swing.JPanel MenuSegurança;
    private javax.swing.JPanel MenuUsuario;
    private javax.swing.JLabel btnCalendario;
    private javax.swing.JPanel btnClientesP;
    private javax.swing.JLabel btnConfigurações;
    private javax.swing.JPanel btnFuncionariosP;
    private javax.swing.JPanel btnGastoP;
    private javax.swing.JPanel btnHome;
    private javax.swing.JLabel btnMenuExit;
    private javax.swing.JLabel btnMenuResetar;
    private javax.swing.JLabel btnMenuTroca;
    private javax.swing.JPanel btnProdutosP;
    public javax.swing.JLabel btnRegistros;
    private javax.swing.JLabel btnSair;
    private javax.swing.JLabel btnSeguranca;
    private javax.swing.JPanel btnServicosP;
    private javax.swing.JLabel btnUsuario;
    private javax.swing.JPanel btnVendasP;
    public javax.swing.JLabel btnVerificar;
    private javax.swing.JLabel horaCalendario;
    private javax.swing.JPanel indClientes;
    private javax.swing.JPanel indFuncionarios;
    private javax.swing.JPanel indGastos;
    private javax.swing.JPanel indHome;
    private javax.swing.JPanel indProdutos;
    private javax.swing.JPanel indServicos;
    private javax.swing.JPanel indVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuApresentacao;
    private javax.swing.JPanel menuSecundario;
    private javax.swing.JPanel menuTerciario;
    private javax.swing.JPanel painelGitHub;
    private javax.swing.JPanel painelLinkedIn;
    private javax.swing.JPanel painelSuport;
    private javax.swing.JPanel painelWebSite;
    private javax.swing.JPanel subMenuTerciario;
    private javax.swing.JPanel subMenuTerciario2;
    private javax.swing.JLabel txtEmailUsuario;
    private javax.swing.JLabel txtNome;
    public javax.swing.JLabel txtNomeDeUsuario;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JLabel txtSobrenomeUsuario;
    private javax.swing.JLabel txtTelefoneUsuario;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Calendar now = Calendar.getInstance();

            horaCalendario.setText(String.format("%1$tH:%1$tM:%1$tS", now));

        }

    }

}
