package com.harun.ui;

import com.harun.PegSolitaireGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class SelectBoardUi extends JPanel {
    public SelectBoardUi(PegSolitaireGame frame){
        super();

        /*
        **Panels and layout settings
        */
        setLayout(new GridLayout(4,1,100,10));

        JPanel boardsPanel = new JPanel();
        boardsPanel.setLayout(new GridLayout(1,6,50,0));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(1,1,0,50));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,100,1000));


        /*
        * Components
        */

        //Title Text
        JLabel helperText = new JLabel("Select Board Type",SwingConstants.CENTER);
        helperText.setFont(new Font("Arial",Font.PLAIN,25));

        //Back Button
        JButton backToMenubtn = new JButton();

        try {
            URL urlBackBtn = this.getClass().getClassLoader().getResource("com/harun/assets/back.png");
            backToMenubtn.setIcon(new ImageIcon(ImageIO.read(urlBackBtn)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        backToMenubtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showMainMenu();
            }
        });


        //Select Board 1 Button
        JButton board1btn = new JButton();

        try {
            URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/1.png");
            board1btn.setIcon(new ImageIcon(ImageIO.read(urlBoard)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        board1btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setBoardType(1);
                frame.board.initializeBoard();
                frame.showSelectPlayerScreen();
            }
        });


        //Select Board 2 Button
        JButton board2btn = new JButton();

        try {
            URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/2.png");
            board2btn.setIcon(new ImageIcon(ImageIO.read(urlBoard)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        board2btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setBoardType(2);
                frame.board.initializeBoard();
                frame.showSelectPlayerScreen();
            }
        });


        //Select Board 3 Button
        JButton board3btn = new JButton();

        try {
            URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/3.png");
            board3btn.setIcon(new ImageIcon(ImageIO.read(urlBoard)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        board3btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setBoardType(3);
                frame.board.initializeBoard();
                frame.showSelectPlayerScreen();
            }
        });

        //Select Board 4 Button
        JButton board4btn = new JButton();

        try {
            URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/4.png");
            board4btn.setIcon(new ImageIcon(ImageIO.read(urlBoard)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        board4btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setBoardType(4);
                frame.board.initializeBoard();
                frame.showSelectPlayerScreen();
            }
        });

        //Select Board 5 Button
        JButton board5btn = new JButton();

        try {
            URL urlBoard = this.getClass().getClassLoader().getResource("com/harun/assets/5.png");
            board5btn.setIcon(new ImageIcon(ImageIO.read(urlBoard)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        board5btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setBoardType(5);
                frame.board.initializeBoard();
                frame.showSelectPlayerScreen();
            }
        });

        //Arbitrary Boards Button
        JPanel panelArbitraryBoardBtn = new JPanel();
        panelArbitraryBoardBtn.setLayout(new GridLayout(1,1));
        panelArbitraryBoardBtn.setBorder(BorderFactory.createEmptyBorder(50,300,50,300));

        JButton arbitraryBoardsBtn = new JButton("Arbitrary Boards");
        panelArbitraryBoardBtn.add(arbitraryBoardsBtn);
        arbitraryBoardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLoadArbitraryBoardScreen();
            }
        });


        /*
        * Adding components to panel
        */

        headerPanel.add(backToMenubtn);
        boardsPanel.add(board1btn);
        boardsPanel.add(board2btn);
        boardsPanel.add(board3btn);
        boardsPanel.add(board4btn);
        boardsPanel.add(board5btn);

        add(headerPanel);
        add(helperText);
        add(boardsPanel);
        add(panelArbitraryBoardBtn);

    }
}
