package VT01;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PainelDesenho extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private Timer timer = new Timer(30,this);
    
    public int centerX, centerY;
    public int maxX, maxY;
    float pixelSize, rWidth = 100.0F, rHeight = 100.0F;
    public List<Geometria> geometrias = new ArrayList<Geometria>();

    ///novo
    private boolean primeiraVez = true;
    private RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    private BufferedImage bi;
    private Graphics2D fundo;
    ///

    private void init() {
        Dimension d = getSize();
        maxX = d.width - 1;
        maxY = d.height - 1;
        pixelSize = Math.max(rWidth / maxX, rHeight / maxY);
        centerX = maxX / 2;
        centerY = maxY / 2;
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;

        if (primeiraVez) {
            initEixo();
            init();
            bi = (BufferedImage) createImage(maxX, maxY);
            fundo = bi.createGraphics();
            fundo.setStroke(new BasicStroke(1.5f));
            fundo.setRenderingHints(qualityHints);
            primeiraVez = false;
        }

        fundo.setPaint(Color.BLACK);
        fundo.fillRect(0, 0, maxX, maxY);

        for (int i = 0; i < geometrias.size(); i++) {
            drawGeometria(fundo, geometrias.get(i), geometrias.get(i).cor);
        }
        g2.drawImage(bi, 0, 0, this);
    }

    private void initEixo() {
//        Geometria geometria = new Geometria();
//        geometria.setId("Target *nao editar pufavo*");
//        geometria.getPontos().add(new Point2D(-200, 0));
//        geometria.getPontos().add(new Point2D(200, 0));
//        geometria.getPontos().add(new Point2D(0, -200));
//        geometria.getPontos().add(new Point2D(0, 200));

   //     geometria.getArestas().add(new Aresta(0, 1));
    //    geometria.getArestas().add(new Aresta(2, 3));

 //       geometrias.add(geometria);

        //criaTriangulo();
        //criacasa();
    }

    void drawGeometria(Graphics g, Geometria geom, Color color) {
        AplicaPerspectiva(geom);
        
        if (color != null) {
            g.setColor(color);
        }
        geom.getArestas().forEach((aresta) -> {
            Point2D p1 = geom.getPontosPersp().get(aresta.getInicio());
            Point2D p2 = geom.getPontosPersp().get(aresta.getFim());
            drawLinha(g, p1, p2);
        });
    }

    void drawLinha(Graphics g, Point2D p1, Point2D p2) {
        g.drawLine(ix(p1.x), iy(p1.y), ix(p2.x), iy(p2.y));
    }

    public void aplicaTransformacao(Geometria gselec, float dx, float dy, float dz) {

        Transformacoes.translacao(gselec, dx, dy, dz);
        repaint();
    }

    public void aplicaRotacao(float graus, Geometria gselec) {

        Transformacoes.rotacao(gselec, graus);
        repaint();
    }

    public void aplicaEscala(Geometria gselec, float dx, float dy, float dz) {
        Transformacoes.escala(gselec, dx, dy, dz);
        repaint();
    }
    
    public Geometria GetByNome(String id) {
        for (Geometria geo : geometrias) {
            if (geo.getId().equals(id)) {
                return geo;
            }
        }
        return null;
    }

    int ix(float x) {
        return centerX + Math.round(x / pixelSize);
    }

    int iy(float y) {
        return centerY - Math.round(y / pixelSize);
    }

    public void setZoom(float zoom) {
        for (int i = 0; i < geometrias.size(); i++) {
            aplicaEscala(geometrias.get(i), zoom, zoom, zoom);
        }
        //fundo.setStroke(new BasicStroke(zoom + 0.5f));
    }
    

//    private void criacasa() {
//        Geometria geometria = new Geometria();
//        geometria.setId("Casa");
//        geometria.cor = Color.gray;
//        geometria.getPontos().add(new Point2D(-13, -8));
//        geometria.getPontos().add(new Point2D(-6, -8));
//        geometria.getPontos().add(new Point2D(13, -8));
//        geometria.getPontos().add(new Point2D(-13, 6));
//        geometria.getPontos().add(new Point2D(-6, 6));
//        geometria.getPontos().add(new Point2D(13, 6));
//        geometria.getPontos().add(new Point2D(-9, 13));
//        geometria.getPontos().add(new Point2D(9, 13));
//
//        geometria.getArestas().add(new Aresta(0, 1));
//        geometria.getArestas().add(new Aresta(1, 2));
//        geometria.getArestas().add(new Aresta(2, 5));
//        geometria.getArestas().add(new Aresta(1, 4));
//        geometria.getArestas().add(new Aresta(0, 3));
//        geometria.getArestas().add(new Aresta(3, 4));
//        geometria.getArestas().add(new Aresta(4, 5));
//        geometria.getArestas().add(new Aresta(5, 7));
//        geometria.getArestas().add(new Aresta(4, 6));
//        geometria.getArestas().add(new Aresta(3, 6));
//        geometria.getArestas().add(new Aresta(6, 7));
//
//        geometrias.add(geometria);
//    }

//    private void criaTriangulo() {
//        Geometria geometria = new Geometria();
//        geometria.setId("Triangulo");
//        geometria.cor = Color.red;
//        geometria.getPontos().add(new Point2D(10, 10));
//        geometria.getPontos().add(new Point2D(10, 35));
//        geometria.getPontos().add(new Point2D(35, 35));
//        geometria.getPontos().add(new Point2D(10, 10));
//
//        geometria.getArestas().add(new Aresta(0, 1));
//        geometria.getArestas().add(new Aresta(1, 2));
//        geometria.getArestas().add(new Aresta(2, 3));
//
//        geometrias.add(geometria);
//    }
    
    private float theta = 30f;
    private float phi = 60f;
    private float rho = 200f;
    private float d = 400f;
    
    
    
    public void AplicaVisualizacao(float theta, float phi, float rho, float d){
        this.theta = theta;
        this.phi = phi;
        this.rho = rho;
        this.d = d;
        
        repaint();
    }

    public void AplicaPerspectiva(Geometria geo) {
        float[][] matVis3d = Transformacoes.transformadaVisualizacao3d(theta, phi, rho);
        geo.getPontosPersp().clear();
        for(Point3D point: geo.getPontos()){
            Point3D novoPonto3D = new Point3D();
            novoPonto3D.setMatriz(Transformacoes.mult(point.getMatriz(), matVis3d));
            
            float x = -d * novoPonto3D.getX() / novoPonto3D.getZ();
            float y = -d * novoPonto3D.getY() / novoPonto3D.getZ();
            Point2D novo = new Point2D(x,y);
            geo.getPontosPersp().add(novo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        aplicaComposicoes();
        repaint();
    }

    public void aplicaComposicoes() {
        Geometria geoselec = geometrias.get(0);
        Transformacoes.rotacao(geoselec, 4);
    }
    
    public void animar(){
        timer.start();
    }
    
    public void desanimar(){
        timer.stop();
    }
    

}
