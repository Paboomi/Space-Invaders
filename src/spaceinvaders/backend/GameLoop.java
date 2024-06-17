package spaceinvaders.backend;

import java.awt.Rectangle;
import spaceinvaders.backend.enemigos.Enemigo;
import spaceinvaders.backend.item.Item;
import spaceinvaders.frontend.juego.Juego;

/**
 *
 * @author saien
 */
public class GameLoop extends Thread {

    private Juego gamePanel;

    public GameLoop(Juego gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        while (true) {
            gamePanel.getJugador().move();
            for (Enemigo enemy : gamePanel.getEnemies()) {
                enemy.move();
            }
            for (Item item : gamePanel.getItems()) {
                item.move();
            }

            gamePanel.repaint();

            // Verificar colisiones
            checkCollisions();

            try {
                Thread.sleep(16); // Aproximadamente 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkCollisions() {
        Jugador player = gamePanel.getJugador();
        Rectangle playerBounds = new Rectangle(player.getX(), player.getY(), 50, 50);

        for (Enemigo enemy : gamePanel.getEnemies()) {
            Rectangle enemyBounds = new Rectangle(enemy.getX(), enemy.getY(), 40, 40);
            if (playerBounds.intersects(enemyBounds)) {
                System.out.println("Juego terminado. Un enemigo ha tocado la nave.");
                System.exit(0);
            }
        }

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
