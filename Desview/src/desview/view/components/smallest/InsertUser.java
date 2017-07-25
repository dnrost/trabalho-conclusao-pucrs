package desview.view.components.smallest;

import desview.controller.UsersControl;
import desview.model.entities.Users;
import desview.model.enums.UserType;
import java.awt.Dimension;
import java.awt.Toolkit;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 * This class is for insertion and update of users.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 12/06/2010.
 * @version 1.0
 */
public class InsertUser extends JXFrame {

    private static final long serialVersionUID = 51521221L;
    private UsersControl usersControl;

    /**
     * Construtor da classe InsertUser.
     * @param title
     */
    public InsertUser(String title) {
        super(title);
        initComponents();
        postInit();
        centralizaJanela();
        setResizable(false);
        //TODO implement creation of admin users.
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        status = new org.jdesktop.swingx.JXStatusBar();
        labelStatus = new org.jdesktop.swingx.JXLabel();
        labelUser = new org.jdesktop.swingx.JXLabel();
        labelPassword = new org.jdesktop.swingx.JXLabel();
        password = new javax.swing.JPasswordField();
        user = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        labelWelcome = new org.jdesktop.swingx.JXLabel();
        labelType = new org.jdesktop.swingx.JXLabel();
        labelRefresh = new org.jdesktop.swingx.JXLabel();
        refresh = new javax.swing.JComboBox();
        radioadmin = new javax.swing.JRadioButton();
        radiouser = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        status.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelStatus.setText(" ");
        status.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 4, 370, 31));

        labelUser.setText("User:");

        labelPassword.setText("Password:");

        btLogin.setText("Insert");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btExit.setText("Close");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        labelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWelcome.setText("Insert User");

        labelType.setText("Type:");

        labelRefresh.setText("Refresh time:");

        refresh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "5", "10", "15", "20", "25", "30" }));

        buttonGroup1.add(radioadmin);
        radioadmin.setText("admin");

        buttonGroup1.add(radiouser);
        radiouser.setText("user");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(user)
                                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioadmin)
                                        .addGap(18, 18, 18)
                                        .addComponent(radiouser))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelType, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
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
                    .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioadmin)
                    .addComponent(radiouser))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin)
                    .addComponent(btExit))
                .addGap(18, 18, 18)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        dispose();
    }//GEN-LAST:event_btExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        insert();
    }//GEN-LAST:event_btLoginActionPerformed

    private void postInit() {
        DropShadowBorder drop = new DropShadowBorder();
        drop.setShadowSize(1);
        status.setBorder(drop);
        labelWelcome.setBorder(drop);
        labelWelcome.setText("Insert user");

    }

    private void centralizaJanela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXLabel labelPassword;
    private org.jdesktop.swingx.JXLabel labelRefresh;
    private org.jdesktop.swingx.JXLabel labelStatus;
    private org.jdesktop.swingx.JXLabel labelType;
    private org.jdesktop.swingx.JXLabel labelUser;
    private org.jdesktop.swingx.JXLabel labelWelcome;
    private javax.swing.JPasswordField password;
    private javax.swing.JRadioButton radioadmin;
    private javax.swing.JRadioButton radiouser;
    private javax.swing.JComboBox refresh;
    private org.jdesktop.swingx.JXStatusBar status;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("deprecation")
    private void insert() {
        usersControl = new UsersControl();
        Users us = usersControl.getUsersByName(user.getText());
        if (us == null) {
            Users u = new Users();
            u.setName(user.getText());
            u.setPassword(password.getText());
            if (radioadmin.isSelected()) {
                u.setType(UserType.ADMIN);
            } else {
                u.setType(UserType.USER);
            }
            String r = refresh.getSelectedItem().toString();
            u.setRefreshTime(Integer.parseInt(r));
            usersControl.setUser(u);
            boolean i = usersControl.insert();
            if (i) {
                labelStatus.setText("User inserted successfully");
            } else {
                labelStatus.setText("User was not inserted.");
            }
        } else {
            labelStatus.setText("User already registered.");
        }
    }

    /**
     * This is only for edition
     * @param name
     */
    public void preeencheDados(String name) {
        user.setText(name);
    }

    public void setIsAdmin(boolean admin) {
        if (!admin) {
            radioadmin.setEnabled(false);
            radiouser.setSelected(true);
        } else {
            radioadmin.setEnabled(false);
            radiouser.setSelected(true);
        }
    }
}
