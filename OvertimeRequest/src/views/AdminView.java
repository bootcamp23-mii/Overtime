/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.OvertimeController;
import controllers.OvertimeControllerInterface;
import controllers.RoleController;
import controllers.RoleControllerInterface;
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
    private DefaultTableModel myTableModel = new DefaultTableModel();
    private OvertimeControllerInterface oci = new OvertimeController(sessionFactory);
    private RoleControllerInterface rci = new RoleController(sessionFactory);
    private EmployeeControllerInterface eci = new EmployeeController(sessionFactory);
    private List<Site> sites = new ArrayList<>();
    private List<Division> divisions = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    /**
     * Creates new form AdminView
     */
    public AdminView() {
        initComponents();
        tableData(rci.getAll());
        tableDataEmp(eci.getAll());
        showDivision();
        showSite();
    }
    
    private void tableData(List<Role> role) {
        Object[] columnNames = {"No", "ID", "Employee Name", "Job", "Role"};
        Object[][] data = new Object[role.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = role.get(i).getId();
            data[i][2] = role.get(i).getEmployee().getName();
            data[i][3] = role.get(i).getJob().getPosition();
            data[i][4] = role.get(i).getName();
        }
        myTableModel = new DefaultTableModel(data, columnNames);
        tbUser.setModel(myTableModel);
    }
    
    private void tableDataEmp(List<Employee> emp) {
        Object[] columnNames = {"No", "ID", "Name", "Address", "Email", "Manager id", "Salary",};
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
                data[i][7] = emp.get(i).getSite().getName();
            } else {
                data[i][7] = "";
            }
            if (emp.get(i).getDivision().getName() != null) {
                data[i][8] = emp.get(i).getDivision().getName();
            } else {
                data[i][8] = "";
            }
            
        }
        myTableModel = new DefaultTableModel(data, columnNames);
        tbUser.setModel(myTableModel);
    }
    
    private boolean isEmpty() {
        return eci.getData(tfEmpId.getText()).isEmpty();
    }
    
    private void setComboBox() {
        for (Site site : sites) {
            cbSite.addItem(site.getId() + " - " + site.getName());
        }
        for (Division division : divisions) {
            cbDivision.addItem(division.getId() + " - " + division.getName());
        }
    }
    
    private void showSite() {
        for (Employee employee : employees) {
            if (!sites.contains(employee.getSite())) {
                sites.add(new Site(employee.getId(),
                        employee.getName(), employee.getAddress()));
            }
        }
    }
    
    private void showDivision() {
        for (Employee employee : employees) {
            if (!divisions.contains(employee.getDivision())) {
                divisions.add(new Division(employee.getId(), employee.getName()));
            }
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

        panelNewUser = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
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
        tfRole = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btFind = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btClear = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfJob = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        miInsertUser = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
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
        jScrollPane2.setViewportView(tbEmp);

        jLabel6.setText("Id");

        jLabel7.setText("Name");

        jLabel8.setText("Address");

        jLabel9.setText("E-mail");

        jLabel10.setText("Manager Id");

        jLabel11.setText("Salary");

        jLabel12.setText("Site");

        jLabel13.setText("Division");

        tfEmpMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmpMailActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btClearEmp.setText("Clear");
        btClearEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearEmpActionPerformed(evt);
            }
        });

        btDeleteEmp.setText("Delete");
        btDeleteEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteEmpActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane2)
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
                        .addGap(0, 164, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(199, 220, 236));

        tfRole.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText("User Access Setting");

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

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel2.setText("Name");

        btDelete.setBackground(new java.awt.Color(128, 137, 149));
        btDelete.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
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
        jScrollPane1.setViewportView(tbUser);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel3.setText("Job");

        btClear.setBackground(new java.awt.Color(128, 137, 149));
        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        lblSearch.setText("Search User");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel4.setText("Role");

        tfName.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel1.setText("Id");

        tfJob.setEditable(false);

        jMenu1.setText("Menu");

        jMenuItem2.setText("Home");
        jMenu1.add(jMenuItem2);

        miInsertUser.setText("Insert New User");
        miInsertUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInsertUserActionPerformed(evt);
            }
        });
        jMenu1.add(miInsertUser);

        jMenuItem3.setText("About");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Log Out");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSearch)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfRole)
                            .addComponent(tfJob)
                            .addComponent(tfName)
                            .addComponent(tfId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(tfSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btFind, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSave)
                            .addComponent(btDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btFind))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btClear)
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindActionPerformed
        String key = tfSearch.getText();
        tableData(rci.search(key));
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
                    tableData(rci.getAll());
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
        
        tableData(rci.getAll());
    }//GEN-LAST:event_btClearActionPerformed

    private void miInsertUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInsertUserActionPerformed
        // TODO add your handling code here:
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

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
        tfEmpId.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 1).toString());
        tfEmpName.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 2).toString());
        tfEmpAdrress.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 3).toString());
        tfEmpMail.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 4).toString());
        tfEmpManagerId.setText(tbEmp.getValueAt(tbEmp.getSelectedRow(), 5).toString());
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
    }//GEN-LAST:event_jScrollPane2MouseClicked

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
    }//GEN-LAST:event_tbEmpMouseClicked

    private void btSearchEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchEmpActionPerformed
        // TODO add your handling code here:
        tableDataEmp(eci.getData(tfSearchEmp.getText()));
    }//GEN-LAST:event_btSearchEmpActionPerformed


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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JMenuItem miInsertUser;
    private javax.swing.JPanel panelNewUser;
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
