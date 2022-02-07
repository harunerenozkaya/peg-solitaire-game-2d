package com.harun.ui;

import com.harun.PegSolitaireGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


public class SelectPlayerUi extends JPanel {
    public SelectPlayerUi(PegSolitaireGame frame){
        super();

        setLayout(new GridLayout(2,1,0,50));

        //player type buttons
        JPanel playerTypePanel = new JPanel();
        playerTypePanel.setLayout(new GridLayout(1,2,50,0));
        playerTypePanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        //back button
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(1,1,0,50));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,100,1000));

        //player type buttons + title
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2,1,0,40));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0,250,0,250));


        /*
         * Components
         */

        JLabel helperText = new JLabel("Select Player Type",SwingConstants.CENTER);
        helperText.setFont(new Font("Arial",Font.PLAIN,25));

        //Back button
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
                frame.board.getBoard().clear();
                frame.showSelectBoardScreen();
            }
        });


        JButton selectHumanbtn = new JButton("Human");
        selectHumanbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setPlayerType(0);
                frame.showGameHumanScreen();
            }
        });


        JButton selectComputerbtn = new JButton("Computer");
        selectComputerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.board.setPlayerType(1);
                frame.showGameComputerScreen();
            }
        });



        /*
         * Adding components to panel
         */

        playerTypePanel.add(selectHumanbtn);
        playerTypePanel.add(selectComputerbtn);
        headerPanel.add(backToMenubtn);

        contentPanel.add(helperText);
        contentPanel.add(playerTypePanel);

        add(headerPanel);
        add(contentPanel);


    }
}
