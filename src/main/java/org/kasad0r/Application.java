package org.kasad0r;

import javax.swing.*;

public class Application {
    public static Starter starter = new Starter();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        starter.start();
    }
}
