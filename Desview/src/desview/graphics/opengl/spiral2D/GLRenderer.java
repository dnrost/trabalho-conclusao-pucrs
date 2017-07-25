package desview.graphics.opengl.spiral2D;

import desview.controller.snmp.SNMPFacade;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import desview.util.Message;
import java.util.LinkedList;
import java.util.List;
import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * This class is the Renderer of the Spiral graphic.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 26/05/2008.
 */
public class GLRenderer implements GLEventListener {

    private int counter1 = 1, counter2 = 1, counter3 = 1, counter4 = 1;
    private int RESTART_VALUE = 10000;
    private List<Instance> instances1, instances2, instances3, instances4;
    private Task task;
    private int numberOfVariables;
    private boolean inform1 = false, inform2 = false;

    /**
     * Constructor of class.
     * @param task the task to monitoring.
     */
    public GLRenderer(Task task) {
        this.task = task;
        this.numberOfVariables = task.getVariables().size();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0f, 0f, 0f, 1f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
        createList();
        InsertThread p = new InsertThread();
        p.start();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        //createInstances();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        if (instances1 != null && !instances1.isEmpty()) {
            desenha1(gl, instances1);
        }
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        if (instances2 != null && !instances2.isEmpty()) {
            desenha2(gl, instances2);
        }
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        if (instances3 != null && !instances3.isEmpty()) {
            desenha3(gl, instances3);
        }
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        if (instances4 != null && !instances4.isEmpty()) {
            desenha4(gl, instances4);
        }
        gl.glLoadIdentity();
        gl.glFlush();
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    private void desenha1(GL gl, List<Instance> list) {
        int kill = counter1++;
        double raio = 0.00001;
        double x = raio * Math.sin(0);
        double y = raio * Math.cos(0);

        gl.glLineWidth(2);

        gl.glTranslatef(-1f, 1.0f, 0.0f);
        x = raio * Math.sin(0);
        y = raio * Math.cos(0);
        gl.glBegin(gl.GL_LINE_STRIP);
        if (kill >= RESTART_VALUE) {
            System.out.println("\tRestarting...");
            counter1 = 0;
            instances1 = new LinkedList<Instance>();
            System.gc();
        }
        for (int j = 0; j < list.size(); j++) {
            gl.glColor3f(list.get(j).getR(), list.get(j).getG(), list.get(j).getB());
            gl.glVertex3d(x, y, 0);

            double rad = Math.toRadians(j);
            raio += 0.00025;
            x = raio * Math.sin(rad);
            y = raio * Math.cos(rad);
        }
        gl.glEnd();
    }

    private void desenha2(GL gl, List<Instance> list) {
        int kill = counter2++;
        double raio = 0.00001;
        double x = raio * Math.sin(0);
        double y = raio * Math.cos(0);

        gl.glLineWidth(2);

        gl.glTranslatef(3f, 1.0f, 0.0f);
        x = raio * Math.sin(0);
        y = raio * Math.cos(0);
        gl.glBegin(gl.GL_LINE_STRIP);
        if (kill >= RESTART_VALUE) {
            System.out.println("\tRestarting...");
            counter2 = 0;
            instances2 = new LinkedList<Instance>();
            System.gc();
        }
        for (int j = 0; j < list.size(); j++) {
            gl.glColor3f(list.get(j).getR(), list.get(j).getG(), list.get(j).getB());
            gl.glVertex3d(x, y, 0);

            double rad = Math.toRadians(j);
            raio += 0.0025;
            x = raio * Math.sin(rad);
            y = raio * Math.cos(rad);
        }
        gl.glEnd();
    }

    private void desenha3(GL gl, List<Instance> list) {
        int kill = counter3++;
        double raio = 0.00001;
        double x = raio * Math.sin(0);
        double y = raio * Math.cos(0);

        gl.glLineWidth(2);

        gl.glTranslatef(-1f, -1f, 0.0f);
        x = raio * Math.sin(0);
        y = raio * Math.cos(0);
        gl.glBegin(gl.GL_LINE_STRIP);
        if (kill >= RESTART_VALUE) {
            System.out.println("\tRestarting...");
            counter3 = 0;
            instances3 = new LinkedList<Instance>();
            System.gc();
        }
        for (int j = 0; j < list.size(); j++) {
            gl.glColor3f(list.get(j).getR(), list.get(j).getG(), list.get(j).getB());
            gl.glVertex3d(x, y, 0);

            double rad = Math.toRadians(j);
            raio += 0.0025;
            x = raio * Math.sin(rad);
            y = raio * Math.cos(rad);
        }
        gl.glEnd();
    }

    private void desenha4(GL gl, List<Instance> list) {
        int kill = counter4++;
        double raio = 0.00001;
        double x = raio * Math.sin(0);
        double y = raio * Math.cos(0);

        gl.glLineWidth(2);

        gl.glTranslatef(3f, -1f, 0.0f);
        x = raio * Math.sin(0);
        y = raio * Math.cos(0);
        gl.glBegin(gl.GL_LINE_STRIP);
        if (kill >= RESTART_VALUE) {
            System.out.println("\tRestarting...");
            counter4 = 0;
            instances4 = new LinkedList<Instance>();
            System.gc();
        }
        for (int j = 0; j < list.size(); j++) {
            gl.glColor3f(list.get(j).getR(), list.get(j).getG(), list.get(j).getB());
            gl.glVertex3d(x, y, 0);

            double rad = Math.toRadians(j);
            raio += 0.0025;
            x = raio * Math.sin(rad);
            y = raio * Math.cos(rad);
        }
        gl.glEnd();
    }

    private void createList() {
        //create new arrays.
        switch (numberOfVariables) {
            case 0:
                //do nothing.
                StringBuilder b = new StringBuilder("Number of variables in");
                b.append(task.getTaskName());
                b.append(" is 0.");
                Message.information(null, "Nothing to do!", b.toString());
                break;
            case 1:
                instances1 = new LinkedList<Instance>();
                break;
            case 2:
                instances1 = new LinkedList<Instance>();
                instances2 = new LinkedList<Instance>();
                break;
            case 3:
                instances1 = new LinkedList<Instance>();
                instances2 = new LinkedList<Instance>();
                instances3 = new LinkedList<Instance>();
                break;
            default:
                instances1 = new LinkedList<Instance>();
                instances2 = new LinkedList<Instance>();
                instances3 = new LinkedList<Instance>();
                instances4 = new LinkedList<Instance>();
        }
    }

    private int createInstances() {
        int time = 0;
        List<Variable> lista = task.getVariables();
        String freq = task.getFrequency();
        String[] t = freq.split(":");

        time = (Integer.parseInt(t[0]) * 3600000);
        time += (Integer.parseInt(t[1]) * 60000);
        time += (Integer.parseInt(t[2]) * 1000);
        for (int i = 0; i < numberOfVariables; i++) {
            Instance instance = null;
            Variable v = lista.get(i);
            instance = cria(v);
            switch (i) {
                case 0:
                    instances1.add(instance);
                    break;
                case 1:
                    instances2.add(instance);
                    break;
                case 2:
                    instances3.add(instance);
                    break;
                case 3:
                    instances4.add(instance);
                    break;
            }
        }
        return time;
    }

    class InsertThread extends Thread {

        @Override
        public void run() {
            while (true) {
                int s = createInstances();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    private Instance cria(Variable v) {
        Instance instance = null;
        int status = 0;// inicialization is good

        String read = SNMPFacade.snmpGet(v.getOid(), task.getEquipment().getIP(), task.getEquipment().getReadCommunity());
        double data = Double.valueOf(read);
        String vu = v.getUpper();
        if (vu == null) {
            vu = "0";
            if (!inform1) {
                inform1 = true;
                Message.warning(null, "Upper value threshold", "The upper threshold is not set.");
            }
        }
        String vl = v.getLower();
        if (vl == null) {
            vl = "0";
            if (!inform2) {
                inform2 = true;
                Message.warning(null, "Upper value threshold", "The upper threshold is not set.");
            }
        }
        if (data < Double.parseDouble(vl)) {
            status = -1; // is lower, yellow
            instance = new Instance(255f, 255f, 0f, v.getLabel(), data, status);
        } else if (data > Double.parseDouble(vu)) {
            status = 1; // is upper, red
            instance = new Instance(255f, 0f, 0f, v.getLabel(), data, status);
        } else if (data >= Double.parseDouble(vl) && data <= Double.parseDouble(vu)) {
            status = 0; //is good, green
            instance = new Instance(0f, 255f, 0f, v.getLabel(), data, status);
        }

        instance.setLower(Double.parseDouble(vl));
        instance.setUpper(Double.parseDouble(vu));
        instance.setOid(v.getOid());
        return instance;
    }
}
