package desview.graphics.opengl.spiral2D;

import com.sun.opengl.util.Animator;
import desview.model.entities.Task;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

public class SpiralGLCanvas extends JFrame {

    static {
        // When using a GLCanvas, we have to set the Popup-Menues to be HeavyWeight, so they display properly on top of the GLCanvas
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
    }
    private static final long serialVersionUID = 32454436275721L;
    private Animator animator;

    /**
     * Creates new form MainFrame
     * @param title
     * @param task
     */
    public SpiralGLCanvas(String title, Task task) {
        initComponents();
        setTitle(title);

        canvas.addGLEventListener(new GLRenderer(task));
        animator = new Animator(canvas);

        // This is a workaround for the GLCanvas not adjusting its size, when the frame is resized.
        canvas.setMinimumSize(new Dimension());

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        animator.stop();
                        //System.exit(0);
                    }
                }).start();
            }
        });
    }

    @Override
    public void setVisible(boolean show) {
        if (!show) {
            animator.stop();
        }
        super.setVisible(show);
        if (show) {
            animator.start();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        JLabel label = new JLabel();
        canvas = new GLCanvas(createGLCapabilites());

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        label.setText(" ");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(label, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(canvas, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called from within initComponents().
     * hint: to customize the generated code choose 'Customize Code' in the contextmenu
     * of the selected UI Component you wish to cutomize in design mode.
     * @return Returns customized GLCapabilities.
     */
    private GLCapabilities createGLCapabilites() {

        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setHardwareAccelerated(true);

        // try to enable 2x anti aliasing - should be supported on most hardware
        capabilities.setNumSamples(2);
        capabilities.setSampleBuffers(true);

        return capabilities;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GLCanvas canvas;
    // End of variables declaration//GEN-END:variables
}
