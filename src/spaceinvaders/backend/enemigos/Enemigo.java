package spaceinvaders.backend.enemigos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author saien
 */
public class Enemigo extends JComponent{
    private int x, y;

    public Enemigo() {
        this.x = x;
        this.y = y;
    }
    public void move() {
        y += 2; // Movimiento hacia abajo
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 40, 40);
    }

    public int getY() {
        return y;
    }
    
}
