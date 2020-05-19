package org.kasad0r;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Starter extends JPanel implements Runnable {
    public static StatisticsBar statisticsBar;
    private float lastTime;
    private static Game game;
    public static JFrame frame;
    private static boolean running;
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;
    public static ScoresController scoresController = new ScoresController();
    public static KeyStroke exit = KeyStroke.getKeyStroke("ctrl shift pressed Q");
    public static Thread thread;

    public static void showEndGameDialog(long population) {
        EndGameDialog dialog = new EndGameDialog(population);
        dialog.setLocation(WIDTH / 2, HEIGHT / 2);
        dialog.setSize(300, 300);
        dialog.setVisible(true);

    }

    public Starter() {
        frame = new JFrame();
        Dimension size = new Dimension(Starter.WIDTH, Starter.HEIGHT);
        frame.pack();
        frame.setSize(size);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Anti PlagueInc.");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        game = new Game();
        thread = new Thread(this);
        statisticsBar = new StatisticsBar();
        running = true;
        thread.start();
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game.checkMouse(e);
            }
        };
        addMouseListener(mouseAdapter);
    }

    @Override
    public void run() {
        while (running) {

            repaint();
            statisticsBar.repaint();
            StatisticsBar.dialog.repaint();
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        if (running) {
            float currentTime = System.nanoTime();
            float delta = currentTime - lastTime;
            lastTime = currentTime;
            game.tick(delta);

            game.render(g);
        }

    }


    public void start() {

        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(e -> {
            KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);
            if (exit.equals(keyStroke)) {
                EpidemicController.clean();
                running = false;
                frame.getContentPane().removeAll();
                Application.starter.start();
            }
            return false;
        });
        scoresController.restoreData();
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setVisible(true);
        frame.add(menuPanel);
        frame.setVisible(true);
    }

    public void loadGame() {

        init();
        frame.add(this, BorderLayout.CENTER);
        frame.add(statisticsBar, BorderLayout.NORTH);
    }
}