package org.kasad0r;

import org.kasad0r.domain.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class EndGameDialog extends JDialog {

    private JTextField textField;

    public EndGameDialog(long scores) {
        JLabel labelScoresInfo = new JLabel("Scores: " + scores);
        JButton buttonOK = new JButton("OK");

        textField = new JTextField("Name");
        buttonOK.setSize(100, 50);
        textField.setSize(100, 50);
        labelScoresInfo.setSize(100, 50);
        setLayout(new GridLayout(3, 1));
        labelScoresInfo.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(labelScoresInfo);
        textField.setFont(new Font("TimesRoman", Font.BOLD, 20));
        buttonOK.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(textField);
        add(buttonOK);
        setModal(true);
        buttonOK.setMnemonic(KeyEvent.VK_ENTER);
        buttonOK.addActionListener(e -> {
                    Score score = new Score();
                    if (textField.getText() != null && !textField.getText().isEmpty() || (textField != null && Objects.equals(textField.getText(), "Name")))
                        score.name = textField.getText();
                    else
                        score.name = "unknown_user" + new Random().nextInt(10000);
                    score.localDate = LocalDate.now();
                    score.scores = scores;
                    score.difficulty = Game.selectedDifficulty;
                    Starter.scoresController.addNew(score);
                    System.exit(0);
                }
        );

    }
}