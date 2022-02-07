package com.harun.ui;

import com.harun.PegSolitaireGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUi extends JPanel {
    public MenuUi(PegSolitaireGame frame){
        super();

        //Main layout
        setLayout(new GridLayout(3,3,0,-120));

        //Menu items panel
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(3,1,0,80));

        //Button group panel
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1,2,50,0));


        /*
        ** Components
        */

        //Peg Solitaire Game Text
        JLabel gameTitle = new JLabel("Peg Solitaire Game",SwingConstants.CENTER);
        gameTitle.setFont(new Font("Arial",Font.PLAIN,40));

        //New Game Button
        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showSelectBoardScreen();

            }
        });

        //Load Game Button
        JButton btnLoadGame = new JButton("Load Game");
        btnLoadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLoadGameScreen();
            }
        });

        //Author Name Text
        JLabel author = new JLabel("Harun Eren Ozkaya",SwingConstants.CENTER);


        /*
        ** Add components to panels
        **/

        panelMenu.add(gameTitle);

        panelButtons.add(btnNewGame);
        panelButtons.add(btnLoadGame);
        panelMenu.add(panelButtons);

        panelMenu.add(author);

        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(panelMenu);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
    }
}
