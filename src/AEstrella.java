import java.util.ArrayList;
import java.util.List;

public class AEstrella {

    List<Estado> listaAbierta;
    List<Estado> listaCerrada;

    public AEstrella() {
        listaAbierta = new ArrayList<Estado>();
        listaCerrada = new ArrayList<Estado>();
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

    public void crearArbol(Estado ini) throws Exception{
        Estado actual = ini;
        if(!actual.getListaProduccion().isEmpty()) actual.creaPredecesores();
        listaAbierta.add(ini);

        while (listaAbierta.size()>0){
            int mejor = 0;
            actual = listaAbierta.get(mejor);
            for( int i = 0; i<listaAbierta.size(); i++){
                if(listaAbierta.get(i).getF() < listaAbierta.get(mejor).getF()){
                    mejor = i;
                    actual = listaAbierta.get(mejor);
                }
            }

            if(actual.getListaProduccion().isEmpty() || actual.getAlmacen().lleno()){
                System.out.println(actual.getAlmacen().toString());
                if(actual.getAlmacen().lleno()){
                    System.out.println("\n\nNo caben : \n\t");
                    System.out.println(actual.getListaProduccion().toString());
                }
                return;
            }else if(actual.getPredecesores()==null){
                actual.creaPredecesores();
            }

            listaCerrada.add(actual);

            if(actual.getPredecesores()!=null){
                for(Estado vecino:actual.getPredecesores()) {
                    if (!listaCerrada.contains(vecino)) {
                        if (!listaAbierta.contains(vecino)) {
                            listaAbierta.add(vecino);
                        }
                        vecino.setF(vecino.getG() + vecino.getH());
                    }
                }
            }
            listaAbierta.remove(actual);
        }
    }


}
