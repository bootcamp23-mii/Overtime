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
import controllers.ParameterController;
import controllers.ParameterControllerInterface;
import controllers.TaskController;
import controllers.TaskControllerInterface;
import controllers.TimeSheetController;
import controllers.TimeSheetControllerInterface;
import controllers.UploadDBController;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Employee;
import models.Overtime;
import models.Sessions;
import models.Task;
import models.TimeSheet;
import models.UploadDB;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import views.DBConnection;

/**
 *
 * @author milhamafemi
 */
public class OvertimeReportView extends javax.swing.JInternalFrame {

    /**
     * Creates new form OvertimeReportView
     */
    private DBConnection connection = new DBConnection();
//    private SessionFactory factory = HibernateUtil.getSessionFactory();
//    private UploadControllerInterface c = new UploadController(factory);
    private UploadDBController cc = new UploadDBController(connection.getConnection());

//    private List<Upload> list = new ArrayList<>();
    private List<UploadDB> listUp = new ArrayList<>();
    private NewJInternalFrame fc = new NewJInternalFrame();
    SessionFactory factory = HibernateUtil.getSessionFactory();
    OvertimeControllerInterface oc = new OvertimeController(factory);
    ParameterControllerInterface pc = new ParameterController(factory);
    String id = Sessions.getId();
    String idtab = Sessions.getIdtab();
    TimeSheetControllerInterface tc = new TimeSheetController(factory);
    EmployeeControllerInterface ec = new EmployeeController(factory);
    TaskControllerInterface tic = new TaskController(factory);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public OvertimeReportView() {
        setDefaultCondition();
        initComponents();
        setData(idtab);
        Employee e = ec.getById(id);
        tfNik.setText(id);
        tfName.setText(e.getName());
        setukuran();

        if (idtab != "") {
            btDelete.setEnabled(true);
        } else {
            btDelete.setEnabled(false);
            tfNik.setEnabled(true);
            tfName.setEnabled(true);
        }

        jdSatu.setDateFormatString("yyyy-MM-dd");

    }

    private void setDefaultCondition() {

//        list=c.search("14303");
////        list=c.search(Session.getSession());
//        if (!list.isEmpty()){
////            serializable=;
////             System.out.println(list.get(0).getPhoto().toString());
////            blobPhoto = ;
////            try {
////                InputStream in = blobPhoto.getBinaryStream();  
////                BufferedImage image = ImageIO.read(in);
////                lblImage.setIcon(new ImageIcon(image));
////                
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//            
//            byte [] data = list.get(0).getPhoto();
//            BufferedImage image = null;
//            try {
//            image = ImageIO.read(new ByteArrayInputStream(data));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            lblImage.setIcon(new ImageIcon(image));
//        }
    }

    public void uploadToDB(File file) throws FileNotFoundException {
        listUp = cc.seachBy(Sessions.getId());
        if (listUp.isEmpty()) {
            cc.upload(Sessions.getId(), fc.getSelectedFile());
            JOptionPane.showMessageDialog(null, "Upload sukses");
        } else {
            cc.replace(Sessions.getId(), fc.getSelectedFile());
            JOptionPane.showMessageDialog(null, "Upload ganti gambar sukses");
        }

    }

    public void setImagetoLabel(File imageFile) {
//        try {
//            JOptionPane.showMessageDialog(null, imageFile.getAbsolutePath());
//            lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//            lblImage.setIcon(new javax.swing.ImageIcon(imageFile.getAbsolutePath()));
////            lblImage.setIcon(new ImageIcon(image));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }

    private void setukuran() {
        this.setSize(670, 510);
    }

    public void setData(String idTabel) {
        if (idTabel != "") {
            
            
            System.out.println(idtab);
            Employee e = ec.getById(id);
            Task t = tic.getByid(oc.getById(tc.getByid(idtab).getOvertimeList().get(0).getId()).getTaskList().get(0).getId());
            System.out.println(t.getName());
            tfNik.setText(id);
            tfName.setText(e.getName());
            tfTimeDuration.setText((tc.getByid(idtab).getOvertimeList().get(0).getTimeDuration()).toString());
            jdSatu.setDate((tc.getByid(idtab).getOvertimeList().get(0).getOvertimeDate()));
            tfTask.setText(t.getName());
            taDetail.setText(tc.getByid(idtab).getOvertimeList().get(0).getKeterangan());
        }
    }

    public void clear() {
        tfNik.setText("");
        tfName.setText("");
        tfTimeDuration.setText("");
        jdSatu.cleanup();
        tfTask.setText("");
        taDetail.setText("");
    }

    void filterhuruf(KeyEvent a) {
        if (Character.isAlphabetic(a.getKeyChar())) {
            a.consume();
            JOptionPane.showMessageDialog(null, "Pada Kolom Jumlah Hanya Bisa Memasukan Karakter Angka");
        }
    }

    public Date setTanggal() {
        java.util.Date skrg = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return skrg;
    }
    
    public int getMonth(Date a){
            Calendar cal = Calendar.getInstance();
            cal.setTime(a);
            int month = cal.get(Calendar.MONTH);
            return month;
    }
    
    public int getDay(Date a){
            Calendar cal = Calendar.getInstance();
            cal.setTime(a);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            return day;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNik = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfTimeDuration = new javax.swing.JTextField();
        tfTask = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDetail = new javax.swing.JTextArea();
        btSubmit = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jdSatu = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(199, 220, 236));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setText("Overtime Request");

        jLabel2.setFont(new java.awt.Font("Courier New", 2, 12)); // NOI18N
        jLabel2.setText("Mitra Integrasi Informatika");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel3.setText("NIK");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel5.setText("Time Duration");

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setText("Date");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("Task");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("Detail");

        tfNik.setEditable(false);
        tfNik.setForeground(new java.awt.Color(128, 137, 149));
        tfNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNikActionPerformed(evt);
            }
        });

        tfName.setEditable(false);
        tfName.setForeground(new java.awt.Color(128, 137, 149));

        tfTimeDuration.setCaretColor(new java.awt.Color(128, 137, 149));
        tfTimeDuration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTimeDurationKeyTyped(evt);
            }
        });

        taDetail.setColumns(20);
        taDetail.setRows(5);
        jScrollPane1.setViewportView(taDetail);

        btSubmit.setBackground(new java.awt.Color(128, 137, 149));
        btSubmit.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(128, 137, 149));
        btCancel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        jButton1.setText("Upload File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        jdSatu.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jdSatuComponentAdded(evt);
            }
        });
        jdSatu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdSatuMouseClicked(evt);
            }
        });

        jLabel9.setText("Catatan: Overtime hanya bisa diajukan pada bulan yang sama maksimal tanggal 28");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btSubmit)
                                        .addGap(3, 3, 3)
                                        .addComponent(btCancel))
                                    .addComponent(tfTask, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(tfNik, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTimeDuration, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdSatu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTimeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdSatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSubmit)
                    .addComponent(btCancel)
                    .addComponent(jButton1)
                    .addComponent(btDelete))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNikActionPerformed

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        // TODO add your handling code here:

        if (Integer.parseInt(tfTimeDuration.getText()) < Integer.parseInt(pc.getById("PMinDuration").getValue()) || Integer.parseInt(tfTimeDuration.getText()) > Integer.parseInt(pc.getById("PMaxDuration").getValue())) {
            JOptionPane.showMessageDialog(null, "Durasi Overtime minimal 2 jam dan maksimal 3 jam perhari");
        } else {
            
            
            if( getMonth(jdSatu.getDate()) < getMonth(setTanggal()) && getDay(jdSatu.getDate())<=27 
                    || getMonth(jdSatu.getDate()) == getMonth(setTanggal()) && getDay(jdSatu.getDate())>27
                    || getMonth(jdSatu.getDate())> getMonth(setTanggal())){
                JOptionPane.showMessageDialog(null, "Tanggal salah");
            }
            else{

            String date = sdf.format(jdSatu.getDate());
            

//        System.out.println(t.getId());
            if (idtab != "") {
                if (tc.getByid(idtab).getOvertimeList().get(0).getStatus().toString() != "0") {
                    JOptionPane.showMessageDialog(null, "Data sudah Diproses");
                } else {
                    Overtime x = oc.getById(tc.getByid(idtab).getOvertimeList().get(0).getId());
//        System.out.println(x.getId());
                    Task t = tic.getByid(oc.getById(x.getId()).getTaskList().get(0).getId());
                    tc.save(idtab, date.toString(), ec.getById(id).getName(), id);
                    oc.insert(tc.getByid(idtab).getOvertimeList().get(0).getId(), date.toString(), tfTimeDuration.getText(), taDetail.getText(), "S03", idtab);
                    JOptionPane.showMessageDialog(null, tic.save(t.getId(), tfTask.getText(), x.getId()));
                    this.setVisible(false);
                    EmployeeMainView op = new EmployeeMainView();
                    this.getParent().add(op);
                    op.setVisible(true);
                    idtab = "";
                }
            } else {
                tc.save("TS02", date.toString(), ec.getById(id).getName(), id);
                oc.insert("o002", date.toString(), tfTimeDuration.getText(), taDetail.getText(), "S03", tc.last().getId());
                JOptionPane.showMessageDialog(null, tic.save("T02", tfTask.getText(), oc.last().getId()));
                this.setVisible(false);
                EmployeeMainView op = new EmployeeMainView();
                this.getParent().add(op);
                op.setVisible(true);
                idtab = "";
            }
            }
        }


    }//GEN-LAST:event_btSubmitActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        EmployeeMainView op = new EmployeeMainView();
        this.getParent().add(op);
        op.setVisible(true);
        idtab = "";
    }//GEN-LAST:event_btCancelActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        // public String delete(String id, String date, String name, String employee);

        Overtime x = oc.getById(tc.getByid(idtab).getOvertimeList().get(0).getId());
//        System.out.println(x.getId());
        Task t = tic.getByid(oc.getById(x.getId()).getTaskList().get(0).getId());
//        System.out.println(t.getId());
        if (tc.getByid(idtab).getOvertimeList().get(0).getStatus().toString() != "0") {
            JOptionPane.showMessageDialog(null, "Data sudah Diproses");
        } else {

            tic.delete(t.getId(), "", "");

            JOptionPane.showMessageDialog(null, oc.delete(tc.getByid(idtab).getOvertimeList().get(0).getId(), "0000-00-00",
                    "0", "", "0",
                    ""));

            JOptionPane.showMessageDialog(null, tc.delete(idtab, "0000-00-00", "", ""));
            clear();
        }


    }//GEN-LAST:event_btDeleteActionPerformed

    private void jdSatuComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jdSatuComponentAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_jdSatuComponentAdded

    private void jdSatuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdSatuMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jdSatuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NewJInternalFrame nif = new NewJInternalFrame();
        this.getParent().add(nif);
        nif.setVisible(true);
        this.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfTimeDurationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimeDurationKeyTyped
        // TODO add your handling code here:
        filterhuruf(evt);
    }//GEN-LAST:event_tfTimeDurationKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdSatu;
    private javax.swing.JTextArea taDetail;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNik;
    private javax.swing.JTextField tfTask;
    private javax.swing.JTextField tfTimeDuration;
    // End of variables declaration//GEN-END:variables
}
