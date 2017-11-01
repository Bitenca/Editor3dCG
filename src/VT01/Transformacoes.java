package VT01;

import java.util.ArrayList;
import java.util.List;

public class Transformacoes {

    public static float[][] mult(float[][] A, float[][] B) {

        float[][] aux = new float[A.length][B[0].length];

        for (int m = 0; m < A.length; m++) {

            for (int n = 0; n < B[0].length; n++) {

                aux[m][n] = 0;
                for (int k = 0; k < A[0].length; k++) {

                    aux[m][n] = aux[m][n] + A[m][k] * B[k][n];
                }
            }
        }
        return aux;
    }

    public static Point3D rotacao(Point3D A, float graus) {
        graus = (float) Math.PI * graus / 180;

        float cos = (float) Math.cos(graus);
        float sin = (float) Math.sin(graus);

        float[][] rot = {
            {1f, 0,     0, 0f},
            {0f,cos, -sin, 0f},
            {0f,sin,  cos, 0f},
            {0f, 0f,   0f, 1f}
        };
        float ponto[][] = mult(A.getMatriz(), rot);
        return new Point3D(ponto);
    }

    public static Point3D translacao(Point3D A, float dx, float dy, float dz) {
        float[][] tran = {
            {1f, 0f, 0f, 0f},
            {0f, 1f, 0f, 0f},
            {0f, 0f, 1f, 0f},
            {dx, dy, dz, 1f}
        };
        float ponto[][] = mult(A.getMatriz(), tran);
        return new Point3D(ponto);
    }

    public static Point3D escala(Point3D A, float sx, float sy, float sz) {
        float[][] esc = {
            {sx, 0f, 0f, 0f},
            {0f, sy, 0f, 0f},
            {0f, 0f, sz, 0f},
            {0f, 0f, 0f, 1f}
        };
        float ponto[][] = mult(A.getMatriz(), esc);
        return new Point3D(ponto);
    }

    public static void translacao(Geometria geom, float dx, float dy, float dz) {
        List<Point3D> newPontos = new ArrayList<Point3D>();
        for (Point3D ponto : geom.getPontos()) {
            newPontos.add(translacao(ponto, dx, dy,dz));
        }
        geom.setPontos(newPontos);
    }

    public static void rotacao(Geometria geom, float ang) {
        List<Point3D> newPontos = new ArrayList<Point3D>();
        for (Point3D ponto : geom.getPontos()) {
            newPontos.add(rotacao(ponto, ang));
        }
        geom.setPontos(newPontos);
    }

    public static void escala(Geometria geom, float sx, float sy, float sz) {
        List<Point3D> novosPontos = new ArrayList<Point3D>();
        for (Point3D ponto : geom.getPontos()) {
            novosPontos.add(escala(ponto, sx, sy, sz));
        }
        geom.setPontos(novosPontos);
    }
    
    public static float[][] transformadaVisualizacao3d(float theta, float phi, float rho){
        theta = (float)(Math.PI * theta / 180.0);
        phi = (float)(Math.PI * phi / 180.0);
        
        float[][] out = {
                {-(float)Math.sin(theta), -(float)Math.cos(phi)*(float)Math.cos(theta),(float)Math.cos(phi)*(float)Math.cos(theta),0},
                { (float)Math.sin(theta), -(float)Math.cos(phi)*(float)Math.cos(theta),(float)Math.cos(phi)*(float)Math.cos(theta),0},
                {0,(float)Math.sin(phi), (float)+Math.cos(phi),0},
                {0,0,-rho,0}
        };
    return out;
    }

}
