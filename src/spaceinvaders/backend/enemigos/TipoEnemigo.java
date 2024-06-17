package spaceinvaders.backend.enemigos;

/**
 *
 * @author saien
 */
public enum TipoEnemigo {
    TIPO_1(2, 10),
    TIPO_2(3, 20),
    TIPO_3(4, 30);

    private final int salud;
    private final int puntos;

    TipoEnemigo(int salud, int puntos) {
        this.salud = salud;
        this.puntos = puntos;
    }

    public int getSalud() {
        return salud;
    }

    public int getPuntos() {
        return puntos;
    }
}
