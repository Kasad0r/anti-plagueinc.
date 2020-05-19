package org.kasad0r;

import org.kasad0r.domain.Difficulty;
import org.kasad0r.domain.Score;
import org.kasad0r.domain.VirusFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        Starter.scoresController.restoreData();
        var buttonEasy = new JButton("EASY");
        var buttonMedium = new JButton("MEDIUM");
        var buttonHard = new JButton("HARD");
        var buttonStart = new JButton("Start");
        var buttonExit = new JButton("Exit");
        var scoreList = ScoresController.scoreList;
        scoreList.sort(Comparator.comparingDouble(Score::getScores).reversed());
        var dlm = new DefaultListModel<String>();
        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);
            dlm.add(i, score.toString());
        }

        var list2 = new JList<>(dlm);
        var jScrollPane = new JScrollPane(list2);
        if (scoreList.size() < 1) {
            jScrollPane.setVisible(false);
        }
        list2.setBackground(new Color(16, 157, 241, 180));
        jScrollPane.setBounds(Starter.WIDTH / 2 - 375, Starter.HEIGHT / 2 + 25, 750, 200);
        list2.setForeground(Color.WHITE);
        list2.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(jScrollPane);
        setLayout(null);
        //  add(scoreLabel);
        buttonEasy.setFont(new Font("TimesRoman", Font.BOLD, 20));
        buttonEasy.setBounds(Starter.WIDTH / 2 - 386, Starter.HEIGHT / 2 - 275, 250, 100);
        buttonEasy.setForeground(Color.WHITE);
        buttonEasy.setBackground(new Color(217, 157, 0));
        buttonEasy.setContentAreaFilled(false);
        buttonEasy.setOpaque(true);
        buttonMedium.setFont(new Font("TimesRoman", Font.BOLD, 20));
        buttonMedium.setBounds(Starter.WIDTH / 2 - 136, Starter.HEIGHT / 2 - 275, 250, 100);
        buttonMedium.setForeground(Color.WHITE);
        buttonMedium.setBackground(new Color(187, 78, 0));
        buttonMedium.setContentAreaFilled(false);
        buttonMedium.setOpaque(true);
        buttonHard.setFont(new Font("TimesRoman", Font.BOLD, 20));
        buttonHard.setBounds(Starter.WIDTH / 2 + 114, Starter.HEIGHT / 2 - 275, 250, 100);
        buttonHard.setForeground(Color.WHITE);
        buttonHard.setBackground(new Color(247, 60, 60));
        buttonHard.setContentAreaFilled(false);
        buttonHard.setOpaque(true);

        buttonExit.setFont(new Font("TimesRoman", Font.BOLD, 20));
        buttonExit.setBounds(Starter.WIDTH / 2 - 136, Starter.HEIGHT / 2 - 75, 250, 100);
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setBackground(new Color(0, 191, 85));
        buttonExit.setContentAreaFilled(false);
        buttonExit.setOpaque(true);
        buttonStart.setFont(new Font("TimesRoman", Font.BOLD, 20));
        buttonStart.setBounds(Starter.WIDTH / 2 - 136, Starter.HEIGHT / 2 - 175, 250, 100);
        buttonStart.setBackground(new Color(0, 182, 187));
        buttonStart.setContentAreaFilled(false);
        buttonStart.setForeground(Color.WHITE);
        buttonStart.setOpaque(true);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buttonEasy.setVisible(true);
                buttonMedium.setVisible(true);
                buttonHard.setVisible(true);
                repaint();
            }
        });
        buttonEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.virus = VirusFactory.create(Difficulty.EASY);
                Application.starter.loadGame();
                setVisible(false);
                Game.selectedDifficulty = Difficulty.EASY;
            }
        });
        buttonMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.virus = VirusFactory.create(Difficulty.MEDIUM);
                Application.starter.loadGame();
                setVisible(false);
                Game.selectedDifficulty = Difficulty.MEDIUM;
            }
        });
        buttonHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.virus = VirusFactory.create(Difficulty.HARD);
                Application.starter.loadGame();
                setVisible(false);
                Game.selectedDifficulty = Difficulty.HARD;
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        add(buttonEasy);
        buttonMedium.setVisible(false);
        buttonEasy.setVisible(false);
        buttonHard.setVisible(false);
        add(buttonMedium);
        add(buttonHard);
        add(buttonStart);
        add(buttonExit);

        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            InputStream mapStream = this.getClass().getClassLoader().getResourceAsStream("world-map.png");

            g.drawImage(ImageIO.read(mapStream)
                    .getScaledInstance(1600, 900, 0), 0, 0, this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
