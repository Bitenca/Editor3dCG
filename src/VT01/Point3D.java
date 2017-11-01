package VT01;

public class Point3D extends Point2D {

    public float z;

    public Point3D() {
        super();
    }

    public Point3D(float[][] mat) {
        this.x = mat[0][0];
        this.y = mat[0][1];
        this.z = mat[0][2];
        this.w = mat[0][3];
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setMatriz(float[][] mat) {
        this.x = mat[0][0];
        this.y = mat[0][1];
        this.z = mat[0][2];
        this.w = mat[0][3];
    }

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }

    public Point3D(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public float[][] getMatriz() {
        float[][] out = {{getX(), getY(), z, getW()}};
        return out;
    }
}
