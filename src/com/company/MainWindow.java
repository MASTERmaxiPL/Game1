package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(int weight, int height, Team team) {
        setSize(weight, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new GameField(team));
        setVisible(true);
    }
}
