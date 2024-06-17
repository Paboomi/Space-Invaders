package spaceinvaders.backend.enemigos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author saien
 */
public class Enemigo extends JComponent {

    private int x, y;
    private int salud;
    private int puntos;
    private boolean eliminado;
    private TipoEnemigo tipo;
    private ImageIcon imagenEnemigoIcon;
    private ImageIcon imagenExplosionIcon;
    private Image imagenEnemigo;
    private Image imagenExplosion;
    private boolean enExplosion;
    private long tiempoExplosion;
    private String PATH_ENEMIGO1 = "spaceinvader/Images";
    private String PATH_ENEMIGO2 = "spaceinvader/Images";
    private String PATH_ENEMIGO3 = "spaceinvader/Images";

    public Enemigo(int x, int y, TipoEnemigo tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.salud = tipo.getSalud();
        this.puntos = tipo.getPuntos();
        this.eliminado = false;
        this.enExplosion = false;
    }

    //Cargar imagenes segun el tipo de enemigo
    public void cargarImagen(TipoEnemigo tipo) {
        switch (tipo) {
            case TIPO_1:
                this.imagenEnemigoIcon = new ImageIcon(getClass().getClassLoader().getResource(PATH_ENEMIGO1 + "/enemigo_1x65.png"));
                break;
            case TIPO_2:
                this.imagenEnemigoIcon = new ImageIcon(getClass().getClassLoader().getResource(PATH_ENEMIGO1 + "/enemigo_2x65.png"));
                break;
            case TIPO_3:
                this.imagenEnemigoIcon = new ImageIcon(getClass().getClassLoader().getResource(PATH_ENEMIGO1 + "/enemigo_3x65.png"));
                break;
            default:
                throw new AssertionError();
        }

        this.imagenExplosionIcon = new ImageIcon(getClass().getClassLoader().getResource(PATH_ENEMIGO1 + "/explosion1.gif"));
        this.imagenEnemigo = imagenEnemigoIcon.getImage();
        this.imagenExplosion = imagenExplosionIcon.getImage();
    }

    public void move() {
        y += 2; // Movimiento hacia abajo
    }

    public void draw(Graphics2D g) {
//        g.setColor(Color.RED);
//        g.fillRect(x, y, 40, 40);

        if (enExplosion) {
            g.drawImage(imagenExplosion, x, y, null);
            if (System.currentTimeMillis() - tiempoExplosion >= 500) {
                eliminado = true;
            }
        } else {
            g.drawImage(imagenEnemigo, x, y, null);
        }
    }

    public void recibirDisparo() {
        salud--;
        if (salud <= 0) {
            enExplosion = true;
            tiempoExplosion = System.currentTimeMillis();
        }
    }

    public int getY() {
        return y;
    }

    public TipoEnemigo getTipo() {
        return tipo;
    }

    public boolean isEliminado() {
        return eliminado;
    }
    

}
