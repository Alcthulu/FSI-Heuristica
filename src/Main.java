import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Caja cajas[] = new Caja[18];
        cajas[0] = new Caja(0,1,17);
        cajas[1] = new Caja(1,1,17);
        cajas[2] = new Caja(2,1,17);
        cajas[3] = new Caja(3,1,17);
        cajas[4] = new Caja(4,1,17);
        cajas[5] = new Caja(5,1,17);
        cajas[6] = new Caja(6,1,17);
        cajas[7] = new Caja(7,1,17);
        cajas[8] = new Caja(8,1,17);
        cajas[9] = new Caja(9,1,17);
        cajas[10] = new Caja(10,1,17);
        cajas[11] = new Caja(11,1,17);
        cajas[12] = new Caja(12,1,18);
        cajas[13] = new Caja(13,1,18);
        cajas[14] = new Caja(14,1,18);
        cajas[15] = new Caja(14,1,18);
        cajas[16] = new Caja(14,1,18);
        cajas[17] = new Caja(14,1,19);

        List<Caja> cajotas = new ArrayList<Caja>();
        for (int i=0; i<cajas.length; i++) {
            cajotas.add(cajas[i]);
        }

        Estado inicio = new Estado(null, cajotas, new Almacen());
        AEstrella AE = new AEstrella();
        AE.crearArbol(inicio);


    }
}
