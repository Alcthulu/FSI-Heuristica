import java.util.List;

public class Almacen {

    private Pila[] pilas;

    public Almacen() {
        pilas = new Pila[5];
        for(int i=0; i<pilas.length; i++){
            pilas[i] = new Pila();
        }
    }

    public Pila[] getPilas() {
        return pilas;
    }

    public void setPilas(Pila[] pilas) {
        this.pilas = pilas;
    }

    public boolean colocar(Caja acolocar, int pila){
        return pilas[pila].colocar(acolocar);
    }
}
