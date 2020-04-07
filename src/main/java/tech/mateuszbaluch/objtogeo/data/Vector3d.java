package tech.mateuszbaluch.objtogeo.data;

public class Vector3d {
    private double x, y, z;

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void div(double f) {
        x /= f;
        y /= f;
        z /= f;
    }
}
