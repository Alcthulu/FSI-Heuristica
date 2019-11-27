import java.util.ArrayList;
import java.util.List;

public class Pila {

    private List<Caja> lBox;
    private int actual, limite;

    public Pila() {
        this.lBox = new ArrayList<Caja>();
        this.actual = 0;
        this.limite = 4;
    }

    public List<Caja> getlBox() {
        return lBox;
    }

    public void setlBox(List<Caja> lBox) {
        this.lBox = lBox;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public boolean colocar(Caja aColocar){
        if(actual<limite && lBox.get(lBox.size()).getDiaSalida()>=aColocar.getDiaSalida()){
            lBox.add(aColocar);
            ++actual;
            return true;
        }
        return false;
    }
}
