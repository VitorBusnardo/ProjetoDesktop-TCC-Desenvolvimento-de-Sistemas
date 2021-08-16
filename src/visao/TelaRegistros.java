package visao;

import conexao.ConexaoSQLite;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class TelaRegistros extends javax.swing.JFrame {

    public String nomeDeUsuario = null;
    protected float SalesValor;
    protected float SalesValorInicial;
    protected float SpendingValor;
    protected float SpendingValorInicial;

    protected void buscarVendasValor() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select Valor from Vendas;";

        float valorSales = 0;

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                valorSales = Float.parseFloat(resultSQL.getString("Valor"));
                SalesValorInicial = SalesValorInicial + valorSales;
            }
            System.out.println(SalesValorInicial);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    protected void buscarGastosValores() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();

        ResultSet resultSQL = null;

        PreparedStatement comandoSQL = null;

        String insertSQL = "select Valor from Gastos;";

        float valorSpending = 0;

        try {

            comandoSQL = conexao.criarPreparedStatement(insertSQL);
            resultSQL = comandoSQL.executeQuery();
            while (resultSQL.next()) {
                valorSpending = Float.parseFloat(resultSQL.getString("Valor"));
                SpendingValorInicial = SpendingValorInicial + valorSpending;
            }
            System.out.println(SpendingValorInicial);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    protected void deletarClientes() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "delete from Clientes where NomeCompleto=?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);

            comandoSQL.setString(1, deletarClientes.getText());

            int apagado = comandoSQL.executeUpdate();

            if (apagado > 0) {

                deletarClientes.setText(null);
                TelaSucessoDeletar sucesso = new TelaSucessoDeletar();
                sucesso.setVisible(true);
                pesquisarClientes();
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

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
                pesquisarProdutosSem();
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

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
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

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
            }

        } catch (Exception e) {

            TelaErroDeletar erro = new TelaErroDeletar();
            erro.setVisible(true);

        }
    }

    protected void pesquisarClientesSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select NomeCompleto, Telefone, Cpf, Sexo, Servico from Clientes where NomeCompleto like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarClientes.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaClientes.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarClientes() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select NomeCompleto, Telefone, Cpf, Sexo, Servicos from Clientes where NomeCompleto like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarClientes.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaClientes.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarFuncionariosSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select NomeCompleto, Telefone, Cpf, Salario, AreaOcupacao from Funcionarios;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaFuncionarios.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarFuncionarios() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select NomeCompleto, Telefone, Cpf, Salario, AreaOcupacao from Funcionarios where NomeCompleto like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarFuncionarios.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaFuncionarios.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarProdutosSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Nome, Marca, Estoque, Valor, Tipo from Produtos;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaProdutos.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarProdutos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Nome, Marca, Estoque, Valor, Tipo from Produtos where Nome like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarProdutos.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaProdutos.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarServicos() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Nome, Tipo, Descricao, Valor from Servicos where Nome like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, pesquisarServicos.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            tabelaServicos.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisarServicosSem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Nome, Tipo, Descricao, Valor from Servicos;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            tabelaServicos.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void setarCamposProdutos() {

        int setar = tabelaProdutos.getSelectedRow();
        deletarProdutos.setText(tabelaProdutos.getModel().getValueAt(setar, 0).toString());

    }

    private void setarCamposClientes() {

        int setar = tabelaClientes.getSelectedRow();
        deletarClientes.setText(tabelaClientes.getModel().getValueAt(setar, 0).toString());

    }

    private void setarCamposFuncionarios() {

        int setar = tabelaFuncionarios.getSelectedRow();
        deletarFuncionarios.setText(tabelaFuncionarios.getModel().getValueAt(setar, 0).toString());

    }

    private void setarCamposServicos() {

        int setar = tabelaServicos.getSelectedRow();
        deletarServicos.setText(tabelaServicos.getModel().getValueAt(setar, 0).toString());

    }

    public TelaRegistros() {

        setIcon();

        initComponents();

        this.buscarGastosValores();
        this.buscarVendasValor();

        setLblColor(btnGrafico);
        resetLblColor(btnProdutos);
        resetLblColor(btnClientes);
        resetLblColor(btnFuncionarios);
        resetLblColor(btnServicos);

        grafico.setVisible(true);
        produtos.setVisible(false);
        clientes.setVisible(false);
        funcionarios.setVisible(false);
        servicos.setVisible(false);

        tabelaProdutos.getTableHeader().setOpaque(false);
        tabelaProdutos.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaProdutos.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaProdutos.setRowHeight(25);

        tabelaClientes.getTableHeader().setOpaque(false);
        tabelaClientes.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaClientes.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaClientes.setRowHeight(25);

        tabelaFuncionarios.getTableHeader().setOpaque(false);
        tabelaFuncionarios.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaFuncionarios.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaFuncionarios.setRowHeight(25);

        tabelaServicos.getTableHeader().setOpaque(false);
        tabelaServicos.getTableHeader().setBackground(new Color(71, 120, 197));
        tabelaServicos.getTableHeader().setForeground(new Color(255, 255, 255));
        tabelaServicos.setRowHeight(25);
    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int lucro = (int) SalesValorInicial;

        int gastos = (int) SpendingValorInicial;

        int l = lucro - gastos;

        dataset.addValue(lucro, "Vendas", "Geral");

        dataset.addValue(gastos, "Gastos", "Geral");

        dataset.addValue(l, "Lucro Líquido", "Geral");

        return dataset;

    }

    public void criaGrafico() {

        CategoryDataset cds = createDataset();

        String titulo = "Gráfico Monetário";

        String eixoy = "Valores";

        String txt_legenda = "";

        boolean legenda = true;

        boolean tooltips = true;

        boolean urls = true;

        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);

        ChartPanel myChartPanel = new ChartPanel(graf, true);

        myChartPanel.setSize(painelGrafico.getWidth(), painelGrafico.getHeight());

        myChartPanel.setVisible(true);

        painelGrafico.removeAll();

        painelGrafico.add(myChartPanel);

        painelGrafico.revalidate();

        painelGrafico.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrincipal = new javax.swing.JPanel();
        menuCabecario = new javax.swing.JPanel();
        btnSair = new javax.swing.JLabel();
        btnGrafico = new javax.swing.JLabel();
        btnProdutos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnServicos = new javax.swing.JLabel();
        btnClientes = new javax.swing.JLabel();
        btnFuncionarios = new javax.swing.JLabel();
        lblNomeDeUsuarioRegistro = new javax.swing.JLabel();
        menuPaineis = new javax.swing.JPanel();
        grafico = new javax.swing.JPanel();
        painelGrafico = new javax.swing.JPanel();
        clientes = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        pesquisarClientes = new javax.swing.JTextField();
        btnDeletarClientes = new javax.swing.JLabel();
        deletarClientes = new javax.swing.JTextField();
        produtos = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        pesquisarProdutos = new javax.swing.JTextField();
        btnDeletarProdutos = new javax.swing.JLabel();
        deletarProdutos = new javax.swing.JTextField();
        servicos = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaServicos = new javax.swing.JTable();
        pesquisarServicos = new javax.swing.JTextField();
        btnDeletarServicos = new javax.swing.JLabel();
        deletarServicos = new javax.swing.JTextField();
        funcionarios = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        pesquisarFuncionarios = new javax.swing.JTextField();
        btnDeletarFuncionarios = new javax.swing.JLabel();
        deletarFuncionarios = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Intermedix");
        setLocationByPlatform(true);
        setUndecorated(true);

        menuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        menuPrincipal.setPreferredSize(new java.awt.Dimension(900, 565));

        menuCabecario.setBackground(new java.awt.Color(23, 35, 51));
        menuCabecario.setPreferredSize(new java.awt.Dimension(838, 200));
        menuCabecario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuCabecarioMouseDragged(evt);
            }
        });
        menuCabecario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuCabecarioMousePressed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(23, 35, 51));
        btnSair.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSair.setText("X");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.setOpaque(true);
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });

        btnGrafico.setBackground(new java.awt.Color(23, 35, 51));
        btnGrafico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGrafico.setForeground(new java.awt.Color(255, 255, 255));
        btnGrafico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGrafico.setText("Gráfico");
        btnGrafico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGrafico.setOpaque(true);
        btnGrafico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGraficoMouseClicked(evt);
            }
        });

        btnProdutos.setBackground(new java.awt.Color(23, 35, 51));
        btnProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnProdutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProdutos.setText("Produtos");
        btnProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProdutos.setOpaque(true);
        btnProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProdutosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProdutosMouseEntered(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconFloatingPlanet.png"))); // NOI18N

        btnServicos.setBackground(new java.awt.Color(23, 35, 51));
        btnServicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnServicos.setForeground(new java.awt.Color(255, 255, 255));
        btnServicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnServicos.setText("Serviços");
        btnServicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicos.setOpaque(true);
        btnServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServicosMouseClicked(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(23, 35, 51));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClientes.setText("Clientes");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setOpaque(true);
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
        });

        btnFuncionarios.setBackground(new java.awt.Color(23, 35, 51));
        btnFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        btnFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFuncionarios.setText("Funcionários");
        btnFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionarios.setOpaque(true);
        btnFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFuncionariosMouseClicked(evt);
            }
        });

        lblNomeDeUsuarioRegistro.setBackground(new java.awt.Color(23, 35, 51));
        lblNomeDeUsuarioRegistro.setForeground(new java.awt.Color(23, 35, 51));
        lblNomeDeUsuarioRegistro.setText("jLabel2");

        javax.swing.GroupLayout menuCabecarioLayout = new javax.swing.GroupLayout(menuCabecario);
        menuCabecario.setLayout(menuCabecarioLayout);
        menuCabecarioLayout.setHorizontalGroup(
            menuCabecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuCabecarioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addComponent(lblNomeDeUsuarioRegistro)
                .addGap(275, 275, 275)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuCabecarioLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 73, Short.MAX_VALUE))
        );
        menuCabecarioLayout.setVerticalGroup(
            menuCabecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuCabecarioLayout.createSequentialGroup()
                .addGroup(menuCabecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuCabecarioLayout.createSequentialGroup()
                        .addGroup(menuCabecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSair)
                            .addComponent(lblNomeDeUsuarioRegistro))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuCabecarioLayout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(menuCabecarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        menuPaineis.setLayout(new java.awt.CardLayout());

        grafico.setBackground(new java.awt.Color(255, 255, 255));
        grafico.setForeground(new java.awt.Color(204, 204, 204));
        grafico.setPreferredSize(new java.awt.Dimension(900, 565));

        painelGrafico.setBackground(new java.awt.Color(255, 255, 255));
        painelGrafico.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        painelGrafico.setPreferredSize(new java.awt.Dimension(785, 300));

        javax.swing.GroupLayout painelGraficoLayout = new javax.swing.GroupLayout(painelGrafico);
        painelGrafico.setLayout(painelGraficoLayout);
        painelGraficoLayout.setHorizontalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        painelGraficoLayout.setVerticalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout graficoLayout = new javax.swing.GroupLayout(grafico);
        grafico.setLayout(graficoLayout);
        graficoLayout.setHorizontalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graficoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(painelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        graficoLayout.setVerticalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graficoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuPaineis.add(grafico, "card3");

        clientes.setBackground(new java.awt.Color(255, 255, 255));
        clientes.setForeground(new java.awt.Color(102, 102, 102));
        clientes.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaClientes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Endereço", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaClientes.setFocusable(false);
        tabelaClientes.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaClientes.setRowHeight(25);
        tabelaClientes.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaClientes.setShowVerticalLines(false);
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelaClientes);

        pesquisarClientes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarClientes.setToolTipText("");
        pesquisarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarClientesKeyReleased(evt);
            }
        });

        btnDeletarClientes.setBackground(new java.awt.Color(23, 35, 51));
        btnDeletarClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeletarClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeletarClientes.setText("Deletar");
        btnDeletarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletarClientes.setOpaque(true);
        btnDeletarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletarClientesMouseClicked(evt);
            }
        });

        deletarClientes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarClientes.setToolTipText("");
        deletarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientesLayout = new javax.swing.GroupLayout(clientes);
        clientes.setLayout(clientesLayout);
        clientesLayout.setHorizontalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(deletarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeletarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientesLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        clientesLayout.setVerticalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientesLayout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deletarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeletarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(262, Short.MAX_VALUE)))
        );

        menuPaineis.add(clientes, "card3");

        produtos.setBackground(new java.awt.Color(255, 255, 255));
        produtos.setForeground(new java.awt.Color(102, 102, 102));
        produtos.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaProdutos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaProdutos.setFocusable(false);
        tabelaProdutos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaProdutos.setRowHeight(25);
        tabelaProdutos.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaProdutos.setShowVerticalLines(false);
        tabelaProdutos.getTableHeader().setReorderingAllowed(false);
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaProdutos);

        pesquisarProdutos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarProdutosKeyReleased(evt);
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

        deletarProdutos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarProdutos.setToolTipText("");
        deletarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout produtosLayout = new javax.swing.GroupLayout(produtos);
        produtos.setLayout(produtosLayout);
        produtosLayout.setHorizontalGroup(
            produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(deletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        produtosLayout.setVerticalGroup(
            produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosLayout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addGroup(produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeletarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(262, Short.MAX_VALUE)))
        );

        menuPaineis.add(produtos, "card3");

        servicos.setBackground(new java.awt.Color(255, 255, 255));
        servicos.setForeground(new java.awt.Color(51, 51, 51));
        servicos.setPreferredSize(new java.awt.Dimension(900, 565));
        servicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                servicosKeyReleased(evt);
            }
        });
        servicos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaServicos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaServicos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaServicos.setFocusable(false);
        tabelaServicos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaServicos.setRowHeight(25);
        tabelaServicos.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaServicos.setShowVerticalLines(false);
        tabelaServicos.getTableHeader().setReorderingAllowed(false);
        tabelaServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaServicosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaServicos);
        if (tabelaServicos.getColumnModel().getColumnCount() > 0) {
            tabelaServicos.getColumnModel().getColumn(1).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(2).setResizable(false);
        }

        servicos.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 833, 227));

        pesquisarServicos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarServicosActionPerformed(evt);
            }
        });
        pesquisarServicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarServicosKeyReleased(evt);
            }
        });
        servicos.add(pesquisarServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 267, 270, -1));

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
        servicos.add(btnDeletarServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 267, 146, 30));

        deletarServicos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarServicos.setToolTipText("");
        deletarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarServicosActionPerformed(evt);
            }
        });
        servicos.add(deletarServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 267, 189, -1));

        menuPaineis.add(servicos, "card3");

        funcionarios.setBackground(new java.awt.Color(255, 255, 255));
        funcionarios.setForeground(new java.awt.Color(102, 102, 102));
        funcionarios.setPreferredSize(new java.awt.Dimension(900, 565));

        tabelaFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaFuncionarios.setFocusable(false);
        tabelaFuncionarios.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaFuncionarios.setRowHeight(25);
        tabelaFuncionarios.setSelectionBackground(new java.awt.Color(192, 192, 192));
        tabelaFuncionarios.setShowVerticalLines(false);
        tabelaFuncionarios.getTableHeader().setReorderingAllowed(false);
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tabelaFuncionarios);

        pesquisarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pesquisarFuncionarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarFuncionariosKeyReleased(evt);
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

        deletarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deletarFuncionarios.setToolTipText("");
        deletarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarFuncionariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout funcionariosLayout = new javax.swing.GroupLayout(funcionarios);
        funcionarios.setLayout(funcionariosLayout);
        funcionariosLayout.setHorizontalGroup(
            funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funcionariosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(deletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funcionariosLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        funcionariosLayout.setVerticalGroup(
            funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funcionariosLayout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addGroup(funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeletarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funcionariosLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(198, Short.MAX_VALUE)))
        );

        menuPaineis.add(funcionarios, "card3");

        javax.swing.GroupLayout menuPrincipalLayout = new javax.swing.GroupLayout(menuPrincipal);
        menuPrincipal.setLayout(menuPrincipalLayout);
        menuPrincipalLayout.setHorizontalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPaineis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuCabecario, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuPrincipalLayout.setVerticalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPrincipalLayout.createSequentialGroup()
                .addComponent(menuCabecario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPaineis, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int xx;
    int xy;
    private void menuCabecarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCabecarioMousePressed

        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_menuCabecarioMousePressed

    private void menuCabecarioMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCabecarioMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_menuCabecarioMouseDragged

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked

        TelaPrincipal principal = new TelaPrincipal();
        principal.lblNomeUsuario.setText(lblNomeDeUsuarioRegistro.getText());

        this.dispose();

        principal.setVisible(true);
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnGraficoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficoMouseClicked

        setLblColor(btnGrafico);
        resetLblColor(btnProdutos);
        resetLblColor(btnClientes);
        resetLblColor(btnFuncionarios);
        resetLblColor(btnServicos);

        grafico.setVisible(true);
        produtos.setVisible(false);
        clientes.setVisible(false);
        funcionarios.setVisible(false);
        servicos.setVisible(false);

    }//GEN-LAST:event_btnGraficoMouseClicked

    private void btnProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutosMouseClicked

        resetLblColor(btnGrafico);
        setLblColor(btnProdutos);
        resetLblColor(btnClientes);
        resetLblColor(btnFuncionarios);
        resetLblColor(btnServicos);

        grafico.setVisible(false);
        produtos.setVisible(true);
        clientes.setVisible(false);
        funcionarios.setVisible(false);
        servicos.setVisible(false);

        this.lblNomeDeUsuarioRegistro.setVisible(true);

        pesquisarProdutosSem();

    }//GEN-LAST:event_btnProdutosMouseClicked

    private void btnServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicosMouseClicked

        resetLblColor(btnGrafico);
        resetLblColor(btnProdutos);
        resetLblColor(btnClientes);
        resetLblColor(btnFuncionarios);
        setLblColor(btnServicos);

        grafico.setVisible(false);
        produtos.setVisible(false);
        clientes.setVisible(false);
        funcionarios.setVisible(false);
        servicos.setVisible(true);

        pesquisarServicosSem();

    }//GEN-LAST:event_btnServicosMouseClicked

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked

        resetLblColor(btnGrafico);
        resetLblColor(btnProdutos);
        setLblColor(btnClientes);
        resetLblColor(btnFuncionarios);
        resetLblColor(btnServicos);

        grafico.setVisible(false);
        produtos.setVisible(false);
        clientes.setVisible(true);
        funcionarios.setVisible(false);
        servicos.setVisible(false);

        pesquisarClientesSem();

    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuncionariosMouseClicked

        resetLblColor(btnGrafico);
        resetLblColor(btnProdutos);
        resetLblColor(btnClientes);
        setLblColor(btnFuncionarios);
        resetLblColor(btnServicos);

        grafico.setVisible(false);
        produtos.setVisible(false);
        clientes.setVisible(false);
        funcionarios.setVisible(true);
        servicos.setVisible(false);

        pesquisarFuncionariosSem();

    }//GEN-LAST:event_btnFuncionariosMouseClicked

    private void pesquisarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarServicosActionPerformed

    }//GEN-LAST:event_pesquisarServicosActionPerformed

    private void btnDeletarServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarServicosMouseClicked

        deletarServicos();
    }//GEN-LAST:event_btnDeletarServicosMouseClicked

    private void deletarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarServicosActionPerformed

    }//GEN-LAST:event_deletarServicosActionPerformed

    private void btnProdutosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProdutosMouseEntered

    private void btnDeletarProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarProdutosMouseClicked
        deletarProdutos();
    }//GEN-LAST:event_btnDeletarProdutosMouseClicked

    private void deletarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletarProdutosActionPerformed

    private void btnDeletarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarClientesMouseClicked
        deletarClientes();
    }//GEN-LAST:event_btnDeletarClientesMouseClicked

    private void deletarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletarClientesActionPerformed

    private void btnDeletarFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarFuncionariosMouseClicked
        deletarFuncionarios();
    }//GEN-LAST:event_btnDeletarFuncionariosMouseClicked

    private void deletarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletarFuncionariosActionPerformed

    private void pesquisarProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarProdutosKeyReleased
        pesquisarProdutos();
    }//GEN-LAST:event_pesquisarProdutosKeyReleased

    private void pesquisarClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarClientesKeyReleased
        pesquisarClientes();
    }//GEN-LAST:event_pesquisarClientesKeyReleased

    private void pesquisarFuncionariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarFuncionariosKeyReleased
        pesquisarFuncionarios();
    }//GEN-LAST:event_pesquisarFuncionariosKeyReleased

    private void servicosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servicosKeyReleased
        pesquisarServicos();
    }//GEN-LAST:event_servicosKeyReleased

    private void tabelaServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaServicosMouseClicked
        setarCamposServicos();
    }//GEN-LAST:event_tabelaServicosMouseClicked

    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        setarCamposFuncionarios();
    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        setarCamposProdutos();
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        setarCamposClientes();
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void pesquisarServicosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarServicosKeyReleased
        pesquisarServicos();
    }//GEN-LAST:event_pesquisarServicosKeyReleased

    public void setLblColor(JLabel lbl) {

        lbl.setBackground(new Color(41, 57, 80));
    }

    public void resetLblColor(JLabel lbl) {

        lbl.setBackground(new Color(23, 35, 51));
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClientes;
    public javax.swing.JLabel btnDeletarClientes;
    public javax.swing.JLabel btnDeletarFuncionarios;
    public javax.swing.JLabel btnDeletarProdutos;
    private javax.swing.JLabel btnDeletarServicos;
    private javax.swing.JLabel btnFuncionarios;
    private javax.swing.JLabel btnGrafico;
    private javax.swing.JLabel btnProdutos;
    private javax.swing.JLabel btnSair;
    private javax.swing.JLabel btnServicos;
    public javax.swing.JPanel clientes;
    public javax.swing.JTextField deletarClientes;
    private javax.swing.JTextField deletarFuncionarios;
    private javax.swing.JTextField deletarProdutos;
    private javax.swing.JTextField deletarServicos;
    public javax.swing.JPanel funcionarios;
    public javax.swing.JPanel grafico;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JLabel lblNomeDeUsuarioRegistro;
    private javax.swing.JPanel menuCabecario;
    private javax.swing.JPanel menuPaineis;
    private javax.swing.JPanel menuPrincipal;
    private javax.swing.JPanel painelGrafico;
    public javax.swing.JTextField pesquisarClientes;
    public javax.swing.JTextField pesquisarFuncionarios;
    public javax.swing.JTextField pesquisarProdutos;
    public javax.swing.JTextField pesquisarServicos;
    public javax.swing.JPanel produtos;
    public javax.swing.JPanel servicos;
    public javax.swing.JTable tabelaClientes;
    public javax.swing.JTable tabelaFuncionarios;
    public javax.swing.JTable tabelaProdutos;
    public javax.swing.JTable tabelaServicos;
    // End of variables declaration//GEN-END:variables
}
