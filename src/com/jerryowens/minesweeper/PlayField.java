package com.jerryowens.minesweeper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayField extends JPanel {
    private int row;
    private int column;
    private int numMines;
    public PlayField (int row, int column, int numMines) {
        this.row = row;
        this.column = column;
        this.numMines = numMines;

        this.addMouseListener(new MinesAdapater());
        this.createField();
    }

    public Cell[][] createField () {
        Cell[][] field = new Cell[this.row][this.column];
        int startX = 40;

        for (int x = 0; x < this.row; x++) {
            int startY = 65;
            for (int y = 0; y < this.column; y++){
                field[x][y] = new Cell(startX, startY, 50, 100);
                this.add(field[x][y].getButton());
                startY = startY + 50;
            }
            startX = startX + 50;
        }
        for (int i = 0; i < this.numMines; i++) {
            boolean bombPlaced = false;
            int randX = 0;
            int randY = 0;

            while (!bombPlaced) {
                randX = (int) (Math.random() * this.column);
                randY = (int) (Math.random() * this.row);

                if (!field[randX][randY].isMine()) {
                    field[randX][randY].setMine();
                    bombPlaced = true;
                }
            }

            if ((randX -1) >= 0 && (randY -1 >= 0)) {
                field[randX - 1][randY - 1].addNeighbor();
            }
            if ((randY -1) >= 0) {
                field[randX][randY - 1].addNeighbor();
            }
            if ((randX +1) < column && (randY -1) >= 0) {
                field[randX + 1][randY - 1].addNeighbor();
            }
            if ((randX -1) >= 0 ) {
                field[randX - 1][randY].addNeighbor();
            }
            if ((randX +1) < column) {
                field[randX +1][randY].addNeighbor();
            }
            if ((randX -1) >= 0 && (randY +1) < row) {
                field[randX -1][randY +1].addNeighbor();
            }
            if ((randY +1) < row) {
                field[randX][randY +1].addNeighbor();
            }
            if ((randX +1) < column && (randY +1) < row) {
                field[randX +1][randY +1].addNeighbor();
            }

        }

        return field;
    }

    class MinesAdapater extends MouseAdapter {
        public void mousePressed (MouseEvent event) {
            System.out.println(event.getX() + " " + event.getY());
        }
    }

}

