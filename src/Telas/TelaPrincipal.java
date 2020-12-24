
package Telas;

import java.awt.Color;
import javax.swing.JPanel;


public class TelaPrincipal extends javax.swing.JFrame {


    public TelaPrincipal() {
        initComponents();
        setColor(btn_home); 
        
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
        btn_users = new javax.swing.JPanel();
        ind_users = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_profile = new javax.swing.JPanel();
        ind_profile = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_customersP = new javax.swing.JPanel();
        ind_customers = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btn_EmployeesP = new javax.swing.JPanel();
        ind_employees = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btn_servicesP = new javax.swing.JPanel();
        ind_services = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btn_settings = new javax.swing.JPanel();
        ind_settings = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
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
        jLabel15 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_records = new javax.swing.JPanel();
        ind_records = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        MenuApresentacao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(23, 35, 51));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setBackground(new java.awt.Color(23, 35, 51));
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
                .addGap(0, 0, Short.MAX_VALUE))
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

        Menu.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 120, -1));

        btn_productsP.setBackground(new java.awt.Color(23, 35, 51));
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
                .addGap(0, 35, Short.MAX_VALUE))
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

        Menu.add(btn_productsP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 120, -1));

        btn_users.setBackground(new java.awt.Color(23, 35, 51));
        btn_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_usersMousePressed(evt);
            }
        });

        ind_users.setOpaque(false);
        ind_users.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_usersLayout = new javax.swing.GroupLayout(ind_users);
        ind_users.setLayout(ind_usersLayout);
        ind_usersLayout.setHorizontalGroup(
            ind_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_usersLayout.setVerticalGroup(
            ind_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Users");

        javax.swing.GroupLayout btn_usersLayout = new javax.swing.GroupLayout(btn_users);
        btn_users.setLayout(btn_usersLayout);
        btn_usersLayout.setHorizontalGroup(
            btn_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usersLayout.createSequentialGroup()
                .addComponent(ind_users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_usersLayout.setVerticalGroup(
            btn_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usersLayout.createSequentialGroup()
                .addComponent(ind_users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_usersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 120, -1));

        btn_profile.setBackground(new java.awt.Color(23, 35, 51));
        btn_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_profileMousePressed(evt);
            }
        });

        ind_profile.setOpaque(false);
        ind_profile.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_profileLayout = new javax.swing.GroupLayout(ind_profile);
        ind_profile.setLayout(ind_profileLayout);
        ind_profileLayout.setHorizontalGroup(
            ind_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_profileLayout.setVerticalGroup(
            ind_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Profile");

        javax.swing.GroupLayout btn_profileLayout = new javax.swing.GroupLayout(btn_profile);
        btn_profile.setLayout(btn_profileLayout);
        btn_profileLayout.setHorizontalGroup(
            btn_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_profileLayout.createSequentialGroup()
                .addComponent(ind_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        btn_profileLayout.setVerticalGroup(
            btn_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_profileLayout.createSequentialGroup()
                .addComponent(ind_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_profileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 120, -1));

        btn_customersP.setBackground(new java.awt.Color(23, 35, 51));
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
                .addGap(0, 25, Short.MAX_VALUE))
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

        Menu.add(btn_customersP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 120, -1));

        btn_EmployeesP.setBackground(new java.awt.Color(23, 35, 51));
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
                .addGap(0, 25, Short.MAX_VALUE))
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

        Menu.add(btn_EmployeesP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 120, -1));

        btn_servicesP.setBackground(new java.awt.Color(23, 35, 51));
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
                .addGap(0, 40, Short.MAX_VALUE))
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

        Menu.add(btn_servicesP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 120, -1));

        btn_settings.setBackground(new java.awt.Color(23, 35, 51));
        btn_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_settingsMouseReleased(evt);
            }
        });

        ind_settings.setOpaque(false);
        ind_settings.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_settingsLayout = new javax.swing.GroupLayout(ind_settings);
        ind_settings.setLayout(ind_settingsLayout);
        ind_settingsLayout.setHorizontalGroup(
            ind_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_settingsLayout.setVerticalGroup(
            ind_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Settings");

        javax.swing.GroupLayout btn_settingsLayout = new javax.swing.GroupLayout(btn_settings);
        btn_settings.setLayout(btn_settingsLayout);
        btn_settingsLayout.setHorizontalGroup(
            btn_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_settingsLayout.createSequentialGroup()
                .addComponent(ind_settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel20)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        btn_settingsLayout.setVerticalGroup(
            btn_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_settingsLayout.createSequentialGroup()
                .addComponent(ind_settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_settingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(btn_settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 120, -1));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 590));

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

        javax.swing.GroupLayout Menu2Layout = new javax.swing.GroupLayout(Menu2);
        Menu2.setLayout(Menu2Layout);
        Menu2Layout.setHorizontalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu2Layout.createSequentialGroup()
                .addContainerGap(747, Short.MAX_VALUE)
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

        getContentPane().add(Menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 950, 50));

        Menu3.setBackground(new java.awt.Color(192, 192, 192));

        jPanel4.setBackground(new java.awt.Color(23, 35, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(71, 120, 197));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Contacts_25px.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Calendar_25px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Lock_25px.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Secured_Letter_25px_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel15)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(40, 40, 40))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, -1, 130));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Exit_25px.png"))); // NOI18N
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        jPanel4.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 24, -1, 46));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/iconfinder_27-man_4715001.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("User");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/planet.png"))); // NOI18N

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

        javax.swing.GroupLayout Menu3Layout = new javax.swing.GroupLayout(Menu3);
        Menu3.setLayout(Menu3Layout);
        Menu3Layout.setHorizontalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Menu3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_records, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Menu3Layout.setVerticalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_records, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel5)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(Menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 300, 540));

        MenuApresentacao.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MenuApresentacaoLayout = new javax.swing.GroupLayout(MenuApresentacao);
        MenuApresentacao.setLayout(MenuApresentacaoLayout);
        MenuApresentacaoLayout.setHorizontalGroup(
            MenuApresentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        MenuApresentacaoLayout.setVerticalGroup(
            MenuApresentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(MenuApresentacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 650, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        
        setColor(btn_home); 
        ind_home.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,btn_users,btn_profile,btn_customersP,btn_EmployeesP,btn_servicesP,btn_settings}, new JPanel[]{ind_products,ind_users, ind_profile,ind_customers, ind_employees,ind_services,ind_settings, ind_records});
        
    }//GEN-LAST:event_btn_homeMousePressed

    private void btn_usersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usersMousePressed
        
         setColor(btn_users); 
        ind_users.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,btn_home,btn_profile,btn_customersP,btn_EmployeesP,btn_servicesP,btn_settings, btn_records}, new JPanel[]{ind_products,ind_home, ind_profile,ind_customers, ind_employees,ind_services,ind_settings, ind_records});
        
    }//GEN-LAST:event_btn_usersMousePressed

    private void btn_profileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_profileMousePressed
        
        setColor(btn_profile); 
        ind_profile.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,btn_users,btn_home,btn_customersP,btn_EmployeesP,btn_servicesP,btn_settings, btn_records}, new JPanel[]{ind_products,ind_users, ind_home,ind_customers, ind_employees,ind_services,ind_settings, ind_records});
            
    }//GEN-LAST:event_btn_profileMousePressed

    private void btn_productsPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productsPMouseReleased
        
        setColor(btn_productsP); 
        ind_products.setOpaque(true);
        resetColor(new JPanel[]{btn_home,btn_users,btn_profile,btn_customersP,btn_EmployeesP,btn_servicesP,btn_settings, btn_records}, new JPanel[]{ind_home,ind_users, ind_profile,ind_customers, ind_employees,ind_services,ind_settings, ind_records});
        
    }//GEN-LAST:event_btn_productsPMouseReleased

    int xx,xy;
    
    private void Menu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MousePressed
        
        xx = evt.getX();
        xy = evt.getY();
        
    }//GEN-LAST:event_Menu2MousePressed

    private void Menu2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseDragged
        
        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
        
    }//GEN-LAST:event_Menu2MouseDragged

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        
        System.exit(0);
        
    }//GEN-LAST:event_btn_exitMousePressed

    private void btn_customersPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customersPMouseReleased
        
        setColor(btn_customersP); 
        ind_customers.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,btn_users,btn_profile,btn_home,btn_EmployeesP,btn_servicesP,btn_settings, btn_records}, new JPanel[]{ind_products,ind_users, ind_profile,ind_home, ind_employees,ind_services,ind_settings, ind_records});
    }//GEN-LAST:event_btn_customersPMouseReleased

    private void btn_EmployeesPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmployeesPMouseReleased
        setColor(btn_EmployeesP); 
        ind_employees.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,btn_users,btn_profile,btn_home,btn_customersP,btn_servicesP,btn_settings, btn_records}, new JPanel[]{ind_products,ind_users, ind_profile,ind_home, ind_customers,ind_services,ind_settings, ind_records});
    }//GEN-LAST:event_btn_EmployeesPMouseReleased

    private void btn_servicesPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_servicesPMouseReleased
        setColor(btn_servicesP); 
        ind_services.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,btn_users,btn_profile,btn_home,btn_EmployeesP,btn_customersP,btn_settings, btn_records}, new JPanel[]{ind_products,ind_users, ind_profile,ind_home, ind_employees,ind_customers,ind_settings, ind_records});
    }//GEN-LAST:event_btn_servicesPMouseReleased

    private void btn_settingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_settingsMouseReleased
        setColor(btn_settings); 
        ind_settings.setOpaque(true);
        resetColor(new JPanel[]{btn_productsP,btn_users,btn_profile,btn_home,btn_EmployeesP,btn_customersP,btn_servicesP, btn_records}, new JPanel[]{ind_products,ind_users, ind_profile,ind_home, ind_employees,ind_customers,ind_services, ind_records});
    }//GEN-LAST:event_btn_settingsMouseReleased

    private void btn_recordsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recordsMouseReleased
        
        setColor(btn_records); 
        
        resetColor(new JPanel[]{btn_productsP,btn_users,btn_profile,btn_home,btn_EmployeesP,btn_customersP,btn_servicesP,btn_settings}, new JPanel[]{ind_products,ind_users, ind_profile,ind_home, ind_employees,ind_customers,ind_services, ind_settings});
        
        TelaRegistros registro = new TelaRegistros();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_recordsMouseReleased

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
   
    
    private void setColor(JPanel pane)
    {
        pane.setBackground(new Color(41,57,80));
    }
    
    private void resetColor(JPanel [] pane, JPanel [] indicators)
    {
        for(int i=0;i<pane.length;i++){
            
           pane[i].setBackground(new Color(23,35,51));
           
        } for(int i=0;i<indicators.length;i++){
            
           indicators[i].setOpaque(false);           
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Menu2;
    private javax.swing.JPanel Menu3;
    private javax.swing.JPanel MenuApresentacao;
    private javax.swing.JPanel btn_EmployeesP;
    private javax.swing.JPanel btn_customersP;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_productsP;
    private javax.swing.JPanel btn_profile;
    private javax.swing.JPanel btn_records;
    private javax.swing.JPanel btn_servicesP;
    private javax.swing.JPanel btn_settings;
    private javax.swing.JPanel btn_users;
    private javax.swing.JPanel ind_customers;
    private javax.swing.JPanel ind_employees;
    private javax.swing.JPanel ind_home;
    private javax.swing.JPanel ind_products;
    private javax.swing.JPanel ind_profile;
    private javax.swing.JPanel ind_records;
    private javax.swing.JPanel ind_services;
    private javax.swing.JPanel ind_settings;
    private javax.swing.JPanel ind_users;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
