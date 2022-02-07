package com.harun.ui;

import com.harun.Cell;
import com.harun.PegSolitaireGame;
import com.harun.customComponents.BoardButtons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


public class GameComputerUi extends JPanel {

    public GameComputerUi(PegSolitaireGame frame){
        super();

        int height = frame.board.getBoard().size();
        int width = frame.board.getBoard().get(0).size();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        /*
         ***Panels
         */
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1,1,0,0));

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1,1,0,0));

        JPanel boardArea = new JPanel();
        boardArea.setLayout(new GridLayout(1,1,0,0));

        JPanel startButtonArea = new JPanel();
        startButtonArea.setLayout(new GridLayout(1,1,50,0));


        /*
         ***Components
         */

        //Board
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(height,width));

        for(int i = 0;i<height;i++){
            for(int j=0;j<width;j++){
                if(frame.board.getCell(i,j) == Cell.PEG){

                    try {
                        URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/peg.png");
                        board.add(new BoardButtons(Cell.PEG,frame, new ImageIcon(ImageIO.read(urlBoard)),i,j));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (frame.board.getCell(i,j) == Cell.EMPTY){
                    try {
                        URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/empty.png");
                        board.add(new BoardButtons(Cell.EMPTY,frame, new ImageIcon(ImageIO.read(urlBoard)),i,j));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(frame.board.getCell(i,j) == Cell.OUT){
                    try {
                        URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/out.png");
                        board.add(new BoardButtons(Cell.OUT,frame, new ImageIcon(ImageIO.read(urlBoard)),i,j));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /*
        Go back Button
        */
        JButton backBtn = new JButton();

        try {
            URL urlBackBtn = this.getClass().getClassLoader().getResource("com/harun/assets/back.png");
            backBtn.setIcon(new ImageIcon(ImageIO.read(urlBackBtn)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete game infos and initialized defaultl value of clicked cell
                frame.board.setPlayerType(-1);
                frame.board.setBoardType(-1);
                frame.board.getBoard().clear();
                frame.board.getMoves().clear();
                frame.board.setFirstClickedCellX(-1);
                frame.board.setSecondClickedCellX(-1);
                frame.board.setFirstClickedCellY(-1);
                frame.board.setSecondClickedCellY(-1);
                frame.board.setGameStatus(true);
                frame.board.setComputerGameStarted(false);
                frame.showMainMenu();
            }
        });


        /*
        Start Button
        */
        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            //remove all movements
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setComputerGameStarted(true);
                (new MysteryWorker(frame)).execute();
            }
        });
        if(frame.board.getComputerGameStarted() == true){
            startBtn.setEnabled(false);
        }

        /*
        Add panels to layout
        */
        header.add(backBtn);

        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;
        c.ipadx = 10;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(30,0,0,0);
        add(header,c);

        boardArea.add(board);
        boardArea.add(board);

        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 60;
        c.ipady = 60;
        c.anchor = GridBagConstraints.CENTER;
        add(boardArea,c);

        startButtonArea.add(startBtn);

        content.add(startButtonArea);

        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 30;
        c.ipadx = 700;
        add(content,c);

        if(frame.board.getGameStatus() == false)
            gameFinish(frame,backBtn);

    }

    public void gameFinish(PegSolitaireGame frame,JButton btn){
        //Show dialog box
        JOptionPane.showMessageDialog(frame,"Congrulations! Your point is " + frame.board.calculateFinalScore(),"Peg Solitaire Game",JOptionPane.PLAIN_MESSAGE);

        //delete game infos and initialized default value of clicked cell
        frame.board.setPlayerType(-1);
        frame.board.setBoardType(-1);
        frame.board.getBoard().clear();
        frame.board.getMoves().clear();
        frame.board.setFirstClickedCellX(-1);
        frame.board.setSecondClickedCellX(-1);
        frame.board.setFirstClickedCellY(-1);
        frame.board.setSecondClickedCellY(-1);
        frame.board.setGameStatus(true);
        frame.board.setComputerGameStarted(false);

        btn.setVisible(false);

        frame.showMainMenu();
    }
}

class MysteryWorker extends SwingWorker<Boolean, Object> {

    PegSolitaireGame frame;

    public  MysteryWorker(PegSolitaireGame frame){
        this.frame = frame;
    }

    @Override
    public Boolean doInBackground() throws Exception  {
        while(frame.board.getGameStatus() == true){
            frame.board.doRandomMovement();
            Thread.sleep(100);
        }
        return true;
    }

}
