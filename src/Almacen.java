import java.util.List;

public class Almacen {

    private Pila[] Pilas;

    public Almacen() {
        Pilas = new Pila[5];
    }

    public Pila[] getPilas() {
        return Pilas;
    }

    public void setPilas(Pila[] pilas) {
        Pilas = pilas;
    }
}
