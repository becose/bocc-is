/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boccis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tommybennett
 */
public class trainingF extends javax.swing.JFrame {
    methodC mmc = new methodC();
    memberC mc = new memberC();
    trainingC tc = new trainingC();
    
    boolean isLoaded = true;
    int iClickCount = 0;
    String sClassList = ""; 
    ArrayList<Integer> alClassList = new ArrayList<>();
    /**
     * Creates new form trainingF
     */
    public trainingF() throws SQLException {
        initComponents();
        this.setupForm();
    }
    public void setupForm() throws SQLException{
        this.setLocationRelativeTo(null); 
        this.dtClassDate.setDateFormatString("MM/dd/yyyy");
        
        if(this.isLoaded){
            this.loadTrainingTable();
            this.loadClassDates();
            this.isLoaded = false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bClose = new javax.swing.JButton();
        bSchedule = new javax.swing.JButton();
        bConfirm = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTraining = new javax.swing.JTable();
        cbTrainingDate = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tClassList = new javax.swing.JTextArea();
        dtClassDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("New Member Training");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });

        bSchedule.setText("Schedule");
        bSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bScheduleActionPerformed(evt);
            }
        });

        bConfirm.setText("Confirm Attendance");
        bConfirm.setEnabled(false);
        bConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bSchedule)
                .addGap(18, 18, 18)
                .addComponent(bConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(bClose)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bClose)
                    .addComponent(bSchedule)
                    .addComponent(bConfirm)))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblTraining.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTraining.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrainingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTraining);

        cbTrainingDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrainingDateActionPerformed(evt);
            }
        });

        jLabel2.setText("Member Training Dates ->");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTrainingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTrainingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        tClassList.setColumns(20);
        tClassList.setRows(5);
        jScrollPane2.setViewportView(tClassList);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(10, 50, 250, 190);
        jPanel4.add(dtClassDate);
        dtClassDate.setBounds(10, 10, 150, 28);
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 10, 250, 190);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bScheduleActionPerformed
        Date dValue = this.dtClassDate.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        tc.setTD(sdf.format(dValue));
        mmc.messageBox(tc.getTD());
        
        for(int iMemberID : this.alClassList){
            tc.setMI(iMemberID);
            
            if(tc.scheduleTraining()){
                mc.findMember(tc.getMI());
                mmc.outputBox("Member "+mc.getFullName()+" successfully registered for class on "+tc.getTD());
            }
        }
        
    }//GEN-LAST:event_bScheduleActionPerformed

    private void tblTrainingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainingMouseClicked
        if(evt.getClickCount() == 1){
            int iRow = this.tblTraining.getSelectedRow();
            //mc.outputBox("Current row: " + iRow);
            if(iRow>-1){
                int iMID = mmc.String2int(this.tblTraining.getValueAt(iRow, 0).toString());
                //mc.outputBox("Clicked ID : " + iLID);
                this.iClickCount = 0;
                mc.findMember(iMID);
                if(notInClass(mc.getID())){
                    this.alClassList.add(mc.getID());
                    this.addMember2ClassList(mc.getFullName());    
                }                
            }
        }
        evt.consume();
    }//GEN-LAST:event_tblTrainingMouseClicked

    private void cbTrainingDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrainingDateActionPerformed
        String sComboValue = this.cbTrainingDate.getSelectedItem().toString().trim();
        
        this.isLoaded = true;
        if(this.isLoaded){
            if(!sComboValue.equals("Not Attended")){
                this.loadTrainingTable(sComboValue); 
                this.bConfirm.setEnabled(true);
            } else {
                this.loadTrainingTable();
                this.bConfirm.setEnabled(false);
            }
            this.isLoaded = false;
        }
        
    }//GEN-LAST:event_cbTrainingDateActionPerformed

    private void bConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmActionPerformed
        this.bConfirm.setEnabled(false);
        String sDate = this.cbTrainingDate.getSelectedItem().toString().trim();
        mmc.outputBox("Confirming attendance for Class dated "+sDate);
        
        if(!sDate.equals("Not Attended")){
            try {
                tc.confirmTraining(sDate);
            } catch (SQLException ex) {
                Logger.getLogger(trainingF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bConfirmActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(trainingF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(trainingF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(trainingF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(trainingF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new trainingF().setVisible(true);
//            }
//        });
//    }
    public void loadClassDates() throws SQLException{
        ResultSet rs = tc.getTrainingDates();
        this.cbTrainingDate.removeAllItems();
        this.cbTrainingDate.addItem("Not Attended");
        
        while(rs.next()){
            this.cbTrainingDate.addItem(rs.getString("training_date"));
        }           
    }
    public void loadTrainingTable(){
        try {
            this.tblTraining.setModel(DbUtils.resultSetToTableModel(tc.getMembersNeedingClass()));
        } catch (SQLException ex) {
            Logger.getLogger(trainingF.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    public void loadTrainingTable(String sValue){
        try {
            this.tblTraining.setModel(DbUtils.resultSetToTableModel(tc.getMembersByTrainingDate(sValue)));
        } catch (SQLException ex) {
            Logger.getLogger(trainingF.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }    
    public void addMember2ClassList(String sValue){
        //this.tClassList.setText("");
        this.sClassList += (sValue+ "\n");
        this.tClassList.setText(this.sClassList);
        mmc.outputBox("Class count: " + this.alClassList.size());
    }
    public boolean notInClass(int iValue){
        boolean isOK = true;
        
        if(this.alClassList.contains(iValue)){
            isOK = false;
            mmc.outputBox("WARNING: "+mc.getFullName()+" already on class list ....");
        }
        
        return isOK;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bConfirm;
    private javax.swing.JButton bSchedule;
    private javax.swing.JComboBox cbTrainingDate;
    private com.toedter.calendar.JDateChooser dtClassDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tClassList;
    private javax.swing.JTable tblTraining;
    // End of variables declaration//GEN-END:variables
}
