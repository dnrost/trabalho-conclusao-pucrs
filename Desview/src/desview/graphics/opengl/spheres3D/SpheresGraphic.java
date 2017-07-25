package desview.graphics.opengl.spheres3D;

import desview.controller.TaskControl;
import desview.graphics.opengl.lines2D.Popup;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.jouvieje.application.IGLApplication;
import org.jouvieje.camera.Viewer;
import org.jouvieje.camera.ViewerCamera;
import org.jouvieje.camera.MovableBehavior.CameraMode;
import org.jouvieje.font.BMFont;
import org.jouvieje.font.IFont;
import org.jouvieje.font.IFont.FontAlign;
import org.jouvieje.io.Stream;
import org.jouvieje.io.event.KeyEvent;
import org.jouvieje.io.input.IInput;
import org.jouvieje.math.Area;
import org.jouvieje.math.Matrix16f;
import org.jouvieje.math.Quaternion4f;
import org.jouvieje.math.Vector3f;
import org.jouvieje.opengl.IGL;
import org.jouvieje.opengl.IGLApi;
import org.jouvieje.opengl.IGLU;
import org.jouvieje.opengl.helper.ViewHelper;
import org.jouvieje.scene.IComponent;
import org.jouvieje.scene.ISceneTarget;
import org.jouvieje.scene.Scene;
import org.jouvieje.scene.picking.DefaultPicking;
import org.jouvieje.scene.picking.PickingEvent;
import org.jouvieje.terrain.ITerrain;
import org.jouvieje.texture.ITexture;
import org.jouvieje.texture.TextureParam;
import org.jouvieje.texture.TextureReader;
import org.jouvieje.texture.TextureID;
import org.jouvieje.texture.TextureLoader;
import org.jouvieje.visibility.BoundingBox;
import org.jouvieje.visibility.IBoundingVolume;
import static org.jouvieje.math.InlineMath.PI;

/**
 * Class for 3D visualization
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 15/06/2010.
 * @version 1.0
 */
public class SpheresGraphic extends Scene {

    private static Task task = null;
    /* Ground */
    private Dimension groundSize = new Dimension(20, 20);
    /* Viewer / Camera */
    private Vector<Viewer> viewers = new Vector<Viewer>();
    private ViewerCamera camera;
    /* Fog */
    private boolean fog = true, fogChange = true;
    /* Picking */
    private Area dragRegion = null;
    /* Picking: id */
    private final static int GROUND_ID = 10;
    private final static int OBJECT_ID = 20;
    private final static int VIEWER_ID = 30;
    private final static int MONTH_ID = 40;
    private final static int DAY_ID = 50;
    /* Picking: targets */
    private Vector<Target> targets, targetsMonth, targetDay;
    private final float targetDistance = groundSize.height - 4.0f;
    private static int variaveis;
    private static int objetivos;
    private static int meses = 12;
    private static int maxTargetsDay = 31;
    /* Textures */
    private TextureID[] textures;
    private int textureIndex = 0;
    /* Quadric */
    private Object quadric;
    private SelectType tipo = SelectType.INITIAL;
    private IFont font;

    public SpheresGraphic() {
        super();
        TaskControl taskControl = new TaskControl();
        StringBuilder s = new StringBuilder("Enter task name: \n");
        List<Task> lista = taskControl.getTasks();
        for (int i = 0; i < lista.size(); i++) {
            Task t = lista.get(i);
            s.append("   ~> ").append(t.getTaskName()).append("\n");
        }

        String name = JOptionPane.showInputDialog(null, s.toString());
        task = taskControl.getTaskByName(name);
        if (task != null) {
            List<Variable> l = task.getVariables();
            variaveis = l.size();
            objetivos = variaveis * meses;
        } else {
            JOptionPane.showMessageDialog(null, "task error");
            variaveis = 0;
            objetivos = 0;
        }
    }

    /**
     *
     * @param glApi
     * @param x
     * @param y
     * @param width
     * @param height
     */
    @Override
    public void reshape(IGLApi glApi, int x, int y, int width, int height) {
        super.reshape(glApi, x, y, width, height);
        if (camera != null) {
            camera.reshape(x, y, width, height);
        }
    }

    /**
     *
     * @param glApi
     */
    @Override
    public void init(IGLApi glApi) {
        super.init(glApi);

        final IGL gl = glApi.getGL();
        final IGLU glu = glApi.getGLU();
        final ISceneTarget sceneTarge_t = glApi.getSceneTarget();

        //Viewers initialization
        Viewer viewer1 = new Viewer(new BoundingBox(
                new Vector3f(-0.3f, -1.7f, -0.3f),
                new Vector3f(0.3f, 0.2f, 0.3f)));
        viewer1.setPosition(new Vector3f(groundSize.width / 2, 1.7f, 1.0f));
        viewers.add(viewer1);

        Viewer viewer2 = new Viewer(new BoundingBox(
                new Vector3f(-0.3f, -2.0f, -0.3f),
                new Vector3f(0.3f, 0.2f, 0.3f)));
        viewer2.setPosition(new Vector3f(groundSize.width - 1.0f, 2.0f, groundSize.height / 2));
        viewer2.setRotation(new Quaternion4f().fromAxisAngle(Vector3f.axisY, -PI / 2));
        viewers.add(viewer2);

        Viewer viewer3 = new Viewer(new BoundingBox(
                new Vector3f(-0.3f, -1.2f, -0.3f),
                new Vector3f(0.3f, 0.2f, 0.3f)));
        viewer3.setPosition(new Vector3f(1.0f, 1.2f, groundSize.height / 2));
        viewer3.setRotation(new Quaternion4f().fromAxisAngle(Vector3f.axisY, PI / 2));
        viewers.add(viewer3);

        //Camera initialisation
        camera = new ViewerCamera(sceneTarge_t);
        camera.attachMovable(viewer1);
        camera.setMouseControlled(true);
        camera.getBehavior().mode = CameraMode.TERRAIN;
        camera.terrain = new ITerrain() {

            IBoundingVolume<?> bounds = new BoundingBox(
                    new Vector3f(-1, -Float.MAX_VALUE, -1),
                    new Vector3f(23, Float.MAX_VALUE, 23));

            @Override
            public float getHeight(Vector3f vector) {
                return 0;
            }	//Flat terrain

            @Override
            public IBoundingVolume<?> getBoundingVolume(int bvOptions) {
                return bounds;
            }
        };

        //loads textures
        if (!loadTextures(glApi)) {
            JOptionPane.showMessageDialog(null, "FAILED TO LOAD TEXTURES !");
            sceneTarge_t.getGLApplication().exit();
            return;
        }

        quadric = glu.gluNewQuadric();

        //Font: see tutorials 17 to 20
        font = new BMFont(new Stream("/datas/fonts/CourrierNew__14.fnt"), new Stream("/datas/fonts/CourrierNew__14.png"));
        if (!font.init(glApi)) {
            font = null;
        }

        //Init targets
        targets = new Vector<Target>(objetivos);
        targetsMonth = new Vector<Target>(meses);
        targetDay = new Vector<Target>(maxTargetsDay);
        for (int i = 0; i < variaveis; i++) {
            for (int j = 0; j < meses; j++) {
                if (j == 5) {//only for test
                    targets.add(createTarget(2 * i, 2 * j, 255, 0, 0, 0.1f, 0.7f, task.getVariables().get(i).getOid()));
                } else {
                    targets.add(createTarget(2 * i, 2 * j, 0, 0, 255, 0.1f, 0.7f, task.getVariables().get(i).getOid()));
                }
            }
        }


        for (int i = 0; i < maxTargetsDay; i++) {
            targetDay.add(createDays(i, 0, 255, 0, 0.1f, 0.6f, ""));
        }

        //For object selection
        addPickable(pickable);

        //Fog
        float[] fogColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        gl.glFog(IGL.GL_FOG_COLOR, fogColor);
        gl.glFog(IGL.GL_FOG_MODE, IGL.GL_EXP2);
        gl.glFog(IGL.GL_FOG_DENSITY, 0.05f);
        gl.glHint(IGL.GL_FOG_HINT, IGL.GL_DONT_CARE);

        gl.glShadeModel(IGL.GL_SMOOTH);	//Smooth color shading
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);//Clearing color
        gl.glClearDepth(1.0);//Enable Clearing of the Depth buffer
        gl.glDepthFunc(IGL.GL_LEQUAL);//Type of Depth test
        gl.glEnable(IGL.GL_DEPTH_TEST);	//Enable Depth Testing

        //Define the correction done to the perspective calculation (perspective looks a it better)
        gl.glHint(IGL.GL_PERSPECTIVE_CORRECTION_HINT, IGL.GL_NICEST);

        //Draw the scene in loop
        sceneTarge_t.getRenderingLoop().start();
    }

    private Target createTarget(int x, int y, float red, float green, float blue, float height, float radius, String name) {
        return new Target(new Vector3f(groundSize.width / 2 + ((variaveis - 1) / 2 - x) * 3.0f,
                (y), targetDistance), red, green, blue, height, radius, name);
    }

    private Target createDays(int i, float red, float green, float blue, float height, float radius, String name) {
        return new Target(new Vector3f(groundSize.width / 2 + ((maxTargetsDay - 1) / 2 - i) * 3.0f,
                0.0f,
                targetDistance), red, green, blue, height, radius, name);
    }

    /** Texture loading */
    private boolean loadTextures(IGLApi glApi) {
        textures = new TextureID[2];

        TextureParam params = new TextureParam();
        params.magFilter = IGL.GL_LINEAR;
        params.minFilter = IGL.GL_LINEAR_MIPMAP_NEAREST;
        params.mipmap = true;

        TextureReader textureReader = new TextureReader();
        TextureLoader textureLoader = new TextureLoader(glApi);
        ITexture picture;

        picture = textureReader.readTexture(new Stream("/textures/Walkway4.png"));
        textures[0] = textureLoader.loadTexture2D(picture, params);
        picture = textureReader.readTexture(new Stream("/textures/Walkway7.png"));
        textures[1] = textureLoader.loadTexture2D(picture, params);

        return textureLoader.isTexture(textures[0]) && textureLoader.isTexture(textures[1]);
    }

    /**
     * Render
     * @param glApi
     */
    @Override
    public void render(IGLApi glApi) {
        super.render(glApi);

        final IGL gl = glApi.getGL();
        final Matrix16f modelView = getModelView().modelView;

        //Process input
        processInput(glApi, getInput());
        camera.processInput(glApi, getInput());

        /*
         * Here RenderMode is GL_RENDER.
         */
        gl.glClear(IGL.GL_COLOR_BUFFER_BIT | IGL.GL_DEPTH_BUFFER_BIT);	//Clear the buffers

        camera.update(getTimer().getTimePassedMillis());
        camera.lookAt(modelView);
        gl.glLoadMatrix(modelView);

        if (fogChange) {
            fogChange = false;
            if (fog) {
                gl.glEnable(IGL.GL_FOG);
            } else {
                gl.glDisable(IGL.GL_FOG);
            }
        }
        if (tipo == SelectType.INITIAL) {
            drawTargets(glApi);
        } else if (tipo == SelectType.MONTH) {
            drawMonth(glApi);
        } else if (tipo == SelectType.DAYS) {
            drawDays(glApi);
        }
        drawInfos(glApi);
    }

    /*
    Draw the target
     */
    private void drawTargets(IGLApi glApi) {
        final IGL gl = glApi.getGL();
        final IGLU glu = glApi.getGLU();

        gl.glLoadName(OBJECT_ID);
        gl.glPushName(0);
        for (int i = 0; i < targets.size(); i++) {
            Target target = targets.get(i);

            gl.glColor(target.getColor()[0], target.getColor()[1], target.getColor()[2]);
            gl.glPushMatrix();
            gl.glTranslate(target.getPosition().getX(), target.getPosition().getY(), target.getPosition().getZ());
            gl.glRotate(-90.0f, 1.0f, 0.0f, 0.0f);
            /*
             * Identify the object drawn by loading its identitier in the name stack.
             * Rem : this is ignored if RenderMode is not GL_SELECT.
             */
            gl.glLoadName(i);
            glu.gluSphere(quadric, target.getRadius(), 20, 20);
            gl.glPopMatrix();
        }
        gl.glPopName();

        gl.glColor(1.0f, 1.0f, 1.0f);
    }

    private void drawInfos(IGLApi glApi) {
        final IGL gl = glApi.getGL();

        final IComponent c = glApi.getSceneTarget().getComponent();
        final int width = c.getSize().getWidth();
        final int height = c.getSize().getHeight();

        ViewHelper.beginOrtho(glApi);
        int lineHeight = -font.getLineHeight();
        Vector3f position = new Vector3f(10, height - 20, 0);
        font.drawTextAt("Click on an object to select it.", position);
        position.addY(lineHeight);
        position.addY(lineHeight);

        position.set(width - 10, height - 20, 0);
        font.drawTextAt("FPS = " + getTimer().getFPS(), FontAlign.BotRight, -1, position);
        position.addY(lineHeight);
        if (dragRegion != null) {
            //Blend area
            gl.glEnable(IGL.GL_BLEND);
            gl.glBlendFunc(IGL.GL_SRC_ALPHA, IGL.GL_ONE_MINUS_SRC_ALPHA);
            gl.glColor(0, 0, 1, 0.25f);
//					ShapeRenderer.drawRectangle_ZPlane_VtxUvNrm(gl, dragRegion.width, dragRegion.height, dragRegion.x, dragRegion.y, 0);
            gl.glDisable(IGL.GL_BLEND);

            //Border
            gl.glPolygonMode(IGL.GL_FRONT, IGL.GL_LINE);
//					ShapeRenderer.drawRectangle_ZPlane_VtxUvNrm(gl, dragRegion.width, dragRegion.height, dragRegion.x, dragRegion.y, 0);
            gl.glPolygonMode(IGL.GL_FRONT, IGL.GL_FILL);
            gl.glColor(1, 1, 1, 1);
        }
        ViewHelper.endOrtho(glApi);
    }

    /**
     *Inputs
     * @param glApi
     * @param input
     */
    public void processInput(IGLApi glApi, IInput input) {
        if (input.isKeyClicked(KeyEvent.VK_ESCAPE) > 0) {
            final IGLApplication glApplication = glApi.getSceneTarget().getGLApplication();
            glApplication.exit();
        }
        if (input.isKeyClicked(KeyEvent.VK_F4) > 0) {//TODO
            tipo = SelectType.INITIAL;
            render(glApi);
        }
        if (input.isKeyClicked(KeyEvent.VK_F1) > 0) {
            camera.attachMovable(viewers.get(0));
        }
        if (input.isKeyClicked(KeyEvent.VK_F2) > 0) {
            camera.attachMovable(viewers.get(1));
        }
        if (input.isKeyClicked(KeyEvent.VK_F3) > 0) {
            camera.attachMovable(viewers.get(2));
        }
    }
    /**
     * Picking
     */
    private DefaultPicking pickable = new DefaultPicking() {

        @Override
        public boolean pickEvent(IGLApi glApi, PickingEvent mode, Area region) {
            dragRegion = null;
            switch (mode) {
                default:
                    return false;
                case LeftClick:
                    return true;
                case Drag:
                    if (!camera.isMouseControlled()) {
                        dragRegion = region;
                    }
                    return false;
                case Area:
                    return !camera.isMouseControlled();
            }
        }

        @Override
        public void pickMissed(IGLApi glApi, PickingEvent mode, Area region) {
        }

        @Override
        public void renderObjects(IGLApi glApi) {
            final IGL gl = glApi.getGL();
            final Matrix16f modelView = getModelView().modelView;

            /*
             * Here RenderMode is GL_SELECT.
             */
            gl.glClear(IGL.GL_COLOR_BUFFER_BIT | IGL.GL_DEPTH_BUFFER_BIT);	//Clear the buffers

            camera.update(getTimer().getTimePassedMillis());
            camera.lookAt(modelView);
            gl.glLoadMatrix(modelView);

            //Initialize name stack
            gl.glInitNames();
            gl.glPushName(0);

            /*
             * Here we draw only pickable objects. Don't draw the others.
             * Rem: the drawing is done out of the screen ie this will not be drawn in the screen.
             */
            if (tipo == SelectType.INITIAL) {
                drawTargets(glApi);
            } else if (tipo == SelectType.MONTH) {
                drawMonth(glApi);

            } else if (tipo == SelectType.DAYS) {
                drawDays(glApi);
            }
        }

        @Override
        public void processPicked(IGLApi glApi, PickingEvent mode, Area region, List<int[]> selection) {
            if (selection == null) {
                //Nothing selected
                fogChange = true;
                fog = !fog;
                return;
            }

            //Process event here
            for (int[] select : selection) {
                switch (select[0]) {
                    case GROUND_ID:
                        textureIndex++;
                        if (textureIndex >= textures.length) {
                            textureIndex = 0;
                        }
                        break;
                    case VIEWER_ID:
                        if (select.length > 0) {
                            camera.attachMovable(viewers.get(select[1]));
                        }
                        break;
                    case OBJECT_ID:
                        if (select.length > 0) {
                            targets.set(select[1], createTarget(select[1], 10, 0, 255, 0, 0.1f, 0.6f, ""));
                            System.out.println("picked" + select[1]);
                            Target t = getFromFirstList(select[1]);
                            if (t != null) {
                                Popup p = new Popup();
                                p.setVariableNameText(t.getName());
                                p.hideComponents();
                                p.setVisible(true);
                            }
                        }
                        tipo = SelectType.DAYS;

                        break;
                    case DAY_ID:
                        if (select.length > 0) {
                            targetDay.set(select[1], createDays(select[1], 0, 255, 0, 0.1f, 0.6f, ""));
                            System.out.println("picked" + select[1]);
                            //    tipo = SelectType.INITIAL;
                            System.out.println("RARARARARARARA");
                            Popup p = new Popup();
                            p.setVariableNameText(String.valueOf(select[1]));
                            p.hideComponents();
                            p.setVisible(true);
                        }
                        break;
                }
            }
        }

        @Override
        public int getNameStackSize() {
            //+1 for the grounds
            //name max stack depth
            return 2 * (targets.size() + viewers.size() + 1);
        }
    };

    /*
     * Draw the months
     */
    private void drawMonth(IGLApi glApi) {
        final IGL gl = glApi.getGL();
        final IGLU glu = glApi.getGLU();

        gl.glLoadName(MONTH_ID);
        gl.glPushName(0);
        for (int i = 0; i < targetsMonth.size(); i++) {
            Target target = targetsMonth.get(i);

            gl.glColor(target.getColor()[0], target.getColor()[1], target.getColor()[2]);
            gl.glPushMatrix();
            gl.glTranslate(target.getPosition().getX(), target.getPosition().getY(), target.getPosition().getZ());
            gl.glRotate(-90.0f, 1.0f, 0.0f, 0.0f);
            /*
             * Identify the object drawn by loading its identitier in the name stack.
             * Rem : this is ignored if RenderMode is not GL_SELECT.
             */
            gl.glLoadName(i);
            glu.gluSphere(quadric, target.getRadius(), 20, 20);
            gl.glPopMatrix();
        }
        gl.glPopName();

        gl.glColor(1.0f, 1.0f, 1.0f);
    }

    /*
    Draw the months
     */
    private void drawDays(IGLApi glApi) {
        final IGL gl = glApi.getGL();
        final IGLU glu = glApi.getGLU();

        gl.glLoadName(DAY_ID);
        gl.glPushName(0);
        for (int i = 0; i < targetDay.size(); i++) {
            Target target = targetDay.get(i);

            gl.glColor(target.getColor()[0], target.getColor()[1], target.getColor()[2]);
            gl.glPushMatrix();
            gl.glTranslate(target.getPosition().getX(), target.getPosition().getY(), target.getPosition().getZ());
            gl.glRotate(-90.0f, 1.0f, 0.0f, 0.0f);
            /*
             * Identify the object drawn by loading its identitier in the name stack.
             * Rem : this is ignored if RenderMode is not GL_SELECT.
             */
            gl.glLoadName(i);

            glu.gluSphere(quadric, target.getRadius(), 20, 20);
            gl.glPopMatrix();
        }
        gl.glPopName();

        gl.glColor(1.0f, 1.0f, 1.0f);
    }

    private Target getFromFirstList(int position) {
        return targets.get(position);
    }
}
