package desview.view.components;

import desview.controller.UsersControl;
import desview.model.entities.Users;
import desview.model.enums.UserType;
import desview.scheduler.Reader;
import desview.util.Message;
import desview.util.Util;
import desview.view.MainWindow;
import desview.view.components.smallest.InsertUser;
import desview.view.components.smallest.ResetPassword;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 * This is the class of login.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 12/06/2010.
 * @version 1.0
 */
public class Login extends JXFrame {

    private static final long serialVersionUID = -809156281L;
    private UsersControl usersControl;
    private boolean beta = true;
    private Users usuario;

    /**
     * Construtor da classe Login.
     */
    public Login() {
        initComponents();
        postInit();
        centralizaJanela();
        setResizable(false);
        setTitle("Login");
    }

    public Login(boolean beta) {
        initComponents();
        postInit();
        centralizaJanela();
        setResizable(false);
        setTitle("Login");
        if (!beta) {
            criarAdmin.setVisible(false);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new org.jdesktop.swingx.JXStatusBar();
        labelStatus = new org.jdesktop.swingx.JXLabel();
        labelUser = new org.jdesktop.swingx.JXLabel();
        labelPassword = new org.jdesktop.swingx.JXLabel();
        password = new javax.swing.JPasswordField();
        user = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        labelWelcome = new org.jdesktop.swingx.JXLabel();
        createAccount = new org.jdesktop.swingx.JXHyperlink();
        forgotPassword = new org.jdesktop.swingx.JXHyperlink();
        criarAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        status.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelStatus.setText(" ");
        status.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 4, 300, 31));

        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 356, 39));

        labelUser.setText("User:");
        getContentPane().add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, 102, -1));

        labelPassword.setText("Password:");
        getContentPane().add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, 102, -1));

        password.setEchoChar('*');
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 220, -1));
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 220, -1));

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 150, -1));

        labelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWelcome.setText("Welcome to Desview");
        getContentPane().add(labelWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 320, 46));

        createAccount.setText("Create account");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });
        getContentPane().add(createAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 223, 129, -1));

        forgotPassword.setText("Forgot password");
        forgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(forgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 223, -1, -1));

        criarAdmin.setText("adm");
        criarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarAdminActionPerformed(evt);
            }
        });
        getContentPane().add(criarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 219, 45, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        if (user.getText().isEmpty()) {
            labelStatus.setText("Please, fill user field.");
        } else {
            doLogin();
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        createAccount();
    }//GEN-LAST:event_createAccountActionPerformed

    private void forgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordActionPerformed
        resetPassword();
    }//GEN-LAST:event_forgotPasswordActionPerformed

    private void criarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarAdminActionPerformed
        createAdminCount();
}//GEN-LAST:event_criarAdminActionPerformed

    private void postInit() {
        DropShadowBorder drop = new DropShadowBorder();
        drop.setShadowSize(1);
        status.setBorder(drop);
        labelWelcome.setBorder(drop);
        StringBuilder s = new StringBuilder();
        s.append("Welcome to Desview ").append(Util.DESVIEW_VERSION);
        labelWelcome.setText(s.toString());
    }

    private void centralizaJanela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private org.jdesktop.swingx.JXHyperlink createAccount;
    private javax.swing.JButton criarAdmin;
    private org.jdesktop.swingx.JXHyperlink forgotPassword;
    private org.jdesktop.swingx.JXLabel labelPassword;
    private org.jdesktop.swingx.JXLabel labelStatus;
    private org.jdesktop.swingx.JXLabel labelUser;
    private org.jdesktop.swingx.JXLabel labelWelcome;
    private javax.swing.JPasswordField password;
    private org.jdesktop.swingx.JXStatusBar status;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("deprecation")
    private void doLogin() {
        usersControl = new UsersControl();
        Users u = usersControl.getUsersByName(user.getText());
        if (u == null) {
            labelStatus.setText("User not found");
        } else if (u != null) {
            Users l = usersControl.getLoginUser(user.getText(), password.getText());
            if (l == null) {
                labelStatus.setText("The username or password you entered is incorrect.");
            } else {
                dispose();
                loginSuccessfully();
                usuario = l;
            }
        }
    }

    private void loginSuccessfully() {
        try {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    MainWindow janela = new MainWindow();
                    janela.setVisible(true);
                    janela.pack();
                    janela.setUser(usuario);
                    if (!beta) {
                        janela.setDefaultCloseOperation(JXFrame.DO_NOTHING_ON_CLOSE);
                        janela.addWindowListener(new WindowAdapter() {

                            @Override
                            public void windowClosing(WindowEvent e) {
                                if (Message.question(null, "Exit", "Do you want to close and exit?")) {
                                    System.exit(0);
                                }
                            }
                        });
                    } else {
                        janela.setDefaultCloseOperation(JXFrame.EXIT_ON_CLOSE);
                    }
                }
            });
            Reader schedulerThread = new Reader();
            schedulerThread.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createAccount() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                InsertUser janela = new InsertUser("Inserting a new user");
                janela.setVisible(true);
                janela.pack();
                janela.setIsAdmin(false);
            }
        });
    }

    private void resetPassword() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ResetPassword janela = new ResetPassword("Reseting password");
                janela.setVisible(true);
                janela.pack();
            }
        });
    }

    private void createAdminCount() {
        Users us = new Users();
        us.setName("sudo");
        us.setPassword("1234567");
        us.setRefreshTime(5);
        us.setType(UserType.ADMIN);
        usersControl = new UsersControl(us);
        if (usersControl.insert()) {
            labelStatus.setText("User 'adm' and password '1234567' to login");
        }
    }
}
