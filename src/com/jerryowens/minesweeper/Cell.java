package com.jerryowens.minesweeper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell {
    private boolean isMine = false;
    private boolean isFlagged = false;
    private int numNeighborBombs = 0;
    private JButton button;

    public Cell(int positionX, int positionY, int width, int height) {
        button = new JButton();
        button.setBounds(positionX, positionY, width, height);
        /*button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isMine) {
                    button.setText("Boom");
                } else if (numNeighborBombs > 0){
                    button.setText(String.valueOf(numNeighborBombs));
                } else {

                }
            }
        });*/
    }



    public void setMine(){
        isMine = true;
    }

    public boolean isMine(){
        return this.isMine;
    }

    public void addNeighbor(){
        numNeighborBombs++;
    }

    public JButton getButton(){
        return button;
    }
}
