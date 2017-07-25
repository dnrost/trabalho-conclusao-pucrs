package desview.graphics.opengl.spheres3D;

import org.jouvieje.math.Vector3f;

/**
 * Class for 3D visualization (target)
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 15/06/2010.
 * @version 1.0
 */
public class Target {
    //Position

    private Vector3f position;
    //Geometry properties
    private float height;
    private float radius;
    //Color
    private float[] color;
    private String name;

    public Target(Vector3f position, float r, float g, float b, float height, float radius, String name) {
        setHeight(height);
        setRadius(radius);
        setColor(new float[]{r, g, b});
        setPosition(position);
        setName(name);
    }

    public float[] getColor() {
        return color;
    }

    public void setColor(float[] color) {
        this.color = color;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
