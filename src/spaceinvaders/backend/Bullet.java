package spaceinvaders.backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import spaceinvaders.backend.enemigos.Enemigo;

/**
 *
 * @author saien
 */
public class Bullet extends JComponent {

    private int x, y;
    private int speed = 5;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        x += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 10, 5);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 5);
    }
     public boolean colisionaCon(Enemigo enemigo) {
        return this.x < enemigo.getX() + 40 && this.x + 10 > enemigo.getX() && this.y < enemigo.getY() + 40 && this.y + 10 > enemigo.getY();
    }

}
