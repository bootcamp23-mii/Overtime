/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.OvertimeController;
import controllers.RoleController;
import controllers.RoleControllerInterface;
import controllers.TimeSheetController;
import controllers.UserController;
import controllers.UserControllerInterface;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Employee;
import models.Sessions;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author AdhityaWP
 */
public class LoginView extends javax.swing.JInternalFrame {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    SessionFactory factory = HibernateUtil.getSessionFactory();
    DefaultTableModel myTable = new DefaultTableModel();
    UserControllerInterface uc = new UserController(factory);
    EmployeeControllerInterface ec = new EmployeeController(factory);
    RoleControllerInterface rc = new RoleController(factory);
        

    /**
     * Creates new form RegisterView
     */
    public LoginView() {
        initComponents();
//        getMiddle();
    }
    
//    private void getMiddle() {
//       int frameWidth = ((dim.width - this.getSize().width) / 2);
//        int frameHeigth = ((dim.height - this.getSize().height) / 2);
//        this.setLocation(frameWidth, frameHeigth);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLogin = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        spMain = new javax.swing.JSeparator();
        lblSubTitle = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        btCancel = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Register");
        setNormalBounds(new java.awt.Rectangle(0, 0, 120, 0));
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pnLogin.setBackground(new java.awt.Color(199, 220, 236));
        pnLogin.setPreferredSize(new java.awt.Dimension(390, 300));
        pnLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        lblTitle.setText("OVERTIME REQUEST");
        pnLogin.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, -1, 35));
        pnLogin.add(spMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 370, 12));

        lblSubTitle.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSubTitle.setText("Mitra Integrasi Informatika");
        pnLogin.add(lblSubTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 57, -1, 26));

        btLogin.setBackground(new java.awt.Color(128, 137, 149));
        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        pnLogin.add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 247, -1, -1));

        lblUsername.setText("Username");
        pnLogin.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 137, 138, 21));

        lblPassword.setText("Password");
        pnLogin.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 176, 136, 21));
        pnLogin.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 131, 96, -1));

        btCancel.setBackground(new java.awt.Color(128, 137, 149));
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        pnLogin.add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 247, -1, -1));
        pnLogin.add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 176, 96, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        this.hide();
        MainView mv = new MainView();
        mv.setVisible(true);


    }//GEN-LAST:event_btCancelActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
        String pass = "";
        for (char c : tfPassword.getPassword()) {
            pass += c;
        }
        if ((uc.login(tfUsername.getText(), pass))) {
            JOptionPane.showMessageDialog(null, "Login Sukses.");
            this.setVisible(false);
            
            System.out.println(Sessions.getId());
            String x = ec.getById(Sessions.getId()).getRoleList().get(0).getId();
            String u = rc.getByid(x).getJob().getId();
            System.out.println(u);
            if (u.equals("J01")) {
                ManagerMainView mv = new ManagerMainView();
                this.getParent().add(mv);
                mv.setVisible(true);
            } else if (u.equals("J02")) {
                EmployeeMainView ev = new EmployeeMainView();
                this.getParent().add(ev);
                ev.setVisible(true);
            } else {
                AdminView av = new AdminView();
                this.getParent().add(av);
                av.setVisible(true);
            }
//            Employee u = ec.getById(Sessions.getId());
        } else {
            tfUsername.setText("");
            tfPassword.setText("");
            JOptionPane.showMessageDialog(null, "Username atau Password salah.");
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        this.hide();
        MainView mv = new MainView();
        mv.setVisible(true);
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JSeparator spMain;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
