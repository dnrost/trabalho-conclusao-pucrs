package desview.view;

import desview.controller.UsersControl;
import desview.model.entities.Users;
import desview.model.enums.UserType;
import desview.util.Message;
import desview.util.Util;
import java.awt.event.KeyEvent;
import org.jdesktop.swingx.JXFrame;

/**
 * This class shows a window with information about project data, authors and other information.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 11/04/2010.
 */
public class AboutWindow extends JXFrame {

    private static final long serialVersionUID = -9956745253287l;
    private Users user;

    /**
     * Creates the About window.
     * @param user the current user.
     */
    public AboutWindow(Users user) {
        super("Desview: About");
        this.user = user;
        initComponents();
        StringBuilder b = new StringBuilder();
        b.append(labelDataRelease.getText());
        b.append(" ").append(Util.RELEASE_DATE);
        labelDataRelease.setText(b.toString());
        StringBuilder e = new StringBuilder();
        e.append("Authors:").append(Util.LINE_SEPARATOR).append("  Diones Rossetto").append(Util.LINE_SEPARATOR).append("  Luiz Mello").append(Util.LINE_SEPARATOR);
        e.append(Util.LINE_SEPARATOR);
        e.append("This is a final work in Computer Science in 2010/1 at PUCRS.");
        editor.setText(e.toString());
        StringBuilder s = new StringBuilder();
        s.append("Version ").append(Util.DESVIEW_VERSION);
        labelVersao.setText(s.toString());
        if (user != null) {
            StringBuilder su = new StringBuilder();
            su.append("User: ").append(this.user.getName());
            labelUser.setText(su.toString());
        } else {
            StringBuilder su = new StringBuilder();
            su.append("User: ").append("Anonymous");
            labelUser.setText(su.toString());
        }
        buttonAddUser.setVisible(false);
        buttonVuvuzela.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separador = new javax.swing.JSeparator();
        scroll = new javax.swing.JScrollPane();
        editor = new org.jdesktop.swingx.JXEditorPane();
        labelNomeProjeto = new org.jdesktop.swingx.JXLabel();
        labelDataRelease = new org.jdesktop.swingx.JXLabel();
        labelVersao = new org.jdesktop.swingx.JXLabel();
        labelUser = new org.jdesktop.swingx.JXLabel();
        buttonAddUser = new javax.swing.JButton();
        buttonVuvuzela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        editor.setEditable(false);
        scroll.setViewportView(editor);

        labelNomeProjeto.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        labelNomeProjeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeProjeto.setText("Desview Project");

        labelDataRelease.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        labelDataRelease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataRelease.setText("Release date:");

        labelVersao.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        labelVersao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVersao.setText("Version ");

        labelUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        labelUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUser.setText("User:");

        buttonAddUser.setMnemonic(KeyEvent.VK_A);
        buttonAddUser.setText("Add user");
        buttonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddUserActionPerformed(evt);
            }
        });

        buttonVuvuzela.setMnemonic(KeyEvent.VK_V);
        buttonVuvuzela.setText("Vuvuzela");
        buttonVuvuzela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVuvuzelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(labelVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(labelDataRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(labelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonAddUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                                .addComponent(buttonVuvuzela))
                            .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .addComponent(labelNomeProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelNomeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDataRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonVuvuzela)
                            .addComponent(buttonAddUser))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void buttonVuvuzelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVuvuzelaActionPerformed
        Message.information(null, "Vuvuzela", "=======<() póóóóóóóóóóóóóóóóóóóóóóó");
    }//GEN-LAST:event_buttonVuvuzelaActionPerformed

    private void buttonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddUserActionPerformed
        if (user == null) {
            UsersControl usersControl = new UsersControl();
            Users u = usersControl.getUsersByName("adminDesview");
            if (u == null) {
                Users newUser = new Users();
                newUser.setId(-1l);
                newUser.setName("adminDesview");
                newUser.setPassword("adminDesview");
                newUser.setRefreshTime(10);
                newUser.setType(UserType.ADMIN);
                usersControl.setUser(newUser);
                if (usersControl.insert()) {
                    Message.information(null, "User", "Default user was inserted");
                    user = newUser;
                } else {
                    Message.information(null, "User", "Default already inserted");
                }
            } else {
                Message.information(null, "User", "Default already inserted");
            }
        }
}//GEN-LAST:event_buttonAddUserActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddUser;
    private javax.swing.JButton buttonVuvuzela;
    private org.jdesktop.swingx.JXEditorPane editor;
    private org.jdesktop.swingx.JXLabel labelDataRelease;
    private org.jdesktop.swingx.JXLabel labelNomeProjeto;
    private org.jdesktop.swingx.JXLabel labelUser;
    private org.jdesktop.swingx.JXLabel labelVersao;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
