/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.DivisionController;
import controllers.DivisionControllerInterface;
import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.OvertimeController;
import controllers.OvertimeControllerInterface;
import controllers.RoleController;
import controllers.RoleControllerInterface;
import controllers.SiteController;
import controllers.SiteControllerInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Division;
import models.Employee;
import models.Role;
import models.Site;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author milhamafemi
 */
public class AdminView extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private DefaultTableModel tableModelRole = new DefaultTableModel();
    private DefaultTableModel tableModelEmp = new DefaultTableModel();
    private OvertimeControllerInterface oci = new OvertimeController(sessionFactory);
    private RoleControllerInterface rci = new RoleController(sessionFactory);
    private EmployeeControllerInterface eci = new EmployeeController(sessionFactory);
    private List<Site> sites = new ArrayList<>();
    private DivisionControllerInterface dci= new DivisionController(sessionFactory);
    private SiteControllerInterface sci= new SiteController(sessionFactory);
    private List<Division> divisions = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    /**
     * Creates new form AdminView
     */
    public AdminView() {
        initComponents();
        tableDataRole(rci.getAll());
        panelNewUser.setVisible(false);
        panelRole.setVisible(true);
    }

    private void tableDataRole(List<Role> role) {
        Object[] columnNames = {"No", "ID", "Employee Name", "Job", "Role"};
        Object[][] data = new Object[role.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = role.get(i).getId();
            data[i][2] = role.get(i).getEmployee().getName();
            data[i][3] = role.get(i).getJob().getPosition();
            data[i][4] = role.get(i).getName();
        }
        tableModelRole = new DefaultTableModel(data, columnNames);
        tbUser.setModel(tableModelRole);
    }

    private void tableDataEmp(List<Employee> emp) {
        Object[] columnNames = {"No", "ID", "Name", "Address", "Email", "Manager id", "Salary", "Site", "Division"};
        Object[][] data = new Object[emp.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = emp.get(i).getId();
            data[i][2] = emp.get(i).getName();
            data[i][3] = emp.get(i).getAddress();
            data[i][4] = emp.get(i).getEmail();
            data[i][5] = emp.get(i).getManager();
            data[i][6] = emp.get(i).getSalary();
            if (emp.get(i).getSite().getName() != null) {
                data[i][7] = emp.get(i).getSite().getName() + "";
            } else {
                data[i][7] = "";
            }
            if (emp.get(i).getDivision().getName() != null) {
                data[i][8] = emp.get(i).getDivision().getName() + "";
            } else {
                data[i][8] = "";
            }

        }
        tableModelEmp = new DefaultTableModel(data, columnNames);
        tbEmp.setModel(tableModelEmp);
    }

    private boolean isEmpty() {
        return eci.getData(tfEmpId.getText()).isEmpty();
    }

//    private void setComboBox() {
//        for (Site site : sites) {
//            cbSite.addItem(site.getId() + " - " + site.getName());
//        }
//        for (Division division : divisions) {
//            cbDivision.addItem(division.getId() + " - " + division.getName());
//        }
//    }

    private void showSite() {
        for (Site site : sites) {
            cbSite.addItem(site.getId()+" - "+site.getName());
        }
    }

    private void showDivision() {
        for (Division division : divisions) {
            cbDivision.addItem(division.getId()+" - "+division.getName());
        }
    }

    private boolean confirmation() {
        if (tfEmpId.getText().equals("")
                || tfEmpName.getText().equals("")
                || tfEmpAdrress.getText().equals("")
                || tfEmpMail.getText().equals("")
                || tfEmpManagerId.getText().equals("")
                || tfEmpSal.getText().equals("")
                || cbSite.getSelectedIndex() == 0
                || cbDivision.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please fill all text field");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRole = new javax.swing.JPanel();
        tfJob = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btClear = new javax.swing.JButton();
        scrlUser = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        btDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btFind = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfRole = new javax.swing.JTextField();
        panelNewUser = new javax.swing.JPanel();
        scrlEmp = new javax.swing.JScrollPane();
        tbEmp = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfEmpId = new javax.swing.JTextField();
        tfEmpName = new javax.swing.JTextField();
        tfEmpAdrress = new javax.swing.JTextField();
        tfEmpMail = new javax.swing.JTextField();
        tfEmpSal = new javax.swing.JTextField();
        tfEmpManagerId = new javax.swing.JTextField();
        cbSite = new javax.swing.JComboBox<>();
        cbDivision = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btClearEmp = new javax.swing.JButton();
        btDeleteEmp = new javax.swing.JButton();
        btSearchEmp = new javax.swing.JButton();
        tfSearchEmp = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miHome = new javax.swing.JMenuItem();
        miInsertUser = new javax.swing.JMenuItem();
        miAbout = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setBackground(new java.awt.Color(199, 220, 236));

        panelRole.setBackground(new java.awt.Color(199, 220, 236));

        tfJob.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel1.setText("Id");

        tfName.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel4.setText("Role");

        lblSearch.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        lblSearch.setText("Search User");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel3.setText("Job");

        btClear.setBackground(new java.awt.Color(128, 137, 149));
        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Id", "Name", "Job", "Role"
            }
        ));
        tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
        scrlUser.setViewportView(tbUser);

        btDelete.setBackground(new java.awt.Color(128, 137, 149));
        btDelete.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel2.setText("Name");

        btFind.setBackground(new java.awt.Color(128, 137, 149));
        btFind.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        btFind.setText("Find");
        btFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindActionPerformed(evt);
            }
        });

        btSave.setBackground(new java.awt.Color(128, 137, 149));
        btSave.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText("User Access Setting");

        tfRole.setEditable(false);

        javax.swing.GroupLayout panelRoleLayout = new javax.swing.GroupLayout(panelRole);
        panelRole.setLayout(panelRoleLayout);
        panelRoleLayout.setHorizontalGroup(
            panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRoleLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrlUser, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRoleLayout.createSequentialGroup()
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSearch)
                                .addComponent(jLabel5))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelRoleLayout.createSequentialGroup()
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRoleLayout.createSequentialGroup()
                                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfRole)
                                .addComponent(tfJob)
                                .addComponent(tfName)
                                .addComponent(tfId)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoleLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(tfSearch)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btFind, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap()))
        );
        panelRoleLayout.setVerticalGroup(
            panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRoleLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrlUser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(panelRoleLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btSave)
                                .addComponent(btDelete))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblSearch)
                            .addGap(9, 9, 9)
                            .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btFind))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btClear)
                            .addGap(0, 83, Short.MAX_VALUE)))
                    .addContainerGap()))
        );

        panelNewUser.setBackground(new java.awt.Color(199, 220, 236));
        panelNewUser.setForeground(new java.awt.Color(199, 220, 236));

        scrlEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrlEmpMouseClicked(evt);
            }
        });

        tbEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Id", "Name", "Address", "Email", "Manager Id", "Salary", "Site", "Division"
            }
        ));
        tbEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpMouseClicked(evt);
            }
        });
        scrlEmp.setViewportView(tbEmp);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel6.setText("Id");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel7.setText("Name");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel8.setText("Address");

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel9.setText("E-mail");

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel10.setText("Manager Id");

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel11.setText("Salary");

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel12.setText("Site");

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel13.setText("Division");

        tfEmpMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmpMailActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(128, 137, 149));
        jButton1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btClearEmp.setBackground(new java.awt.Color(128, 137, 149));
        btClearEmp.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        btClearEmp.setText("Clear");
        btClearEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearEmpActionPerformed(evt);
            }
        });

        btDeleteEmp.setBackground(new java.awt.Color(128, 137, 149));
        btDeleteEmp.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        btDeleteEmp.setText("Delete");
        btDeleteEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteEmpActionPerformed(evt);
            }
        });

        btSearchEmp.setBackground(new java.awt.Color(128, 137, 149));
        btSearchEmp.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        btSearchEmp.setText("Search");
        btSearchEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNewUserLayout = new javax.swing.GroupLayout(panelNewUser);
        panelNewUser.setLayout(panelNewUserLayout);
        panelNewUserLayout.setHorizontalGroup(
            panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNewUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlEmp)
                    .addGroup(panelNewUserLayout.createSequentialGroup()
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfEmpSal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelNewUserLayout.createSequentialGroup()
                                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelNewUserLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelNewUserLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfEmpAdrress, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelNewUserLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(49, 49, 49)
                                        .addComponent(tfEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNewUserLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelNewUserLayout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btDeleteEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tfEmpMail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelNewUserLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfEmpManagerId, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbSite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbDivision, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelNewUserLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btClearEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 145, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNewUserLayout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(tfSearchEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearchEmp)))
                .addContainerGap())
        );
        panelNewUserLayout.setVerticalGroup(
            panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNewUserLayout.createSequentialGroup()
                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNewUserLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNewUserLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(tfEmpManagerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(tfEmpSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(tfEmpAdrress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(tfEmpMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(cbDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelNewUserLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btSearchEmp)
                                    .addComponent(tfSearchEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelNewUserLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(btDeleteEmp)
                                    .addComponent(btClearEmp))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(scrlEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        miHome.setText("Home");
        miHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHomeActionPerformed(evt);
            }
        });
        jMenu1.add(miHome);

        miInsertUser.setText("Insert New User");
        miInsertUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInsertUserActionPerformed(evt);
            }
        });
        jMenu1.add(miInsertUser);

        miAbout.setText("About");
        miAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutActionPerformed(evt);
            }
        });
        jMenu1.add(miAbout);

        jMenuItem4.setText("Log Out");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindActionPerformed
        String key = tfSearch.getText();
        tableDataRole(rci.search(key));
    }//GEN-LAST:event_btFindActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        if (tfSearch.equals("")) {
            JOptionPane.showMessageDialog(null, "Fill Empty Data Please !");
        } else {
            try {
                int reply = JOptionPane.showConfirmDialog(null,
                        "Are sure save the data?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
                );
                if (reply == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, rci.saveRoleId(tfId.getText()));
                    tfSearch.setText("");
                    tableDataRole(rci.getAll());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //        tableData(role);
    }//GEN-LAST:event_btSaveActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUserMouseClicked
        // TODO add your handling code here:
        tfId.setText(tbUser.getValueAt(tbUser.getSelectedRow(), 1).toString());
        tfName.setText(tbUser.getValueAt(tbUser.getSelectedRow(), 2).toString());
        tfJob.setText(tbUser.getValueAt(tbUser.getSelectedRow(), 3).toString());
        tfRole.setText(tbUser.getValueAt(tbUser.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tbUserMouseClicked

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        tfId.setText("");
        tfJob.setText("");
        tfName.setText("");
        tfRole.setText("");
        tfSearch.setText("");
        tfId.setEnabled(true);
        tableDataRole(rci.getAll());
    }//GEN-LAST:event_btClearActionPerformed

    private void miInsertUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInsertUserActionPerformed
        // TODO add your handling code here:

        panelRole.setVisible(false);
        panelNewUser.setVisible(true);
        tableDataEmp(eci.getAll());
        showDivision();
        showSite();
//        setComboBox();


    }//GEN-LAST:event_miInsertUserActionPerformed

    private void tfEmpMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmpMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmpMailActionPerformed

    private void btClearEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearEmpActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btClearEmpActionPerformed

    public void clear() {
        tfEmpAdrress.setText("");
        tfEmpId.setText("");
        tfEmpMail.setText("");
        tfEmpManagerId.setText("");
        tfEmpName.setText("");
        tfEmpSal.setText("");
        cbDivision.setSelectedIndex(0);
        cbSite.setSelectedIndex(0);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (confirmation()) {
            if (isEmpty()) {
                JOptionPane.showMessageDialog(null, eci.insertOrUpdate(tfEmpId.getText(), tfEmpName.getText(),
                        tfEmpAdrress.getText(), tfEmpMail.getText(), tfEmpSal.getText(), tfEmpManagerId.getText(),
                        cbSite.getSelectedItem().toString().split(" - ")[0], cbDivision.getSelectedItem().toString().split(" - ")[0]));
                clear();
            } else {
                try {
                    int reply = JOptionPane.showConfirmDialog(null,
                            "Anda yakin akan melakukan perubahan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
                    );
                    if (reply == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, eci.insertOrUpdate(tfEmpId.getText(), tfEmpName.getText(),
                                tfEmpAdrress.getText(), tfEmpMail.getText(), tfEmpSal.getText(), tfEmpManagerId.getText(),
                                cbSite.getSelectedItem().toString().split(" - ")[0], cbDivision.getSelectedItem().toString().split(" - ")[0]));
                        clear();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            tableDataEmp(eci.getAll());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void scrlEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrlEmpMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_scrlEmpMouseClicked

    private void btDeleteEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteEmpActionPerformed
        // TODO add your handling code here:
        if (tfSearchEmp.equals("")) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
        } else {
            try {
                int reply = JOptionPane.showConfirmDialog(null,
                        "Are you sure to delete data?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
                );
                if (reply == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, eci.insertOrUpdate(tfEmpId.getText(), tfEmpName.getText(),
                            tfEmpAdrress.getText(), tfEmpMail.getText(), tfEmpSal.getText(), tfEmpManagerId.getText(),
                            cbSite.getSelectedItem().toString().split(" - ")[0], cbDivision.getSelectedItem().toString().split(" - ")[0]));
                    tfSearchEmp.setText("");
                    tableDataEmp(eci.getAll());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tableDataEmp(eci.getAll());

    }//GEN-LAST:event_btDeleteEmpActionPerformed

    private void tbEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpMouseClicked
        // TODO add your handling code here:
        tfEmpId.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 1).toString());
        tfEmpName.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 2).toString());
        tfEmpAdrress.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 3).toString());
        tfEmpMail.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 4).toString());
        if ((tbEmp.getValueAt(tbEmp.getSelectedRow(), 5) == null)) {
            tfEmpManagerId.setText("");
        } else {
            tfEmpManagerId.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 5).toString());
        }

        tfEmpSal.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 6).toString());
        for (int i = 0; i < cbSite.getItemCount(); i++) {
            if (cbSite.getItemAt(i).split(" - ")[0].equals(tbEmp.getValueAt(tbEmp.getSelectedRow(), 7).toString())) {
                cbSite.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < cbDivision.getItemCount(); i++) {
            if (cbDivision.getItemAt(i).split(" - ")[0].equals(tbEmp.getValueAt(tbEmp.getSelectedRow(), 8).toString())) {
                cbDivision.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tbEmpMouseClicked

    private void btSearchEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchEmpActionPerformed
        // TODO add your handling code here:
        tableDataEmp(eci.getData(tfSearchEmp.getText()));
    }//GEN-LAST:event_btSearchEmpActionPerformed

    private void miHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHomeActionPerformed
        // TODO add your handling code here:
        panelNewUser.setVisible(false);
        panelRole.setVisible(true);
    }//GEN-LAST:event_miHomeActionPerformed

    private void miAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Application for Overtime Request", "About", HEIGHT);
    }//GEN-LAST:event_miAboutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btClearEmp;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btDeleteEmp;
    private javax.swing.JButton btFind;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearchEmp;
    private javax.swing.JComboBox<String> cbDivision;
    private javax.swing.JComboBox<String> cbSite;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JMenuItem miAbout;
    private javax.swing.JMenuItem miHome;
    private javax.swing.JMenuItem miInsertUser;
    private javax.swing.JPanel panelNewUser;
    private javax.swing.JPanel panelRole;
    private javax.swing.JScrollPane scrlEmp;
    private javax.swing.JScrollPane scrlUser;
    private javax.swing.JTable tbEmp;
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField tfEmpAdrress;
    private javax.swing.JTextField tfEmpId;
    private javax.swing.JTextField tfEmpMail;
    private javax.swing.JTextField tfEmpManagerId;
    private javax.swing.JTextField tfEmpName;
    private javax.swing.JTextField tfEmpSal;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfJob;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfRole;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSearchEmp;
    // End of variables declaration//GEN-END:variables
}
