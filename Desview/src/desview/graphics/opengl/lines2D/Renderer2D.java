package desview.graphics.opengl.lines2D;

/**
 * This class represents the Renderer 2D.
 * <br> Thanks to Leonardo Peres.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 21/05/2010.
 */
import com.sun.opengl.util.j2d.TextRenderer;
import desview.controller.snmp.SNMPFacade;
import desview.graphics.opengl.spiral2D.Instance;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import org.jdesktop.swingx.JXFrame;

public class Renderer2D extends KeyAdapter implements GLEventListener, MouseListener {

    private GL gl;
    private GLU glu;
    private GLAutoDrawable glDrawable;
    private float left, right, bottom, top;
    private float panX, panY;
    private float width, height;
    private TextRenderer text;
    private int textPosition, increment;
    private Task task;
    private LinkedList<Instance> instances1, instances2, instances3, instances4, instances5,
            instances6, instances7, instances8, instances9, instances10;
    //  instances11, instances12, instances13, instances14, instances15,
    //  instances16, instances17, instances18, instances19, instances20;
    private int numberOfVariables;
    private int contador1, contador2, contador3, contador4, contador5,
            contador6, contador7, contador8, contador9, contador10;
    // contador11, contador12, contador13, contador14, contador15,
    //  contador16, contador17, contador18, contador19, contador20;

    /**
     * Constructor of class.
     * @param task the selected task.
     */
    public Renderer2D(Task task) {
        this.task = task;
        this.numberOfVariables = task.getVariables().size();
        initComponents();
    }

    void initComponents() {
        switch (numberOfVariables) {
            case 1:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                break;
            case 2:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                break;
            case 3:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                break;
            case 4:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                instances4 = new LinkedList<Instance>();
                contador4 = 0;
                break;
            case 5:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                instances4 = new LinkedList<Instance>();
                contador4 = 0;
                instances5 = new LinkedList<Instance>();
                contador5 = 0;
                break;
            case 6:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                instances4 = new LinkedList<Instance>();
                contador4 = 0;
                instances5 = new LinkedList<Instance>();
                contador5 = 0;
                instances6 = new LinkedList<Instance>();
                contador6 = 0;
                break;
            case 7:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                instances4 = new LinkedList<Instance>();
                contador4 = 0;
                instances5 = new LinkedList<Instance>();
                contador5 = 0;
                instances6 = new LinkedList<Instance>();
                contador6 = 0;
                instances7 = new LinkedList<Instance>();
                contador7 = 0;
                break;
            case 8:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                instances4 = new LinkedList<Instance>();
                contador4 = 0;
                instances5 = new LinkedList<Instance>();
                contador5 = 0;
                instances6 = new LinkedList<Instance>();
                contador6 = 0;
                instances7 = new LinkedList<Instance>();
                contador7 = 0;
                instances8 = new LinkedList<Instance>();
                contador8 = 0;
                break;
            case 9:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                instances4 = new LinkedList<Instance>();
                contador4 = 0;
                instances5 = new LinkedList<Instance>();
                contador5 = 0;
                instances6 = new LinkedList<Instance>();
                contador6 = 0;
                instances7 = new LinkedList<Instance>();
                contador7 = 0;
                instances8 = new LinkedList<Instance>();
                contador8 = 0;
                instances9 = new LinkedList<Instance>();
                contador9 = 0;
                break;
            case 10:
                instances1 = new LinkedList<Instance>();
                contador1 = 0;
                instances2 = new LinkedList<Instance>();
                contador2 = 0;
                instances3 = new LinkedList<Instance>();
                contador3 = 0;
                instances4 = new LinkedList<Instance>();
                contador4 = 0;
                instances5 = new LinkedList<Instance>();
                contador5 = 0;
                instances6 = new LinkedList<Instance>();
                contador6 = 0;
                instances7 = new LinkedList<Instance>();
                contador7 = 0;
                instances8 = new LinkedList<Instance>();
                contador8 = 0;
                instances9 = new LinkedList<Instance>();
                contador9 = 0;
                instances10 = new LinkedList<Instance>();
                contador10 = 0;
                break;
        }
    }

    /**
     * Metodo definido na interface GLEventListener e chamado pelo objeto no qual sera feito o desenho
     * logo apos a inicializacao do contexto OpenGL.
     * @param drawable
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        textPosition = 0;
        increment = 2;
        panX = panY = 0;
        left = -20.0f;
        bottom = -40.0f;
        right = 20.0f;
        top = 15.0f;
        glDrawable = drawable;
        gl = drawable.getGL();
        glu = new GLU();

        drawable.setGL(new DebugGL(gl));

        // gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); //white
        gl.glClearColor(0, 0, 0, 1.0f); //black

        // Define a janela de visualizacao 2D
        gl.glMatrixMode(GL.GL_PROJECTION);
        glu.gluOrtho2D(left + panX, right + panX, bottom + panY, top + panY);

        gl.glMatrixMode(GL.GL_MODELVIEW);
        text = new TextRenderer(new Font("SansSerif", Font.BOLD, 24), true, true);
        InsertThread i = new InsertThread();
        i.start();
    }

    /**
     * Metodo definido na interface GLEventListener e chamado pelo objeto no qual sera feito o desenho
     * para comecar a fazer o desenho OpenGL pelo cliente.
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) {

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        glu.gluOrtho2D((left + panX) * width / 500, (right + panX) * width / 500, (bottom + panY) * height / 500, (top + panY) * height / 500);
        gl.glMatrixMode(GL.GL_MODELVIEW);

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        //desenhaEixos();
        text.beginRendering((int) width, (int) height);
        text.setColor(0.0f, 0.0f, 1.0f, 1.0f);
        text.draw(" ", textPosition, (int) height - 40);
        text.endRendering();
        if (textPosition > width || textPosition < 0) {
            increment -= increment;
        }
        textPosition += increment;
        for (int i = 1; i <= 10; i++) {
            switch (i) {
                case 1:
                    if (instances1 != null) {
                        for (Instance instance : instances1) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 2:
                    if (instances2 != null) {
                        for (Instance instance : instances2) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 3:
                    if (instances3 != null) {
                        for (Instance instance : instances3) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 4:
                    if (instances4 != null) {
                        for (Instance instance : instances4) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 5:
                    if (instances5 != null) {
                        for (Instance instance : instances5) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 6:
                    if (instances6 != null) {
                        for (Instance instance : instances6) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 7:
                    if (instances7 != null) {
                        for (Instance instance : instances7) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 8:
                    if (instances8 != null) {
                        for (Instance instance : instances8) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 9:
                    if (instances9 != null) {
                        for (Instance instance : instances9) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
                case 10:
                    if (instances10 != null) {
                        for (Instance instance : instances10) {
                            drawLine(i, instance.getR(), instance.getG(), instance.getB(), 3);
                        }
                    }
                    break;
            }
            gl.glTranslatef(5, 0, 0);
        }
    }

    /**
     * Metodo definido na interface GLEventListener e chamado pelo objeto no qual sera feito o desenho
     * depois que a janela foi redimensionada.
     * @param drawable
     * @param x
     * @param y
     * @param width
     * @param height
     */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        gl.glViewport(0, 0, width, height);
    }

    /**
     * Metodo definido na interface GLEventListener e chamado pelo objeto no qual sera feito o desenho
     * quando o modo de exibicao ou o dispositivo de exibicao associado foi alterado.
     * @param drawable
     * @param modeChanged
     * @param deviceChanged
     */
    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    /**
     * Metodo definido na interface KeyListener que esta sendo implementado que seja
     * feita a saida do sistema quando for pressionada a tecla ESC.
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                break;
            case KeyEvent.VK_HOME:
                zoomIn();
                break;
            case KeyEvent.VK_END:
                zoomOut();
                break;
            case KeyEvent.VK_UP:
                panY += 0.1;
                break;
            case KeyEvent.VK_DOWN:
                panY -= 0.1;
                break;
            case KeyEvent.VK_LEFT:
                panX -= 0.1;
                break;
            case KeyEvent.VK_RIGHT:
                panX += 0.1;
                break;
        }
        glDrawable.display();
    }

    private void zoomOut() {
        left = left * 2;
        right = right * 2;
        bottom = bottom * 2;
        top = top * 2;
    }

    private void zoomIn() {
        left = left / 2;
        right = right / 2;
        bottom = bottom / 2;
        top = top / 2;
    }

    public void createInstances() {
        List<Variable> lista = task.getVariables();
        for (int i = 0; i < numberOfVariables; i++) {
            Instance instance = null;
            Variable v = lista.get(i);
            instance = cria(v);
            switch (i) {
                case 0:
                    if (instances1 != null) {
                        instances1.add(instance);
                    }
                    break;
                case 1:
                    if (instances2 != null) {
                        instances2.add(instance);
                    }
                    break;
                case 2:
                    if (instances3 != null) {
                        instances3.add(instance);
                    }
                    break;
                case 3:
                    if (instances4 != null) {
                        instances4.add(instance);
                    }
                    break;
                case 4:
                    if (instances5 != null) {
                        instances5.add(instance);
                    }
                    break;
                case 5:
                    if (instances6 != null) {
                        instances6.add(instance);
                    }
                    break;
                case 6:
                    if (instances7 != null) {
                        instances7.add(instance);
                    }
                    break;
                case 7:
                    if (instances8 != null) {
                        instances8.add(instance);
                    }
                    break;
                case 8:
                    if (instances9 != null) {
                        instances9.add(instance);
                    }
                    break;
                case 9:
                    if (instances10 != null) {
                        instances10.add(instance);
                    }
                    break;
            }
        }
    }

    public Instance cria(Variable v) {
        Instance instance = null;

        int status = 0;// inicialization is good
        String read = SNMPFacade.snmpGet(v.getOid(), task.getEquipment().getIP(), task.getEquipment().getReadCommunity());
        double data = Double.valueOf(read);
        String vu = v.getUpper();
        if (vu == null) {
            vu = "0";
        }
        String vl = v.getLower();
        if (vl == null) {
            vl = "0";
        }
        if (data <= Double.parseDouble(vl)) {
            status = -1; // is lower
            instance = new Instance(255, 255, 0, v.getLabel(), data, status);//yellow
        } else if (data >= Double.parseDouble(vu)) {
            status = 1; // is upper
            instance = new Instance(255, 0, 0, v.getLabel(), data, status);
        } else if (data > Double.parseDouble(vl) && data < Double.parseDouble(vu)) {//good
            status = 0;
            instance = new Instance(0, 255, 0, v.getLabel(), data, status);
        }
        instance.setLower(Double.parseDouble(vl));
        instance.setUpper(Double.parseDouble(vu));
        instance.setOid(v.getOid());
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        float x = ((evento.getX() - 0) / ((1024 - 0) / (((right + panX) * width / 500) - ((left + panX) * width / 500)))) + ((left + panX) * width / 500) + 1;
        float y = ((evento.getY() - 768) / ((0 - 745) / (((top + panY) * height / 500) - ((bottom + panY) * height / 500)))) + ((bottom + panY) * height / 500) + 1;
        for (Instance i : instances1) {
            if (i != null) {
                System.out.println("i: " + i.getName() + " ix: " + i.getTx() + " iy: " + i.getTy());
                System.out.println("X: " + x + " Y: " + y);
                if (x <= (i.getTx() + 0.5) && x >= (i.getTx() - 0.5)) {
                    Popup p = new Popup(i.getName(), String.valueOf(i.getValue()), String.valueOf(i.getUpper()), String.valueOf(i.getLower()), i.getStatus());
                    p.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                    p.setVisible(true);
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent evento) {
    }

    @Override
    public void mouseExited(MouseEvent evento) {
    }

    @Override
    public void mousePressed(MouseEvent evento) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    public void drawLine(int j, float r, float g, float b, int lineWidth) {
        switch (j) {
            case 1:
                contador1 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador1 <= -800) {
                    contador1 = 0;
                    instances1 = new LinkedList<Instance>();
                    System.gc();
                }
                for (int i = contador1; i <= 0; i++) {
                    gl.glVertex2d(-45, 600);
                    gl.glVertex2d(-45, contador1);
                }
                gl.glEnd();
                break;

            case 2:
                contador2 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador2 <= -800) {
                    contador2 = 0;
                }
                for (int i = contador2; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador2);
                }
                gl.glEnd();
                break;

            case 3:
                contador3 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador3 <= -800) {
                    contador3 = 0;
                }
                for (int i = contador3; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador3);
                }
                gl.glEnd();
                break;

            case 4:
                contador4 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador4 <= -800) {
                    contador4 = 0;
                }
                for (int i = contador4; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador4);
                }
                gl.glEnd();
                break;


            case 5:
                contador5 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador5 <= -800) {
                    contador5 = 0;
                }
                for (int i = contador5; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador5);
                }
                gl.glEnd();
                break;

            case 6:
                contador6 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador6 <= -800) {
                    contador6 = 0;
                }
                for (int i = contador6; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador6);
                }
                gl.glEnd();
                break;


            case 7:
                contador7 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador7 <= -800) {
                    contador7 = 0;
                }
                for (int i = contador7; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador7);
                }
                gl.glEnd();
                break;

            case 8:
                contador8 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador8 <= -800) {
                    contador8 = 0;
                }
                for (int i = contador8; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador8);
                }
                gl.glEnd();
                break;

            case 9:
                contador9 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador9 <= -800) {
                    contador9 = 0;
                }
                for (int i = contador9; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador9);
                }
                gl.glEnd();
                break;

            case 10:
                contador10 -= 10;
                gl.glLineWidth(lineWidth);
                gl.glColor3f(r, g, b);
                gl.glBegin(GL.GL_LINES);
                if (contador10 <= -800) {
                    contador10 = 0;
                }
                for (int i = contador10; i <= 0; i++) {
                    gl.glVertex2d(-45, 10);
                    gl.glVertex2d(-45, contador10);
                }
                gl.glEnd();
                break;
        }
    }

    private void shiftData(Instance[] data, Instance newInstance) {
        for (int i = 1; i < data.length; ++i) {
            data[i - 1] = data[i];
        }
        data[data.length - 1] = newInstance;
    }

    void desenhaEixos() {
        gl.glLineWidth(1);
        gl.glColor3f(0, 255, 255);
        //x
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(-800, 0);
        gl.glVertex2d(800, 0);
        gl.glEnd();
        //y
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(0, 800);
        gl.glVertex2d(0, -800);
        gl.glEnd();
    }

    class InsertThread extends Thread {

        @Override
        public void run() {
            while (true) {
                createInstances();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}

