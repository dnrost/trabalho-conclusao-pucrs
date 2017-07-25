package desview.view.components;

import desview.controller.UsersControl;
import desview.model.entities.Users;
import desview.util.Message;
import desview.view.components.smallest.InsertUser;
import desview.view.components.smallest.RemoveEditUser;
import java.awt.EventQueue;
import org.jdesktop.swingx.JXFrame;

/**
 * This is a class to set configuration, user etc.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 27/05/2010.
 * @version 1.0
 */
public class Options extends JXFrame {

    private static final long serialVersionUID = 4256412554L;
    private Users user;

    /**
     * Constructor of class Options.
     * @param title title of window.
     * @param user the user.
     */
    public Options(String title, Users user) {
        super(title);
        this.user = user;
        initComponents();
        comboFreq.setSelectedItem(this.user.getRefreshTime());
        repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abas = new javax.swing.JTabbedPane();
        userConfPanel = new javax.swing.JPanel();
        labelChangePassw = new javax.swing.JLabel();
        oldPass = new javax.swing.JLabel();
        oldPasswText = new javax.swing.JPasswordField();
        newPass = new javax.swing.JLabel();
        newPasswText = new javax.swing.JPasswordField();
        confirmNewPass = new javax.swing.JLabel();
        confirmText = new javax.swing.JPasswordField();
        btSaveUser = new javax.swing.JButton();
        systemConfPanel = new javax.swing.JPanel();
        labelFreq = new javax.swing.JLabel();
        labelConfig = new javax.swing.JLabel();
        comboFreq = new javax.swing.JComboBox();
        btSaveSystem = new javax.swing.JButton();
        labelInform = new javax.swing.JLabel();
        otherPanel = new javax.swing.JPanel();
        btViewSearches = new javax.swing.JButton();
        btInsert = new javax.swing.JButton();
        BtEdit = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        btClose = new javax.swing.JButton();
        inutil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userConfPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelChangePassw.setText("Change password");
        userConfPanel.add(labelChangePassw, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 11, 268, -1));

        oldPass.setText("Old password:");
        userConfPanel.add(oldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 39, 180, -1));

        oldPasswText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oldPasswText.setEchoChar('*');
        userConfPanel.add(oldPasswText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 110, -1));

        newPass.setText("New password:");
        userConfPanel.add(newPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 70, 170, -1));

        newPasswText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newPasswText.setEchoChar('*');
        userConfPanel.add(newPasswText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 110, -1));

        confirmNewPass.setText("Confirm password:");
        userConfPanel.add(confirmNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 108, 170, -1));

        confirmText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmText.setEchoChar('*');
        userConfPanel.add(confirmText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 110, -1));

        btSaveUser.setText("Save");
        btSaveUser.setToolTipText("Save the password");
        btSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveUserActionPerformed(evt);
            }
        });
        userConfPanel.add(btSaveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, -1));

        abas.addTab("User configuration", userConfPanel);

        systemConfPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                systemConfPanelMouseEntered(evt);
            }
        });

        labelFreq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFreq.setText("Frequency of update (seconds):");

        labelConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelConfig.setText("Configuration:");

        comboFreq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60" }));

        btSaveSystem.setText("Save");
        btSaveSystem.setToolTipText("Save the password");
        btSaveSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveSystemActionPerformed(evt);
            }
        });

        labelInform.setText(" ");

        javax.swing.GroupLayout systemConfPanelLayout = new javax.swing.GroupLayout(systemConfPanel);
        systemConfPanel.setLayout(systemConfPanelLayout);
        systemConfPanelLayout.setHorizontalGroup(
            systemConfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemConfPanelLayout.createSequentialGroup()
                .addGroup(systemConfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(systemConfPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(systemConfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(systemConfPanelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(labelConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(systemConfPanelLayout.createSequentialGroup()
                                .addComponent(labelFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(systemConfPanelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btSaveSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(systemConfPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelInform, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        systemConfPanelLayout.setVerticalGroup(
            systemConfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemConfPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelConfig)
                .addGap(14, 14, 14)
                .addGroup(systemConfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFreq)
                    .addComponent(comboFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btSaveSystem)
                .addGap(18, 18, 18)
                .addComponent(labelInform)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        abas.addTab("System configuration", systemConfPanel);

        btViewSearches.setText("View searches");
        btViewSearches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewSearchesActionPerformed(evt);
            }
        });

        btInsert.setText("Insert user");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });

        BtEdit.setText("Edit or remove user");
        BtEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout otherPanelLayout = new javax.swing.GroupLayout(otherPanel);
        otherPanel.setLayout(otherPanelLayout);
        otherPanelLayout.setHorizontalGroup(
            otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, otherPanelLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(btInsert, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(btViewSearches, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addGap(170, 170, 170))
        );
        otherPanelLayout.setVerticalGroup(
            otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btViewSearches)
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btInsert)
                .addGap(28, 28, 28)
                .addComponent(BtEdit)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        abas.addTab("Other", otherPanel);

        getContentPane().add(abas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, -1, 220));

        btClose.setText("Close");
        btClose.setToolTipText("Close this window");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 140, -1));
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 380, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btViewSearchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewSearchesActionPerformed
        searches();
    }//GEN-LAST:event_btViewSearchesActionPerformed

    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed
        insertUser();
    }//GEN-LAST:event_btInsertActionPerformed

    private void BtEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditActionPerformed
        removeUser();
    }//GEN-LAST:event_BtEditActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    @SuppressWarnings("deprecation")
    private void btSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveUserActionPerformed
        if (newPasswText.getText().equals(confirmText.getText()) && !confirmText.getText().equals("")) {
            saveNewPassword();
        } else {
            Message.error(null, "Passwords", "Passwords do not match.");
        }
    }//GEN-LAST:event_btSaveUserActionPerformed

    private void btSaveSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveSystemActionPerformed
        saveSystem();
        comboFreq.setSelectedItem(this.user.getRefreshTime());
        labelInform.setText("You must restart application for the changes to take effect.");
        repaint();
    }//GEN-LAST:event_btSaveSystemActionPerformed

    private void systemConfPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_systemConfPanelMouseEntered
        comboFreq.setSelectedItem(this.user.getRefreshTime());
        repaint();
    }//GEN-LAST:event_systemConfPanelMouseEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtEdit;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btSaveSystem;
    private javax.swing.JButton btSaveUser;
    private javax.swing.JButton btViewSearches;
    private javax.swing.JComboBox comboFreq;
    private javax.swing.JLabel confirmNewPass;
    private javax.swing.JPasswordField confirmText;
    private javax.swing.JLabel inutil;
    private javax.swing.JLabel labelChangePassw;
    private javax.swing.JLabel labelConfig;
    private javax.swing.JLabel labelFreq;
    private javax.swing.JLabel labelInform;
    private javax.swing.JLabel newPass;
    private javax.swing.JPasswordField newPasswText;
    private javax.swing.JLabel oldPass;
    private javax.swing.JPasswordField oldPasswText;
    private javax.swing.JPanel otherPanel;
    private javax.swing.JSeparator separador;
    private javax.swing.JPanel systemConfPanel;
    private javax.swing.JPanel userConfPanel;
    // End of variables declaration//GEN-END:variables

    private void searches() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ViewSearches("Search").setVisible(true);
            }
        });
    }

    private void insertUser() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new InsertUser("Inserting a new user").setVisible(true);
            }
        });
    }

    private void removeUser() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new RemoveEditUser("Remove user").setVisible(true);
            }
        });
    }

    @SuppressWarnings("deprecation")
    private void saveNewPassword() {
        UsersControl usersControl = new UsersControl();
        Users test = usersControl.getLoginUser(user.getName(), oldPasswText.getText());
        if (test == null) {//nao ha usuario
            Message.warning(null, "Update", "The old password does not match");
        } else {
            Users newUser = new Users();
            newUser.setName(user.getName());
            newUser.setPassword(confirmText.getText());
            newUser.setRefreshTime(user.getRefreshTime());
            newUser.setType(user.getType());
            newUser.setId(user.getId());
            usersControl.setUser(newUser);
            if (usersControl.update()) {
                user = newUser;
                Message.information(null, "Update", "Password was succesfully updated");
            } else {
                Message.error(null, "Update", "Password was not updated");
            }
        }
    }

    private void saveSystem() {
        UsersControl usersControl = new UsersControl();
        Users newUser = new Users();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setRefreshTime(Integer.parseInt(comboFreq.getSelectedItem().toString()));
        newUser.setType(user.getType());
        newUser.setId(user.getId());
        usersControl.setUser(newUser);
        if (usersControl.update()) {
            user = newUser;
            Message.information(null, "Update", "Refresh time was succesfully updated");
        } else {
            Message.error(null, "Update", "Refresh time was not updated");
        }
    }
}
