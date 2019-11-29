import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estado {

    private Estado apuntador;
    private List<Caja> listaProduccion;
    private Almacen almacen;
    private List<Estado> predecesores;
    private double ultimaCaja;

    private double g, h, f;

    public Estado(Estado apuntador, List<Caja> listaProduccion, Almacen almacen,int ultimoDiaSal) {
        this.apuntador = apuntador;
        this.listaProduccion = listaProduccion;
        this.almacen = almacen;
        this.ultimaCaja=ultimoDiaSal;
        h = heuristica();
        f=g+h;
        g=listaProduccion.size();
    }

    private double heuristica() {
        double mejor=0;
        double totalH=0;
        Pila pilas[]=almacen.getPilas();
        for (int i=0; i<pilas.length; i++) {
            totalH+=pilas[i].getLimite() - pilas[i].getActual();
            if(pilas[i].getLimite()-pilas[i].getActual()>mejor){
                mejor=pilas[i].getLimite() - pilas[i].getActual();
            }
        }
        return totalH-mejor+(30/ultimaCaja);
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

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public boolean creaPredecesores() throws Exception {

        predecesores = new ArrayList<Estado>();
        int nCaja = 0;
        Caja aColocar=new Caja();

        do{

                aColocar = listaProduccion.get(nCaja);
                for (int i = 0; i < 5; i++) {
                    Almacen nuevoAlmacen = almacen.deepCopy();
                    if (nuevoAlmacen.colocar(aColocar, i)) {
                       List<Caja> listaNueva=new ArrayList<Caja>(listaProduccion);
                       int diaSalida=aColocar.getDiaSalida();
                       listaNueva.remove(aColocar);
                       Estado posible = new Estado(this, listaNueva, nuevoAlmacen,diaSalida);
                       predecesores.add(posible);
                    }
                }
                nCaja++;

        }while(nCaja<listaProduccion.size());

        if(predecesores.size() != 0){
            return true;
        }
        return false;
    }

}
