package desview.view.components;

import org.jdesktop.swingx.JXFrame;

/**
 * This class is a minipanel with a textarea.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 24/05/2010.
 * @version 1.0
 */
public class MiniPanel extends JXFrame {

    private static final long serialVersionUID = 5432774142L;
    private boolean clickWillDispose = false;

    /**
     * Constructor of class MiniPanel.
     */
    public MiniPanel() {
        initComponents();
    }

    /**
     * Creates new form MiniPanel2.
     * @param text the text to appear in textarea.
     * @param clickWillDispose if a click in the window will dispose it.
     * @param editable if the area will be editable.
     */
    public MiniPanel(String text, boolean clickWillDispose, boolean editable) {
        initComponents();
        this.clickWillDispose = clickWillDispose;
        setTextArea(text, editable);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        area.setColumns(20);
        area.setRows(5);
        area.setText("text\ntext\ntext\ntext\ntext");
        scroll.setViewportView(area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (clickWillDispose) {
            dispose();
        }
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    public void setTextArea(String text, boolean editable) {
        area.setText(text);
        area.setEditable(editable);
    }
}
