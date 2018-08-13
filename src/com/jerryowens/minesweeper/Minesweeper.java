package com.jerryowens.minesweeper;

import javax.swing.*;

public class Minesweeper extends JFrame{
    public  Minesweeper () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 650);
        setLocationRelativeTo(null);
        setTitle("Minesweeper");
        add(new PlayField(10, 10, 10));
        setResizable(false);
        setVisible(true);
    }
}
