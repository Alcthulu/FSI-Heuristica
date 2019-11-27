public class Caja {
    private int identificador, diaEntrada, diaSalida;

    public Caja(int identificador, int diaEntrada, int diaSalida) {
        this.identificador = identificador;
        this.diaEntrada = diaEntrada;
        this.diaSalida = diaSalida;
    }

    public Caja() {

    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(int diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public int getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(int diaSalida) {
        this.diaSalida = diaSalida;
    }
}
