package view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        setColor(btn_home);
        ind_home.setOpaque(true);
        
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        ind_home = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_productsP = new javax.swing.JPanel();
        ind_products = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_customersP = new javax.swing.JPanel();
        ind_customers = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btn_EmployeesP = new javax.swing.JPanel();
        ind_employees = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btn_servicesP = new javax.swing.JPanel();
        ind_services = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btn_salesP = new javax.swing.JPanel();
        ind_services1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btn_spendingP = new javax.swing.JPanel();
        ind_services2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        Menu2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Menu3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_Settings = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_records = new javax.swing.JPanel();
        ind_records = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        MenuSettings = new javax.swing.JPanel();
        MenuApresentacao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(23, 35, 51));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setBackground(new java.awt.Color(23, 35, 51));
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        ind_home.setOpaque(false);
        ind_home.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_homeLayout = new javax.swing.GroupLayout(ind_home);
        ind_home.setLayout(ind_homeLayout);
        ind_homeLayout.setHorizontalGroup(
            ind_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_homeLayout.setVerticalGroup(
            ind_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home");

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addComponent(ind_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(0, 69, Short.MAX_VALUE))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addComponent(ind_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 140, -1));

        btn_productsP.setBackground(new java.awt.Color(23, 35, 51));
        btn_productsP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_productsP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_productsPMouseReleased(evt);
            }
        });

        ind_products.setOpaque(false);
        ind_products.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_productsLayout = new javax.swing.GroupLayout(ind_products);
        ind_products.setLayout(ind_productsLayout);
        ind_productsLayout.setHorizontalGroup(
            ind_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_productsLayout.setVerticalGroup(
            ind_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Products");

        javax.swing.GroupLayout btn_productsPLayout = new javax.swing.GroupLayout(btn_productsP);
        btn_productsP.setLayout(btn_productsPLayout);
        btn_productsPLayout.setHorizontalGroup(
            btn_productsPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_productsPLayout.createSequentialGroup()
                .addComponent(ind_products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        btn_productsPLayout.setVerticalGroup(
            btn_productsPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_productsPLayout.createSequentialGroup()
                .addComponent(ind_products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_productsPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_productsP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 140, -1));

        btn_customersP.setBackground(new java.awt.Color(23, 35, 51));
        btn_customersP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_customersP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_customersPMouseReleased(evt);
            }
        });

        ind_customers.setOpaque(false);
        ind_customers.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_customersLayout = new javax.swing.GroupLayout(ind_customers);
        ind_customers.setLayout(ind_customersLayout);
        ind_customersLayout.setHorizontalGroup(
            ind_customersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_customersLayout.setVerticalGroup(
            ind_customersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Customers");

        javax.swing.GroupLayout btn_customersPLayout = new javax.swing.GroupLayout(btn_customersP);
        btn_customersP.setLayout(btn_customersPLayout);
        btn_customersPLayout.setHorizontalGroup(
            btn_customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_customersPLayout.createSequentialGroup()
                .addComponent(ind_customers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel13)
                .addGap(0, 45, Short.MAX_VALUE))
        );
        btn_customersPLayout.setVerticalGroup(
            btn_customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_customersPLayout.createSequentialGroup()
                .addComponent(ind_customers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_customersPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_customersP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, -1));

        btn_EmployeesP.setBackground(new java.awt.Color(23, 35, 51));
        btn_EmployeesP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_EmployeesP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_EmployeesPMouseReleased(evt);
            }
        });

        ind_employees.setOpaque(false);
        ind_employees.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_employeesLayout = new javax.swing.GroupLayout(ind_employees);
        ind_employees.setLayout(ind_employeesLayout);
        ind_employeesLayout.setHorizontalGroup(
            ind_employeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_employeesLayout.setVerticalGroup(
            ind_employeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Employees");

        javax.swing.GroupLayout btn_EmployeesPLayout = new javax.swing.GroupLayout(btn_EmployeesP);
        btn_EmployeesP.setLayout(btn_EmployeesPLayout);
        btn_EmployeesPLayout.setHorizontalGroup(
            btn_EmployeesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_EmployeesPLayout.createSequentialGroup()
                .addComponent(ind_employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel18)
                .addGap(0, 45, Short.MAX_VALUE))
        );
        btn_EmployeesPLayout.setVerticalGroup(
            btn_EmployeesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_EmployeesPLayout.createSequentialGroup()
                .addComponent(ind_employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_EmployeesPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_EmployeesP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 140, -1));

        btn_servicesP.setBackground(new java.awt.Color(23, 35, 51));
        btn_servicesP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_servicesP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_servicesPMouseReleased(evt);
            }
        });

        ind_services.setOpaque(false);
        ind_services.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_servicesLayout = new javax.swing.GroupLayout(ind_services);
        ind_services.setLayout(ind_servicesLayout);
        ind_servicesLayout.setHorizontalGroup(
            ind_servicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_servicesLayout.setVerticalGroup(
            ind_servicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Services");

        javax.swing.GroupLayout btn_servicesPLayout = new javax.swing.GroupLayout(btn_servicesP);
        btn_servicesP.setLayout(btn_servicesPLayout);
        btn_servicesPLayout.setHorizontalGroup(
            btn_servicesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_servicesPLayout.createSequentialGroup()
                .addComponent(ind_services, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel19)
                .addGap(0, 60, Short.MAX_VALUE))
        );
        btn_servicesPLayout.setVerticalGroup(
            btn_servicesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_servicesPLayout.createSequentialGroup()
                .addComponent(ind_services, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_servicesPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_servicesP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 140, -1));

        btn_salesP.setBackground(new java.awt.Color(23, 35, 51));
        btn_salesP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salesP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_salesPMouseReleased(evt);
            }
        });

        ind_services1.setOpaque(false);
        ind_services1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_services1Layout = new javax.swing.GroupLayout(ind_services1);
        ind_services1.setLayout(ind_services1Layout);
        ind_services1Layout.setHorizontalGroup(
            ind_services1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_services1Layout.setVerticalGroup(
            ind_services1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Sales");

        javax.swing.GroupLayout btn_salesPLayout = new javax.swing.GroupLayout(btn_salesP);
        btn_salesP.setLayout(btn_salesPLayout);
        btn_salesPLayout.setHorizontalGroup(
            btn_salesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_salesPLayout.createSequentialGroup()
                .addComponent(ind_services1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel21)
                .addGap(0, 76, Short.MAX_VALUE))
        );
        btn_salesPLayout.setVerticalGroup(
            btn_salesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_salesPLayout.createSequentialGroup()
                .addComponent(ind_services1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_salesPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_salesP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, 40));

        btn_spendingP.setBackground(new java.awt.Color(23, 35, 51));
        btn_spendingP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_spendingP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_spendingPMouseReleased(evt);
            }
        });

        ind_services2.setOpaque(false);
        ind_services2.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_services2Layout = new javax.swing.GroupLayout(ind_services2);
        ind_services2.setLayout(ind_services2Layout);
        ind_services2Layout.setHorizontalGroup(
            ind_services2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_services2Layout.setVerticalGroup(
            ind_services2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Spending");

        javax.swing.GroupLayout btn_spendingPLayout = new javax.swing.GroupLayout(btn_spendingP);
        btn_spendingP.setLayout(btn_spendingPLayout);
        btn_spendingPLayout.setHorizontalGroup(
            btn_spendingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_spendingPLayout.createSequentialGroup()
                .addComponent(ind_services2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel22)
                .addGap(0, 52, Short.MAX_VALUE))
        );
        btn_spendingPLayout.setVerticalGroup(
            btn_spendingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_spendingPLayout.createSequentialGroup()
                .addComponent(ind_services2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_spendingPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_spendingP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 140, -1));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 590));

        Menu2.setBackground(new java.awt.Color(71, 120, 197));
        Menu2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Menu2MouseDragged(evt);
            }
        });
        Menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu2MousePressed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(123, 156, 225));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setPreferredSize(new java.awt.Dimension(2, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Search_18px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Menu2Layout = new javax.swing.GroupLayout(Menu2);
        Menu2.setLayout(Menu2Layout);
        Menu2Layout.setHorizontalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu2Layout.createSequentialGroup()
                .addContainerGap(737, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(34, 34, 34))
        );
        Menu2Layout.setVerticalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 940, 50));

        Menu3.setBackground(new java.awt.Color(192, 192, 192));

        jPanel4.setBackground(new java.awt.Color(23, 35, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(71, 120, 197));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Contacts_25px.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Calendar_25px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Lock_25px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/settings-25.png"))); // NOI18N
        btn_Settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_SettingsMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btn_Settings)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(39, 39, 39))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 310, 130));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Exit_25px.png"))); // NOI18N
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        jPanel4.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 24, -1, 46));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/iconfinder_Neptune_1715800.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("User");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        btn_records.setBackground(new java.awt.Color(23, 35, 51));
        btn_records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_recordsMouseReleased(evt);
            }
        });

        ind_records.setOpaque(false);
        ind_records.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_recordsLayout = new javax.swing.GroupLayout(ind_records);
        ind_records.setLayout(ind_recordsLayout);
        ind_recordsLayout.setHorizontalGroup(
            ind_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_recordsLayout.setVerticalGroup(
            ind_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Records");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_recordsLayout = new javax.swing.GroupLayout(btn_records);
        btn_records.setLayout(btn_recordsLayout);
        btn_recordsLayout.setHorizontalGroup(
            btn_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_recordsLayout.createSequentialGroup()
                .addComponent(ind_records, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel14)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        btn_recordsLayout.setVerticalGroup(
            btn_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_recordsLayout.createSequentialGroup()
                .addComponent(ind_records, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_recordsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MenuSettings.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MenuSettingsLayout = new javax.swing.GroupLayout(MenuSettings);
        MenuSettings.setLayout(MenuSettingsLayout);
        MenuSettingsLayout.setHorizontalGroup(
            MenuSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        MenuSettingsLayout.setVerticalGroup(
            MenuSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Menu3Layout = new javax.swing.GroupLayout(Menu3);
        Menu3.setLayout(Menu3Layout);
        Menu3Layout.setHorizontalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Menu3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btn_records, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Menu3Layout.setVerticalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_records, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(MenuSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(Menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 310, 540));

        MenuApresentacao.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MenuApresentacaoLayout = new javax.swing.GroupLayout(MenuApresentacao);
        MenuApresentacao.setLayout(MenuApresentacaoLayout);
        MenuApresentacaoLayout.setHorizontalGroup(
            MenuApresentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        MenuApresentacaoLayout.setVerticalGroup(
            MenuApresentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(MenuApresentacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 630, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
 
    }//GEN-LAST:event_btn_homeMousePressed

    private void btn_productsPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productsPMouseReleased

        setColor(btn_productsP);
        ind_products.setOpaque(true);
        resetColor(new JPanel[]{ btn_customersP, btn_EmployeesP, btn_servicesP,  btn_records, btn_salesP, btn_spendingP}, new JPanel[]{ ind_customers, ind_employees, ind_services, ind_records, ind_services2, ind_services1});
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }//GEN-LAST:event_btn_productsPMouseReleased

    int xx, xy;

    private void Menu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MousePressed

        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_Menu2MousePressed

    private void Menu2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_Menu2MouseDragged

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed

        System.exit(0);

    }//GEN-LAST:event_btn_exitMousePressed

    private void btn_customersPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customersPMouseReleased

        setColor(btn_customersP);
        ind_customers.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP, btn_EmployeesP, btn_servicesP,  btn_records, btn_salesP, btn_spendingP}, new JPanel[]{ind_products, ind_employees, ind_services,  ind_records, ind_services2, ind_services1});
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }//GEN-LAST:event_btn_customersPMouseReleased

    private void btn_EmployeesPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmployeesPMouseReleased
        
        setColor(btn_EmployeesP);
        ind_employees.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,  btn_customersP, btn_servicesP, btn_records, btn_salesP, btn_spendingP}, new JPanel[]{ind_products,   ind_customers, ind_services, ind_records, ind_services2, ind_services1});
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }//GEN-LAST:event_btn_EmployeesPMouseReleased

    private void btn_servicesPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_servicesPMouseReleased
        
        setColor(btn_servicesP);
        ind_services.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,  btn_EmployeesP, btn_customersP, btn_records, btn_salesP, btn_spendingP}, new JPanel[]{ind_products,  ind_employees, ind_customers,  ind_records, ind_services2, ind_services1});
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }//GEN-LAST:event_btn_servicesPMouseReleased

    private void btn_recordsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recordsMouseReleased

        setColor(btn_records);
        resetColor(new JPanel[]{btn_productsP,   btn_EmployeesP, btn_customersP, btn_servicesP, btn_salesP, btn_spendingP}, new JPanel[]{ind_products, ind_employees, ind_customers, ind_services,  ind_services2, ind_services1});

        TelaRegistros registro = new TelaRegistros();
        registro.setVisible(true);
        this.dispose();
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }//GEN-LAST:event_btn_recordsMouseReleased

    private void btn_salesPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salesPMouseReleased
        
        setColor(btn_salesP);
        ind_services1.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP, btn_customersP, btn_servicesP, btn_records, btn_spendingP}, new JPanel[]{ind_products,  ind_customers, ind_services,  ind_records, ind_services2});
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }//GEN-LAST:event_btn_salesPMouseReleased

    private void btn_spendingPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_spendingPMouseReleased
        
        setColor(btn_spendingP);
        ind_services2.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,  btn_customersP, btn_servicesP, btn_records, btn_salesP}, new JPanel[]{ind_products, ind_customers, ind_services, ind_records, ind_services1});
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
    }//GEN-LAST:event_btn_spendingPMouseReleased

    private void btn_SettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SettingsMousePressed
        
        MenuSettings.setVisible(true);
        MenuSettings.setEnabled(true);
        
        
    }//GEN-LAST:event_btn_SettingsMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
        
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        
        MenuSettings.setVisible(false);
        MenuSettings.setEnabled(false);
        
    }//GEN-LAST:event_jLabel3MousePressed

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
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Menu2;
    private javax.swing.JPanel Menu3;
    private javax.swing.JPanel MenuApresentacao;
    private javax.swing.JPanel MenuSettings;
    private javax.swing.JPanel btn_EmployeesP;
    private javax.swing.JLabel btn_Settings;
    private javax.swing.JPanel btn_customersP;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_productsP;
    private javax.swing.JPanel btn_records;
    private javax.swing.JPanel btn_salesP;
    private javax.swing.JPanel btn_servicesP;
    private javax.swing.JPanel btn_spendingP;
    private javax.swing.JPanel ind_customers;
    private javax.swing.JPanel ind_employees;
    private javax.swing.JPanel ind_home;
    private javax.swing.JPanel ind_products;
    private javax.swing.JPanel ind_records;
    private javax.swing.JPanel ind_services;
    private javax.swing.JPanel ind_services1;
    private javax.swing.JPanel ind_services2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
