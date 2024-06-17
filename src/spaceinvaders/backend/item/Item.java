package spaceinvaders.backend.item;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author saien
 */
public class Item {

    private int x, y;
    private boolean isPowerUp;

    public Item(int x, int y, boolean isPowerUp) {
        this.x = x;
        this.y = y;
        this.isPowerUp = isPowerUp;
    }

    public void move() {
        y += 2; // Movimiento hacia abajo
    }

    public void draw(Graphics g) {
        g.setColor(isPowerUp ? Color.BLUE : Color.YELLOW);
        g.fillRect(x, y, 20, 20);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isPowerUp() {
        return isPowerUp;
    }
    
    
}
