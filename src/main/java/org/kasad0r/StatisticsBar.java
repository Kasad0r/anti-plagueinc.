package org.kasad0r;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StatisticsBar extends JPanel {
    public static JButton buttonResearch = new JButton("Research");
    public static JLabel labelPopulation = new JLabel();
    public static JLabel labelDeath = new JLabel();
    public static JLabel labelInfected = new JLabel();
    public static JLabel labelDate = new JLabel();
    public static JLabel labelRecovered = new JLabel();
    public static JProgressBar vaccineProgressBar = new JProgressBar();
    public static ResearchDialog dialog = new ResearchDialog();
    public static ImageIcon icon;

    public static void update(long totalDeaths, long population, long infectedRate, long recovered) {
        labelPopulation.setText("Population: " + population);
        labelInfected.setText("Infected: " + infectedRate);
        labelDeath.setText("Deaths: " + totalDeaths);
        labelRecovered.setText("Recoverd: " + recovered);
        labelDate.setText(Game.currentPoints + "     Date: " + Game.gameDate);
    }

    public StatisticsBar() {
        try {
            icon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("molekula.png"))
                    .getScaledInstance(30, 30, 0))
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDoubleBuffered(true);
        setSize(getWidth(), 100);
        setLayout(new GridLayout());
        labelDate.setIcon(icon);
        labelDate.setFont(new Font("TimesRoman", Font.BOLD, 15));
        labelRecovered.setFont(new Font("TimesRoman", Font.BOLD, 15));
        labelPopulation.setFont(new Font("TimesRoman", Font.BOLD, 15));
        labelInfected.setFont(new Font("TimesRoman", Font.BOLD, 15));
        labelDeath.setFont(new Font("TimesRoman", Font.BOLD, 15));
        labelPopulation.setBounds(10, 30, 200, 200);
        add(labelDate);
        add(labelPopulation);
        add(labelInfected);
        add(labelRecovered);
        add(labelDeath);
        buttonResearch.setFont(new Font("TimesRoman", Font.BOLD, 15));
        buttonResearch.setBackground(Color.white);
        buttonResearch.setBorder(null);
        buttonResearch.setOpaque(true);
        buttonResearch.setFocusPainted(false);
        buttonResearch.addActionListener(e -> {
            dialog.pack();
            dialog.setLocation(Starter.WIDTH / 2 - dialog.getWidth() / 4,
                    Starter.HEIGHT / 2 - dialog.getHeight() / 4);
            dialog.setVisible(true);
        });
        add(buttonResearch);
        setOpaque(false);
        vaccineProgressBar.setValue(0);
        vaccineProgressBar.setStringPainted(true);
        vaccineProgressBar.setFont(new Font("TimesRoman", Font.BOLD, 15));
        vaccineProgressBar.setString("Vaccine Progress");
        add(vaccineProgressBar);
        setBackground(new Color(0, 0, 0, 0));
    }


}
