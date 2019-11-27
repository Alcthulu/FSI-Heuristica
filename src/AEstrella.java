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

    public void crearArbol(Estado ini){
        Estado actual = ini;
        listaAbierta = new ArrayList<Estado>();
        listaAbierta.add(ini);

        while (listaAbierta.size()>0){
            int mejor = 0;
            for( int i = 0; i<listaAbierta.size(); i++){
                if(listaAbierta.get(i).getF() < listaAbierta.get(mejor).getF()){
                    mejor = i;
                    actual = listaAbierta.get(mejor);
                }
            }

            if(actual.getListaProduccion().isEmpty()){
                System.out.println("Done");
                break;
            }

            listaCerrada.add(actual);
            listaAbierta.remove(actual);

            for (Estado vecino:actual.getPredecesores()) {
                if(!listaCerrada.contains(vecino)){
                    int tempG = actual.getG()+1;

                    if(listaAbierta.contains(vecino)){
                        if(tempG<vecino.getG()){
                            vecino.setG(tempG);
                        }
                    }else {
                        vecino.setG(tempG);
                        listaAbierta.add(vecino);
                    }

                    vecino.setF(vecino.getG()+vecino.getH());
                }
            }
        }
    }


}
