package VT01;

public class Aresta {

    public int inicio;
    public int fim;

    public Aresta() {
    }

    public Aresta(int ini, int fim) {
        this.inicio = ini;
        this.fim = fim;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int ini) {
        this.inicio = ini;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

}
