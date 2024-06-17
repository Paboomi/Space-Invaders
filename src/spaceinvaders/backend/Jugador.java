package spaceinvaders.backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author saien
 */
public class Jugador extends JComponent {

    private int x, y;
    private int dy;
    private int speed = 5;
    private List<Bullet> bullets;
    private int heightPanel;
    private int widthPanel;

    public Jugador(int x, int y, int heightPanel, int widthPanel) {
        this.x = x;
        this.y = y;
        this.dy = 0;
        this.bullets = new ArrayList<>();
        this.heightPanel = heightPanel;
    }

    public void move() {
        y += dy;
        y = Math.max(0, Math.min(y, heightPanel - 40)); // Limitar el movimiento a los bordes
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 40, 40);

        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    public void Shoot() {
        bullets.add(new Bullet(x + 40, y + 20));
    }
    
    public void updateBullets() {
        List<Bullet> toRemove = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.move();
            if (bullet.getX() > widthPanel) {
                toRemove.add(bullet);
            }
        }
        bullets.removeAll(toRemove);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -speed;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = speed;
        }
        if (key == KeyEvent.VK_SPACE) {
            Shoot();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    public List<Bullet> getBullets() {
        return bullets;
    }

}
