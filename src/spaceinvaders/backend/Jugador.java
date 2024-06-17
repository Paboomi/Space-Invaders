package spaceinvaders.backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

/**
 *
 * @author saien
 */
public class Jugador extends JComponent{
    
    private int x, y;
    private int dy;

    public Jugador(int x, int y) {
        this.x = x;
        this.y = y;
        this.dy = 0;
    }
    public void move() {
        y += dy;
        y = Math.max(0, Math.min(y, 550)); // Limitar el movimiento a los bordes
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 50, 50);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -5;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
}
