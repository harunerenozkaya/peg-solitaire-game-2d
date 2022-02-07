package com.harun.customComponents;

import com.harun.Cell;
import com.harun.PegSolitaireGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardButtons extends JButton {
    private Cell value;
    private int x;
    private int y;
    private boolean isClicked;

    public BoardButtons(Cell value,PegSolitaireGame frame, ImageIcon icon, int y, int x){
        this.value = value;
        this.x = x;
        this.y = y;
        isClicked = false;

        //Set button background and color
        setIcon(icon);
        setBackground(new Color(248,236,204));

        //Player game
        if(frame.board.getPlayerType() == 0){
            //When clicked button
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //If button is not clicked
                    if(isClicked == false){
                        if(frame.board.getFirstClickedCellX() == -1 && frame.board.getFirstClickedCellY() == -1){
                            if(value != Cell.EMPTY){
                                frame.board.setFirstClickedCellX(x);
                                frame.board.setFirstClickedCellY(y);
                                isClicked = true;
                                setBackground(Color.RED);
                            }
                        }
                        else{
                            if(frame.board.getFirstClickedCellX() != -1 && frame.board.getFirstClickedCellY() != -1 && value == Cell.EMPTY){
                                frame.board.setSecondClickedCellX(x);
                                frame.board.setSecondClickedCellY(y);
                                isClicked = true;
                                frame.board.doMovement();
                            }
                        }
                    }

                    //If button is clicked already
                    else{
                        if(value == Cell.PEG){
                            frame.board.setFirstClickedCellX(-1);
                            frame.board.setFirstClickedCellY(-1);
                            frame.board.setSecondClickedCellX(-1);
                            frame.board.setSecondClickedCellY(-1);
                            isClicked = false;
                            setBackground(new Color(248,236,204));
                        }
                    }
                }
            });
        }

        //Computer game
        else if(frame.board.getPlayerType() == 1){
            setDisable();
            if(value == Cell.PEG || value == Cell.EMPTY){
                setDisabledIcon(icon);
                setBackground(new Color(248,236,204));
                setBorder(BorderFactory.createLineBorder(Color.CYAN));
            }
        }

        //If button is out then disable
        if(value == Cell.OUT){
            setDisable();
        }
    }

    public void setValue(Cell value){
        this.value = value;
    }

    public void setDisable(){
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setBackground(new Color(212,212,212,255));
        this.setEnabled(false);
    }



}
