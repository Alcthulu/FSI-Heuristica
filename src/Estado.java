import java.util.List;

public class Estado {

    private Estado apuntador;
    private List<Caja> listaProduccion;
    private Almacen almacen;
    private List<Estado> predecesores;

    private int g, h, f;

    public Estado(Estado apuntador, List<Caja> listaProduccion, Almacen almacen) {
        this.apuntador = apuntador;
        this.listaProduccion = listaProduccion;
        this.almacen = almacen;


    }

    public List<Estado> getPredecesores() {
        return predecesores;
    }

    public void setPredecesores(List<Estado> predecesores) {
        this.predecesores = predecesores;
    }

    public Estado getApuntador() {
        return apuntador;
    }

    public void setApuntador(Estado apuntador) {
        this.apuntador = apuntador;
    }

    public List<Caja> getListaProduccion() {
        return listaProduccion;
    }

    public void setListaProduccion(List<Caja> listaProduccion) {
        this.listaProduccion = listaProduccion;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void creaPredecesores(){
        Caja aColocar=listaProduccion.get(0);
        listaProduccion.remove(0);
        for(int i=0; i<6; i++){
            Almacen nuevoAlmacen = new Almacen();
            nuevoAlmacen = almacen;
            if(nuevoAlmacen.colocar(aColocar,i)){
                Estado posible = new Estado(this, listaProduccion, nuevoAlmacen );
                predecesores.add(posible);
            }
        }
    }
}
