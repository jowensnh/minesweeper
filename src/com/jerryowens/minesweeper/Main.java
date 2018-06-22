package com.jerryowens.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JButton;


public class Main {

    public static void main( String[] args) {
        // write your code here
        PlayField playField = new PlayField(10, 10, 10);


        JFrame mainWindow = new JFrame();
        JButton startButton = new JButton("Start");
        startButton.setBounds(10, 10, 50, 20);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setText("Started");
                playField.createField(mainWindow);
                mainWindow.repaint();
                }

        });
        mainWindow.add(startButton);
        mainWindow.setSize(650, 650);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
    }


}
