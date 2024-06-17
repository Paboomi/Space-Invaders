package spaceinvaders.frontend.juego;

import java.awt.Dimension;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
import spaceinvaders.backend.Jugador;
import spaceinvaders.backend.enemigos.Enemigo;
import spaceinvaders.backend.item.Item;

public class Juego extends JPanel {

    private Jugador jugador;
    private List<Enemigo> enemies;
    private List<Item> items;

    public Juego() {
        jugador = new Jugador(400, 500);
        enemies = new ArrayList<>();
        items = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        
        setFocusable(true);
        setSize(1178, 587);
        setPreferredSize(new Dimension(1178, 587));
        for (int i = 0; i < 10; i++) {
            enemies.add(new Enemigo());

        }
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
