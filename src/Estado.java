import java.util.ArrayList;
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
        h = heuristica();
        f=0;
        g=0;
        if(!listaProduccion.isEmpty())
        creaPredecesores();
    }

    private int heuristica() {
        int mejor=5;
        Pila pilas[]=almacen.getPilas();
        for (int i=0; i<pilas.length; i++) {
            if(pilas[i].getActual()<pilas[i].getLimite() && pilas[i].getLimite()-pilas[i].getActual()<mejor){
                mejor=pilas[i].getLimite() - pilas[i].getActual();
            }
        }
        return mejor;
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

    public boolean creaPredecesores(){

        predecesores = new ArrayList<Estado>();
        int nCaja = 0;
        Caja aColocar=new Caja();
        do{

                aColocar = listaProduccion.get(nCaja);
                for (int i = 0; i < 5; i++) {
                    Almacen nuevoAlmacen = new Almacen();
                    nuevoAlmacen = almacen;
                    if (nuevoAlmacen.colocar(aColocar, i)) {
                       List<Caja> listaNueva=new ArrayList<Caja>();
                       listaNueva=listaProduccion;
                       listaNueva.remove(aColocar);
                        Estado posible = new Estado(this, listaNueva, nuevoAlmacen);
                        predecesores.add(posible);
                    }
                }
                nCaja++;

        }while(predecesores.isEmpty() && nCaja<listaProduccion.size()-1);

        if(predecesores.size() != 0){
            listaProduccion.remove(aColocar);
            return true;
        }
        return false;
    }
}
