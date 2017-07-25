package desview.graphics.opengl.lines2D;

import com.sun.opengl.util.FPSAnimator;
import desview.model.entities.Task;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * This class represents the window with the canvas.
 * <br> Thanks to Leonardo Peres.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.1
 * @since 10/10/2008.
 * Adapted in 21/05/2010
 */
public class Window {

    private Renderer2D renderer;

    /**
     * Construtor of class. Creates a window and inserts in a canvas.
     * @param task the selected task.
     * @param windowTitle the window title.
     */
    public Window(String windowTitle, Task task) {
        // Cria janela
        JFrame janela = new JFrame(windowTitle);
        janela.setBounds(0, 0, 1025, 745);
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        Container caixa = janela.getContentPane();
        caixa.setLayout(layout);

        // Cria um objeto GLCapabilities para especificar o numero de bits
        // por pixel para RGBA
        GLCapabilities c = new GLCapabilities();
        c.setRedBits(8);
        c.setBlueBits(8);
        c.setGreenBits(8);
        c.setAlphaBits(8);

        // Cria o objeto que ira gerenciar os eventos
        renderer = new Renderer2D(task);

        // Cria um canvas, adiciona na janela, e especifica o objeto "ouvinte"
        // para os eventos Gl, de mouse e teclado
        GLCanvas canvas = new GLCanvas(c);
        janela.add(canvas, BorderLayout.CENTER);
        canvas.addGLEventListener(renderer);
        canvas.addKeyListener(renderer);
        canvas.addMouseListener(renderer);
        janela.setVisible(true);
        canvas.requestFocus();
        final FPSAnimator anim = new FPSAnimator(canvas, 1);

        janela.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                anim.stop();
                //   System.exit(0);
            }
        });
        anim.start();
    }
}
