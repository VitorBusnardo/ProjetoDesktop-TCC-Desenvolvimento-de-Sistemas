
package view;

import view.TelaPrincipal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


public class TelaRegistros extends javax.swing.JFrame {


    public TelaRegistros() {
        initComponents();
        
        setLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_accounting);
        
        Graphic.setVisible(true);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Accounting.setVisible(false);
        
        
        
        TabelaGraphic.getTableHeader().setOpaque(false);
        TabelaGraphic.getTableHeader().setBackground(new Color(71,120,197));
        TabelaGraphic.getTableHeader().setForeground(new Color(255,255,255));
        TabelaGraphic.setRowHeight(25);
        
        TabelaProducts.getTableHeader().setOpaque(false);
        TabelaProducts.getTableHeader().setBackground(new Color(71,120,197));
        TabelaProducts.getTableHeader().setForeground(new Color(255,255,255));
        TabelaProducts.setRowHeight(25);
    
        TabelaCustomers.getTableHeader().setOpaque(false);
        TabelaCustomers.getTableHeader().setBackground(new Color(71,120,197));
        TabelaCustomers.getTableHeader().setForeground(new Color(255,255,255));
        TabelaCustomers.setRowHeight(25);
        
        TabelaEmployees.getTableHeader().setOpaque(false);
        TabelaEmployees.getTableHeader().setBackground(new Color(71,120,197));
        TabelaEmployees.getTableHeader().setForeground(new Color(255,255,255));
        TabelaEmployees.setRowHeight(25);
        
        TabelaAccounting.getTableHeader().setOpaque(false);
        TabelaAccounting.getTableHeader().setBackground(new Color(71,120,197));
        TabelaAccounting.getTableHeader().setForeground(new Color(255,255,255));
        TabelaAccounting.setRowHeight(25);
        
        TabelaServices.getTableHeader().setOpaque(false);
        TabelaServices.getTableHeader().setBackground(new Color(71,120,197));
        TabelaServices.getTableHeader().setForeground(new Color(255,255,255));
        TabelaServices.setRowHeight(25);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_graphic = new javax.swing.JLabel();
        btn_products = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_services = new javax.swing.JLabel();
        btn_customers = new javax.swing.JLabel();
        btn_employees = new javax.swing.JLabel();
        btn_accounting = new javax.swing.JLabel();
        Paineis = new javax.swing.JPanel();
        Graphic = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaGraphic = new javax.swing.JTable();
        Products = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaProducts = new javax.swing.JTable();
        Customers = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaCustomers = new javax.swing.JTable();
        Employees = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelaEmployees = new javax.swing.JTable();
        Accounting = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelaAccounting = new javax.swing.JTable();
        Services = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabelaServices = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        main.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(23, 35, 51));
        header.setPreferredSize(new java.awt.Dimension(838, 200));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(23, 35, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        btn_graphic.setBackground(new java.awt.Color(23, 35, 51));
        btn_graphic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_graphic.setForeground(new java.awt.Color(255, 255, 255));
        btn_graphic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_graphic.setText("Graphic");
        btn_graphic.setOpaque(true);
        btn_graphic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_graphicMouseClicked(evt);
            }
        });

        btn_products.setBackground(new java.awt.Color(23, 35, 51));
        btn_products.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_products.setForeground(new java.awt.Color(255, 255, 255));
        btn_products.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_products.setText("Products");
        btn_products.setOpaque(true);
        btn_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_productsMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/planet.png"))); // NOI18N

        btn_services.setBackground(new java.awt.Color(23, 35, 51));
        btn_services.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_services.setForeground(new java.awt.Color(255, 255, 255));
        btn_services.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_services.setText("Services");
        btn_services.setOpaque(true);
        btn_services.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_servicesMouseClicked(evt);
            }
        });

        btn_customers.setBackground(new java.awt.Color(23, 35, 51));
        btn_customers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_customers.setForeground(new java.awt.Color(255, 255, 255));
        btn_customers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_customers.setText("Customers");
        btn_customers.setOpaque(true);
        btn_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_customersMouseClicked(evt);
            }
        });

        btn_employees.setBackground(new java.awt.Color(23, 35, 51));
        btn_employees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_employees.setForeground(new java.awt.Color(255, 255, 255));
        btn_employees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_employees.setText("Employees");
        btn_employees.setOpaque(true);
        btn_employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_employeesMouseClicked(evt);
            }
        });

        btn_accounting.setBackground(new java.awt.Color(23, 35, 51));
        btn_accounting.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_accounting.setForeground(new java.awt.Color(255, 255, 255));
        btn_accounting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_accounting.setText("Accounting");
        btn_accounting.setOpaque(true);
        btn_accounting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_accountingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btn_graphic, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_products, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_services, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_accounting, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(29, 29, 29)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_products, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_graphic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_services, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_accounting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Paineis.setLayout(new java.awt.CardLayout());

        Graphic.setBackground(new java.awt.Color(255, 255, 255));
        Graphic.setForeground(new java.awt.Color(204, 204, 204));

        TabelaGraphic.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TabelaGraphic.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaGraphic.setFocusable(false);
        TabelaGraphic.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaGraphic.setRowHeight(25);
        TabelaGraphic.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaGraphic.setShowVerticalLines(false);
        TabelaGraphic.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TabelaGraphic);

        javax.swing.GroupLayout GraphicLayout = new javax.swing.GroupLayout(Graphic);
        Graphic.setLayout(GraphicLayout);
        GraphicLayout.setHorizontalGroup(
            GraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(GraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GraphicLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        GraphicLayout.setVerticalGroup(
            GraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(GraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GraphicLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        Paineis.add(Graphic, "card3");

        Products.setBackground(new java.awt.Color(255, 255, 255));
        Products.setForeground(new java.awt.Color(204, 204, 204));

        TabelaProducts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TabelaProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaProducts.setFocusable(false);
        TabelaProducts.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaProducts.setRowHeight(25);
        TabelaProducts.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaProducts.setShowVerticalLines(false);
        TabelaProducts.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TabelaProducts);

        javax.swing.GroupLayout ProductsLayout = new javax.swing.GroupLayout(Products);
        Products.setLayout(ProductsLayout);
        ProductsLayout.setHorizontalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductsLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        ProductsLayout.setVerticalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductsLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        Paineis.add(Products, "card3");

        Customers.setBackground(new java.awt.Color(255, 255, 255));
        Customers.setForeground(new java.awt.Color(153, 153, 153));

        TabelaCustomers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TabelaCustomers.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaCustomers.setFocusable(false);
        TabelaCustomers.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaCustomers.setRowHeight(25);
        TabelaCustomers.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaCustomers.setShowVerticalLines(false);
        TabelaCustomers.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TabelaCustomers);

        javax.swing.GroupLayout CustomersLayout = new javax.swing.GroupLayout(Customers);
        Customers.setLayout(CustomersLayout);
        CustomersLayout.setHorizontalGroup(
            CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomersLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        CustomersLayout.setVerticalGroup(
            CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomersLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        Paineis.add(Customers, "card3");

        Employees.setBackground(new java.awt.Color(255, 255, 255));
        Employees.setForeground(new java.awt.Color(102, 102, 102));

        TabelaEmployees.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TabelaEmployees.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaEmployees.setFocusable(false);
        TabelaEmployees.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaEmployees.setRowHeight(25);
        TabelaEmployees.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaEmployees.setShowVerticalLines(false);
        TabelaEmployees.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TabelaEmployees);

        javax.swing.GroupLayout EmployeesLayout = new javax.swing.GroupLayout(Employees);
        Employees.setLayout(EmployeesLayout);
        EmployeesLayout.setHorizontalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        EmployeesLayout.setVerticalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        Paineis.add(Employees, "card3");

        Accounting.setBackground(new java.awt.Color(255, 255, 255));
        Accounting.setForeground(new java.awt.Color(102, 102, 102));

        TabelaAccounting.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TabelaAccounting.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaAccounting.setFocusable(false);
        TabelaAccounting.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaAccounting.setRowHeight(25);
        TabelaAccounting.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaAccounting.setShowVerticalLines(false);
        TabelaAccounting.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TabelaAccounting);

        javax.swing.GroupLayout AccountingLayout = new javax.swing.GroupLayout(Accounting);
        Accounting.setLayout(AccountingLayout);
        AccountingLayout.setHorizontalGroup(
            AccountingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(AccountingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccountingLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        AccountingLayout.setVerticalGroup(
            AccountingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(AccountingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccountingLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        Paineis.add(Accounting, "card3");

        Services.setBackground(new java.awt.Color(255, 255, 255));
        Services.setForeground(new java.awt.Color(51, 51, 51));

        TabelaServices.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TabelaServices.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaServices.setFocusable(false);
        TabelaServices.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaServices.setRowHeight(25);
        TabelaServices.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaServices.setShowVerticalLines(false);
        TabelaServices.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(TabelaServices);

        javax.swing.GroupLayout ServicesLayout = new javax.swing.GroupLayout(Services);
        Services.setLayout(ServicesLayout);
        ServicesLayout.setHorizontalGroup(
            ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServicesLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        ServicesLayout.setVerticalGroup(
            ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServicesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        Paineis.add(Services, "card3");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Paineis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Paineis, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int xx;
    int xy;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        
        xx = evt.getX();
        xy = evt.getY();
       
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_headerMouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_graphicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_graphicMouseClicked
        

        
        setLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_accounting);
        
        Graphic.setVisible(true);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Accounting.setVisible(false);
      
    }//GEN-LAST:event_btn_graphicMouseClicked

    private void btn_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productsMouseClicked
        
        
        resetLblColor(btn_graphic);
        setLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_accounting);
        
        Graphic.setVisible(false);
        Products.setVisible(true);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Accounting.setVisible(false);
    }//GEN-LAST:event_btn_productsMouseClicked

    private void btn_servicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_servicesMouseClicked
        
        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        setLblColor(btn_services);
        resetLblColor(btn_accounting);
        
        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(true);
        Accounting.setVisible(false);
        
    }//GEN-LAST:event_btn_servicesMouseClicked

    private void btn_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customersMouseClicked
        
        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        setLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_accounting);
        
        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(true);
        Employees.setVisible(false);
        Services.setVisible(false);
        Accounting.setVisible(false);
    }//GEN-LAST:event_btn_customersMouseClicked

    private void btn_employeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_employeesMouseClicked
        
        
        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        setLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_accounting);
        
        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(true);
        Services.setVisible(false);
        Accounting.setVisible(false);
    }//GEN-LAST:event_btn_employeesMouseClicked

    private void btn_accountingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accountingMouseClicked
        
        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        setLblColor(btn_accounting);
        
        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Accounting.setVisible(true);
        
    }//GEN-LAST:event_btn_accountingMouseClicked
    
    
    public void setLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(41,57,80));
    }
    
      public void resetLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(23,35,51));
    }
      
           
      
    
      
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //Change UI look of table.
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Accounting;
    private javax.swing.JPanel Customers;
    private javax.swing.JPanel Employees;
    private javax.swing.JPanel Graphic;
    private javax.swing.JPanel Paineis;
    private javax.swing.JPanel Products;
    private javax.swing.JPanel Services;
    private javax.swing.JTable TabelaAccounting;
    private javax.swing.JTable TabelaCustomers;
    private javax.swing.JTable TabelaEmployees;
    private javax.swing.JTable TabelaGraphic;
    private javax.swing.JTable TabelaProducts;
    private javax.swing.JTable TabelaServices;
    private javax.swing.JLabel btn_accounting;
    private javax.swing.JLabel btn_customers;
    private javax.swing.JLabel btn_employees;
    private javax.swing.JLabel btn_graphic;
    private javax.swing.JLabel btn_products;
    private javax.swing.JLabel btn_services;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}