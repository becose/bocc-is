package boccis;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tommybennett
 */
public class familyF extends javax.swing.JFrame {
    familyC fc = new familyC();
    methodC mmc = new methodC();
    memberC mc = new memberC();
    /**
     * Creates new form familyF
     * @param familyID
     * @throws java.sql.SQLException
     */
    public familyF(int familyID) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);    
        this.loadPrimaryMember();
        this.loadToMember();
    }
    private void loadPrimaryMember() throws SQLException{
        ResultSet rs = mc.getMembers();
        this.cbPrimaryMember.removeAllItems();
        this.cbPrimaryMember.addItem("Select Primary Member ->");
        
        while(rs.next()){
            //if(mmc.int2String(rs.getInt("member_id")).equals("1")){
                this.cbPrimaryMember.addItem(mmc.padString(mmc.int2String(rs.getInt("member_id")),6, "0") + 
                        " - " + rs.getString("member_lname") +", "+ rs.getString("member_fname"));
            //}
        }           
    }
   private void loadToMember() throws SQLException{
        ResultSet rs = mc.getMembers();
        this.cbToMember.removeAllItems();
        this.cbToMember.addItem("Select To Member ->");
        
        while(rs.next()){
            //if(mmc.int2String(rs.getInt("member_id")).equals("1")){
                this.cbToMember.addItem(mmc.padString(mmc.int2String(rs.getInt("member_id")),6, "0") + 
                        " - " + rs.getString("member_lname") +", "+ rs.getString("member_fname"));
            //}
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
        bLink = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbPrimaryMember = new javax.swing.JComboBox();
        cbToMember = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbRelation = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Family Relation Link");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });

        bLink.setText("Link");
        bLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLinkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bLink)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bClose)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bClose)
                    .addComponent(bLink)))
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(null);

        jLabel1.setText("Primary Member:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(50, 20, 105, 16);

        cbPrimaryMember.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Primary Member ->" }));
        jPanel3.add(cbPrimaryMember);
        cbPrimaryMember.setBounds(180, 20, 281, 27);

        cbToMember.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select To Member ->" }));
        jPanel3.add(cbToMember);
        cbToMember.setBounds(180, 60, 281, 27);

        jLabel2.setText("Relation To:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(50, 60, 75, 16);

        cbRelation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001 - Spouse", "002 - Child", "003 - Parent", "004 - Sibling", "005 - Relative" }));
        jPanel3.add(cbRelation);
        cbRelation.setBounds(180, 100, 155, 27);

        jLabel3.setText("Relationship:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(50, 100, 82, 16);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boccis/familyicon.png"))); // NOI18N
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 10, 480, 170);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLinkActionPerformed
        String sMI = this.cbPrimaryMember.getSelectedItem().toString().substring(0, 6);
        String sCI = this.cbToMember.getSelectedItem().toString().substring(0, 6);
        String sRI = this.cbRelation.getSelectedItem().toString().substring(0, 3);
        
        if((!sCI.equals("Select") && !sMI.equals("Select")) && !sCI.equals(sMI)){
            fc.setCI(mmc.String2int(sCI));
            fc.setMI(mmc.String2int(sMI));
            fc.setRI(mmc.String2int(sRI));
            fc.setDT(mmc.getCurrentDate());
            
            if(fc.linkFamily()){
                mmc.outputBox("Member -> "+fc.getMemberName(fc.getMI())
                            +" Connected -> "+fc.getMemberName(fc.getCI())
                            +" Relation -> "+fc.getRI()
                            +" Date: "+fc.getDT());
                if(fc.getRI()==1 || 
                   fc.getRI()==4 ||
                   fc.getRI()==5){ // 1-Spouse, 4-Sibling and 5-Relative to reverse link
                    int tempMI = fc.getMI();
                    int tempCI = fc.getCI();
                    
                    fc.setCI(tempMI);
                    fc.setMI(tempCI);
                    
                    if(fc.linkFamily()){
                        mmc.outputBox("Member -> "+fc.getMemberName(fc.getMI())
                                    +" Connected -> "+fc.getMemberName(fc.getCI())
                                    +" Relation -> "+fc.getRI()
                                    +" Date: "+fc.getDT());                        
                    }                    
                }
                if(fc.getRI()==3){ // 3 - Parent to 2 - Child
                    int tempMI = fc.getMI();
                    int tempCI = fc.getCI();
                    
                    fc.setCI(tempMI);
                    fc.setMI(tempCI);
                    fc.setRI(2);
                    
                    if(fc.linkFamily()){
                        mmc.outputBox("Member -> "+fc.getMemberName(fc.getMI())
                                    +" Connected -> "+fc.getMemberName(fc.getCI())
                                    +" Relation -> "+fc.getRI()
                                    +" Date: "+fc.getDT());                        
                    }         
                   
                    if(mc.findMember(tempMI)){
                        mmc.outputBox("Found member to get address from...");
                    }
                    if(mc.saveMemberAddress(tempCI, tempMI)){
                        mmc.outputBox("Secondary member address updated...");
                    }                   
                }
            }
        } else {
            mmc.messageBox("ERROR -> You did not Select the Primary or Link To Member nor can it be the same...");
        }
    }//GEN-LAST:event_bLinkActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(familyF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(familyF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(familyF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(familyF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new familyF(0).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bLink;
    private javax.swing.JComboBox cbPrimaryMember;
    private javax.swing.JComboBox cbRelation;
    private javax.swing.JComboBox cbToMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
