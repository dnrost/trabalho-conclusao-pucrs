package desview.view.components.smallest;

import desview.controller.UsersControl;
import desview.model.entities.Users;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 * This class is for reset the password.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 13/06/2010.
 * @version 1.0
 */
public class ResetPassword extends JXFrame {

    private static final long serialVersionUID = 51521574221L;
    private UsersControl usersControl;

    /**
     * Constructor of class.
     * @param title the window title.
     */
    public ResetPassword(String title) {
        super(title);
        initComponents();
        postInit();
        centralizaJanela();
        setResizable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new org.jdesktop.swingx.JXStatusBar();
        labelStatus = new org.jdesktop.swingx.JXLabel();
        labelUser = new org.jdesktop.swingx.JXLabel();
        user = new javax.swing.JTextField();
        resetBt = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        labelWelcome = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        status.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelStatus.setText(" ");
        status.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 30));

        labelUser.setText("User:");

        resetBt.setText("Reset");
        resetBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtActionPerformed(evt);
            }
        });

        btExit.setText("Close");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        labelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWelcome.setText("Type User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(resetBt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExit)
                    .addComponent(resetBt))
                .addGap(26, 26, 26)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        dispose();
    }//GEN-LAST:event_btExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void resetBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtActionPerformed
        reset();
    }//GEN-LAST:event_resetBtActionPerformed

    private void postInit() {
        DropShadowBorder drop = new DropShadowBorder();
        drop.setShadowSize(1);
        status.setBorder(drop);
        labelWelcome.setBorder(drop);
        repaint();
    }

    private void centralizaJanela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private org.jdesktop.swingx.JXLabel labelStatus;
    private org.jdesktop.swingx.JXLabel labelUser;
    private org.jdesktop.swingx.JXLabel labelWelcome;
    private javax.swing.JButton resetBt;
    private org.jdesktop.swingx.JXStatusBar status;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("deprecation")
    private void reset() {
        usersControl = new UsersControl();
        Users us = usersControl.getUsersByName(user.getText());
        if (us != null) {
            us.setPassword("12345");
            usersControl.setUser(us);
            boolean i = usersControl.update();
            if (i) {
                labelStatus.setForeground(Color.black);
                labelStatus.setText("Password was reseted to default : 12345");
            } else {
                labelStatus.setForeground(Color.red);
                labelStatus.setText("Password was not reseted.");
            }
        } else {
            labelStatus.setForeground(Color.red);
            labelStatus.setText("User is not registered.");
        }
    }

    /**
     * This is only for edition
     * @param name
     */
    public void preeencheDados(String name) {
        user.setText(name);
    }
}
