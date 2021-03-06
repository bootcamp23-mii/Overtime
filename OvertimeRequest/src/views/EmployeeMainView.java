/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.OvertimeController;
import controllers.OvertimeControllerInterface;
import controllers.TimeSheetController;
import controllers.TimeSheetControllerInterface;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import models.Employee;
import models.Overtime;
import models.Sessions;
import models.TimeSheet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import tools.HibernateUtil;

/**
 *
 * @author AdhityaWP
 */
public class EmployeeMainView extends javax.swing.JInternalFrame {

    DefaultTableModel myTableModel = new DefaultTableModel();

    /**
     * Creates new form ManagerView
     */
    SessionFactory factory = HibernateUtil.getSessionFactory();
    DefaultTableModel myTable = new DefaultTableModel();
    OvertimeControllerInterface oc = new OvertimeController(factory);
    String id = Sessions.getId();
    TimeSheetControllerInterface tc = new TimeSheetController(factory);
    EmployeeControllerInterface ec = new EmployeeController(factory);
    JasperReport JasRep;
    JasperPrint JasPri;
    Map param = new HashMap();
    JasperDesign JasDes;
    Connection c;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
    private TableRowSorter tabsorter;

    public EmployeeMainView() {
        initComponents();
        System.out.println(id);
        List a = ec.getById(id).getTimeSheetList();
        Employee u = ec.getById(id);
        lblNik.setText(u.getId());
        lblUsername.setText(u.getName());
        lblManager.setText("Manager: " + u.getManager().getName());
        tableData(a);
        hideCol();
        setukuran();
        pmMonth.setToolTipText("MM");
        if (!u.getRoleList().get(0).getJob().getId().equals("J01")) {
            jMenuItem3.setEnabled(false);
        }

    }

    private void setukuran() {
        this.setSize(670, 510);
    }

    private int sum() {
        Date ys = new Date(); // membuat oject ys dari class Date
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        DefaultTableModel dataModel = (DefaultTableModel) tbEmployee.getModel();
        int jumlah = dataModel.getRowCount();
        int sumDurasi = 0;

        for (int i = 0; i < jumlah; i++) {
            int dataBerat = Integer.valueOf(dataModel.getValueAt(i, 3).toString());
            sumDurasi += dataBerat;

        }
        return sumDurasi;
    }

    private void tableData(List<TimeSheet> ts) {
//        jobs = jc.getAll();
        Object[] columnNames = {"Nomor", "id", "Overtime Date", "Duration", "Status"};

        Object[][] data = new Object[ts.size()][columnNames.length];

        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = ts.get(i).getId();
            for (Object obj : tc.getByid(ts.get(i).getId()).getOvertimeList()) {
                Overtime overtime = (Overtime) obj;
                data[i][2] = dateFormat.format(overtime.getOvertimeDate());
                data[i][3] = overtime.getTimeDuration();
                data[i][4] = overtime.getStatus().getStatus();
            }
        }
        myTable = new DefaultTableModel(data, columnNames);
        tbEmployee.setModel(myTable);
    }

    private void hideCol() {
        tbEmployee.getColumnModel().getColumn(1).setMinWidth(0);
        tbEmployee.getColumnModel().getColumn(1).setMaxWidth(0);

        tbEmployee.doLayout();
    }

    private void tableData2(List<TimeSheet> ts) {
//        jobs = jc.getAll();

        Object[] columnNames = {"Nomor", "Id", "Overtime Date", "Duration", "Status"};

        Object[][] data = new Object[ts.size()][columnNames.length];

        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = ts.get(i).getId();
            for (Object obj : tc.getByid(ts.get(i).getId()).getOvertimeList()) {
                Overtime overtime = (Overtime) obj;
                data[i][2] = overtime.getOvertimeDate();
                data[i][3] = overtime.getTimeDuration();
                data[i][4] = overtime.getStatus();
//      

            }
        }
        myTable = new DefaultTableModel(data, columnNames);
        tbEmployee.setModel(myTable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnManagerMain = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblSubTitle = new javax.swing.JLabel();
        spMain = new javax.swing.JSeparator();
        pnUser = new javax.swing.JPanel();
        lblNik = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblManager = new javax.swing.JLabel();
        spTableManager = new javax.swing.JScrollPane();
        tbEmployee = new javax.swing.JTable();
        btReport = new javax.swing.JButton();
        btOtReport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pmMonth = new javax.swing.JTextField();
        jMonth = new com.toedter.calendar.JMonthChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        miManager = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setClosable(true);
        setTitle("Employee Main");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnManagerMain.setBackground(new java.awt.Color(199, 220, 236));
        pnManagerMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        lblTitle.setText("OVERTIME REQUEST");
        pnManagerMain.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 25, -1, -1));

        lblSubTitle.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSubTitle.setText("Mitra Integrasi Informatika");
        pnManagerMain.add(lblSubTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 33, -1, -1));
        pnManagerMain.add(spMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 64, 689, 11));

        pnUser.setBackground(new java.awt.Color(199, 200, 239));

        lblNik.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        lblNik.setText("NIK");

        lblUsername.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblUsername.setText("Username");

        lblManager.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblManager.setText("Manager");

        javax.swing.GroupLayout pnUserLayout = new javax.swing.GroupLayout(pnUser);
        pnUser.setLayout(pnUserLayout);
        pnUserLayout.setHorizontalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnUserLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnUserLayout.createSequentialGroup()
                        .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNik, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblManager))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnUserLayout.setVerticalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNik, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblManager)
                .addContainerGap())
        );

        pnManagerMain.add(pnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 86, 210, -1));

        tbEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmployeeMouseClicked(evt);
            }
        });
        spTableManager.setViewportView(tbEmployee);

        pnManagerMain.add(spTableManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 630, 130));

        btReport.setText("Request Overtime");
        btReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReportActionPerformed(evt);
            }
        });
        pnManagerMain.add(btReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 140, 33));

        btOtReport.setText("Report");
        btOtReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOtReportActionPerformed(evt);
            }
        });
        pnManagerMain.add(btOtReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 70, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Show Overtime Report");
        pnManagerMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        pmMonth.setToolTipText("MM");
        pmMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pmMonthFocusGained(evt);
            }
        });
        pmMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pmMonthKeyTyped(evt);
            }
        });
        pnManagerMain.add(pmMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 70, 30));

        jMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMonthMouseClicked(evt);
            }
        });
        pnManagerMain.add(jMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        getContentPane().add(pnManagerMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 655, 384));

        miManager.setText("MENU");

        jMenuItem2.setText("Profile");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        miManager.add(jMenuItem2);

        jMenuItem3.setText("Review Overtime");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        miManager.add(jMenuItem3);

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        miManager.add(jMenuItem1);

        jMenuBar1.add(miManager);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReportActionPerformed
        // TODO add your handling code here:
//        if(sum()>=20){
//            JOptionPane
//        }
        this.setVisible(false);
        OvertimeReportView op = new OvertimeReportView();
        this.getParent().add(op);
        op.setVisible(true);
    }//GEN-LAST:event_btReportActionPerformed

    private void tbEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmployeeMouseClicked
        // TODO add your handling code here:
        if (tbEmployee.getSelectedColumnCount() == 1) {
            int row = tbEmployee.getSelectedRow();
            Sessions.setIdtab(tbEmployee.getValueAt(row, 1).toString());
            this.setVisible(false);
            OvertimeReportView op = new OvertimeReportView();
            this.getParent().add(op);
            op.setVisible(true);
        }
    }//GEN-LAST:event_tbEmployeeMouseClicked

    private void btOtReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOtReportActionPerformed
        // TODO add your handling code here:
        System.out.println(jMonth.getMonth());

        param.put("id", id);
        param.put("pmMonth", String.valueOf(jMonth.getMonth() + 1));
        try {
            c = factory.
                    getSessionFactoryOptions().getServiceRegistry().
                    getService(ConnectionProvider.class).getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerMainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String fileName = "./src/report/report1.jrxml";
            String filetoFill = "./src/report/report1.jasper";
            JasperCompileManager.compileReport(fileName);
            JasPri = JasperFillManager.fillReport(filetoFill, param, c);
            JasperViewer.viewReport(JasPri, false);

        } catch (JRException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btOtReportActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        LoginView lv = new LoginView();
        this.getParent().add(lv);
        lv.setVisible(true);
        Sessions.setId("");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMonthMouseClicked
        // TODO add your handling code here:
        System.out.println(String.valueOf(jMonth.getMonth()));
    }//GEN-LAST:event_jMonthMouseClicked

    private void pmMonthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pmMonthKeyTyped
        // TODO add your handling code here:
        pmMonth.setToolTipText("MM");
    }//GEN-LAST:event_pmMonthKeyTyped

    private void pmMonthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pmMonthFocusGained
        // TODO add your handling code here:
        pmMonth.setToolTipText("abcdefgg");
    }//GEN-LAST:event_pmMonthFocusGained

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Profile pf = new Profile();
        this.getParent().add(pf);
        pf.setVisible(true);
        Sessions.setId("");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ManagerMainView mv = new ManagerMainView();
        this.getParent().add(mv);
        mv.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOtReport;
    private javax.swing.JButton btReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private com.toedter.calendar.JMonthChooser jMonth;
    private javax.swing.JLabel lblManager;
    private javax.swing.JLabel lblNik;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenu miManager;
    private javax.swing.JTextField pmMonth;
    private javax.swing.JPanel pnManagerMain;
    private javax.swing.JPanel pnUser;
    private javax.swing.JSeparator spMain;
    private javax.swing.JScrollPane spTableManager;
    private javax.swing.JTable tbEmployee;
    // End of variables declaration//GEN-END:variables

}
