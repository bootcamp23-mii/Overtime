/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AdhityaWP
 */
public class ManagerMainView extends javax.swing.JInternalFrame {
    DefaultTableModel myTableModel = new DefaultTableModel();

    /**
     * Creates new form ManagerView
     */
    public ManagerMainView() {
        initComponents();
    }
    
    private void tableData(List<models.TimeSheet> timesheet) {
        Object[] columnNames = {"ID", "Time Sheet", "Name", "Employee"};
        Object[][] data = new Object[timesheet.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = timesheet.get(i).getId();
            data[i][2] = timesheet.get(i).getTimeSheetDate();
            data[i][3] = timesheet.get(i).getName();
            data[i][4] = timesheet.get(i).getEmployee().getName();

        }
        myTableModel = new DefaultTableModel(data, columnNames);
        tbManager.setModel(myTableModel);
        
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
        spTableManager = new javax.swing.JScrollPane();
        tbManager = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        miManager = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setClosable(true);
        setTitle("Manager Main");

        pnManagerMain.setBackground(new java.awt.Color(199, 220, 236));

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        lblTitle.setText("OVERTIME REQUEST");

        lblSubTitle.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSubTitle.setText("Mitra Integrasi Informatika");

        pnUser.setBackground(new java.awt.Color(199, 200, 239));

        lblNik.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        lblNik.setText("NIK");

        lblUsername.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblUsername.setText("Username");

        javax.swing.GroupLayout pnUserLayout = new javax.swing.GroupLayout(pnUser);
        pnUser.setLayout(pnUserLayout);
        pnUserLayout.setHorizontalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(lblNik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnUserLayout.setVerticalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNik, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbManager.setModel(new javax.swing.table.DefaultTableModel(
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
        spTableManager.setViewportView(tbManager);

        javax.swing.GroupLayout pnManagerMainLayout = new javax.swing.GroupLayout(pnManagerMain);
        pnManagerMain.setLayout(pnManagerMainLayout);
        pnManagerMainLayout.setHorizontalGroup(
            pnManagerMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnManagerMainLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(pnManagerMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnManagerMainLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(38, 38, 38)
                        .addComponent(lblSubTitle)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnManagerMainLayout.createSequentialGroup()
                        .addComponent(pnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(pnManagerMainLayout.createSequentialGroup()
                .addComponent(spMain)
                .addContainerGap())
            .addComponent(spTableManager)
        );
        pnManagerMainLayout.setVerticalGroup(
            pnManagerMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnManagerMainLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnManagerMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubTitle)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spMain, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(spTableManager, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        miManager.setText("MENU");

        jMenuItem1.setText("jMenuItem1");
        miManager.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        miManager.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        miManager.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        miManager.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        miManager.add(jMenuItem5);

        jMenuBar1.add(miManager);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnManagerMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnManagerMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JLabel lblNik;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenu miManager;
    private javax.swing.JPanel pnManagerMain;
    private javax.swing.JPanel pnUser;
    private javax.swing.JSeparator spMain;
    private javax.swing.JScrollPane spTableManager;
    private javax.swing.JTable tbManager;
    // End of variables declaration//GEN-END:variables
}