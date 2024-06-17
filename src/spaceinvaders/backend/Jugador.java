package spaceinvaders.backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
    private String PATH_NAVE = "spaceinvaders/Images";
    private Image imgNave;
    private ImageIcon imgNaveIcon;

    public Jugador(int x, int y, int heightPanel, int widthPanel) {
        this.x = x;
        this.y = y;
        this.dy = 0;
        this.bullets = new ArrayList<>();
        this.heightPanel = heightPanel;
    }

    public void move(int dy) {
        y += dy;
        y = Math.max(0, Math.min(y, heightPanel - 40)); // Limitar el movimiento a los bordes
    }

    public void draw(Graphics g) {
        this.imgNaveIcon = new ImageIcon(getClass().getClassLoader().getResource(PATH_NAVE+"/nave2x65.png"));
        this.imgNave = imgNaveIcon.getImage();
//        g.setColor(Color.GREEN);
        g.drawImage(imgNave, x, y, null);
//        g.fillRect(x, y, 40, 40);

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
            move(dy);
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = speed;
            move(dy);
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
