package spaceinvaders.frontend.juego;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.*;
import spaceinvaders.backend.Bullet;
import spaceinvaders.backend.Jugador;
import spaceinvaders.backend.enemigos.Enemigo;
import spaceinvaders.backend.enemigos.TipoEnemigo;
import spaceinvaders.backend.item.Item;

public class Juego extends JPanel {

    private Jugador jugador;
    private List<Enemigo> enemies;
    private List<Item> items;
    private BufferedImage buffer;

    public Juego() {
        jugador = new Jugador(50, 250, this.getHeight(), this.getWidth());
        enemies = new ArrayList<>();
        items = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {

        setFocusable(true);
        setSize(1178, 587);
        setPreferredSize(new Dimension(1178, 587));
        setDoubleBuffered(true);
        setVisible(true);

        generarEnemigos();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                jugador.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                jugador.keyReleased(e);
            }
        });
        buffer = new BufferedImage(1178, 587, BufferedImage.TYPE_INT_ARGB);

    }
    
    public void actualizarJuego() {
//        jugador.move();
        jugador.updateBullets();

        for (Enemigo enemigo : enemies) {
            enemigo.move();
        }

        verificarColisiones();
        repaint();
    }

    //Generar los enemigos
    private void generarEnemigos() {
        int columna = 0;
        for (int i = 0; i < 8; i++) {
            enemies.add(new Enemigo(500 + columna * 60, 50 + i * 60, TipoEnemigo.TIPO_1));
        }
        columna++;
        for (int i = 0; i < 8; i++) {
            enemies.add(new Enemigo(500 + columna * 60, 50 + i * 60, TipoEnemigo.TIPO_2));
        }
        columna++;
        for (int i = 0; i < 8; i++) {
            enemies.add(new Enemigo(500 + columna * 60, 50 + i * 60, TipoEnemigo.TIPO_2));
        }
        columna++;
        for (int i = 0; i < 8; i++) {
            enemies.add(new Enemigo(500 + columna * 60, 50 + i * 60, TipoEnemigo.TIPO_3));
        }
        columna++;
        for (int i = 0; i < 8; i++) {
            enemies.add(new Enemigo(500 + columna * 60, 50 + i * 60, TipoEnemigo.TIPO_3));
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) buffer.getGraphics();
        g2d.clearRect(0, 0, getWidth(), getHeight());

        jugador.draw(g2d);

        for (Enemigo enemy : enemies) {
            enemy.draw(g2d);
        }
        for (Item item : items) {
            item.draw(g2d);
        }
        g.drawImage(buffer, 0, 0, null);
    }

    // Método para verificar las restricciones de eliminación
    private boolean sePuedeEliminar(Enemigo enemigo) {
        if (enemigo.getTipo() == TipoEnemigo.TIPO_2) {
            return enemies.stream().noneMatch(e -> e.getTipo() == TipoEnemigo.TIPO_1 && !e.isEliminado());
        } else if (enemigo.getTipo() == TipoEnemigo.TIPO_3) {
            return enemies.stream().noneMatch(e -> (e.getTipo() == TipoEnemigo.TIPO_1 || e.getTipo() == TipoEnemigo.TIPO_2) && !e.isEliminado());
        }
        return true;
    }

    private void verificarColisiones() {
        Iterator<Enemigo> iterEnemigos = enemies.iterator();
        while (iterEnemigos.hasNext()) {
            Enemigo enemigo = iterEnemigos.next();
            Iterator<Bullet> iterBullets = jugador.getBullets().iterator();
            while (iterBullets.hasNext()) {
                Bullet bullet = iterBullets.next();
                if (bullet.colisionaCon(enemigo) && sePuedeEliminar(enemigo)) {
                    enemigo.recibirDisparo();
                    iterBullets.remove();
                    if (enemigo.isEliminado()) {
                        iterEnemigos.remove();
                        // Agregar puntos al jugador
                    }
                }
            }
        }
    }

    public Jugador getJugador() {
        return jugador;
    }

    public List<Enemigo> getEnemies() {
        return enemies;
    }

    public List<Item> getItems() {
        return items;
    }

}
