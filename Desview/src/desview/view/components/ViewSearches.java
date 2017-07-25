package desview.view.components;

import desview.controller.SearchControl;
import desview.model.entities.Search;
import desview.util.Message;
import desview.util.Util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.jdesktop.swingx.JXFrame;

/**
 * This class is a window to view the searches.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 27/05/2010.
 * @version 1.0
 */
public class ViewSearches extends JXFrame {

    private static final long serialVersionUID = 411454621522L;
    private DefaultListModel modeloLista;
    private String OS;
    private JPopupMenu popup;
    private SearchControl searchControl;

    /**
     * Constructor of class ViewSearches.
     * @param title title of window.
     */
    public ViewSearches(String title) {
        super(title);
        modeloLista = new DefaultListModel();
        popup = new JPopupMenu();
        initComponents();
        OS = Util.OS;
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollLista = new javax.swing.JScrollPane();
        lista = new org.jdesktop.swingx.JXList();
        btClose = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        lista.setBorder(dropShadowBorder1);
        lista.setModel(modeloLista);
        scrollLista.setViewportView(lista);

        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        label.setText("Searches:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(scrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addComponent(btClose)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(scrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(49, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JLabel label;
    private org.jdesktop.swingx.JXList lista;
    private javax.swing.JScrollPane scrollLista;
    // End of variables declaration//GEN-END:variables

    private void postInitComponents() {
        JMenuItem mi = new JMenuItem("Remove");
        mi.addActionListener(new Menu());
        mi.setActionCommand("remove");
        popup.add(mi);
        mi = new JMenuItem("Remove all");
        mi.addActionListener(new Menu());
        mi.setActionCommand("removeall");
        popup.add(mi);
        popup.setOpaque(true);
        popup.setLightWeightPopupEnabled(true);
        if (OS.contains("Linux")) {
            lista.addMouseListener(
                    new MouseAdapter() {

                        private boolean isTriggered = false;

                        @Override
                        public void mousePressed(MouseEvent e) {
                            if (isTriggered = e.isPopupTrigger()) {
                                popup.show((JComponent) e.getSource(), e.getX(), e.getY());
                                repaint();
                            }
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            isTriggered = false;
                            repaint();
                        }
                    });
        } else if (OS.contains("Windows")) {
            lista.addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            if (e.isPopupTrigger()) {
                                popup.show((JComponent) e.getSource(), e.getX(), e.getY());
                            }
                        }
                    });
        }

        fillList();
    }

    private void fillList() {
        //fill the list
        modeloLista.removeAllElements();
        searchControl = new SearchControl();
        List<Search> listaSearches = searchControl.getSearches();
        for (Search search : listaSearches) {
            modeloLista.addElement(search);
        }
    }

    private class Menu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("remove")) {
                Search s = (Search) lista.getSelectedValue();
                remover(s);
            }
            if (ae.getActionCommand().equals("removeall")) {
                for (int i = 0; i < modeloLista.getSize(); i++) {
                    Search s = (Search) modeloLista.get(i);
                    remover(s);
                }
            }
            fillList();
        }
    }

    private void remover(Search s) {
        searchControl.setSearch(s);
        try {
            searchControl.delete();
        } catch (Exception ex) {
            Message.error(null, "Removing search", "Cannot remove search");
        }
    }
}

