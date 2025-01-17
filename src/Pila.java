import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pila implements Serializable {

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
        if(!lBox.isEmpty()){
            if(actual<limite && lBox.get(lBox.size()-1).getDiaSalida()>=aColocar.getDiaSalida()){
                lBox.add(aColocar);
                ++actual;
                return true;
            }
        }else{
            lBox.add(aColocar);
            ++actual;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nPila{" + lBox.toString()+
                ", actual=" + actual +
                ", limite=" + limite +
                '}';
    }
}
