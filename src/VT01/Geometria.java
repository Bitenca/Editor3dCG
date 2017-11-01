package VT01;

import java.awt.Color;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Geometria {

    private String id;
    private List<Point2D> pontosPersp = new ArrayList<Point2D>();
    private List<Point3D> pontos = new ArrayList<Point3D>();
    private List<Aresta> arestas = new ArrayList<Aresta>();
    public Color cor = Color.GREEN;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Point3D> getPontos() {
        return pontos;
    }

    public void setPontos(List<Point3D> pontos) {
        this.pontos = pontos;
    }
    
    public List<Point2D> getPontosPersp() {
        return pontosPersp;
    }

    public void setPontosPersp(List<Point2D> pontos) {
        this.pontosPersp = pontos;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> vertices) {
        this.arestas = vertices;
    }
    
    public static Geometria build(BufferedReader reader) throws IOException {

		Geometria geometria = new Geometria();
		
		String id = reader.readLine();
		geometria.setId(id);
		
		String snroPontos = reader.readLine();
		Integer nroPontos = Integer.parseInt(snroPontos);
		
		for(int i = 0; i <nroPontos; i++)
		{
			String linha = reader.readLine();
			String[] coords = linha.split(" ");
			float x = Float.parseFloat(coords[0]);
			float y = Float.parseFloat(coords[1]);
                        float z = Float.parseFloat(coords[2]);
			Point3D ponto = new Point3D(x,y,z);
			geometria.getPontos().add(ponto);
		}
		
		String snroArestas = reader.readLine();
		Integer nroArestas = Integer.parseInt(snroArestas);
		
		for(int i = 0; i <nroArestas; i++)
		{
			String linha = reader.readLine();
			String[] coords = linha.split(" ");
			int p1 = Integer.parseInt(coords[0]);
			int p2 = Integer.parseInt(coords[1]);
			Aresta aresta = new Aresta(p1,p2);
			geometria.getArestas().add(aresta);
		}
		
		return geometria;
	}

}
