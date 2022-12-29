/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controllers.Settings5Controller;

/**
 *
 * @author Atmani
 */
public class Settings5 extends javax.swing.JFrame { //Settings5 extends JFrame in order to use its GUI functionalities.

    private Settings5Controller controller = new Settings5Controller(); //Instance of the "Settings5Controller" controller class. 
    //Allows using functions of the "Settings5Controller" class inside the "Settings5" class. 

    /**
     * Creates new form Settings5
     */
    private String UN;

    public Settings5(String UserName) { //Constructor of the "Settings5" GUI class.
        initComponents();
        UN = UserName;

        //If the Group notification set up is = to "1" it means that the user is willing to receive emails for StudyGroups. 
        //If the Group notification set up is = to "0" it means that the user is not willing to receive emails for StudyGroups. 
        //If the Tutoring notification set up is = to "1" it means that the user is willing to receive emails for Tutoring. 
        //If the Tutoring notification set up is = to "0" it means that the user is not willing to receive emails for Tutoring. 
        Boolean Flag1 = controller.CheckNotificationsGroups(UN);//Check if the Group notification set up is = to "1"
        if (Flag1 == true) { //If yes:
            System.out.print("Yes");
            jCheckBoxGroups.setSelected(true); //Set the "jCheckBoxGroups" to true.
        } else { // if not:
            System.out.print("NO");
            jCheckBoxGroups.setSelected(false); //Set the "jCheckBoxGroups" to false.
        }
        Boolean Flag2 = controller.CheckNotificationsTutoring(UN); //Check if the Tutoring notification set up is = to "1"
        if (Flag2 == true) { //If yes:
            System.out.print("Yes");
            jCheckBoxTutoring.setSelected(true); //Set the "jCheckBoxTutoring" to true.
        } else { //if not:
            System.out.print("NO");
            jCheckBoxTutoring.setSelected(false); //Set the "jCheckBoxTutoring" to false.    
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxTutoring = new javax.swing.JCheckBox();
        jCheckBoxGroups = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(135, 176, 209));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jButton1.setText("⬅︎");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Notifications");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jCheckBoxTutoring.setText("Notifications to receive tutoring and similarly provide help");

        jCheckBoxGroups.setText("Notifications to recieve emails about new groups being created");
        jCheckBoxGroups.setToolTipText("");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBoxTutoring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxGroups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jCheckBoxTutoring, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jCheckBoxGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Create an instance of the Settings1 GUI class:
        Settings1 x = new Settings1(UN); //Pass by the parameter of "UserName".
        this.hide(); //Hide the current GUI.
        x.setVisible(true); //Show the Settings1 GUI.
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (!jCheckBoxGroups.isSelected()) { //If the StudyGroups check box is unselected (meaning 0), the database will be updated:
            controller.updateGroupNotifications(UN, 0);
        }
        if (jCheckBoxGroups.isSelected()) { //If the StudyGroups check box is selected (meaning 1), the database will be updated:
            controller.updateGroupNotifications(UN, 1);
        }
        if (!jCheckBoxTutoring.isSelected()) { //If the Tutoring check box is unselected (meaning 0), the database will be updated:
            controller.updateTutoringNotifications(UN, 0);
        }
        if (jCheckBoxTutoring.isSelected()) { //If the Tutoring check box is selected (meaning 1), the database will be updated:
            controller.updateTutoringNotifications(UN, 1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBoxGroups;
    private javax.swing.JCheckBox jCheckBoxTutoring;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
