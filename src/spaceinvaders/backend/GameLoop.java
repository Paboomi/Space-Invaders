package spaceinvaders.backend;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import spaceinvaders.backend.enemigos.Enemigo;
import spaceinvaders.backend.item.Item;
import spaceinvaders.frontend.juego.Juego;

/**
 *
 * @author saien
 */
public class GameLoop extends Thread {

    private Juego gamePanel;
    private Timer timer;

    public GameLoop(Juego gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    @Override
    public void run(){
        // Crear un Timer para actualizar el juego y el panel de indicadores
        timer = new Timer(16, new ActionListener() { // Aproximadamente 60 FPS
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.repaint();
            }
        });
        timer.start();
    }

//    @Override
//    public void run() {
//        while (true) {
//            gamePanel.getJugador().move();
//            gamePanel.getJugador().updateBullets();
//            for (Enemigo enemy : gamePanel.getEnemies()) {
//                enemy.move();
//            }
//            for (Item item : gamePanel.getItems()) {
//                item.move();
//            }
//
//            gamePanel.repaint();
//
//            // Verificar colisiones
//            checkCollisions();
//
//            try {
//                Thread.sleep(16); // Aproximadamente 60 FPS
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private void checkCollisions() {
        Jugador player = gamePanel.getJugador();
        Rectangle playerBounds = new Rectangle(player.getX(), player.getY(), 40, 40);

        //Colisiones entre jugador y enemigo
        for (Enemigo enemy : gamePanel.getEnemies()) {
            Rectangle enemyBounds = new Rectangle(enemy.getX(), enemy.getY(), 40, 40);
            if (playerBounds.intersects(enemyBounds)) {
                System.out.println("Juego terminado. Un enemigo ha tocado la nave.");
                System.exit(0);
            }
        }
        
        //Colisiones entre balas y enemigos
        List<Bullet> bullets = player.getBullets();
        List<Enemigo> enemies = gamePanel.getEnemies();
        List<Enemigo> enemiesToRemove = new ArrayList<>();
        List<Bullet> bulletsToRemove = new ArrayList<>();
        
        for (Bullet bullet : bullets) {
            Rectangle bulletBounds = bullet.getBounds();
            for (Enemigo enemy : enemies) {
                Rectangle enemyBounds = new Rectangle(enemy.getX(), enemy.getY(), 40, 40);
                if (bulletBounds.intersects(enemyBounds)) {
                    enemiesToRemove.add(enemy);
                    bulletsToRemove.add(bullet);
                }
            }
        }

        enemies.removeAll(enemiesToRemove);
        bullets.removeAll(bulletsToRemove);

        //Colisiones entre jugador e items
        for (Item item : gamePanel.getItems()) {
            Rectangle itemBounds = new Rectangle(item.getX(), item.getY(), 20, 20);
            if (playerBounds.intersects(itemBounds)) {
                if (item.isPowerUp()) {
                    System.out.println("¡Potenciador recogido!");
                } else {
                    System.out.println("¡Debilitador recogido!");
                }
                gamePanel.getItems().remove(item);
                break;
            }
        }
    }
}
