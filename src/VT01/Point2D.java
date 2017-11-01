package VT01;

public class Point2D {

    public float x;
    public float y;
    public float w;

    public Point2D() {
        super();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
     public float getW() {
        return w;
    }

    public void setW(float W) {
        this.w = w;
    }

    public Point2D(float[][] mat) {
        this.x = mat[0][0];
        this.y = mat[0][1];
        this.w = mat[0][2];
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
        this.w = 1;
    }

    public Point2D(float x, float y, float w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public float[][] getMatriz() {
        float[][] out = new float[1][3];
        out[0][0] = x;
        out[0][1] = y;
        out[0][2] = w;
        return out;
    }
}
