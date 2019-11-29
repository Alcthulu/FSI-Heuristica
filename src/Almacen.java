import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Almacen implements Serializable {

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

    public Almacen deepCopy() throws Exception
    {
        //Serialization of object
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(this);

        //De-serialization of object
        ByteArrayInputStream bis = new   ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        Almacen copied = (Almacen) in.readObject();

        //Verify that object is not corrupt

        //validateNameParts(fName);
        //validateNameParts(lName);

        return copied;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "pilas=" + Arrays.toString(pilas) +
                '}';
    }

    public Boolean lleno(){
        for (Pila p: pilas) {
            if(p.getActual()<p.getLimite()) return false;
        }
        return true;
    }
}
