import java.util.List;

public class AEstrella {

    List<Estado> listaAbierta;
    List<Estado> listaCerrada;

    public AEstrella(List<Estado> listaAbierta, List<Estado> listaCerrada) {
        this.listaAbierta = listaAbierta;
        this.listaCerrada = listaCerrada;
    }

    public List<Estado> getListaAbierta() {
        return listaAbierta;
    }

    public void setListaAbierta(List<Estado> listaAbierta) {
        this.listaAbierta = listaAbierta;
    }

    public List<Estado> getListaCerrada() {
        return listaCerrada;
    }

    public void setListaCerrada(List<Estado> listaCerrada) {
        this.listaCerrada = listaCerrada;
    }

    public void crearArbol(Estado ini){
        Estado actual = ini;
        do {

        }while (!actual.getListaProduccion().isEmpty());
    }


}
