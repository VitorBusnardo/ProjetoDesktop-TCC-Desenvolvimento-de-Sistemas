
package Telas;

import Telas.TelaPrincipal;
import java.awt.Color;
import javax.swing.JLabel;


public class TelaRegistros extends javax.swing.JFrame {


    public TelaRegistros() {
        initComponents();
        
        setLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        
        Graphic.setVisible(true);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
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
        Paineis = new javax.swing.JPanel();
        Graphic = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Products = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Customers = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        Employees = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        Services = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_graphic, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_products, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_services, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_products, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_graphic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_services, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Paineis.setLayout(new java.awt.CardLayout());

        Graphic.setBackground(new java.awt.Color(255, 255, 255));
        Graphic.setLayout(new javax.swing.BoxLayout(Graphic, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Keep", "Too", "4"},
                {"Allan", "Ramstein", "5"},
                {"Fred", "Simmons", "3"},
                {"Wendy", "RaG", "2"}
            },
            new String [] {
                "First Name", "Last Name", "Class"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jScrollPane1.setViewportView(jTable1);

        Graphic.add(jScrollPane1);

        Paineis.add(Graphic, "card3");

        Products.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Keep", "Too", "4", "A"},
                {"Allan", "Ramstein", "5", "B"},
                {"Fred", "Simmons", "3", "C"},
                {"Wendy", "RaG", "2", "A"}
            },
            new String [] {
                "First Name", "Last Name", "Class", "Stream"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setRowHeight(20);
        jTable2.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout ProductsLayout = new javax.swing.GroupLayout(Products);
        Products.setLayout(ProductsLayout);
        ProductsLayout.setHorizontalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ProductsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ProductsLayout.setVerticalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ProductsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Paineis.add(Products, "card3");

        Customers.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable3.setForeground(new java.awt.Color(51, 51, 51));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Keep"},
                {"Allan"},
                {"Fred"},
                {"Wendy"}
            },
            new String [] {
                "First Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setRowHeight(20);
        jTable3.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout CustomersLayout = new javax.swing.GroupLayout(Customers);
        Customers.setLayout(CustomersLayout);
        CustomersLayout.setHorizontalGroup(
            CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CustomersLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        CustomersLayout.setVerticalGroup(
            CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CustomersLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Paineis.add(Customers, "card3");

        Employees.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);

        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable4.setForeground(new java.awt.Color(51, 51, 51));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Keep", "Too", "4", "A"},
                {"Allan", "Ramstein", "5", "B"},
                {"Fred", "Simmons", "3", "C"},
                {"Wendy", "RaG", "2", "A"}
            },
            new String [] {
                "First Name", "Last Name", "Class", "Stream"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jTable4.setRowHeight(20);
        jTable4.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout EmployeesLayout = new javax.swing.GroupLayout(Employees);
        Employees.setLayout(EmployeesLayout);
        EmployeesLayout.setHorizontalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EmployeesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        EmployeesLayout.setVerticalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EmployeesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Paineis.add(Employees, "card3");

        Services.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);

        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable5.setForeground(new java.awt.Color(51, 51, 51));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Keep", "Too", "4", "A", null, null, null, null, null, null},
                {"Allan", "Ramstein", "5", "B", null, null, null, null, null, null},
                {"Fred", "Simmons", "3", "C", null, null, null, null, null, null},
                {"Wendy", "RaG", "2", "A", null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Class", "Stream", "Título 5", "Título 6", "Título 7", "Título 8", "Título 9", "Título 10"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable5.setGridColor(new java.awt.Color(255, 255, 255));
        jTable5.setRowHeight(20);
        jTable5.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout ServicesLayout = new javax.swing.GroupLayout(Services);
        Services.setLayout(ServicesLayout);
        ServicesLayout.setHorizontalGroup(
            ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ServicesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ServicesLayout.setVerticalGroup(
            ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(ServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ServicesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Paineis.add(Services, "card3");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
            .addComponent(Paineis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
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
        
        Graphic.setVisible(true);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        
      
    }//GEN-LAST:event_btn_graphicMouseClicked

    private void btn_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productsMouseClicked
        
        
        resetLblColor(btn_graphic);
        setLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        
        Graphic.setVisible(false);
        Products.setVisible(true);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
    }//GEN-LAST:event_btn_productsMouseClicked

    private void btn_servicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_servicesMouseClicked
        
        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        setLblColor(btn_services);
        
        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(true);
        
        
    }//GEN-LAST:event_btn_servicesMouseClicked

    private void btn_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customersMouseClicked
        
        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        setLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        
        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(true);
        Employees.setVisible(false);
        Services.setVisible(false);
        
    }//GEN-LAST:event_btn_customersMouseClicked

    private void btn_employeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_employeesMouseClicked
        
        
        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        setLblColor(btn_employees);
        resetLblColor(btn_services);
        
        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(true);
        Services.setVisible(false);
    }//GEN-LAST:event_btn_employeesMouseClicked
    
    
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
    private javax.swing.JPanel Customers;
    private javax.swing.JPanel Employees;
    private javax.swing.JPanel Graphic;
    private javax.swing.JPanel Paineis;
    private javax.swing.JPanel Products;
    private javax.swing.JPanel Services;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
